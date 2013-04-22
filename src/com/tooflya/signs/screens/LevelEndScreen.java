package com.tooflya.signs.screens;

import android.util.FloatMath;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.managers.ArrayEntityManager;

/**
 * @author Tooflya.com
 * @since
 */
public class LevelEndScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_STARS_Y;
	private static float POSITION_STARS_TEXT_Y;
	private static float POSITION_MODE_TEXT_Y;
	private static float POSITION_SCORE_TEXT_Y;
	private static float POSITION_DEVIDER_Y;
	private static float POSITION_BEST_SCORE_TEXT_Y;
	private static float POSITION_STARS_TEXT_X;
	private static float POSITION_SCORE_TEXT_X;
	private static float POSITION_BEST_SCORE_TEXT_X;
	private static float POSITION_PLAY_Y;
	private static float POSITION_MODE_TEXT_X_1;
	private static float POSITION_MODE_TEXT_X_2;
	private static float POSITION_MODE_TEXT_X_3;
	private static float POSITION_NUMBERS_X_1;
	private static float POSITION_NUMBERS_X_2;
	private static float POSITION_NUMBERS_X_3;
	private static float POSITION_NUMBERS_X_4;
	private static float POSITION_NUMBERS_X_5;
	private static float POSITION_NUMBERS_X_6;
	private static float POSITION_NUMBERS_X_7;
	private static float POSITION_MODE_TEXT_Y_2;
	private static float POSITION_NUMBERS_X_1_2;
	private static float POSITION_NUMBERS_X_2_2;
	private static float POSITION_NUMBERS_X_3_2;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_STARS_Y = 115f;
			POSITION_STARS_TEXT_Y = 85f;
			POSITION_MODE_TEXT_Y = 65f;
			POSITION_SCORE_TEXT_Y = 32f;
			POSITION_DEVIDER_Y = 10f;
			POSITION_BEST_SCORE_TEXT_Y = 10f;
			POSITION_STARS_TEXT_X = 31f;
			POSITION_SCORE_TEXT_X = 31f;
			POSITION_BEST_SCORE_TEXT_X = 61f;
			POSITION_PLAY_Y = 65f;
			POSITION_MODE_TEXT_Y_2 = 56f;
			POSITION_MODE_TEXT_X_1 = 0f;
			POSITION_MODE_TEXT_X_2 = 16f;
			POSITION_MODE_TEXT_X_3 = 11f;
			POSITION_NUMBERS_X_1 = 15f;
			POSITION_NUMBERS_X_2 = 30f;
			POSITION_NUMBERS_X_3 = 45f;
			POSITION_NUMBERS_X_4 = 60f;
			POSITION_NUMBERS_X_5 = 75f;
			POSITION_NUMBERS_X_6 = 90f;
			POSITION_NUMBERS_X_7 = 105f;
			POSITION_NUMBERS_X_1_2 = 12f;
			POSITION_NUMBERS_X_2_2 = 24f;
			POSITION_NUMBERS_X_3_2 = 36f;
			break;
		case Resolutions.HD:
			POSITION_STARS_Y = 230f;
			POSITION_STARS_TEXT_Y = 170f;
			POSITION_MODE_TEXT_Y = 130f;
			POSITION_SCORE_TEXT_Y = 64f;
			POSITION_DEVIDER_Y = 20f;
			POSITION_BEST_SCORE_TEXT_Y = 20f;
			POSITION_STARS_TEXT_X = 62f;
			POSITION_SCORE_TEXT_X = 62f;
			POSITION_BEST_SCORE_TEXT_X = 122f;
			POSITION_PLAY_Y = 130f;
			POSITION_MODE_TEXT_Y_2 = 112f;
			POSITION_MODE_TEXT_X_1 = 0f;
			POSITION_MODE_TEXT_X_2 = 32f;
			POSITION_MODE_TEXT_X_3 = 22f;
			POSITION_NUMBERS_X_1 = 30f;
			POSITION_NUMBERS_X_2 = 60f;
			POSITION_NUMBERS_X_3 = 90f;
			POSITION_NUMBERS_X_4 = 120f;
			POSITION_NUMBERS_X_5 = 150f;
			POSITION_NUMBERS_X_6 = 180f;
			POSITION_NUMBERS_X_7 = 210f;
			POSITION_NUMBERS_X_1_2 = 24f;
			POSITION_NUMBERS_X_2_2 = 48f;
			POSITION_NUMBERS_X_3_2 = 72f;
			break;
		}
	}

	private static int Score;
	private static int BestScore;
	private static int Stars;

	// ===========================================================
	// Fields
	// ===========================================================

	private final Entity mStars;
	private final Entity mStarsText;
	private final Entity mModeText;
	private final Entity mScoreText;
	private final Entity mBestScoreText;
	private final Entity mItemsCountBackground;

	private final Entity mDevider;

	private final ButtonScaleable mPlayButton;

	private final ArrayEntityManager<Entity> mBestScoreNumbers;
	private final ArrayEntityManager<Entity> mItemsNumbers;
	private final ArrayEntityManager<Entity> mStarsNumbers;
	private final ArrayEntityManager<Entity> mScoreNumbers;

	private final Entity mShopBackground;
	private final ButtonScaleable mShopButton;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public LevelEndScreen() {
		this.mStars = new Entity(Resources.mStarsIconTextureRegion, this.mPanel);
		this.mStarsText = new Entity(Resources.mTextStarsTextureRegion, this.mPanel);
		this.mModeText = new Entity(Resources.mNormalTextModeTextureRegion, this.mPanel);
		this.mScoreText = new Entity(Resources.mTextSCoreTextureRegion, this.mPanel);
		this.mBestScoreText = new Entity(Resources.mBestScoreTextTextureRegion, this.mPanel);

		this.mDevider = new Entity(Resources.mDeviderTextureRegion, this.mPanel);

		this.mPlayButton = new ButtonScaleable(Resources.mTapToPlayButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				LevelEndScreen.this.onBackPressed();
			}
		};

		this.mBestScoreNumbers = new ArrayEntityManager<Entity>(7, new Entity(Resources.mBestScoreNumbersTextureRegion, this.mPanel));
		this.mStarsNumbers = new ArrayEntityManager<Entity>(7, new Entity(Resources.mWhiteNubersTextureRegion, this.mPanel));
		this.mScoreNumbers = new ArrayEntityManager<Entity>(7, new Entity(Resources.mWhiteNubersTextureRegion, this.mPanel));

		this.mShopBackground = new Entity(Resources.mEndShopBackgroundTextureRegion, this.mPanel);
		this.mShopButton = new ButtonScaleable(Resources.mEndShopButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				PauseScreen.ACTION = 2;

				Game.mScreens.set(Screen.SHOP, true);
			}
		};

		this.mItemsCountBackground = new Entity(Resources.mPurchaseItemsCountBackgroundTextureRegion, this.mShopButton);
		//this.mItemsCountBackground.create().setCenterPosition(this.mShopButton.getWidth() / 2 + 25f, this.mShopButton.getHeight() / 2 - 25f);

		this.mItemsNumbers = new ArrayEntityManager<Entity>(2, new Entity(Resources.mBestScoreNumbersTextureRegion, this.mItemsCountBackground));
		//this.mItemsNumbers.create().setCenterPosition(this.mItemsCountBackground.getWidth() / 2 - 7f, this.mItemsCountBackground.getHeight() / 2);
		//this.mItemsNumbers.create().setCenterPosition(this.mItemsCountBackground.getWidth() / 2 + 7f, this.mItemsCountBackground.getHeight() / 2);

		this.mStars.create().setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 - POSITION_STARS_Y);
		this.mStarsText.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_STARS_TEXT_X, this.mPanel.getHeight() / 2 - POSITION_STARS_TEXT_Y);
		this.mModeText.create().setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 - POSITION_MODE_TEXT_Y);
		this.mScoreText.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_SCORE_TEXT_X, this.mPanel.getHeight() / 2 - POSITION_SCORE_TEXT_Y);
		this.mDevider.create().setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 - POSITION_DEVIDER_Y);
		this.mBestScoreText.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_BEST_SCORE_TEXT_X, this.mPanel.getHeight() / 2 + POSITION_BEST_SCORE_TEXT_Y);

		this.mPlayButton.create().setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 + POSITION_PLAY_Y);

		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_1, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_2, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_3, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_4, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_5, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_6, this.mBestScoreText.getCenterY());
		this.mBestScoreNumbers.create().setCenterPosition(this.mBestScoreText.getX() + this.mBestScoreText.getWidth() + POSITION_NUMBERS_X_7, this.mBestScoreText.getCenterY());

		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_1, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_2, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_3, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_4, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_5, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_6, this.mScoreText.getCenterY());
		this.mScoreNumbers.create().setCenterPosition(this.mScoreText.getX() + this.mScoreText.getWidth() + POSITION_NUMBERS_X_7, this.mScoreText.getCenterY());

		this.mStarsNumbers.create().setCenterPosition(this.mStarsText.getX() + this.mStarsText.getWidth() + POSITION_NUMBERS_X_1_2, this.mStarsText.getCenterY());
		this.mStarsNumbers.create().setCenterPosition(this.mStarsText.getX() + this.mStarsText.getWidth() + POSITION_NUMBERS_X_2_2, this.mStarsText.getCenterY());
		this.mStarsNumbers.create().setCenterPosition(this.mStarsText.getX() + this.mStarsText.getWidth() + POSITION_NUMBERS_X_3_2, this.mStarsText.getCenterY());

		this.mShopBackground.create().setCenterPosition(this.mPanel.getWidth() + 20f, this.mPanel.getHeight() / 2);
		this.mShopButton.create().setCenterPosition(this.mShopBackground.getCenterX(), this.mShopBackground.getCenterY());

		this.mPanel.changeTextureRegion(Resources.mEndPopupTextureRegion);
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

		if (Score < 10) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex(Score);
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(false);
			this.mScoreNumbers.getByIndex(2).setVisible(false);
			this.mScoreNumbers.getByIndex(3).setVisible(false);
			this.mScoreNumbers.getByIndex(4).setVisible(false);
			this.mScoreNumbers.getByIndex(5).setVisible(false);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else if (Score < 100) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 10));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(false);
			this.mScoreNumbers.getByIndex(3).setVisible(false);
			this.mScoreNumbers.getByIndex(4).setVisible(false);
			this.mScoreNumbers.getByIndex(5).setVisible(false);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else if (Score < 1000) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 100));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100) * 100) / 10));
			this.mScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(true);
			this.mScoreNumbers.getByIndex(3).setVisible(false);
			this.mScoreNumbers.getByIndex(4).setVisible(false);
			this.mScoreNumbers.getByIndex(5).setVisible(false);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else if (Score < 10000) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 1000));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 1000) * 1000) / 100));
			this.mScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100) * 100) / 10));
			this.mScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(true);
			this.mScoreNumbers.getByIndex(3).setVisible(true);
			this.mScoreNumbers.getByIndex(4).setVisible(false);
			this.mScoreNumbers.getByIndex(5).setVisible(false);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else if (Score < 100000) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 10000));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 10000) * 10000) / 1000));
			this.mScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 1000) * 1000) / 100));
			this.mScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100) * 100) / 10));
			this.mScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(true);
			this.mScoreNumbers.getByIndex(3).setVisible(true);
			this.mScoreNumbers.getByIndex(4).setVisible(true);
			this.mScoreNumbers.getByIndex(5).setVisible(false);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else if (Score < 1000000) {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 100000));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100000) * 100000) / 10000));
			this.mScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 10000) * 10000) / 1000));
			this.mScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 1000) * 1000) / 100));
			this.mScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100) * 100) / 10));
			this.mScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(true);
			this.mScoreNumbers.getByIndex(3).setVisible(true);
			this.mScoreNumbers.getByIndex(4).setVisible(true);
			this.mScoreNumbers.getByIndex(5).setVisible(true);
			this.mScoreNumbers.getByIndex(6).setVisible(false);
		} else {
			this.mScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Score / 1000000));
			this.mScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 1000000) * 1000000) / 100000));
			this.mScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100000) * 100000) / 10000));
			this.mScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 10000) * 10000) / 1000));
			this.mScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 1000) * 1000) / 100));
			this.mScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor((Score - FloatMath.floor(Score / 100) * 100) / 10));
			this.mScoreNumbers.getByIndex(6).setCurrentTileIndex((int) FloatMath.floor(Score % 10));
			this.mScoreNumbers.getByIndex(0).setVisible(true);
			this.mScoreNumbers.getByIndex(1).setVisible(true);
			this.mScoreNumbers.getByIndex(2).setVisible(true);
			this.mScoreNumbers.getByIndex(3).setVisible(true);
			this.mScoreNumbers.getByIndex(4).setVisible(true);
			this.mScoreNumbers.getByIndex(5).setVisible(true);
			this.mScoreNumbers.getByIndex(6).setVisible(true);
		}

		if (BestScore < 10) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex(BestScore);
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(false);
			this.mBestScoreNumbers.getByIndex(2).setVisible(false);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else if (BestScore < 100) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 10));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(false);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else if (BestScore < 1000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 100));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else if (BestScore < 10000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 1000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else if (BestScore < 100000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 10000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else if (BestScore < 1000000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 100000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100000) * 100000) / 10000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(true);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);
		} else {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(BestScore / 1000000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 1000000) * 1000000) / 100000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100000) * 100000) / 10000));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor((BestScore - FloatMath.floor(BestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(6).setCurrentTileIndex((int) FloatMath.floor(BestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(true);
			this.mBestScoreNumbers.getByIndex(6).setVisible(true);
		}

		if (Stars < 10) {
			this.mStarsNumbers.getByIndex(0).setCurrentTileIndex(Stars);
			this.mStarsNumbers.getByIndex(0).setVisible(true);
			this.mStarsNumbers.getByIndex(1).setVisible(false);
			this.mStarsNumbers.getByIndex(2).setVisible(false);
		} else if (Stars < 100) {
			this.mStarsNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 10));
			this.mStarsNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsNumbers.getByIndex(0).setVisible(true);
			this.mStarsNumbers.getByIndex(1).setVisible(true);
			this.mStarsNumbers.getByIndex(2).setVisible(false);
		} else {
			this.mStarsNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(Stars / 100));
			this.mStarsNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((Stars - FloatMath.floor(Stars / 100) * 100) / 10));
			this.mStarsNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor(Stars % 10));
			this.mStarsNumbers.getByIndex(0).setVisible(true);
			this.mStarsNumbers.getByIndex(1).setVisible(true);
			this.mStarsNumbers.getByIndex(2).setVisible(true);
		}
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onAttached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();

		switch (Options.mElementsCount) {
		case 4:
			this.mModeText.changeTextureRegion(Resources.mEasyTextModeTextureRegion);
			this.mModeText.setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 - POSITION_MODE_TEXT_Y_2);
			break;
		case 7:
			this.mModeText.changeTextureRegion(Resources.mNormalTextModeTextureRegion);
			this.mModeText.setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_MODE_TEXT_X_2, this.mPanel.getHeight() / 2 - POSITION_MODE_TEXT_Y_2);
			break;
		case 10:
			this.mModeText.changeTextureRegion(Resources.mExpertTextModeTextureRegion);
			this.mModeText.setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_MODE_TEXT_X_3, this.mPanel.getHeight() / 2 - POSITION_MODE_TEXT_Y_2);
			break;
		}

		if (LevelScreen.Score > LevelScreen.mBestScore) {
			Game.mDatabase.setCurrentBestScore(LevelScreen.Score);
		}

		Game.mDatabase.setStarsCount(LevelScreen.STARS);

		Score = LevelScreen.Score;
		BestScore = LevelScreen.mBestScore;
		Stars = LevelScreen.STARS;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onDetached()
	 */
	@Override
	public void onDetached() {
		if (Options.isMusicEnabled) {
			Options.mEndSound.pause();

			if (!Options.mLevelSound.isPlaying()) {
				Options.mLevelSound.play();
			}
		}

		Game.mScreens.get(Screen.LEVEL).clearChildScene();
		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = true;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
		if (Options.isMusicEnabled) {
			Options.mEndSound.play();

			if (Options.mLevelSound.isPlaying()) {
				Options.mLevelSound.pause();
			}
		}

		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).init();
		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = false;
	}
}
