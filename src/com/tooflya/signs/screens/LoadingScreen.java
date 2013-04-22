package com.tooflya.signs.screens;

import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.util.user.AsyncTaskLoader;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.entities.Rectangle;

/**
 * @author Tooflya.com
 * @since
 */
public class LoadingScreen extends Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_BARS_X;
	private static float POSITION_BARS_Y1 = 0f;
	private static float POSITION_BARS_Y2 = 0f;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_BARS_X = 3f;
			POSITION_BARS_Y1 = 135f;
			POSITION_BARS_Y2 = 140f;
			break;
		case Resolutions.HD:
			POSITION_BARS_X = 6f;
			POSITION_BARS_Y1 = 274f;
			POSITION_BARS_Y2 = 280f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	public static TiledTextureRegion mBlank1024Png;

	/** Declare the necessary canvas in graphics memory, which then will be used to download images. */
	private final BitmapTextureAtlas mBackgroundTextureAtlas;

	/** Declare the entity that acts as a background image of the screen. */
	private final Entity mBackgroundPicture;

	private final Rectangle mBackground = new Rectangle();

	/** Declare the entity that acts as a loading bar. */
	private final Entity mProgressBar1;
	private final Entity mProgressBar2;
	private final Entity mProgressBar3;

	/** Set the timer, which will change the size of the loading bar, depending on the load time. */
	private final TimerHandler mTimer = new TimerHandler(1f / 15.0f, true, new ITimerCallback() {

		/* (non-Javadoc)
		 * @see org.anddev.andengine.engine.handler.timer.ITimerCallback#onTimePassed(org.anddev.andengine.engine.handler.timer.TimerHandler)
		 */
		@Override
		public void onTimePassed(TimerHandler pTimerHandler) {
			/** Changing size of progressbar. */
			if (mProgressBar2.getWidthScaled() < mProgressBar2.getBaseWidth()) {
				mProgressBar2.getTextureRegion().setWidth(mProgressBar2.getTextureRegion().getWidth() + 3);
				mProgressBar2.setWidth(mProgressBar2.getWidth() + 3);
			} else {
				/** If progressbar is full. */
				Game.mIsGameLoaded = true;
			}
		}
	});

	// ===========================================================
	// Constructors
	// ===========================================================

	public LoadingScreen() {
		switch (Options.Resolution) {
		default:
			this.mBackgroundTextureAtlas = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

			mBlank1024Png = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "blank1024.png", 0, 0, 1, 1);

			this.mBackgroundPicture = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-bg.png", 0, 0, 1, 1), this);

			this.mProgressBar1 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-down.png", 0, 380, 1, 1), this.mBackground);
			this.mProgressBar2 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-fill.png", 200, 380, 1, 1), this.mBackground);
			this.mProgressBar3 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-up.png", 400, 380, 1, 1), this.mBackground);
			break;
		case Resolutions.HD:
			this.mBackgroundTextureAtlas = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

			mBlank1024Png = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "blank2048.png", 0, 0, 1, 1);

			this.mBackgroundPicture = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-bg.png", 0, 0, 1, 1), this);

			this.mProgressBar1 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-down.png", 0, 730, 1, 1), this.mBackground);
			this.mProgressBar2 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-fill.png", 370, 730, 1, 1), this.mBackground);
			this.mProgressBar3 = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "start-preloader/start-preloader-up.png", 700, 730, 1, 1), this.mBackground);
			break;
		}

		this.loadResources();

		this.attachChild(this.mBackground);

		this.mBackground.setBackgroundCenterPosition();
		this.mBackgroundPicture.create().setBackgroundCenterPosition();

		this.mProgressBar1.create().setCenterPosition(Options.cameraCenterX + POSITION_BARS_X, Options.cameraCenterY + POSITION_BARS_Y1);
		this.mProgressBar3.create().setCenterPosition(Options.cameraCenterX + POSITION_BARS_X, Options.cameraCenterY + POSITION_BARS_Y2);

		this.mProgressBar2.create().setCenterPosition(Options.cameraCenterX + POSITION_BARS_X, Options.cameraCenterY + POSITION_BARS_Y2);
		this.mProgressBar2.setWidth(1);
		this.mProgressBar2.getTextureRegion().setWidth(1);

		/** Register timer of loading progressbar changes */
		this.registerUpdateHandler(mTimer);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.bubblefun.screens.Screen#onAttached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();
	}

	@Override
	public void onPostAttached() {
		Game.mInstance.runOnUiThread(new Runnable() {

			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				/** Start background loader */
				new AsyncTaskLoader().execute((Game) Game.mInstance);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onDetached()
	 */
	@Override
	public void onDetached() {
		super.onDetached();

		this.clearUpdateHandlers();
		this.unloadResources();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public void loadResources() {
		Game.loadTextures(this.mBackgroundTextureAtlas);
	}

	public void unloadResources() {
		Game.unloadTextures(this.mBackgroundTextureAtlas);
	}
}