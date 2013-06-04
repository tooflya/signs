package com.tooflya.signs.cn.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.Options.Resolutions;

public class LogoLetter extends Entity {

	private static float SPEED_LETTERS_FACTOR;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			SPEED_LETTERS_FACTOR = 1f;
			break;
		case Resolutions.HD:
			SPEED_LETTERS_FACTOR = 2f;
			break;
		}
	}

	private static float u = 0;

	private final float mSpeed;

	private float mMoveTime;
	private float mTime = 0f;

	private boolean mReverse;

	private boolean mIsAnimationEnd;

	private float mStopedY;

	public LogoLetter(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.mSpeed = (0.04f + Game.random.nextFloat() / 10f) * SPEED_LETTERS_FACTOR;
		this.mMoveTime = 0.5f + Game.random.nextFloat();
		this.mReverse = Game.random.nextInt(2) > 0 ? true : false;

		this.mIsAnimationEnd = false;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (this.mIsAnimationEnd) {
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
		} else {
			if (this.getCenterY() < this.mStopedY) {
				this.mY += 8f;
			} else {
				this.mIsAnimationEnd = true;
			}
		}
	}

	@Override
	public void setCenterPosition(final float pX, final float pY) {
		super.setCenterPosition(pX, pY);

		if (!this.mIsAnimationEnd) {
			this.mStopedY = pY;

			u -= 100f;

			super.setCenterPosition(pX, u);
		}
	}
}
