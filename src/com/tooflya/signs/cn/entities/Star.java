package com.tooflya.signs.cn.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;

public class Star extends Entity {

	private boolean mIsScaleReverse;

	private float mScaleSpeed;
	private float mRotationSpeed;
	private float mMoveSpeed;

	public Star(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.enableBlendFunction();
	}

	public Star create(final float pX, final float pY) {
		this.create().setCenterPosition(pX + (Game.random.nextBoolean() ? Game.random.nextInt(50) : -Game.random.nextInt(50)), pY + (Game.random.nextBoolean() ? Game.random.nextInt(50) : -Game.random.nextInt(50)));

		return this;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		this.mScaleSpeed = 0.02f + Game.random.nextFloat() / 2f / 10f;
		this.mRotationSpeed = (Game.random.nextBoolean() ? Game.random.nextInt(3) : -Game.random.nextInt(3));
		this.mMoveSpeed = (Game.random.nextBoolean() ? Game.random.nextFloat() : -Game.random.nextFloat());

		this.mScaleX = 0f;
		this.mScaleY = 0f;

		this.mIsScaleReverse = false;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (this.mIsScaleReverse) {
			this.mScaleX -= this.mScaleSpeed;
			this.mScaleY -= this.mScaleSpeed;

			if (this.mScaleX <= 0f) {
				this.destroy();
			}
		} else {
			this.mScaleX += this.mScaleSpeed;
			this.mScaleY += this.mScaleSpeed;

			if (this.mScaleX >= 1f) {
				this.mIsScaleReverse = true;
			}
		}

		this.mX += this.mMoveSpeed;
		this.mY += this.mMoveSpeed;

		this.mRotation += this.mRotationSpeed;
	}
}
