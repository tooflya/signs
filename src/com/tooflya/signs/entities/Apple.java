package com.tooflya.signs.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class Apple extends Entity {

	private final static float SPEED = 1f;

	private float mFactorX;
	private float mFactorY;

	private boolean mLookLeft;
	private boolean mLookLeftReverse;
	private float mLookLeftTime;

	private boolean mLookRight;
	private boolean mLookRightReverse;
	private float mLookRightTime;

	private boolean mLookUp;
	private boolean mLookUpReverse;
	private float mLookUpTime;

	private boolean mLookDown;
	private boolean mLookDownReverse;
	private float mLookDownTime;

	private boolean mPostLookLeft;
	private boolean mPostLookRight;
	private boolean mPostLookUp;
	private boolean mPostLookDown;

	private float mAnimationTime;

	public Apple(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		this.mFactorX = 0f;
		this.mFactorY = 0f;

		this.mAnimationTime = 0f;

		this.mLookLeft = false;
		this.mLookLeftReverse = false;
		this.mLookLeftTime = 0;

		this.mLookRight = false;
		this.mLookRightReverse = false;
		this.mLookRightTime = 0;

		this.mLookUp = false;
		this.mLookUpReverse = false;
		this.mLookUpTime = 0;

		this.mLookDown = false;
		this.mLookDownReverse = false;
		this.mLookDownTime = 0;

		this.mPostLookLeft = false;
		this.mPostLookRight = false;
		this.mPostLookUp = false;
		this.mPostLookDown = false;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.mAnimationTime += pSecondsElapsed;

		if (this.mLookLeft) {
			if (this.mAnimationTime >= 0.05f) {
				if (!this.mLookLeftReverse) {
					this.mFactorX -= SPEED;

					if (this.mFactorX <= -5f) {
						this.mLookLeftReverse = true;
					}
				} else {
					this.mLookLeftTime += pSecondsElapsed;

					if (this.mLookLeftTime >= (this.mPostLookRight || this.mPostLookLeft ? -1f : 0.2f)) {
						this.mFactorX += SPEED;

						if (this.mFactorX >= 0f) {
							this.mLookLeftTime = 0f;

							this.mLookLeft = false;
							this.mLookLeftReverse = false;

							this.onLookLeftFinished();
						}
					}
				}

				this.mAnimationTime = 0f;
			}
		}

		if (this.mLookRight) {
			if (this.mAnimationTime >= 0.05f) {
				if (!this.mLookRightReverse) {
					this.mFactorX += SPEED;

					if (this.mFactorX >= 5f) {
						this.mLookRightReverse = true;
					}
				} else {
					this.mLookRightTime += pSecondsElapsed;

					if (this.mLookRightTime >= (this.mPostLookLeft || this.mPostLookRight ? -1f : 0.2f)) {
						this.mFactorX -= SPEED;

						if (this.mFactorX <= 0f) {
							this.mLookRightTime = 0f;

							this.mLookRight = false;
							this.mLookRightReverse = false;

							this.onLookRightFinished();
						}
					}
				}

				this.mAnimationTime = 0f;
			}
		}

		if (this.mLookUp) {
			if (this.mAnimationTime >= 0.05f) {
				if (!this.mLookUpReverse) {
					this.mFactorY -= SPEED;

					if (this.mFactorY <= -5f) {
						this.mLookUpReverse = true;
					}
				} else {
					this.mLookUpTime += pSecondsElapsed;

					if (this.mLookUpTime >= (this.mPostLookDown || this.mPostLookUp ? -1f : 0.2f)) {
						this.mFactorY += SPEED;

						if (this.mFactorY >= 0f) {
							this.mLookUpTime = 0f;

							this.mLookUp = false;
							this.mLookUpReverse = false;

							this.onLookUpFinished();
						}
					}
				}

				this.mAnimationTime = 0f;
			}
		}

		if (this.mLookDown) {
			if (this.mAnimationTime >= 0.05f) {
				if (!this.mLookDownReverse) {
					this.mFactorY += SPEED;

					if (this.mFactorY == +5f) {
						this.mLookDownReverse = true;
					}
				} else {
					this.mLookDownTime += pSecondsElapsed;

					if (this.mLookDownTime >= (this.mPostLookUp || this.mPostLookDown ? -1f : 0.2f)) {
						this.mFactorY -= SPEED;

						if (this.mFactorY <= 0f) {
							this.mLookDownTime = 0f;

							this.mLookDown = false;
							this.mLookDownReverse = false;

							this.onLookDownFinished();
						}
					}
				}

				this.mAnimationTime = 0f;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.Entity#setCenterPosition(float, float)
	 */
	@Override
	public void setCenterPosition(final float pCenterX, final float pCenterY) {
		super.setCenterPosition(pCenterX + this.mFactorX, pCenterY + this.mFactorY);
	}

	public void lookLeft() {
		this.mLookLeft = true;
	}

	public void lookRight() {
		this.mLookRight = true;
	}

	public void lookUp() {
		this.mLookUp = true;
	}

	public void lookDown() {
		this.mLookDown = true;
	}

	//

	public void lookFromLeftToRight() {
		this.mLookLeft = true;
		this.mPostLookRight = true;
	}

	public void lookFromRightToLeft() {
		this.mLookRight = true;
		this.mPostLookLeft = true;
	}

	public void lookFromUpToDown() {
		this.mLookUp = true;
		this.mPostLookDown = true;
	}

	public void lookFromDownToUp() {
		this.mLookDown = true;
		this.mPostLookUp = true;
	}

	//

	public void onLookLeftFinished() {
		this.mPostLookLeft = false;

		if (this.mPostLookRight) {
			this.mLookRight = true;
		}
	}

	public void onLookRightFinished() {
		this.mPostLookRight = false;

		if (this.mPostLookLeft) {
			this.mLookLeft = true;
		}
	}

	public void onLookUpFinished() {
		this.mPostLookUp = false;

		if (this.mPostLookDown) {
			this.mLookDown = true;
		}
	}

	public void onLookDownFinished() {
		this.mPostLookDown = false;

		if (this.mPostLookUp) {
			this.mLookUp = true;
		}
	}
}
