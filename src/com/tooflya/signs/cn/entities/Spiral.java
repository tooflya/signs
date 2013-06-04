package com.tooflya.signs.cn.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.Options.Resolutions;

public class Spiral extends Entity {

	private static int SPEED;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			SPEED = 1000;
			break;
		case Resolutions.HD:
			SPEED = 3000;
			break;
		}
	}

	private boolean mRotationReverse;

	private float mRotationSpeed;
	private float mAlphaSpeed;

	private boolean mNeedGoAway;

	public Spiral(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.enableFullBlendFunction();
	}

	public void goAway() {
		this.mNeedGoAway = true;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		this.mRotationReverse = Game.random.nextInt(2) > 0 ? true : false;
		this.mRotationSpeed = Game.random.nextFloat();
		this.mAlphaSpeed = Game.random.nextFloat() / 300;

		this.mAlpha = 1f;
		this.mRotation = 0f;
		this.mScaleX = 0f;
		this.mScaleY = 0f;

		this.setCurrentTileIndex(Game.random.nextInt(5));

		this.mNeedGoAway = false;
	}

	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (this.mNeedGoAway) {
			if (this.mY > Options.cameraCenterY) {
				this.mY += SPEED * pSecondsElapsed;
			} else {
				this.mY -= SPEED * pSecondsElapsed;
			}
			if (this.mX > Options.cameraCenterX) {
				this.mX += SPEED * pSecondsElapsed;
			} else {
				this.mX -= SPEED * pSecondsElapsed;
			}
		} else {
			if (this.mRotationReverse) {
				this.mRotation += this.mRotationSpeed;
			} else {
				this.mRotation -= this.mRotationSpeed;
			}

			if (this.mScaleX < 1f) {
				this.mScaleX += 0.01f;
				this.mScaleY += 0.01f;
			}

			this.mAlpha -= this.mAlphaSpeed;

			if (this.mAlpha <= 0f) {
				this.destroy();
			}
		}
	}
}
