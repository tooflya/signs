package com.tooflya.signs.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class PanelStar extends Entity {

	private float mFactorX;

	public PanelStar(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (this.mX > this.mFactorX) {
			this.mX -= 10;
		} else {
			this.mX = this.mFactorX;
		}
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#setCenterPosition(float, float)
	 */
	@Override
	public void setCenterPosition(final float pCenterX, final float pCenterY) {
		super.setCenterPosition(pCenterX + 100f, pCenterY);

		this.mFactorX = pCenterX;
	}
}
