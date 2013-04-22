package com.tooflya.signs.screens;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.input.touch.TouchEvent;

import android.util.FloatMath;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.entities.Rectangle;
import com.tooflya.signs.entities.ShopButton;
import com.tooflya.signs.managers.ArrayEntityManager;

/**
 * @author Tooflya.com
 * @since
 */
public class ShopScreen extends Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_BACK_BUTTON_X;
	private static float POSITION_BACK_BUTTON_Y;
	private static float POSITION_BACK_BUTTON_BACKGROUND_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_Y;
	private static float POSITION_SROLL_BAR_X;
	private static float POSITION_STARS_PANEL_X;
	private static float POSITION_STARS_PANEL_Y;
	private static float POSITION_LIST_PADDING_Y;
	private static float POSITION_ICON_PADDING_Y;
	private static float POSITION_ICON_PADDING_X;
	private static float POSITION_DEVIDERS_PADDING_Y;
	private static float POSITION_GET_STARS_BUTTON_X;
	private static float POSITION_GET_STARS_BUTTON_Y;
	private static float POSITION_GET_STARS_BACKGROUND_X;
	private static float POSITION_GET_STARS_BACKGROUND_Y;
	private static float POSITION_TEXT_PADDING_X_1;
	private static float POSITION_TEXT_PADDING_Y_1;
	private static float POSITION_TEXT_PADDING_X_2;
	private static float POSITION_TEXT_PADDING_Y_2;
	private static float POSITION_TEXT_PADDING_X_3;
	private static float POSITION_TEXT_PADDING_Y_3;
	private static float POSITION_TEXT_PADDING_X_4;
	private static float POSITION_TEXT_PADDING_Y_4;
	private static float POSITION_PURCHASED_X;
	private static float POSITION_PURCHASED_Y;
	private static float POSITION_GET_BACKGROUND_X;
	private static float POSITION_GET_BACKGROUND_Y;
	private static float POSITION_GET_BUTTON_X;
	private static float POSITION_GET_BUTTON_Y;
	private static float POSITION_NUMBERS_START_PADDING;
	private static float POSITION_NUMBERS_X;
	private static float POSITION_NUMBERS_Y;
	private static float POSITION_NUMBERS_REGULAR_Y;
	private static float POSITION_STARS_X_1;
	private static float POSITION_STARS_X_2;
	private static float POSITION_STARS_X_3;
	private static float POSITION_STARS_X_4;
	private static float POSITION_LIST_PADDING_Y2;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_BACK_BUTTON_X = 30f;
			POSITION_BACK_BUTTON_Y = 70f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 10f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 90f;
			POSITION_SROLL_BAR_X = 162f;
			POSITION_LIST_PADDING_Y = 80f;
			POSITION_ICON_PADDING_Y = 44f;
			POSITION_ICON_PADDING_X = 116f;
			POSITION_DEVIDERS_PADDING_Y = 80f;
			POSITION_STARS_PANEL_X = 220f;
			POSITION_STARS_PANEL_Y = 90f;
			POSITION_GET_STARS_BUTTON_X = 2f;
			POSITION_GET_STARS_BUTTON_Y = 7f;
			POSITION_GET_STARS_BACKGROUND_X = 70f;
			POSITION_GET_STARS_BACKGROUND_Y = 60f;
			POSITION_TEXT_PADDING_X_1 = 40f;
			POSITION_TEXT_PADDING_Y_1 = 44f;
			POSITION_TEXT_PADDING_X_2 = 48f;
			POSITION_TEXT_PADDING_Y_2 = 44f;
			POSITION_TEXT_PADDING_X_3 = 55f;
			POSITION_TEXT_PADDING_Y_3 = 44f;
			POSITION_TEXT_PADDING_X_4 = 65f;
			POSITION_TEXT_PADDING_Y_4 = 44f;
			POSITION_PURCHASED_X = 100f;
			POSITION_PURCHASED_Y = 50f;
			POSITION_GET_BACKGROUND_X = 100f;
			POSITION_GET_BACKGROUND_Y = 50f;
			POSITION_GET_BUTTON_X = 126f;
			POSITION_GET_BUTTON_Y = 44f;
			POSITION_NUMBERS_START_PADDING = 65f;
			POSITION_NUMBERS_X = 12f;
			POSITION_NUMBERS_Y = 50f;
			POSITION_NUMBERS_REGULAR_Y = 5f;
			POSITION_STARS_X_1 = 6f;
			POSITION_STARS_X_2 = 12f;
			POSITION_STARS_X_3 = 18f;
			POSITION_STARS_X_4 = 24f;
			break;
		case Resolutions.HD:
			POSITION_BACK_BUTTON_X = 60f;
			POSITION_BACK_BUTTON_Y = 140f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 30f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 170f;
			POSITION_SROLL_BAR_X = 309f;
			POSITION_LIST_PADDING_Y = 160f;
			POSITION_ICON_PADDING_Y = 88f;
			POSITION_ICON_PADDING_X = 232f;
			POSITION_DEVIDERS_PADDING_Y = 160f;
			POSITION_STARS_PANEL_X = 440f;
			POSITION_STARS_PANEL_Y = 180f;
			POSITION_GET_STARS_BUTTON_X = 4f;
			POSITION_GET_STARS_BUTTON_Y = 7f;
			POSITION_GET_STARS_BACKGROUND_X = 140f;
			POSITION_GET_STARS_BACKGROUND_Y = 120f;
			POSITION_TEXT_PADDING_X_1 = 80f;
			POSITION_TEXT_PADDING_Y_1 = 90f;
			POSITION_TEXT_PADDING_X_2 = 96f;
			POSITION_TEXT_PADDING_Y_2 = 90f;
			POSITION_TEXT_PADDING_X_3 = 110f;
			POSITION_TEXT_PADDING_Y_3 = 90f;
			POSITION_TEXT_PADDING_X_4 = 130f;
			POSITION_TEXT_PADDING_Y_4 = 90f;
			POSITION_PURCHASED_X = 200f;
			POSITION_PURCHASED_Y = 100f;
			POSITION_GET_BACKGROUND_X = 200f;
			POSITION_GET_BACKGROUND_Y = 100f;
			POSITION_GET_BUTTON_X = 320f;
			POSITION_GET_BUTTON_Y = 100f;
			POSITION_NUMBERS_START_PADDING = 130f;
			POSITION_NUMBERS_X = 24f;
			POSITION_NUMBERS_Y = 105f;
			POSITION_NUMBERS_REGULAR_Y = 9f;
			POSITION_STARS_X_1 = 12f;
			POSITION_STARS_X_2 = 24f;
			POSITION_STARS_X_3 = 36f;
			POSITION_STARS_X_4 = 48f;
			POSITION_LIST_PADDING_Y2 = 163.5f;
			break;
		}
	}

	public static int STARS;
	public static int Stars = 0;

	// ===========================================================
	// Fields
	// ===========================================================

	private final Rectangle mBackground;

	private final Entity mBackgroundPicture;

	private final Entity mBackButtonBackground;
	private final ButtonScaleable mBackButton;

	private final Entity mGetCoinsBackground;
	private final ButtonScaleable mGetCoinsButton;

	private final Entity mCoinsPanel;

	private final ArrayEntityManager<Entity> mStarsCountNumbers;

	public final Rectangle mList;

	private final Entity mScroolBar;

	private final ArrayEntityManager<Entity> mDeviders;
	public final ArrayEntityManager<Entity> mGetButtonBackgrounds;
	public final ArrayEntityManager<ShopButton> mGetButtons;
	private final ArrayEntityManager<Entity> mElements;
	private final ArrayEntityManager<Entity> mTextes1;
	private final ArrayEntityManager<Entity> mTextes2;
	private final ArrayEntityManager<Entity> mTextes3;
	private final ArrayEntityManager<Entity> mTextes4;
	private final ArrayEntityManager<Entity> mTextesNumbers;
	public final ArrayEntityManager<Entity> mPriceNumbers;
	public final ArrayEntityManager<Entity> mPurchased;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public ShopScreen() {
		this.setBackground(new ColorBackground(255f / 255f, 252f / 255f, 232f / 255f));

		this.mBackgroundPicture = new Entity(Resources.mShopBackgroundTextureRegion, this);

		this.mBackground = new Rectangle();
		this.attachChild(this.mBackground);
		this.mBackground.setBackgroundCenterPosition();

		this.mBackButtonBackground = new Entity(Resources.mSettingsBackgroundTextureRegion, this.mBackground);
		this.mBackButton = new ButtonScaleable(Resources.mBackButtonTextureRegion, this.mBackground) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				ShopScreen.this.onBackPressed();
			}
		};

		this.mGetCoinsBackground = new Entity(Resources.mGetStarsBackgroundTextureRegion, this.mBackground);
		this.mGetCoinsButton = new ButtonScaleable(Resources.mGetStarsTextureRegion, this.mBackground) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Game.mScreens.setChildScreen(Game.mScreens.get(Screen.COINS), false, false, true);
			}
		};

		this.mCoinsPanel = new Entity(Resources.mStarsBackgroundTextureRegion, this.mBackground);

		this.mStarsCountNumbers = new ArrayEntityManager<Entity>(5, new Entity(Resources.mStarsNumbersTextureRegion, this.mCoinsPanel));

		this.mList = new Rectangle(Options.cameraCenterX, 0, Options.cameraWidth, 46f * 80f) {

			private float mLastTouchY;
			private float mLastPositionY;

			private boolean mPostUpdate = false;

			private boolean created = false;

			/* (non-Javadoc)
			 * @see org.anddev.andengine.entity.scene.Scene#onManagedUpdate(float)
			 */
			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				for (int i = 0; i < 28; i++) {
					((ShopButton) ShopScreen.this.mGetButtons.getByIndex(i)).padding = this.getY();
				}
				
				float k = this.mY / this.mHeight * 100f;

				ShopScreen.this.mScroolBar.setPosition(ShopScreen.this.mScroolBar.getX(), -((Options.cameraHeight - ShopScreen.this.mScroolBar.getHeight()) / 100f * k), true);

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

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.anddev.andengine.entity.shape.Shape#onAreaTouched(org.anddev.andengine.input.touch.TouchEvent, float, float)
			 */
			@Override
			public boolean onAreaTouched(final TouchEvent pAreaTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				pTouchAreaLocalY *= Options.cameraRatioFactor;

				switch (pAreaTouchEvent.getAction()) {

				case TouchEvent.ACTION_DOWN:
					this.mPostUpdate = false;

					this.mLastTouchY = pTouchAreaLocalY;
					this.mLastPositionY = this.mY;
					break;
				case TouchEvent.ACTION_UP:
					this.mPostUpdate = true;
					break;
				case TouchEvent.ACTION_MOVE:
					this.mY = (pTouchAreaLocalY - this.mLastTouchY);
					this.mY += this.mLastPositionY;
					break;
				}

				return super.onAreaTouched(pAreaTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			};
		};
		this.mList.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		this.mList.setAlpha(0f);
		this.attachChild(this.mList);
		this.registerTouchArea(this.mList);

		this.mDeviders = new ArrayEntityManager<Entity>(28, new Entity(Resources.mDeviderTextureRegion, this.mList));
		this.mGetButtonBackgrounds = new ArrayEntityManager<Entity>(28, new Entity(Resources.mBuyButtonBackgroundTextureRegion, this.mList));
		this.mGetButtons = new ArrayEntityManager<ShopButton>(28, new ShopButton(Resources.mBuyButtonTextureRegion, this));
		this.mElements = new ArrayEntityManager<Entity>(28, new Entity(Resources.mShopElementsTextureRegion, this.mList));
		this.mTextes1 = new ArrayEntityManager<Entity>(28, new Entity(Resources.mFunnyFacesTextTextureRegion, this.mList));
		this.mTextes2 = new ArrayEntityManager<Entity>(28, new Entity(Resources.mHeadStafTextTextureRegion, this.mList));
		this.mTextes3 = new ArrayEntityManager<Entity>(28, new Entity(Resources.mMustacheTextTextureRegion, this.mList));
		this.mTextes4 = new ArrayEntityManager<Entity>(28, new Entity(Resources.mGlassesTextTextureRegion, this.mList));
		this.mTextesNumbers = new ArrayEntityManager<Entity>(40, new Entity(Resources.mWhiteNubersTextureRegion, this.mList));
		this.mPriceNumbers = new ArrayEntityManager<Entity>(150, new Entity(Resources.mStarsNumbersTextureRegion, this.mList));
		this.mPurchased = new ArrayEntityManager<Entity>(40, new Entity(Resources.mPurchasedTextureRegion, this.mList));

		this.mScroolBar = new Entity(Resources.mScrollTextureRegion, this.mBackground);

		this.mBackgroundPicture.create().setBackgroundCenterPosition();

		this.mBackButtonBackground.create().setPosition(POSITION_BACK_BUTTON_BACKGROUND_X, Options.cameraHeight - POSITION_BACK_BUTTON_BACKGROUND_Y);
		this.mBackButton.create().setPosition(POSITION_BACK_BUTTON_X, Options.cameraHeight - POSITION_BACK_BUTTON_Y);

		this.mGetCoinsBackground.create().setCenterPosition(Options.cameraWidth - POSITION_GET_STARS_BACKGROUND_X, Options.cameraHeight - POSITION_GET_STARS_BACKGROUND_Y);
		this.mGetCoinsButton.create().setCenterPosition(this.mGetCoinsBackground.getCenterX() - POSITION_GET_STARS_BUTTON_X, this.mGetCoinsBackground.getCenterY() - POSITION_GET_STARS_BUTTON_Y);

		this.mCoinsPanel.create().setCenterPosition(Options.cameraCenterX - POSITION_STARS_PANEL_X, POSITION_STARS_PANEL_Y);

		this.mStarsCountNumbers.create().setCenterPosition(this.mCoinsPanel.getWidth() / 2 + 12f, this.mCoinsPanel.getHeight() / 2);
		this.mStarsCountNumbers.create().setCenterPosition(this.mCoinsPanel.getWidth() / 2 + 24f, this.mCoinsPanel.getHeight() / 2);
		this.mStarsCountNumbers.create().setCenterPosition(this.mCoinsPanel.getWidth() / 2 + 36f, this.mCoinsPanel.getHeight() / 2);
		this.mStarsCountNumbers.create().setCenterPosition(this.mCoinsPanel.getWidth() / 2 + 48f, this.mCoinsPanel.getHeight() / 2);
		this.mStarsCountNumbers.create().setCenterPosition(this.mCoinsPanel.getWidth() / 2 + 60f, this.mCoinsPanel.getHeight() / 2);

		this.mScroolBar.create().setCenterPosition(Options.cameraCenterX + POSITION_SROLL_BAR_X, 10f);

		for (int i = 0; i < 28; i++) {
			final int price = 100 * (i + 1);
			final boolean isAvailable = Game.mDatabase.isItemAvailable(i + 1);

			if (i < 27) {
				this.mDeviders.create().setCenterPosition(this.mList.getWidth() / 2, POSITION_DEVIDERS_PADDING_Y + POSITION_LIST_PADDING_Y * i);
			}

			this.mGetButtonBackgrounds.create().setCenterPosition(this.mList.getWidth() / 2 + POSITION_GET_BACKGROUND_X, POSITION_GET_BACKGROUND_Y + POSITION_LIST_PADDING_Y * i);
			this.mGetButtons.create().create(price, i + 1).setCenterPosition(this.mList.getWidth() / 2 + POSITION_GET_BUTTON_X, POSITION_GET_BUTTON_Y + POSITION_LIST_PADDING_Y2 * i);

			final Entity element = this.mElements.create();
			element.setCenterPosition(this.mList.getWidth() / 2 - POSITION_ICON_PADDING_X, POSITION_ICON_PADDING_Y + POSITION_LIST_PADDING_Y * i);
			element.setCurrentTileIndex(i);

			if (i < 15) {
				final Entity text = this.mTextes1.create();
				text.setCenterPosition(this.mList.getWidth() / 2 - POSITION_TEXT_PADDING_X_1, POSITION_TEXT_PADDING_Y_1 + POSITION_LIST_PADDING_Y * i);

				final Entity number = this.mTextesNumbers.create();
				number.setPosition(text.getX() + text.getWidth() + 7f, text.getY() - 5f, true);
				number.setCurrentTileIndex(this.mTextes1.getCount() < 10 ? this.mTextes1.getCount() : 1);

				if (this.mTextes1.getCount() >= 10) {
					final Entity number2 = this.mTextesNumbers.create();
					number2.setPosition(text.getX() + text.getWidth() + 26f, text.getY() - 5f, true);
					number2.setCurrentTileIndex((this.mTextes1.getCount() - 10));
				}
			} else if (i < 20) {
				final Entity text = this.mTextes2.create();
				text.setCenterPosition(this.mList.getWidth() / 2 - POSITION_TEXT_PADDING_X_2, POSITION_TEXT_PADDING_Y_2 + POSITION_LIST_PADDING_Y * i);

				final Entity number = this.mTextesNumbers.create();
				number.setPosition(text.getX() + text.getWidth() + 2f, text.getY() - 5f, true);
				number.setCurrentTileIndex(this.mTextes2.getCount());
			} else if (i < 22) {
				final Entity text = this.mTextes3.create();
				text.setCenterPosition(this.mList.getWidth() / 2 - POSITION_TEXT_PADDING_X_3, POSITION_TEXT_PADDING_Y_3 + POSITION_LIST_PADDING_Y * i);

				final Entity number = this.mTextesNumbers.create();
				number.setPosition(text.getX() + text.getWidth() + 2f, text.getY() - 5f, true);
				number.setCurrentTileIndex(this.mTextes3.getCount());
			} else {
				final Entity text = this.mTextes4.create();
				text.setCenterPosition(this.mList.getWidth() / 2 - POSITION_TEXT_PADDING_X_4, POSITION_TEXT_PADDING_Y_4 + POSITION_LIST_PADDING_Y * i);

				final Entity number = this.mTextesNumbers.create();
				number.setPosition(text.getX() + text.getWidth() + 2f, text.getY() - 5f, true);
				number.setCurrentTileIndex(this.mTextes4.getCount());
			}
			for (int j = 0; j < 4; j++) {
				this.mPriceNumbers.create().setCenterPosition(this.mList.getWidth() / 2 + POSITION_NUMBERS_START_PADDING + POSITION_NUMBERS_X * j, POSITION_NUMBERS_Y + POSITION_LIST_PADDING_Y * i - POSITION_NUMBERS_REGULAR_Y);
			}

			if (price < 1000) {
				this.mPriceNumbers.getByIndex((i) * 4).setCurrentTileIndex((int) FloatMath.floor(price / 100));
				this.mPriceNumbers.getByIndex((i) * 4 + 1).setCurrentTileIndex((int) FloatMath.floor((price - FloatMath.floor(price / 100) * 100) / 10));
				this.mPriceNumbers.getByIndex((i) * 4 + 2).setCurrentTileIndex((int) FloatMath.floor(price % 10));
				this.mPriceNumbers.getByIndex((i) * 4).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 1).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 2).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 3).setVisible(false);
			} else {
				this.mPriceNumbers.getByIndex((i) * 4).setCurrentTileIndex((int) FloatMath.floor(price / 1000));
				this.mPriceNumbers.getByIndex((i) * 4 + 1).setCurrentTileIndex((int) FloatMath.floor((price - FloatMath.floor(price / 1000) * 1000) / 100));
				this.mPriceNumbers.getByIndex((i) * 4 + 2).setCurrentTileIndex((int) FloatMath.floor((price - FloatMath.floor(price / 100) * 100) / 10));
				this.mPriceNumbers.getByIndex((i) * 4 + 3).setCurrentTileIndex((int) FloatMath.floor(price % 10));
				this.mPriceNumbers.getByIndex((i) * 4).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 1).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 2).setVisible(true);
				this.mPriceNumbers.getByIndex((i) * 4 + 3).setVisible(true);
			}

			if (!isAvailable) {
				this.mGetButtonBackgrounds.getByIndex(i).destroy();
				this.mGetButtons.getByIndex(i).destroy();

				this.mPriceNumbers.getByIndex((i) * 4).setVisible(false);
				this.mPriceNumbers.getByIndex((i) * 4 + 1).setVisible(false);
				this.mPriceNumbers.getByIndex((i) * 4 + 2).setVisible(false);
				this.mPriceNumbers.getByIndex((i) * 4 + 3).setVisible(false);

				this.mPurchased.create().setCenterPosition(this.mList.getWidth() / 2 + POSITION_PURCHASED_X, POSITION_PURCHASED_Y + POSITION_LIST_PADDING_Y * i);
			}
		}
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.Screen#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (Stars < STARS) {
			/**
			 * if (STARS - Stars > 1111) { Stars += 1111; } else
			 **/
			if (STARS - Stars > 111) {
				Stars += 111;
			} else if (STARS - Stars > 11) {
				Stars += 11;
			} else {
				Stars++;
			}
		} else if (Stars > STARS) {
			/**
			 * if (Stars - STARS < 1111) { Stars -= 1111; } else
			 */
			if (Stars - STARS < 111) {
				Stars -= 111;
			} else if (Stars - STARS < 11) {
				Stars -= 11;
			} else {
				Stars--;
			}
		}

		if (Stars < 10) {
			this.mStarsCountNumbers.getByIndex(0).setCurrentTileIndex(Stars);
			this.mStarsCountNumbers.getByIndex(0).setVisible(true);
			this.mStarsCountNumbers.getByIndex(1).setVisible(false);
			this.mStarsCountNumbers.getByIndex(2).setVisible(false);
			this.mStarsCountNumbers.getByIndex(3).setVisible(false);
			this.mStarsCountNumbers.getByIndex(4).setVisible(false);

			this.mStarsCountNumbers.getByIndex(0).setCenterPosition(this.mCoinsPanel.getWidth() / 2, this.mCoinsPanel.getHeight() / 2);
		} else if (Stars < 100) {
			this.mStarsCountNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 10));
			this.mStarsCountNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsCountNumbers.getByIndex(0).setVisible(true);
			this.mStarsCountNumbers.getByIndex(1).setVisible(true);
			this.mStarsCountNumbers.getByIndex(2).setVisible(false);
			this.mStarsCountNumbers.getByIndex(3).setVisible(false);
			this.mStarsCountNumbers.getByIndex(4).setVisible(false);

			this.mStarsCountNumbers.getByIndex(0).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_1, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(1).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_1, this.mCoinsPanel.getHeight() / 2);
		} else if (Stars < 1000) {
			this.mStarsCountNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 100));
			this.mStarsCountNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 100) * 100) / 10));
			this.mStarsCountNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsCountNumbers.getByIndex(0).setVisible(true);
			this.mStarsCountNumbers.getByIndex(1).setVisible(true);
			this.mStarsCountNumbers.getByIndex(2).setVisible(true);
			this.mStarsCountNumbers.getByIndex(3).setVisible(false);
			this.mStarsCountNumbers.getByIndex(4).setVisible(false);

			this.mStarsCountNumbers.getByIndex(0).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_2, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(1).setCenterPosition(this.mCoinsPanel.getWidth() / 2, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(2).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_2, this.mCoinsPanel.getHeight() / 2);
		} else if (Stars < 10000) {
			this.mStarsCountNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 1000));
			this.mStarsCountNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 1000) * 1000) / 100));
			this.mStarsCountNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 100) * 100) / 10));
			this.mStarsCountNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsCountNumbers.getByIndex(0).setVisible(true);
			this.mStarsCountNumbers.getByIndex(1).setVisible(true);
			this.mStarsCountNumbers.getByIndex(2).setVisible(true);
			this.mStarsCountNumbers.getByIndex(3).setVisible(true);
			this.mStarsCountNumbers.getByIndex(4).setVisible(false);

			this.mStarsCountNumbers.getByIndex(0).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_3, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(1).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_1, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(2).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_1, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(3).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_3, this.mCoinsPanel.getHeight() / 2);
		} else {
			this.mStarsCountNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 10000));
			this.mStarsCountNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 10000) * 10000) / 1000));
			this.mStarsCountNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 1000) * 1000) / 100));
			this.mStarsCountNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 100) * 100) / 10));
			this.mStarsCountNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsCountNumbers.getByIndex(0).setVisible(true);
			this.mStarsCountNumbers.getByIndex(1).setVisible(true);
			this.mStarsCountNumbers.getByIndex(2).setVisible(true);
			this.mStarsCountNumbers.getByIndex(3).setVisible(true);
			this.mStarsCountNumbers.getByIndex(4).setVisible(true);

			this.mStarsCountNumbers.getByIndex(0).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_4, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(1).setCenterPosition(this.mCoinsPanel.getWidth() / 2 - POSITION_STARS_X_2, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(2).setCenterPosition(this.mCoinsPanel.getWidth() / 2, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(3).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_2, this.mCoinsPanel.getHeight() / 2);
			this.mStarsCountNumbers.getByIndex(4).setCenterPosition(this.mCoinsPanel.getWidth() / 2 + POSITION_STARS_X_4, this.mCoinsPanel.getHeight() / 2);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onDetached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();

		STARS = Game.mDatabase.getStarsCount();
	}

	/* (non-Javadoc)
	 * @see com.tooflya.bubblefun.screens.Screen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onDetached()
	 */
	@Override
	public void onDetached() {
		super.onDetached();

		this.mList.setPosition(this.mList.getX(), 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		if (this.hasChildScene()) {
			Game.mScreens.clearChildScreens();
		} else {
			if (PauseScreen.ACTION > 1) {
				Game.mScreens.set(Screen.LEVEL, true);
			} else {
				Game.mScreens.set(Screen.MENU, true);
			}

			PauseScreen.ACTION = 0;
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================
}