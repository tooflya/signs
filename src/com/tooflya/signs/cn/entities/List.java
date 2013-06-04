package com.tooflya.signs.cn.entities;

import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.screens.ShopScreen;


public class List extends Rectangle {

	public float mLastTouchY;
	public float mLastPositionY;

	public boolean mPostUpdate = false;

	public boolean created = false;
	
	private ShopScreen mShopScreen;

	public List(float pHeight, ShopScreen pShopScreen) {
		super(Options.cameraCenterX, 0, Options.screenWidth, pHeight);

		this.mShopScreen = pShopScreen;
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.scene.Scene#onManagedUpdate(float)
	 */
	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		/*for (int i = 0; i < 28; i++) {
			((ShopButton) ShopScreen.this.mGetButtons.getByIndex(i)).padding = this.getY();
		}*/
		
		float k = this.mY / this.mHeight * 100f;

		this.mShopScreen.mScroolBar.setPosition(this.mShopScreen.mScroolBar.getX(), -((Options.cameraHeight - this.mShopScreen.mScroolBar.getHeight()) / 100f * k), true);

		if (!this.created) {
			this.mY = 0;

			this.created = true;
		}

		if (this.mPostUpdate) {
			if (this.mY > 0 || this.mY < -this.mHeight) {
				if (this.mY > 0) {
					this.mY -= 15;
				} else {
					this.mY += 15;
				}
			} else {
				this.mPostUpdate = false;
			}
		}
	}
}
