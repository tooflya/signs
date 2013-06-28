package com.tooflya.signs;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.audio.music.MusicFactory;
import org.anddev.andengine.audio.sound.SoundFactory;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.AverageFPSCounter;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.ui.activity.LayoutGameActivity;
import org.anddev.andengine.util.user.IAsyncCallback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.opengl.GLException;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;

import com.tooflya.billing.BillingHelper;
import com.tooflya.billing.BillingService;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.database.DataStorage;
import com.tooflya.signs.managers.AdvertisementManager;
import com.tooflya.signs.managers.ScreenManager;
import com.tooflya.signs.screens.AndEngineScreen;
import com.tooflya.signs.screens.Screen;
import com.tooflya.signs.screens.ShopScreen;

/**
 * That's simple main activity of game chich extends LayoutGameActivity for correct display of advertisiment. Also it implements IAsyncCallback because we need do some loading operations on background.
 * 
 * @author Tooflya.com
 * @since
 */
public class Game extends LayoutGameActivity implements IAsyncCallback {

	// ===========================================================
	// Constants
	// ===========================================================

	/**
	 * Random instance for all application. Using a one copy of the entire application, we obtain a more normal distribution.
	 */
	public final static Random random = new Random();

	// ===========================================================
	// Fields
	// ===========================================================

	/** Instance of engine */
	public static Engine mEngine;

	/**  */
	public static Activity mInstance;

	/** Context of main activity */
	public static Context mContext;

	/**
	 * An instance of the class to work with the camera. The camera has various methods to display, rotation and displacement all display area.
	 */
	public static Camera mCamera;

	/**
	 * Instance of the class to work with SQLite.
	 */
	public static DataStorage mDatabase;

	/**  */
	public static ScreenManager mScreens;

	/** */
	public static AdvertisementManager mAdvertisementManager;

	/**
	 * Variable is used to determine the player's return after the game. Typically, after such return we offer an various actions associated with an introduction to the game.
	 */
	public static boolean mIsAlreadyPlayed = false;

	/**
	 * Flag knowing the extent of the congestion state of the game at the moment.
	 */
	public static boolean mIsGameLoaded = false;

	/**
	 * This variable contains the time elapsed since the last switch the screen. Used to avoid double-clicking on the back button.
	 */
	private long mScreenChangeTime = 0;

	/**
	 * Frames Per Second. Serve as information data, but is sometimes used to remove the unnecessary elements in lost productivity.
	 */
	private float mCurrentFramesPerSecond;

	// ===========================================================
	// Virtual methods
	// ===========================================================

	@Override
	public void onLoadComplete() {
	}

	@Override
	public Engine onLoadEngine() {
		/** Let's remember Context of this activity */
		mContext = getApplicationContext();

		startService(new Intent(mContext, BillingService.class));
		BillingHelper.setCompletedHandler(mTransactionHandler);

		/** Set the position and resolution of camera */
		final DisplayMetrics displayMetrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

		/** Initialize camera parameters */
		Options.screenWidth = displayMetrics.widthPixels;
		Options.screenHeight = displayMetrics.heightPixels;

		/** */
		if (Options.screenWidth > Options.cameraRatioCenter) {
			Options.cameraWidth = 1155;
			Options.cameraHeight = 720;

			Options.CR = "HD/";
			Options.Resolution = Resolutions.HD;
		} else {
			Options.cameraWidth = 610;
			Options.cameraHeight = 380;

			Options.CR = "SD/";
			Options.Resolution = Resolutions.SD;
		}

		Options.cameraCenterX = Options.cameraWidth / 2;
		Options.cameraCenterY = Options.cameraHeight / 2;

		Options.screenCenterX = (int) (Options.screenWidth / 2);
		Options.screenCenterY = (int) (Options.screenHeight / 2);

		Options.cameraRatioFactor = Options.screenHeight / Options.cameraHeight;

		/** Initialize camera instance */
		mCamera = new Camera(0, 0, Options.screenWidth, Options.screenHeight);

		/** Initialize the configuration of engine */
		final EngineOptions options = new EngineOptions(true, ScreenOrientation.LANDSCAPE, new FillResolutionPolicy(), mCamera)
				.setNeedsMusic(true)
				.setNeedsSound(true);

		/** Disable extension vertex buffer objects. This extension usually has a problems with HTC phones. */
		options.getRenderOptions().disableExtensionVertexBufferObjects();

		/** Auto setRunOnUpdateThread for touch events. */
		options.getTouchOptions().setRunOnUpdateThread(true);

		/** Try to init our engine. */
		mEngine = new Engine(options) {

			@Override
			public void onDrawFrame(GL10 pGL) throws InterruptedException {
				super.onDrawFrame(pGL);

				final int error = pGL.glGetError();

				/**
				 * 1280 GL_INVALID_ENUM 1281 GL_INVALID_VALUE 1282 GL_INVALID_OPERATION 1283 GL_STACK_OVERFLOW 1284 GL_STACK_UNDERFLOW 1285 GL_OUT_OF_MEMORY
				 */
				if (error != GL10.GL_NO_ERROR) {
					//throw new GLException(error, "OpenGL ES has error occurred: " + error);
				}
			}

			@Override
			protected void onDrawScene(GL10 pGL) {
				super.onDrawScene(pGL);

				GLHelper.enableDither(pGL);
			}

			@Override
			public void onUpdate(final long pNanosecondsElapsed) {
				try {
					super.onUpdate(pNanosecondsElapsed);

					Options.mMainSound.update();
					Options.mLevelSound.update();
					Options.mEndSound.update();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
				}
			}
		};

		/** */
		mDatabase = new DataStorage();

		/** Create screen manager */
		mScreens = new ScreenManager();

		/**  */
		mInstance = this;

		return mEngine;
	}

	@Override
	public void onLoadResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/" + Options.CR);

		if (Options.DEBUG) {
			Options.isMusicEnabled = false;
			Options.isSoundEnabled = false;
		} else {
			Options.isMusicEnabled = true;
			Options.isSoundEnabled = true;
		}

		if (Options.isMusicEnabled) {
			SoundFactory.setAssetBasePath("mfx/");
			MusicFactory.setAssetBasePath("mfx/");

			try {
				Options.mMainSound = MusicFactory.createMusicFromAsset(mEngine.getMusicManager(), this, "menu.ogg");
				Options.mLevelSound = MusicFactory.createMusicFromAsset(mEngine.getMusicManager(), this, "game.ogg");
				Options.mEndSound = MusicFactory.createMusicFromAsset(mEngine.getMusicManager(), this, "end.ogg");

				Options.mButtonSound = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "buttons.ogg");
				Options.mSmashSound1 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn0.ogg");
				Options.mSmashSound2 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn1.ogg");
				Options.mSmashSound3 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn2.ogg");
				Options.mSmashSound4 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn3.ogg");
				Options.mSmashSound5 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn4.ogg");
				Options.mSmashSound6 = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "burn5.ogg");
				Options.mClockSound = SoundFactory.createSoundFromAsset(mEngine.getSoundManager(), this, "clock.ogg");

				Options.mMainSound.setLooping(true);
				Options.mLevelSound.setLooping(true);
				Options.mEndSound.setLooping(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void workToDo() {
		Resources.loadResources();

		mScreens.createSurfaces();

		/** Wait while progressbar is running */
		while (!mIsGameLoaded) {
		}
		;
	}

	@Override
	public void onComplete() {
		mScreens.set(Screen.MENU);
	}

	@Override
	public Scene onLoadScene() {
		if (Options.DEBUG) {
			this.getEngine().registerUpdateHandler(new AverageFPSCounter() {

				@Override
				protected void onHandleAverageDurationElapsed(float arg0) {

					mCurrentFramesPerSecond = getFPS();
				}
			});

			this.getEngine().registerUpdateHandler(new IUpdateHandler() {

				private float mTime;

				@Override
				public void onUpdate(float pSecondsElapsed) {
					this.mTime += pSecondsElapsed;

					if (this.mTime > 5f) {
						this.mTime = 0;

						System.out.println("Current FPS: " + mCurrentFramesPerSecond);
					}
				}

				@Override
				public void reset() {
				}
			});
		}

		/** */
		mAdvertisementManager = new AdvertisementManager();

		/** Create loading screen and return her scene for attaching to the activity. */
		return new AndEngineScreen();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onDestroy() {
		super.onDestroy();

		/**
		 * Notify the system to finalize and collect all objects of the application on exit so that the process running the application can be killed by the system without causing issues. NOTE: If this is set to true then the process will not be killed until all of its threads have closed.
		 */
		System.runFinalizersOnExit(false);

		/**
		 * Force the system to close the application down completely instead of retaining it in the background. The process that runs the application will be killed. The application will be completely created as a new application in a new process if the user starts the application again.
		 */
		System.exit(0);
	}

	@Override
	public void onResumeGame() {
		if (Options.mLastPlayedMusic != null && Options.isMusicEnabled) {
			Options.mLastPlayedMusic.play(true);
		}

		try {
			mScreens.getCurrent().setIgnoreUpdate(false);
			mScreens.getCurrent().setChildrenIgnoreUpdate(false);
		} catch (NullPointerException e) {
		}
	}

	@Override
	public void onPauseGame() {
		Options.mLastPlayedMusic = null;

		if (Options.isMusicEnabled) {
			if (Options.mMainSound.isPlaying()) {
				Options.mMainSound.pause(true);
				Options.mLastPlayedMusic = Options.mMainSound;
			} else if (Options.mLevelSound.isPlaying()) {
				Options.mLevelSound.pause(true);
				Options.mLastPlayedMusic = Options.mLevelSound;
			} else if (Options.mEndSound.isPlaying()) {
				Options.mEndSound.pause(true);
				Options.mLastPlayedMusic = Options.mEndSound;
			}
		}

		try {
			mScreens.getCurrent().setIgnoreUpdate(true);
			mScreens.getCurrent().setChildrenIgnoreUpdate(true);
		} catch (NullPointerException e) {
		}
	}

	@Override
	public boolean onKeyDown(final int keyCode, final KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (Screen.screen < 0) {
				return true;
			}

			if (System.currentTimeMillis() - mScreenChangeTime < 500) {
				return true;
			}

			mScreenChangeTime = System.currentTimeMillis();

			if (Options.isSoundEnabled) {
				Options.mButtonSound.play();
			}

			try {
			mScreens.getCurrent().onBackPressed();
			} catch(NullPointerException ex)
			{
				
			}

			return true;
		}

		return false;
	}

	@Override
	protected int getLayoutID() {
		return R.layout.advertisiment;
	}

	@Override
	protected int getRenderSurfaceViewID() {
		return R.id.xmllayoutRenderSurfaceView;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * @param textures
	 */
	public static void loadTextures(final BitmapTextureAtlas... textures) {
		mEngine.getTextureManager().loadTextures(textures);
	}

	/**
	 * @param textures
	 */
	public static void unloadTextures(final BitmapTextureAtlas... textures) {
		mEngine.getTextureManager().unloadTextures(textures);
	}

	/**
	 * 
	 */
	public static void close() {
		mInstance.finish();
	}

	/**
	 * @param pString
	 * @return
	 */
	public static String getString(final String pString) {
		try {
			return Game.mContext.getString(Game.mContext.getResources().getIdentifier(pString, "string", Game.mContext.getPackageName()));
		} catch (NotFoundException ex) {
			return pString;
		}
	}

	// ===========================================================
	// Billing
	// ===========================================================

	public Handler mTransactionHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			if (BillingHelper.latestPurchase.isPurchased()) {
				if (BillingHelper.latestPurchase.productId.equals("purchase_of_10000_coins")) {
					Game.mDatabase.setStarsCount(10000);
					ShopScreen.STARS += 10000;
				} else if (BillingHelper.latestPurchase.productId.equals("purchase_of_15000_coins")) {
					Game.mDatabase.setStarsCount(10000);
					ShopScreen.STARS += 15000;
				} else if (BillingHelper.latestPurchase.productId.equals("purchase_of_25000_coins")) {
					Game.mDatabase.setStarsCount(10000);
					ShopScreen.STARS += 25000;
				} else if (BillingHelper.latestPurchase.productId.equals("purchase_of_50000_coins")) {
					Game.mDatabase.setStarsCount(10000);
					ShopScreen.STARS += 50000;
				}
			}
		};

	};
}
