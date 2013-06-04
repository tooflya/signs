package com.tooflya.signs.cn.entities;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.shape.Shape;

public class BonusHolder extends Rectangle {

	public BonusHolder(float pX, float pY, float pWidth, float pHeight) {
		super(pX, pY, pWidth, pHeight);

		this.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.Entity#setPosition(float, float)
	 */
	@Override
	public void setPosition(final float pX, final float pY) {
		super.setPosition(pX, pY + 50f);

		this.mVisible = true;

		this.setAlpha(1f);
	}

	@Override
	public void setAlpha(final float pAlpha) {
		super.setAlpha(pAlpha);

		for (int i = 0; i < this.getChildCount(); i++) {
			((Shape) this.getChild(i)).setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
			this.getChild(i).setAlpha(pAlpha);
		}
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.mY -= 1;
		this.setAlpha(this.getAlpha() - 0.01f);

		if (this.mAlpha <= 0f) {
			this.mVisible = false;
		}
	}
}
