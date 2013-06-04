package com.tooflya.signs.cn.entities;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.screens.Screen;
import com.tooflya.signs.cn.screens.ShopScreen;

public class ShopButton extends ButtonScaleable {

	private int mPrice;
	private int mIndex;

	public float padding;

	private float mNX;
	private float mNY;

	public ShopButton(TiledTextureRegion pTiledTextureRegion, org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.mNX = 0;
		this.mNY = 0;
	}

	public Entity create(final int pPrice, final int pIndex) {
		this.mPrice = pPrice;
		this.mIndex = pIndex;

		return this;
	}

	@Override
	public void onClick() {
		if (this.mPrice > ShopScreen.STARS) {
			if(!Options.IS_CHINA_VERSION) {
				Game.mScreens.setChildScreen(Game.mScreens.get(Screen.COINS), false, false, true);
			}
		} else {
			final ShopScreen screen = (ShopScreen) Game.mScreens.get(Screen.SHOP);

			if (this.isAvailable()) {
				Game.mDatabase.removeItem(this.mIndex);
				Game.mDatabase.removeStarsCount(this.mPrice);

				screen.mPriceNumbers.getByIndex((this.mIndex - 1) * 4).destroy();
				screen.mPriceNumbers.getByIndex((this.mIndex - 1) * 4 + 1).destroy();
				screen.mPriceNumbers.getByIndex((this.mIndex - 1) * 4 + 2).destroy();
				screen.mPriceNumbers.getByIndex((this.mIndex - 1) * 4 + 3).destroy();

				screen.mGetButtonBackgrounds.getByIndex(this.mIndex - 1).destroy();

				screen.mPurchased.create().setCenterPosition(this.getCenterX() - 50.0f	, this.getCenterY());

				this.destroy();

				ShopScreen.STARS -= this.mPrice;
			}
		}
	}

	@Override
	public void onManagedUpdate(float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.setCenterPosition(this.mNX, this.mNY + this.padding);
	}

	@Override
	public void setCenterPosition(float pCenterX, float pCenterY) {
		super.setCenterPosition(pCenterX, pCenterY);

		if (this.mNX == 0) {
			this.mNX = pCenterX;
			this.mNY = pCenterY;
		}
	}
}
