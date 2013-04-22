package com.tooflya.signs.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.Game;

public class ButtonDifficulty extends ButtonScaleable {

	private final float mSpeed;

	private float mMoveTime;
	private float mTime = 0f;

	private boolean mReverse;

	public ButtonDifficulty(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.mSpeed = 0.04f + Game.random.nextFloat() / 10f;
		this.mMoveTime = 0.5f + Game.random.nextFloat();
		this.mReverse = Game.random.nextInt(2) > 0 ? true : false;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.mTime += pSecondsElapsed;

		if (this.mReverse) {
			this.mY += this.mSpeed;
		} else {
			this.mY -= this.mSpeed;
		}

		if (this.mTime >= this.mMoveTime) {
			this.mReverse = !this.mReverse;
			this.mTime = 0f;
		}

	}

	@Override
	public void setPosition(final float pX, final float pY) {
		super.setPosition(pX, pY - this.getHeight() / 2, true);
	}
}
