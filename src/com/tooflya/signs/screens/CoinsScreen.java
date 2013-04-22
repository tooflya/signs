package com.tooflya.signs.screens;

import com.tooflya.billing.BillingHelper;
import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.Resources;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;

/**
 * @author Tooflya.com
 * @since
 */
public class CoinsScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_BACK_BUTTON_X;
	private static float POSITION_BACK_BUTTON_Y;
	private static float POSITION_BACK_BUTTON_BACKGROUND_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_Y;
	private static float POSITION_PADDING_X_1;
	private static float POSITION_PADDING_Y_1;
	private static float POSITION_PADDING_Y_2;
	private static float POSITION_TEXT_X;
	private static float POSITION_TEXT_Y;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_BACK_BUTTON_X = 30f;
			POSITION_BACK_BUTTON_Y = 70f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 30f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 10f;
			POSITION_PADDING_X_1 = 65f;
			POSITION_PADDING_Y_1 = 90f;
			POSITION_PADDING_Y_2 = 20f;
			POSITION_TEXT_X = 4f;
			POSITION_TEXT_Y = 50f;
			break;
		case Resolutions.HD:
			POSITION_BACK_BUTTON_X = 60f;
			POSITION_BACK_BUTTON_Y = 140f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 30f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 170f;
			POSITION_PADDING_X_1 = 130f;
			POSITION_PADDING_Y_1 = 180f;
			POSITION_PADDING_Y_2 = 40f;
			POSITION_TEXT_X = 8f;
			POSITION_TEXT_Y = 100f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private final Entity mText;

	private final ButtonScaleable mGetCoinsButton1;
	private final ButtonScaleable mGetCoinsButton2;
	private final ButtonScaleable mGetCoinsButton3;
	private final ButtonScaleable mGetCoinsButton4;

	private final Entity mBackButtonBackground;
	private final ButtonScaleable mBackButton;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public CoinsScreen() {
		this.mText = new Entity(Resources.mGetStarsTxtTextureRegion, this.mPanel);

		this.mBackButtonBackground = new Entity(Resources.mSettingsBackgroundTextureRegion, this.mBackground);
		this.mBackButton = new ButtonScaleable(Resources.mBackButtonTextureRegion, this.mBackground) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				CoinsScreen.this.modifier2.reset();
			}
		};

		this.mBackButtonBackground.create().setPosition(POSITION_BACK_BUTTON_BACKGROUND_X, Options.cameraHeight - POSITION_BACK_BUTTON_BACKGROUND_Y);
		this.mBackButton.create().setPosition(POSITION_BACK_BUTTON_X, Options.cameraHeight - POSITION_BACK_BUTTON_Y);

		this.mText.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_TEXT_X, this.mPanel.getHeight() / 2 - POSITION_TEXT_Y);

		this.mGetCoinsButton1 = new ButtonScaleable(Resources.mGetStars1TextureRegion, this.mPanel) {

			@Override
			public void onClick() {
				if (BillingHelper.isBillingSupported()) {
					BillingHelper.requestPurchase(Game.mContext, "purchase_of_10000_coins");
				}

				CoinsScreen.this.onBackPressed();
			}
		};

		this.mGetCoinsButton2 = new ButtonScaleable(Resources.mGetStars2TextureRegion, this.mPanel) {

			@Override
			public void onClick() {
				if (BillingHelper.isBillingSupported()) {
					BillingHelper.requestPurchase(Game.mContext, "purchase_of_15000_coins");
				}

				CoinsScreen.this.onBackPressed();
			}
		};

		this.mGetCoinsButton3 = new ButtonScaleable(Resources.mGetStars3TextureRegion, this.mPanel) {

			@Override
			public void onClick() {
				if (BillingHelper.isBillingSupported()) {
					BillingHelper.requestPurchase(Game.mContext, "purchase_of_25000_coins");
				}

				CoinsScreen.this.onBackPressed();
			}
		};

		this.mGetCoinsButton4 = new ButtonScaleable(Resources.mGetStars4TextureRegion, this.mPanel) {

			@Override
			public void onClick() {
				if (BillingHelper.isBillingSupported()) {
					BillingHelper.requestPurchase(Game.mContext, "purchase_of_50000_coins");
				}

				CoinsScreen.this.onBackPressed();
			}
		};

		this.mGetCoinsButton1.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_PADDING_X_1, this.mPanel.getHeight() / 2 + POSITION_PADDING_Y_2);
		this.mGetCoinsButton2.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_PADDING_X_1, this.mPanel.getHeight() / 2 + POSITION_PADDING_Y_2);
		this.mGetCoinsButton3.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_PADDING_X_1, this.mPanel.getHeight() / 2 + POSITION_PADDING_Y_1);
		this.mGetCoinsButton4.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_PADDING_X_1, this.mPanel.getHeight() / 2 + POSITION_PADDING_Y_1);

		this.mPanel.changeTextureRegion(Resources.mEndPopupTextureRegion);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	@Override
	public void onDetached() {
		Game.mScreens.get(Screen.SHOP).clearChildScene();
	}

}
