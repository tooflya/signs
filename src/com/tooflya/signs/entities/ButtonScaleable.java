package com.tooflya.signs.entities;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.ITouchArea;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.Options;
import com.tooflya.signs.screens.Screen;

public class ButtonScaleable extends Button {

	protected boolean mModalTouch;
	public boolean clickable = true;

	private ScaleModifier modifier1 = new ScaleModifier(0.2f, 1f, 0.8f);
	private ScaleModifier modifier2 = new ScaleModifier(0.2f, 0.8f, 1f);

	/**
	 * @param pTiledTextureRegion
	 * @param pParentScreen
	 * @param isModalTouch
	 */
	public ButtonScaleable(TiledTextureRegion pTiledTextureRegion, org.anddev.andengine.entity.Entity pParentScreen, final boolean isModalTouch) {
		super(pTiledTextureRegion, pParentScreen);

		this.mModalTouch = true;

		this.registerEntityModifier(modifier1);
		this.registerEntityModifier(modifier2);
	}

	/**
	 * @param pTiledTextureRegion
	 * @param pParentScreen
	 */
	public ButtonScaleable(TiledTextureRegion pTiledTextureRegion, org.anddev.andengine.entity.Entity pParentScreen) {
		this(pTiledTextureRegion, pParentScreen, false);
	}

	/* (non-Javadoc)
	 * @see com.tooflya.bubblefun.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		this.setScaleCenter(this.getBaseWidth() / 2, this.getBaseHeight() / 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.anddev.andengine.entity.shape.Shape#onAreaTouched(org.anddev.andengine.input.touch.TouchEvent, float, float)
	 */
	@Override
	public boolean onAreaTouched(final TouchEvent pAreaTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
		final float pTouchX = pAreaTouchEvent.getX() / Options.cameraRatioFactor;
		final float pTouchY = pAreaTouchEvent.getY() / Options.cameraRatioFactor;

		switch (pAreaTouchEvent.getAction()) {
		case TouchEvent.ACTION_DOWN:
			this.mLastClickedX = pTouchAreaLocalX;
			this.mLastClickedY = pTouchAreaLocalY;

			this.modifier1.reset();

			this.isClicked = true;

			return this.mModalTouch;

		case TouchEvent.ACTION_UP:
			if (this.isClicked) {
				this.modifier2.reset();

				this.onClick();

				if (Options.isSoundEnabled) {
					Options.mButtonSound.play();
				}
			}

			this.isClicked = false;

			org.anddev.andengine.entity.Entity screen = this.mParentScreen;

			/** At this point, we need to find the root of the parent of the entity, which, in turn, must be an instance of class Screen. */
			while (true) {
				if (screen instanceof Screen) {
					((Screen) screen).registerTouchArea(this);

					break;
				}

				screen = (org.anddev.andengine.entity.Entity) screen.getParent();
			}

			for (ITouchArea area : ((Scene) screen).getTouchAreas()) {
				if (area instanceof ButtonScaleable) {
					ButtonScaleable yourButton = (ButtonScaleable) area;

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
						yourButton.unBind(pAreaTouchEvent.isActionUp());
					}
				}
			}

			return this.mModalTouch;
		case TouchEvent.ACTION_MOVE:
			if (this.isClicked) {
				if (this.mScaleX >= 1f) {
					this.modifier1.reset();
				}
			} else {
				org.anddev.andengine.entity.Entity screen1 = this.mParentScreen;

				/** At this point, we need to find the root of the parent of the entity, which, in turn, must be an instance of class Screen. */
				while (true) {
					if (screen1 instanceof Screen) {
						((Screen) screen1).registerTouchArea(this);

						break;
					}

					screen1 = (org.anddev.andengine.entity.Entity) screen1.getParent();
				}

				for (ITouchArea area : ((Scene) screen1).getTouchAreas()) {
					if (area instanceof ButtonScaleable) {
						ButtonScaleable yourButton = (ButtonScaleable) area;

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
							yourButton.unBind(pAreaTouchEvent.isActionUp());
						}
					}
				}
			}

			return this.mModalTouch;
		}

		return this.mModalTouch;
	}

	@Override
	public void onClick() {
	}

	public void unBind() {
		this.unBind(false);
	}

	public void unBind(final boolean pRemoveClick) {
		this.modifier1.stop();
		this.modifier2.stop();

		this.setScale(1f);

		if (pRemoveClick) {
			this.isClicked = false;
		}
	}

}
