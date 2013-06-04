package com.tooflya.signs.cn.screens;

import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.Options.Resolutions;
import com.tooflya.signs.cn.entities.Entity;
import com.tooflya.signs.cn.entities.Rectangle;

/**
 * @author Tooflya.com
 * @since
 */
public class AndEngineScreen extends Screen implements IOnSceneTouchListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public static TiledTextureRegion mBlank1024Png;

	/**
	 * Declare the necessary canvas in graphics memory, which then will be used to download images.
	 */
	private final BitmapTextureAtlas mBackgroundTextureAtlas;

	private final Rectangle mBackground = new Rectangle();

	private final Entity mAndengineIcon;

	/**
	 * Set the timer, which will change the size of the loading bar, depending on the load time.
	 */
	private final TimerHandler mTimer = new TimerHandler(2.8f, true, new ITimerCallback() {
		@Override
		public void onTimePassed(TimerHandler pTimerHandler) {
			Game.mScreens.set(new LoadingScreen());
		}
	});

	private ScaleModifier modifier1 = new ScaleModifier(0.4f, 0f, 1.2f) {
		@Override
		public void onFinished() {
			modifier2.reset();
		}
	};

	private ScaleModifier modifier2 = new ScaleModifier(0.2f, 1.2f, 0.7f) {
		@Override
		public void onFinished() {
			modifier3.reset();
		}
	};

	private ScaleModifier modifier3 = new ScaleModifier(0.3f, 0.7f, 1f) {
		@Override
		public void onFinished() {
			modifier4.reset();
		}
	};

	private ScaleModifier modifier4 = new ScaleModifier(10f, 1f, 2f);

	private boolean isClickedToContinue = false;

	// ===========================================================
	// Constructors
	// ===========================================================

	public AndEngineScreen() {
		switch (Options.Resolution) {
		default:
			this.mBackgroundTextureAtlas = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			break;
		case Resolutions.HD:
			this.mBackgroundTextureAtlas = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			break;
		}

		mBlank1024Png = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "blank1024.png", 0, 0, 1, 1);

		this.mAndengineIcon = new Entity(BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBackgroundTextureAtlas, Game.mContext, "andengine.png", 0, 0, 1, 1), this.mBackground);

		this.loadResources();

		this.setBackground(new ColorBackground(1f, 1f, 1f, 1f));

		this.mBackground.setAlpha(1f);
		this.mBackground.setColor(1f, 1f, 1f);
		this.attachChild(this.mBackground);
		this.mBackground.setBackgroundCenterPosition();

		this.mAndengineIcon.create().setCenterPosition(this.mBackground.getWidth() / 2, this.mBackground.getHeight() / 2);
		this.mAndengineIcon.setScaleCenter(this.mAndengineIcon.getWidth() / 2, this.mAndengineIcon.getHeight() / 2);
		this.mAndengineIcon.enableFullBlendFunction();
		this.mAndengineIcon.setScale(0f);

		this.mAndengineIcon.registerEntityModifier(this.modifier1);
		this.mAndengineIcon.registerEntityModifier(this.modifier2);
		this.mAndengineIcon.registerEntityModifier(this.modifier3);
		this.mAndengineIcon.registerEntityModifier(this.modifier4);

		this.setOnSceneTouchListener(this);
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

	/* (non-Javadoc)
	 * @see com.tooflya.bubblefun.screens.Screen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
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

		if (Options.isSoundEnabled) {
			//Options.mAndEngineSound.release();
		}
	}

	private float mTimeToWaitMusicLoaded = 0;
	private boolean mIsMusicLoaded = false;

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.scene.Scene#onManagedUpdate(float)
	 */
	protected void onManagedUpdate(final float pSecondsElapsed) {
		if (this.mTimeToWaitMusicLoaded > 1f) {
			if (!this.mIsMusicLoaded) {
				this.modifier1.reset();

				if (Options.isSoundEnabled) {
					//Options.mAndEngineSound.play();
				}

				/** Register timer of loading progressbar changes */
				this.registerUpdateHandler(mTimer);
			}
			this.mIsMusicLoaded = true;
			super.onManagedUpdate(pSecondsElapsed);
		}

		this.mTimeToWaitMusicLoaded += pSecondsElapsed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener#onSceneTouchEvent(org.anddev.andengine.entity.scene.Scene, org.anddev.andengine.input.touch.TouchEvent)
	 */
	@Override
	public boolean onSceneTouchEvent(Scene arg0, TouchEvent arg1) {
		if (!this.isClickedToContinue) {
			this.isClickedToContinue = true;

			if (arg1.isActionDown()) {
				Game.mScreens.set(new LoadingScreen());
			}

			return true;
		}

		return false;
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