package com.tooflya.signs.screens;

import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.input.touch.TouchEvent;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.entities.Rectangle;
import com.tooflya.signs.managers.ArrayEntityManager;

/**
 * @author Tooflya.com
 * @since
 */
public class ArchiementsScreen extends Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_BACK_BUTTON_X;
	private static float POSITION_BACK_BUTTON_Y;
	private static float POSITION_BACK_BUTTON_BACKGROUND_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_Y;
	private static float POSITION_SROLL_BAR_X;
	private static float POSITION_LIST_PADDING_Y;
	private static float POSITION_ICON_PADDING_Y;
	private static float POSITION_ICON_PADDING_X;
	private static float POSITION_DEVIDERS_PADDING_Y;

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
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private final Rectangle mBackground;

	private final Entity mBackgroundPicture;

	private final Entity mBackButtonBackground;
	private final ButtonScaleable mBackButton;

	private final Entity mScroolBar;

	private final Rectangle mList;

	private final ArrayEntityManager<Entity> mDeviders;
	private final ArrayEntityManager<Entity> mIcons;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public ArchiementsScreen() {
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
				ArchiementsScreen.this.onBackPressed();
			}
		};

		this.mScroolBar = new Entity(Resources.mScrollTextureRegion, this.mBackground);

		this.mList = new Rectangle(0, 0, 610f, 5f * 80f) {

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

				float k = this.mY / this.mHeight * 100f;

				ArchiementsScreen.this.mScroolBar.setPosition(ArchiementsScreen.this.mScroolBar.getX(), -((Options.cameraHeight - ArchiementsScreen.this.mScroolBar.getHeight()) / 100f * k), true);

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
		this.attachChild(this.mList);
		this.mList.setBackgroundCenterPosition();
		this.registerTouchArea(this.mList);

		this.mDeviders = new ArrayEntityManager<Entity>(10, new Entity(Resources.mDeviderTextureRegion, this.mList));
		this.mIcons = new ArrayEntityManager<Entity>(10, new Entity(Resources.mAchievementsIconTextureRegion, this.mList));

		this.mBackgroundPicture.create().setBackgroundCenterPosition();

		this.mBackButtonBackground.create().setPosition(POSITION_BACK_BUTTON_BACKGROUND_X, Options.cameraHeight - POSITION_BACK_BUTTON_BACKGROUND_Y);
		this.mBackButton.create().setPosition(POSITION_BACK_BUTTON_X, Options.cameraHeight - POSITION_BACK_BUTTON_Y);

		this.mScroolBar.create().setCenterPosition(Options.cameraCenterX + POSITION_SROLL_BAR_X, 10f);

		ArrayEntityManager<Entity> mLabels = new ArrayEntityManager<Entity>(10, new Entity(Resources.m2, this.mList));
		
		for (int i = 0; i < 5; i++) {
			this.mDeviders.create().setCenterPosition(this.mList.getWidth() / 2, POSITION_DEVIDERS_PADDING_Y + POSITION_LIST_PADDING_Y * i);
			this.mIcons.create().setCenterPosition(this.mList.getWidth() / 2 - POSITION_ICON_PADDING_X, POSITION_ICON_PADDING_Y + POSITION_LIST_PADDING_Y * i);
			mLabels.create().setCenterPosition(this.mList.getWidth() / 2 - POSITION_ICON_PADDING_X + 200, POSITION_ICON_PADDING_Y + POSITION_LIST_PADDING_Y * i);
		}
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onDetached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();
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
		}

		PauseScreen.ACTION = 0;
	}

	// ===========================================================
	// Methods
	// ===========================================================
}