package com.tooflya.signs.cn.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class Counter extends Entity {

	private float mTime;

	public Counter(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		this.setCurrentTileIndex(2);

		this.mTime = 0;

		this.setScale(1.6f);
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.mTime += pSecondsElapsed;

		this.setScale(this.getScaleX() - 0.01f);

		if (this.mTime >= 1f) {
			this.mTime = 0f;

			if (this.getCurrentTileIndex() == 0) {
				this.onFinished();
			} else {
				this.setCurrentTileIndex(this.getCurrentTileIndex() - 1);

				this.setScale(1.6f);
			}
		}
	}

	public void onFinished() {

	}
}
