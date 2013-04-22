package com.tooflya.signs.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class Shows extends Entity {

	public boolean doNotFade;

	public Shows(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.enableFullBlendFunction();
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		this.setAlpha(1f);

		this.doNotFade = false;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (!this.doNotFade) {
			if (this.mAlpha > 0f) {
				this.setAlpha(this.mAlpha - 0.02f);
			} else {
				this.destroy();
			}
		}
	}
}
