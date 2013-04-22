package com.tooflya.signs.entities;

import com.tooflya.signs.Options;

public class Rectangle extends org.anddev.andengine.entity.primitive.Rectangle {

	public Rectangle(float pX, float pY, float pWidth, float pHeight) {
		super(pX, pY, pWidth, pHeight);

		if (pX == 0) {
			this.setAlpha(0f);
		}
	}

	public Rectangle() {
		super(0, 0, Options.cameraWidth, Options.cameraHeight);

		this.setAlpha(0f);
	}

	/**
	 * 
	 */
	public final void setBackgroundCenterPosition() {
		this.mX = Options.screenWidth / 2 - this.mScaleCenterX - (this.mWidth / 2 - this.mScaleCenterX) * this.mScaleX;
		this.mY = Options.screenHeight / 2 - this.mScaleCenterY - (this.mHeight / 2 - this.mScaleCenterY) * this.mScaleY;
	}
}
