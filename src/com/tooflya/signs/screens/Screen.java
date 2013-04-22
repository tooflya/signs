package com.tooflya.signs.screens;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.input.touch.TouchEvent;

import com.tooflya.signs.Options;
import com.tooflya.signs.entities.ButtonScaleable;

/**
 * @author Tooflya.com
 * @since
 */
public abstract class Screen extends Scene implements IOnSceneTouchListener {

	// ===========================================================
	// Constants
	// ===========================================================

	public static int screen = -1;

	public static final int SCREENS_COUNT = 11;

	public static final int MENU = 0;
	public static final int EXIT = 1;
	public static final int LEVEL = 2;
	public static final int MODE = 3;
	public static final int PAUSE = 4;
	public static final int RESTART = 5;
	public static final int MAIN = 6;
	public static final int LEVELEND = 7;
	public static final int SHOP = 8;
	public static final int ACHIEVEMENTS = 9;
	public static final int COINS = 10;

	public static float ADS_PADDING = 0;

	// ===========================================================
	// Fields
	// ===========================================================

	private float mDeltaTiming = 0;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Screen() {
		this.setOnSceneTouchListener(this);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener#onSceneTouchEvent(org.anddev.andengine.entity.scene.Scene, org.anddev.andengine.input.touch.TouchEvent)
	 */
	@Override
	public boolean onSceneTouchEvent(Scene arg0, TouchEvent pTouchEvent) {
		final float pTouchX = pTouchEvent.getX() / Options.cameraRatioFactor;
		final float pTouchY = pTouchEvent.getY() / Options.cameraRatioFactor;

		for (ITouchArea area : Screen.this.getTouchAreas()) {
			if (area instanceof ButtonScaleable) {
				ButtonScaleable yourButton = (ButtonScaleable) area;

				if (!yourButton.clickable) {
					continue;
				}

				float parentX = 0;
				float parentY = 0;

				IEntity parent = yourButton.getParent();
				while (parent != null) {
					parentX += parent.getX();
					parentY += parent.getY();

					parent = parent.getParent();
				}

				if (pTouchX > (parentX + yourButton.getX() + yourButton.getWidthScaled()) || pTouchX < yourButton.getX() + parentX || pTouchY > parentY + yourButton.getY() + yourButton.getHeightScaled()
						|| pTouchY < yourButton.getY() + parentY) {
					yourButton.unBind(pTouchEvent.isActionUp());
				}
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.anddev.andengine.entity.Entity#onAttached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();

		this.setIgnoreUpdate(false);
		this.setChildrenIgnoreUpdate(false);
	}

	/** Must be overrided. */
	public void onPostAttached() {
		throw new IllegalStateException("Sorry, but this method must be overrided by child Class.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.anddev.andengine.entity.Entity#onDetached()
	 */
	@Override
	public void onDetached() {
		super.onDetached();

		this.setIgnoreUpdate(true);
		this.setChildrenIgnoreUpdate(true);
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.Entity#attachChild(org.anddev.andengine.entity.IEntity)
	 */
	@Override
	public void attachChild(final IEntity pEntity) {
		super.attachChild(pEntity);

		/** This section is scale object to the real size for adapt size of entity to the screen resolution. */
		pEntity.setScaleCenter(0, 0);
		pEntity.setScale(Options.cameraRatioFactor);

		/** After scale action we need to find center of entity position. */
		if (((Shape) pEntity).getWidthScaled() > Options.cameraWidth || ((Shape) pEntity).getHeightScaled() > Options.cameraHeight) {
			pEntity.setPosition((Options.screenWidth - ((Shape) pEntity).getWidthScaled()) / 2, (Options.screenHeight - ((Shape) pEntity).getHeightScaled()) / 2);
		}
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.scene.Scene#onManagedUpdate(float)
	 */
	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) {
		if (Options.IS_DELTA_TIMING_ON) {
			this.mDeltaTiming += pSecondsElapsed;
			if (this.mDeltaTiming < Options.framesPerSeconds) {
				return;
			} else {
				super.onManagedUpdate(Options.framesPerSeconds);
				this.mDeltaTiming -= Options.framesPerSeconds;
				while (this.mDeltaTiming >= Options.framesPerSeconds) {
					super.onManagedUpdate(Options.framesPerSeconds);
					this.mDeltaTiming -= Options.framesPerSeconds;
				}
			}
		} else {
			super.onManagedUpdate(pSecondsElapsed);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * 
	 */
	public void onBackPressed() {
	}
}
