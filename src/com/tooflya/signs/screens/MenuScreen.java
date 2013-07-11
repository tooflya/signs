package com.tooflya.signs.screens;

import org.anddev.andengine.entity.modifier.AlphaModifier;
import org.anddev.andengine.entity.modifier.MoveModifier;
import org.anddev.andengine.entity.modifier.MoveYModifier;
import org.anddev.andengine.entity.modifier.RotationModifier;
import org.anddev.andengine.input.touch.TouchEvent;

import android.content.Intent;
import android.net.Uri;
import android.util.FloatMath;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.Resources;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.entities.LogoLetter;
import com.tooflya.signs.entities.Rectangle;
import com.tooflya.signs.entities.Text;
import com.tooflya.signs.managers.ArrayEntityManager;

/**
 * @author Tooflya.com
 * @since
 */
public class MenuScreen extends Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_MUSIC_MOVE_X_1;
	private static float POSITION_MUSIC_MOVE_X_2;
	private static float POSITION_MUSIC_MOVE_Y;
	private static float POSITION_SOUND_MOVE_X_1;
	private static float POSITION_SOUND_MOVE_X_2;
	private static float POSITION_SOUND_MOVE_Y;
	private static float POSITION_CREDITS_MOVE_X_1;
	private static float POSITION_CREDITS_MOVE_X_2;
	private static float POSITION_CREDITS_MOVE_Y;
	private static float POSITION_SETTING_BACKGROUND_X;
	private static float POSITION_SETTING_BACKGROUND_Y;
	private static float POSITION_SETTING_X;
	private static float POSITION_SETTING_Y;
	private static float POSITION_SOCIAL_BACKGROUND_X;
	private static float POSITION_SOCIAL_BACKGROUND_Y;
	private static float POSITION_MORE_GAMES_BUTTON_X;
	private static float POSITION_MORE_GAMES_BUTTON_Y;
	private static float POSITION_FACEBOOK_BUTTON_X;
	private static float POSITION_FACEBOOK_BUTTON_Y;
	private static float POSITION_TWITTER_BUTTON_X;
	private static float POSITION_TWITTER_BUTTON_Y;
	private static float POSITION_BESTSCORE_BACKGROUND_Y;
	private static float POSITION_SOUND_BACKGROUND_X;
	private static float POSITION_SOUND_BACKGROUND_Y;
	private static float POSITION_SOUND_BUTTON_X;
	private static float POSITION_SOUND_BUTTON_Y;
	private static float POSITION_MUSIC_BACKGROUND_X;
	private static float POSITION_MUSIC_BACKGROUND_Y;
	private static float POSITION_MUSIC_BUTTON_X;
	private static float POSITION_MUSIC_BUTTON_Y;
	private static float POSITION_CREDITS_BACKGROUND_X;
	private static float POSITION_CREDITS_BACKGROUND_Y;
	private static float POSITION_CREDITS_BUTTON_X;
	private static float POSITION_CREDITS_BUTTON_Y;
	private static float POSITION_ACHIEVEMENTS_BUTTON_X;
	private static float POSITION_ACHIEVEMENTS_BUTTON_Y;
	private static float POSITION_SHOP_BUTTON_X;
	private static float POSITION_SHOP_BUTTON_Y;
	private static float POSITION_PLAY_BUTTON_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_Y;
	private static float POSITION_BACK_BUTTON_X;
	private static float POSITION_BACK_BUTTON_Y;
	private static float POSITION_MUSIC_BACKGROUND_MOVE_X_1;
	private static float POSITION_MUSIC_BACKGROUND_MOVE_X_2;
	private static float POSITION_MUSIC_BACKGROUND_MOVE_Y;
	private static float POSITION_SOUND_BACKGROUND_MOVE_X_1;
	private static float POSITION_SOUND_BACKGROUND_MOVE_X_2;
	private static float POSITION_SOUND_BACKGROUND_MOVE_Y;
	private static float POSITION_CREDITS_BACKGROUND_MOVE_X_1;
	private static float POSITION_CREDITS_BACKGROUND_MOVE_X_2;
	private static float POSITION_CREDITS_BACKGROUND_MOVE_Y;
	private static float POSITION_LS1_BACKGROUND_X;
	private static float POSITION_LI_BACKGROUND_X;
	private static float POSITION_LG_BACKGROUND_X;
	private static float POSITION_LN_BACKGROUND_X;
	private static float POSITION_LS2_BACKGROUND_X;
	private static float POSITION_LS1_BACKGROUND_Y;
	private static float POSITION_LI_BACKGROUND_Y;
	private static float POSITION_LG_BACKGROUND_Y;
	private static float POSITION_LN_BACKGROUND_Y;
	private static float POSITION_LS2_BACKGROUND_Y;
	private static float POSITION_BEST_SCORE_POS_1_X;
	private static float POSITION_BEST_SCORE_POS_2_X;
	private static float POSITION_BEST_SCORE_POS_3_X;
	private static float POSITION_BEST_SCORE_POS_4_X;
	private static float POSITION_BEST_SCORE_POS_5_X;
	private static float POSITION_BEST_SCORE_POS_6_X;
	private static float POSITION_BEST_SCORE_POS_7_X;
	private static float POSITION_BEST_SCORE_POS_8_X;
	private static float POSITION_BEST_SCORE_POS_9_X;
	private static float POSITION_BEST_SCORE_POS_10_X;
	private static float POSITION_BEST_SCORE_POS_11_X;
	private static float POSITION_BEST_SCORE_POS_12_X;
	private static float POSITION_BEST_SCORE_POS_13_X;
	private static float POSITION_BEST_SCORE_POS_14_X;
	private static float POSITION_BEST_SCORE_POS_15_X;
	private static float POSITION_BEST_SCORE_POS_16_X;
	private static float POSITION_BEST_SCORE_POS_17_X;
	private static float POSITION_BEST_SCORE_POS_18_X;
	private static float POSITION_BEST_SCORE_POS_19_X;
	private static float POSITION_BEST_SCORE_POS_20_X;
	private static float POSITION_BEST_SCORE_POS_21_X;
	private static float POSITION_BEST_SCORE_POS_22_X;
	private static float POSITION_BEST_SCORE_POS_23_X;
	private static float POSITION_BEST_SCORE_POS_24_X;
	private static float POSITION_BEST_SCORE_POS_25_X;
	private static float POSITION_BEST_SCORE_POS_26_X;
	private static float POSITION_BEST_SCORE_POS_27_X;
	private static float POSITION_BEST_SCORE_POS_28_X;
	private static float POSITION_BEST_SCORE_POS_Y;
	private static float CREDITS_PADDING_1;
	private static float CREDITS_PADDING_2;
	private static float CREDITS_PADDING_3;
	private static float CREDITS_PADDING_4;
	private static float CREDITS_PADDING_5;
	private static float CREDITS_PADDING_6;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_MUSIC_MOVE_X_1 = 35f;
			POSITION_MUSIC_MOVE_X_2 = 105f;
			POSITION_MUSIC_MOVE_Y = 67f;
			POSITION_SOUND_MOVE_X_1 = 35f;
			POSITION_SOUND_MOVE_X_2 = 165f;
			POSITION_SOUND_MOVE_Y = 67f;
			POSITION_CREDITS_MOVE_X_1 = 35f;
			POSITION_CREDITS_MOVE_X_2 = 229f;
			POSITION_CREDITS_MOVE_Y = 63f;
			POSITION_SETTING_BACKGROUND_X = 10f;
			POSITION_SETTING_BACKGROUND_Y = 90f;
			POSITION_SETTING_X = 30f;
			POSITION_SETTING_Y = 70f;
			POSITION_SOCIAL_BACKGROUND_X = 210f;
			POSITION_SOCIAL_BACKGROUND_Y = 95f;
			POSITION_MORE_GAMES_BUTTON_X = 190f;
			POSITION_MORE_GAMES_BUTTON_Y = 72f;
			POSITION_FACEBOOK_BUTTON_X = 135f;
			POSITION_FACEBOOK_BUTTON_Y = 72f;
			POSITION_TWITTER_BUTTON_X = 82f;
			POSITION_TWITTER_BUTTON_Y = 75f;
			POSITION_BESTSCORE_BACKGROUND_Y = 50f;
			POSITION_SOUND_BACKGROUND_X = 25f;
			POSITION_SOUND_BACKGROUND_Y = 80f;
			POSITION_SOUND_BUTTON_X = 70f;
			POSITION_SOUND_BUTTON_Y = 140f;
			POSITION_MUSIC_BACKGROUND_X = 25f;
			POSITION_MUSIC_BACKGROUND_Y = 80f;
			POSITION_MUSIC_BUTTON_X = 70f;
			POSITION_MUSIC_BUTTON_Y = 140f;
			POSITION_CREDITS_BACKGROUND_X = 25f;
			POSITION_CREDITS_BACKGROUND_Y = 80f;
			POSITION_CREDITS_BUTTON_X = 70f;
			POSITION_CREDITS_BUTTON_Y = 140f;
			POSITION_ACHIEVEMENTS_BUTTON_X = 50f;
			POSITION_ACHIEVEMENTS_BUTTON_Y = 50f;
			POSITION_SHOP_BUTTON_X = 50f;
			POSITION_SHOP_BUTTON_Y = 50f;
			POSITION_PLAY_BUTTON_X = 4f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 10f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 90f;
			POSITION_BACK_BUTTON_X = 30f;
			POSITION_BACK_BUTTON_Y = 70f;
			POSITION_MUSIC_BACKGROUND_MOVE_X_1 = 25f;
			POSITION_MUSIC_BACKGROUND_MOVE_X_2 = 90f;
			POSITION_MUSIC_BACKGROUND_MOVE_Y = 80f;
			POSITION_SOUND_BACKGROUND_MOVE_X_1 = 25f;
			POSITION_SOUND_BACKGROUND_MOVE_X_2 = 150f;
			POSITION_SOUND_BACKGROUND_MOVE_Y = 80f;
			POSITION_CREDITS_BACKGROUND_MOVE_X_1 = 25f;
			POSITION_CREDITS_BACKGROUND_MOVE_X_2 = 210f;
			POSITION_CREDITS_BACKGROUND_MOVE_Y = 80f;
			POSITION_LS1_BACKGROUND_X = 130f;
			POSITION_LI_BACKGROUND_X = 85f;
			POSITION_LG_BACKGROUND_X = 40f;
			POSITION_LN_BACKGROUND_X = 10f;
			POSITION_LS2_BACKGROUND_X = 55f;
			POSITION_LS1_BACKGROUND_Y = 25f;
			POSITION_LI_BACKGROUND_Y = 15f;
			POSITION_LG_BACKGROUND_Y = 10f;
			POSITION_LN_BACKGROUND_Y = 10f;
			POSITION_LS2_BACKGROUND_Y = 25f;
			POSITION_BEST_SCORE_POS_1_X = 55f;
			POSITION_BEST_SCORE_POS_2_X = 48f;
			POSITION_BEST_SCORE_POS_3_X = 62f;
			POSITION_BEST_SCORE_POS_4_X = 40f;
			POSITION_BEST_SCORE_POS_5_X = 55f;
			POSITION_BEST_SCORE_POS_6_X = 70f;
			POSITION_BEST_SCORE_POS_7_X = 33f;
			POSITION_BEST_SCORE_POS_8_X = 48f;
			POSITION_BEST_SCORE_POS_9_X = 62f;
			POSITION_BEST_SCORE_POS_10_X = 72f;
			POSITION_BEST_SCORE_POS_11_X = 25f;
			POSITION_BEST_SCORE_POS_12_X = 40f;
			POSITION_BEST_SCORE_POS_13_X = 55f;
			POSITION_BEST_SCORE_POS_14_X = 70f;
			POSITION_BEST_SCORE_POS_15_X = 85f;
			POSITION_BEST_SCORE_POS_16_X = 18f;
			POSITION_BEST_SCORE_POS_17_X = 33f;
			POSITION_BEST_SCORE_POS_18_X = 48f;
			POSITION_BEST_SCORE_POS_19_X = 62f;
			POSITION_BEST_SCORE_POS_20_X = 77f;
			POSITION_BEST_SCORE_POS_21_X = 92f;
			POSITION_BEST_SCORE_POS_22_X = 10f;
			POSITION_BEST_SCORE_POS_23_X = 45f;
			POSITION_BEST_SCORE_POS_24_X = 40f;
			POSITION_BEST_SCORE_POS_25_X = 55f;
			POSITION_BEST_SCORE_POS_26_X = 70f;
			POSITION_BEST_SCORE_POS_27_X = 85f;
			POSITION_BEST_SCORE_POS_28_X = 100f;
			POSITION_BEST_SCORE_POS_Y = 35f;
			CREDITS_PADDING_1 = 100f;
			CREDITS_PADDING_2 = 80f;
			CREDITS_PADDING_3 = 60f;
			CREDITS_PADDING_4 = 40f;
			CREDITS_PADDING_5 = 20f;
			CREDITS_PADDING_6 = 130f;
			break;
		case Resolutions.HD:
			POSITION_MUSIC_MOVE_X_1 = 60f;
			POSITION_MUSIC_MOVE_X_2 = 200f;
			POSITION_MUSIC_MOVE_Y = 133f;
			POSITION_SOUND_MOVE_X_1 = 70f;
			POSITION_SOUND_MOVE_X_2 = 320f;
			POSITION_SOUND_MOVE_Y = 133f;
			POSITION_CREDITS_MOVE_X_1 = 70f;
			POSITION_CREDITS_MOVE_X_2 = 446f;
			POSITION_CREDITS_MOVE_Y = 128f;
			POSITION_SETTING_BACKGROUND_X = 30f;
			POSITION_SETTING_BACKGROUND_Y = 170f;
			POSITION_SETTING_X = 60f;
			POSITION_SETTING_Y = 140f;
			POSITION_SOCIAL_BACKGROUND_X = 380f;
			POSITION_SOCIAL_BACKGROUND_Y = 180f;
			POSITION_MORE_GAMES_BUTTON_X = 360f;
			POSITION_MORE_GAMES_BUTTON_Y = 144f;
			POSITION_FACEBOOK_BUTTON_X = 250f;
			POSITION_FACEBOOK_BUTTON_Y = 144f;
			POSITION_TWITTER_BUTTON_X = 145f;
			POSITION_TWITTER_BUTTON_Y = 150f;
			POSITION_BESTSCORE_BACKGROUND_Y = 50f;
			POSITION_SOUND_BACKGROUND_X = 50f;
			POSITION_SOUND_BACKGROUND_Y = 145f;
			POSITION_SOUND_BUTTON_X = 70f;
			POSITION_SOUND_BUTTON_Y = 140f;
			POSITION_MUSIC_BACKGROUND_X = 50f;
			POSITION_MUSIC_BACKGROUND_Y = 145f;
			POSITION_MUSIC_BUTTON_X = 70f;
			POSITION_MUSIC_BUTTON_Y = 140f;
			POSITION_CREDITS_BACKGROUND_X = 50f;
			POSITION_CREDITS_BACKGROUND_Y = 145f;
			POSITION_CREDITS_BUTTON_X = 70f;
			POSITION_CREDITS_BUTTON_Y = 140f;
			POSITION_ACHIEVEMENTS_BUTTON_X = 100f;
			POSITION_ACHIEVEMENTS_BUTTON_Y = 100f;
			POSITION_SHOP_BUTTON_X = 100f;
			POSITION_SHOP_BUTTON_Y = 100f;
			POSITION_PLAY_BUTTON_X = 4f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 30f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 170f;
			POSITION_BACK_BUTTON_X = 60f;
			POSITION_BACK_BUTTON_Y = 140f;
			POSITION_MUSIC_BACKGROUND_MOVE_X_1 = 50f;
			POSITION_MUSIC_BACKGROUND_MOVE_X_2 = 180f;
			POSITION_MUSIC_BACKGROUND_MOVE_Y = 153f;
			POSITION_SOUND_BACKGROUND_MOVE_X_1 = 50f;
			POSITION_SOUND_BACKGROUND_MOVE_X_2 = 300f;
			POSITION_SOUND_BACKGROUND_MOVE_Y = 153f;
			POSITION_CREDITS_BACKGROUND_MOVE_X_1 = 50f;
			POSITION_CREDITS_BACKGROUND_MOVE_X_2 = 420f;
			POSITION_CREDITS_BACKGROUND_MOVE_Y = 153f;
			POSITION_LS1_BACKGROUND_X = 260f;
			POSITION_LI_BACKGROUND_X = 170f;
			POSITION_LG_BACKGROUND_X = 80f;
			POSITION_LN_BACKGROUND_X = 20f;
			POSITION_LS2_BACKGROUND_X = 110f;
			POSITION_LS1_BACKGROUND_Y = 50f;
			POSITION_LI_BACKGROUND_Y = 30f;
			POSITION_LG_BACKGROUND_Y = 20f;
			POSITION_LN_BACKGROUND_Y = 20f;
			POSITION_LS2_BACKGROUND_Y = 50f;
			POSITION_BEST_SCORE_POS_1_X = 110f;
			POSITION_BEST_SCORE_POS_2_X = 96f;
			POSITION_BEST_SCORE_POS_3_X = 124f;
			POSITION_BEST_SCORE_POS_4_X = 80f;
			POSITION_BEST_SCORE_POS_5_X = 110f;
			POSITION_BEST_SCORE_POS_6_X = 140f;
			POSITION_BEST_SCORE_POS_7_X = 66f;
			POSITION_BEST_SCORE_POS_8_X = 96f;
			POSITION_BEST_SCORE_POS_9_X = 124f;
			POSITION_BEST_SCORE_POS_10_X = 144f;
			POSITION_BEST_SCORE_POS_11_X = 50f;
			POSITION_BEST_SCORE_POS_12_X = 80f;
			POSITION_BEST_SCORE_POS_13_X = 110f;
			POSITION_BEST_SCORE_POS_14_X = 140f;
			POSITION_BEST_SCORE_POS_15_X = 170f;
			POSITION_BEST_SCORE_POS_16_X = 36f;
			POSITION_BEST_SCORE_POS_17_X = 66f;
			POSITION_BEST_SCORE_POS_18_X = 96f;
			POSITION_BEST_SCORE_POS_19_X = 124f;
			POSITION_BEST_SCORE_POS_20_X = 154f;
			POSITION_BEST_SCORE_POS_21_X = 184f;
			POSITION_BEST_SCORE_POS_22_X = 20f;
			POSITION_BEST_SCORE_POS_23_X = 50f;
			POSITION_BEST_SCORE_POS_24_X = 80f;
			POSITION_BEST_SCORE_POS_25_X = 110f;
			POSITION_BEST_SCORE_POS_26_X = 140f;
			POSITION_BEST_SCORE_POS_27_X = 170f;
			POSITION_BEST_SCORE_POS_28_X = 200f;
			POSITION_BEST_SCORE_POS_Y = 70f;
			CREDITS_PADDING_1 = 150f;
			CREDITS_PADDING_2 = 120f;
			CREDITS_PADDING_3 = 90f;
			CREDITS_PADDING_4 = 60f;
			CREDITS_PADDING_5 = 30f;
			CREDITS_PADDING_6 = 200f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private final Rectangle mBackground;
	private final Entity mBackgroundPicture;
	private final Entity mSecondBackground;

	private final Entity mBestScoreBackground;
	private final Entity mSocialBackground;
	private final ButtonScaleable mMoreGamesButton;
	private final ButtonScaleable mFacebookButton;
	private final ButtonScaleable mTwitterButton;
	private final Entity mTooflyaLogo;

	private final Entity mSettingsBackground;
	private final ButtonScaleable mSettingsButton;

	private final Entity mSoundBackground;
	private final ButtonScaleable mSoundButton;

	private final Entity mMusicBackground;
	private final ButtonScaleable mMusicButton;

	private final Entity mCreditsBackground;
	private final ButtonScaleable mCreditsButton;

	private final ButtonScaleable mAchievementsButton;

	private final ButtonScaleable mShopButton;

	private final Entity mPlayBackground;
	private final ButtonScaleable mPlayButton;

	private final Entity mS1Background;
	private final Entity mIBackground;
	private final Entity mGBackground;
	private final Entity mNBackground;
	private final Entity mS2Background;

	private final LogoLetter mS1Letter;
	private final LogoLetter mILetter;
	private final LogoLetter mGLetter;
	private final LogoLetter mNLetter;
	private final LogoLetter mS2Letter;

	private final Rectangle mCreditsHolder;

	private int mBestScore;
	private int mCurrentBestScore;

	private final ArrayEntityManager<Entity> mBestScoreNumbers;

	private final RotationModifier mRotateOn = new RotationModifier(0.3f, 0f, 405f);
	private final RotationModifier mRotateOff = new RotationModifier(0.3f, 405f, 0f);

	private final MoveModifier mMusicMoveOn = new MoveModifier(0.3f, POSITION_MUSIC_MOVE_X_1, POSITION_MUSIC_MOVE_X_2, Options.cameraHeight - POSITION_MUSIC_MOVE_Y, Options.cameraHeight - POSITION_MUSIC_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.registerTouchArea(MenuScreen.this.mMusicButton);
		}

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onStarted()
		 */
		@Override
		public void onStarted() {
			MenuScreen.this.mMusicBackground.setVisible(true);
			MenuScreen.this.mMusicButton.setVisible(true);
		}
	};

	private final MoveModifier mMusicMoveOff = new MoveModifier(0.3f, POSITION_MUSIC_MOVE_X_2, POSITION_MUSIC_MOVE_X_1, Options.cameraHeight - POSITION_MUSIC_MOVE_Y, Options.cameraHeight - POSITION_MUSIC_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.mMusicBackground.setVisible(false);
			MenuScreen.this.mMusicButton.setVisible(false);

			MenuScreen.this.unregisterTouchArea(MenuScreen.this.mMusicButton);
		}
	};

	private final MoveModifier mSoundMoveOn = new MoveModifier(0.3f, POSITION_SOUND_MOVE_X_1, POSITION_SOUND_MOVE_X_2, Options.cameraHeight - POSITION_SOUND_MOVE_Y, Options.cameraHeight - POSITION_SOUND_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.registerTouchArea(MenuScreen.this.mSoundButton);
		}

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onStarted()
		 */
		@Override
		public void onStarted() {
			MenuScreen.this.mSoundBackground.setVisible(true);
			MenuScreen.this.mSoundButton.setVisible(true);
		}
	};

	private final MoveModifier mSoundMoveOff = new MoveModifier(0.3f, POSITION_SOUND_MOVE_X_2, POSITION_SOUND_MOVE_X_1, Options.cameraHeight - POSITION_SOUND_MOVE_Y, Options.cameraHeight - POSITION_SOUND_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.mSoundBackground.setVisible(false);
			MenuScreen.this.mSoundButton.setVisible(false);

			MenuScreen.this.unregisterTouchArea(MenuScreen.this.mSoundButton);
		}
	};

	private final MoveModifier mCreditsMoveOn = new MoveModifier(0.3f, POSITION_CREDITS_MOVE_X_1, POSITION_CREDITS_MOVE_X_2, Options.cameraHeight - POSITION_CREDITS_MOVE_Y, Options.cameraHeight - POSITION_CREDITS_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.registerTouchArea(MenuScreen.this.mCreditsButton);
		}

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onStarted()
		 */
		@Override
		public void onStarted() {
			MenuScreen.this.mCreditsBackground.setVisible(false);
			MenuScreen.this.mCreditsButton.setVisible(false);
		}
	};

	private final MoveModifier mCreditsMoveOff = new MoveModifier(0.3f, POSITION_CREDITS_MOVE_X_2, POSITION_CREDITS_MOVE_X_1, Options.cameraHeight - POSITION_CREDITS_MOVE_Y, Options.cameraHeight - POSITION_CREDITS_MOVE_Y) {

		/* (non-Javadoc)
		 * @see com.tooflya.bubblefun.modifiers.MoveModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.mCreditsBackground.setVisible(false);
			MenuScreen.this.mCreditsButton.setVisible(false);

			MenuScreen.this.unregisterTouchArea(MenuScreen.this.mCreditsButton);
		}
	};

	private final MoveModifier mMusicBackgroundMoveOn = new MoveModifier(0.3f, POSITION_MUSIC_BACKGROUND_MOVE_X_1, POSITION_MUSIC_BACKGROUND_MOVE_X_2, Options.cameraHeight - POSITION_MUSIC_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_MUSIC_BACKGROUND_MOVE_Y);
	private final MoveModifier mMusicBackgroundMoveOff = new MoveModifier(0.3f, POSITION_MUSIC_BACKGROUND_MOVE_X_2, POSITION_MUSIC_BACKGROUND_MOVE_X_1, Options.cameraHeight - POSITION_MUSIC_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_MUSIC_BACKGROUND_MOVE_Y);

	private final MoveModifier mSoundBackgroundMoveOn = new MoveModifier(0.3f, POSITION_SOUND_BACKGROUND_MOVE_X_1, POSITION_SOUND_BACKGROUND_MOVE_X_2, Options.cameraHeight - POSITION_SOUND_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_SOUND_BACKGROUND_MOVE_Y);
	private final MoveModifier mSoundBackgroundMoveOff = new MoveModifier(0.3f, POSITION_SOUND_BACKGROUND_MOVE_X_2, POSITION_SOUND_BACKGROUND_MOVE_X_1, Options.cameraHeight - POSITION_SOUND_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_SOUND_BACKGROUND_MOVE_Y);

	private final MoveModifier mCreditsBackgroundMoveOn = new MoveModifier(0.3f, POSITION_CREDITS_BACKGROUND_MOVE_X_1, POSITION_CREDITS_BACKGROUND_MOVE_X_2, Options.cameraHeight - POSITION_CREDITS_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_CREDITS_BACKGROUND_MOVE_Y);
	private final MoveModifier mCreditsBackgroundMoveOff = new MoveModifier(0.3f, POSITION_CREDITS_BACKGROUND_MOVE_X_2, POSITION_CREDITS_BACKGROUND_MOVE_X_1, Options.cameraHeight - POSITION_CREDITS_BACKGROUND_MOVE_Y, Options.cameraHeight - POSITION_CREDITS_BACKGROUND_MOVE_Y);

	private final Entity mBackButtonBackground;
	private final ButtonScaleable mBackButton;

	private final MoveYModifier mMoveAllDown = new MoveYModifier(0.3f, 0, Options.cameraHeight) {

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onStarted()
		 */
		@Override
		public void onStarted() {
			MenuScreen.this.mAlphaDown.reset();
		}

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.mBackButton.create();
			MenuScreen.this.mBackButtonBackground.create();

			MenuScreen.this.mCreditsHolder.setAlpha(1f);

			MenuScreen.this.mCreditsUp.reset();
		}
	};

	private final MoveYModifier mMoveAllUp = new MoveYModifier(0.3f, Options.cameraHeight, 0) {

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onStarted()
		 */
		@Override
		public void onStarted() {
			MenuScreen.this.mAlphaUp.reset();

			MenuScreen.this.mCreditsHolder.setAlpha(0f);

			MenuScreen.this.mCreditsDown.reset();
		}

		/* (non-Javadoc)
		 * @see org.anddev.andengine.util.modifier.BaseDurationModifier#onFinished()
		 */
		@Override
		public void onFinished() {
			MenuScreen.this.mBackButton.destroy();
			MenuScreen.this.mBackButtonBackground.destroy();
		}
	};

	private final AlphaModifier mAlphaDown = new AlphaModifier(0.3f, 1f, 0f);
	private final AlphaModifier mAlphaUp = new AlphaModifier(0.3f, 0f, 1f);

	private final MoveModifier mCreditsUp = new MoveModifier(1f, 0f, 0f, Options.cameraHeight, 50f) {

	};

	private final MoveModifier mCreditsDown = new MoveModifier(0.3f, 0f, 0f, 50f, Options.cameraHeight) {

	};

	// ===========================================================
	// Constructors
	// ===========================================================

	public MenuScreen() {
		this.mBackgroundPicture = new Entity(Resources.mMainMenuBackgroundTextureRegion, this);

		this.mBackground = new Rectangle();
		this.attachChild(this.mBackground);
		this.mBackground.setBackgroundCenterPosition();

		this.mSecondBackground = new Entity(Resources.mSpotsTextureRegion, this.mBackground);

		this.mSecondBackground.enableFullBlendFunction();
		this.mSecondBackground.registerEntityModifier(this.mAlphaUp);
		this.mSecondBackground.registerEntityModifier(this.mAlphaDown);

		final Rectangle buttons = new Rectangle();
		buttons.registerEntityModifier(this.mMoveAllUp);
		buttons.registerEntityModifier(this.mMoveAllDown);
		this.mBackground.attachChild(buttons);
		this.mBackground.setBackgroundCenterPosition();

		this.mBestScoreBackground = new Entity(Resources.mBestScoreBackgroundTextureRegion, buttons);
		this.mSocialBackground = new Entity(Resources.mSocialBackgroundTextureRegion, buttons);
		this.mMoreGamesButton = new ButtonScaleable(Resources.mMoreButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				try {
					Game.mContext.getPackageManager().getPackageInfo("com.facebook.katana", 0);
					Game.mInstance.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Tooflya+Inc.")));
				} catch (Exception e) {
					Game.mInstance.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:Tooflya+Inc.")));
				}
			}
		};

		this.mFacebookButton = new ButtonScaleable(Resources.mFacebookButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				try {
					Game.mContext.getPackageManager().getPackageInfo("com.facebook.katana", 0);
					Game.mInstance.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/386292514777918")));
				} catch (Exception e) {
					Game.mInstance.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/386292514777918")));
				}
			}
		};

		this.mTwitterButton = new ButtonScaleable(Resources.mTwitterButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				try {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=tooflya"));
					Game.mInstance.startActivity(intent);
				} catch (Exception e) {
					Game.mInstance.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/tooflya")));
				}
			}
		};

		this.mMusicBackground = new Entity(Resources.mSoundBackgroundTextureRegion, buttons);
		this.mMusicButton = new ButtonScaleable(Resources.mMusicButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				this.setCurrentTileIndex(Options.isMusicEnabled ? 1 : 0);
				Options.isMusicEnabled = !Options.isMusicEnabled;

				if (!Options.isMusicEnabled) {
					Options.mMainSound.pause();
				} else {
					Options.mMainSound.play();
				}
			}
		};

		this.mSoundBackground = new Entity(Resources.mSoundBackgroundTextureRegion, buttons);
		this.mSoundButton = new ButtonScaleable(Resources.mSoundButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				this.setCurrentTileIndex(Options.isSoundEnabled ? 1 : 0);
				Options.isSoundEnabled = !Options.isSoundEnabled;
			}
		};

		this.mCreditsBackground = new Entity(Resources.mSoundBackgroundTextureRegion, buttons);
		this.mCreditsButton = new ButtonScaleable(Resources.mCreditsButtonTextureRegion, buttons) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.anddev.andengine.entity.shape.Shape#onAreaTouched(org.anddev.andengine.input.touch.TouchEvent, float, float)
			 */
			@Override
			public boolean onAreaTouched(final TouchEvent pAreaTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				return false;
			}
			
			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				//MenuScreen.this.mMoveAllDown.reset();
			}
		};
		this.mCreditsBackground.setVisible(false);
		this.mCreditsButton.setVisible(false);

		this.mSettingsBackground = new Entity(Resources.mSettingsBackgroundTextureRegion, buttons);
		this.mSettingsButton = new ButtonScaleable(Resources.mSettingsButtonTextureRegion, buttons) {

			private boolean rotation = false;

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				if (this.rotation) {
					MenuScreen.this.mRotateOff.reset();
					MenuScreen.this.mCreditsMoveOff.reset();
					MenuScreen.this.mSoundMoveOff.reset();
					MenuScreen.this.mMusicMoveOff.reset();
					MenuScreen.this.mCreditsBackgroundMoveOff.reset();
					MenuScreen.this.mSoundBackgroundMoveOff.reset();
					MenuScreen.this.mMusicBackgroundMoveOff.reset();
				} else {
					MenuScreen.this.mRotateOn.reset();
					MenuScreen.this.mCreditsMoveOn.reset();
					MenuScreen.this.mSoundMoveOn.reset();
					MenuScreen.this.mMusicMoveOn.reset();
					MenuScreen.this.mCreditsBackgroundMoveOn.reset();
					MenuScreen.this.mSoundBackgroundMoveOn.reset();
					MenuScreen.this.mMusicBackgroundMoveOn.reset();
				}

				this.rotation = !this.rotation;
			}
		};

		this.mAchievementsButton = new ButtonScaleable(Resources.mAchievementButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Game.mScreens.set(Screen.ACHIEVEMENTS, true);
			}
		};

		this.mShopButton = new ButtonScaleable(Resources.mShopButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Game.mScreens.set(Screen.SHOP, true);
			}
		};

		this.mPlayBackground = new Entity(Resources.mPlayBackgroundTextureRegion, buttons);
		this.mPlayButton = new ButtonScaleable(Resources.mPlayButtonTextureRegion, buttons) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Game.mScreens.setChildScreen(Game.mScreens.get(Screen.MODE), false, false, true);
			}
		};

		this.mBackgroundPicture.create().setBackgroundCenterPosition();
		this.mSecondBackground.create().setCenterPosition(Options.cameraCenterX, Options.cameraCenterY);
		this.mSocialBackground.create().setPosition(Options.cameraWidth - POSITION_SOCIAL_BACKGROUND_X, Options.cameraHeight - POSITION_SOCIAL_BACKGROUND_Y);
		this.mMoreGamesButton.create().setPosition(Options.cameraWidth - POSITION_MORE_GAMES_BUTTON_X, Options.cameraHeight - POSITION_MORE_GAMES_BUTTON_Y);
		this.mFacebookButton.create().setPosition(Options.cameraWidth - POSITION_FACEBOOK_BUTTON_X, Options.cameraHeight - POSITION_FACEBOOK_BUTTON_Y);
		this.mTwitterButton.create().setPosition(Options.cameraWidth - POSITION_TWITTER_BUTTON_X, Options.cameraHeight - POSITION_TWITTER_BUTTON_Y);
		this.mBestScoreBackground.create().setPosition(0, Options.cameraCenterY - POSITION_BESTSCORE_BACKGROUND_Y);

		this.mSettingsBackground.create().setPosition(POSITION_SETTING_BACKGROUND_X, Options.cameraHeight - POSITION_SETTING_BACKGROUND_Y);
		this.mSettingsButton.create().setPosition(POSITION_SETTING_X, Options.cameraHeight - POSITION_SETTING_Y);

		this.mSoundBackground.create().setPosition(POSITION_SOUND_BACKGROUND_X, Options.cameraHeight - POSITION_SOUND_BACKGROUND_Y);
		this.mSoundButton.create().setPosition(POSITION_SOUND_BUTTON_X, Options.cameraHeight - POSITION_SOUND_BUTTON_Y);

		this.mMusicBackground.create().setPosition(POSITION_MUSIC_BACKGROUND_X, Options.cameraHeight - POSITION_MUSIC_BACKGROUND_Y);
		this.mMusicButton.create().setPosition(POSITION_MUSIC_BUTTON_X, Options.cameraHeight - POSITION_MUSIC_BUTTON_Y);

		this.mCreditsBackground.create().setPosition(POSITION_CREDITS_BACKGROUND_X, Options.cameraHeight - POSITION_CREDITS_BACKGROUND_Y);
		this.mCreditsButton.create().setPosition(POSITION_CREDITS_BUTTON_X, Options.cameraHeight - POSITION_CREDITS_BUTTON_Y);

		this.mAchievementsButton.create().setCenterPosition(Options.cameraCenterX - POSITION_ACHIEVEMENTS_BUTTON_X, Options.cameraCenterY + POSITION_ACHIEVEMENTS_BUTTON_Y);
		this.mShopButton.create().setCenterPosition(Options.cameraCenterX + POSITION_SHOP_BUTTON_X, Options.cameraCenterY + POSITION_SHOP_BUTTON_Y);

		this.mPlayBackground.create().setCenterPosition(Options.cameraCenterX, Options.cameraCenterY);
		this.mPlayButton.create().setCenterPosition(Options.cameraCenterX + POSITION_PLAY_BUTTON_X, Options.cameraCenterY);

		this.mSettingsButton.registerEntityModifier(this.mRotateOn);
		this.mSettingsButton.registerEntityModifier(this.mRotateOff);

		this.mMusicButton.registerEntityModifier(this.mMusicMoveOn);
		this.mMusicButton.registerEntityModifier(this.mMusicMoveOff);

		this.mSoundButton.registerEntityModifier(this.mSoundMoveOn);
		this.mSoundButton.registerEntityModifier(this.mSoundMoveOff);

		this.mCreditsButton.registerEntityModifier(this.mCreditsMoveOn);
		this.mCreditsButton.registerEntityModifier(this.mCreditsMoveOff);

		this.mMusicBackground.registerEntityModifier(this.mMusicBackgroundMoveOn);
		this.mMusicBackground.registerEntityModifier(this.mMusicBackgroundMoveOff);

		this.mSoundBackground.registerEntityModifier(this.mSoundBackgroundMoveOn);
		this.mSoundBackground.registerEntityModifier(this.mSoundBackgroundMoveOff);

		this.mCreditsBackground.registerEntityModifier(this.mCreditsBackgroundMoveOn);
		this.mCreditsBackground.registerEntityModifier(this.mCreditsBackgroundMoveOff);

		this.mMusicBackground.setVisible(false);
		this.mMusicButton.setVisible(false);

		this.mSoundBackground.setVisible(false);
		this.mSoundButton.setVisible(false);

		this.mCreditsBackground.setVisible(false);
		this.mCreditsButton.setVisible(false);

		this.unregisterTouchArea(this.mMusicButton);
		this.unregisterTouchArea(this.mSoundButton);
		this.unregisterTouchArea(this.mCreditsButton);

		this.mS1Background = new Entity(Resources.mS1BackgroundCircleTextureRegion, this.mBackground);
		this.mIBackground = new Entity(Resources.mIBackgroundCircleTextureRegion, this.mBackground);
		this.mGBackground = new Entity(Resources.mGBackgroundCircleTextureRegion, this.mBackground);
		this.mNBackground = new Entity(Resources.mNBackgroundCircleTextureRegion, this.mBackground);
		this.mS2Background = new Entity(Resources.mS2BackgroundCircleTextureRegion, this.mBackground);

		this.mS1Letter = new LogoLetter(Resources.mS1LetterTextureRegion, this.mBackground);
		this.mILetter = new LogoLetter(Resources.mILetterTextureRegion, this.mBackground);
		this.mGLetter = new LogoLetter(Resources.mGLetterTextureRegion, this.mBackground);
		this.mNLetter = new LogoLetter(Resources.mNLetterTextureRegion, this.mBackground);
		this.mS2Letter = new LogoLetter(Resources.mS2LetterTextureRegion, this.mBackground);

		this.mS1Background.create().setPosition(Options.cameraCenterX - POSITION_LS1_BACKGROUND_X, POSITION_LS1_BACKGROUND_Y, true);
		this.mIBackground.create().setPosition(Options.cameraCenterX - POSITION_LI_BACKGROUND_X, POSITION_LI_BACKGROUND_Y, true);
		this.mGBackground.create().setPosition(Options.cameraCenterX - POSITION_LG_BACKGROUND_X, POSITION_LG_BACKGROUND_Y, true);
		this.mNBackground.create().setPosition(Options.cameraCenterX + POSITION_LN_BACKGROUND_X, POSITION_LN_BACKGROUND_Y, true);
		this.mS2Background.create().setPosition(Options.cameraCenterX + POSITION_LS2_BACKGROUND_X, POSITION_LS2_BACKGROUND_Y, true);

		this.mS1Letter.create().setCenterPosition(this.mS1Background.getCenterX() - 10f / Options.cameraRatioFactor, this.mS1Background.getCenterY() - 10f / Options.cameraRatioFactor);
		this.mILetter.create().setCenterPosition(this.mIBackground.getCenterX() - 10f / Options.cameraRatioFactor, this.mIBackground.getCenterY() - 10f / Options.cameraRatioFactor);
		this.mGLetter.create().setCenterPosition(this.mGBackground.getCenterX() - 10f / Options.cameraRatioFactor, this.mGBackground.getCenterY() - 10f / Options.cameraRatioFactor);
		this.mNLetter.create().setCenterPosition(this.mNBackground.getCenterX() - 10f / Options.cameraRatioFactor, this.mNBackground.getCenterY() - 10f / Options.cameraRatioFactor);
		this.mS2Letter.create().setCenterPosition(this.mS2Background.getCenterX() - 10f / Options.cameraRatioFactor, this.mS2Background.getCenterY() - 10f / Options.cameraRatioFactor);

		this.mBackButtonBackground = new Entity(Resources.mSettingsBackgroundTextureRegion, this.mBackground);
		this.mBackButton = new ButtonScaleable(Resources.mBackButtonTextureRegion, this.mBackground) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				MenuScreen.this.mMoveAllUp.reset();
			}
		};

		this.mBackButtonBackground.setPosition(POSITION_BACK_BUTTON_BACKGROUND_X, Options.cameraHeight - POSITION_BACK_BUTTON_BACKGROUND_Y);
		this.mBackButton.setPosition(POSITION_BACK_BUTTON_X, Options.cameraHeight - POSITION_BACK_BUTTON_Y);

		this.mBestScoreNumbers = new ArrayEntityManager<Entity>(7, new Entity(Resources.mBestScoreNumbersTextureRegion, this.mBestScoreBackground));

		this.mBestScoreNumbers.create().setCenterPosition(50f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(80f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(110f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(140f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(70f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(200f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);
		this.mBestScoreNumbers.create().setCenterPosition(230f / Options.cameraRatioFactor, POSITION_BEST_SCORE_POS_Y);

		this.mCreditsHolder = new Rectangle(0, Options.cameraHeight, 0, 0) {

			@Override
			public void setAlpha(final float pAlpha) {
				super.setAlpha(pAlpha);

				for (int i = 0; i < this.getChildCount(); i++) {
					this.getChild(i).setAlpha(pAlpha);
				}
			}
		};
		this.mBackground.attachChild(this.mCreditsHolder);

		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_1 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_1")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_2 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_2")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_3 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_3")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_4 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_4")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_5 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_5")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY, Resources.mFont, Game.getString("credits_6")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY + CREDITS_PADDING_5 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_7")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY + CREDITS_PADDING_4 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_8")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY + CREDITS_PADDING_3 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_9")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY + CREDITS_PADDING_2 * Options.cameraRatioFactor, Resources.mFont, Game.getString("credits_10")));
		this.mCreditsHolder.attachChild(new Text(Options.cameraCenterX, Options.cameraCenterY + (CREDITS_PADDING_1 + CREDITS_PADDING_5) * Options.cameraRatioFactor, Resources.mFont, Game.getString("www.tooflya.com")));

		this.mCreditsHolder.registerEntityModifier(this.mCreditsUp);
		this.mCreditsHolder.registerEntityModifier(this.mCreditsDown);

		this.mTooflyaLogo = new Entity(Resources.mTooflyaLogo, this.mCreditsHolder);
		this.mTooflyaLogo.create().setCenterPosition(Options.cameraCenterX, Options.cameraCenterY - CREDITS_PADDING_6 * Options.cameraRatioFactor);

		this.mCreditsHolder.setAlpha(0f);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.Screen#onManagedUpdate(float)
	 */
	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		if (this.mCurrentBestScore < this.mBestScore) {
			if (this.mBestScore - this.mCurrentBestScore > 1111) {
				this.mCurrentBestScore += 1111;
			} else if (this.mBestScore - this.mCurrentBestScore > 111) {
				this.mCurrentBestScore += 111;
			} else if (this.mBestScore - this.mCurrentBestScore > 11) {
				this.mCurrentBestScore += 11;
			} else {
				this.mCurrentBestScore++;
			}
		}

		if (this.mCurrentBestScore < 10) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex(this.mCurrentBestScore);
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(false);
			this.mBestScoreNumbers.getByIndex(2).setVisible(false);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_1_X, POSITION_BEST_SCORE_POS_Y);
		} else if (this.mCurrentBestScore < 100) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 10));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(false);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_2_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_3_X, POSITION_BEST_SCORE_POS_Y);
		} else if (this.mCurrentBestScore < 1000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 100));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(false);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_4_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_5_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(2).setCenterPosition(POSITION_BEST_SCORE_POS_6_X, POSITION_BEST_SCORE_POS_Y);
		} else if (this.mCurrentBestScore < 10000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 1000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(false);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_7_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_8_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(2).setCenterPosition(POSITION_BEST_SCORE_POS_9_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(3).setCenterPosition(POSITION_BEST_SCORE_POS_10_X, POSITION_BEST_SCORE_POS_Y);
		} else if (this.mCurrentBestScore < 100000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 10000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(false);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_11_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_12_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(2).setCenterPosition(POSITION_BEST_SCORE_POS_13_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(3).setCenterPosition(POSITION_BEST_SCORE_POS_14_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(4).setCenterPosition(POSITION_BEST_SCORE_POS_15_X, POSITION_BEST_SCORE_POS_Y);
		} else if (this.mCurrentBestScore < 1000000) {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 100000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100000) * 100000) / 10000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(true);
			this.mBestScoreNumbers.getByIndex(6).setVisible(false);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_16_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_17_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(2).setCenterPosition(POSITION_BEST_SCORE_POS_18_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(3).setCenterPosition(POSITION_BEST_SCORE_POS_19_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(4).setCenterPosition(POSITION_BEST_SCORE_POS_20_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(5).setCenterPosition(POSITION_BEST_SCORE_POS_21_X, POSITION_BEST_SCORE_POS_Y);
		} else {
			this.mBestScoreNumbers.getByIndex(0).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore / 1000000));
			this.mBestScoreNumbers.getByIndex(1).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 1000000) * 1000000) / 100000));
			this.mBestScoreNumbers.getByIndex(2).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100000) * 100000) / 10000));
			this.mBestScoreNumbers.getByIndex(3).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 10000) * 10000) / 1000));
			this.mBestScoreNumbers.getByIndex(4).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 1000) * 1000) / 100));
			this.mBestScoreNumbers.getByIndex(5).setCurrentTileIndex((int) FloatMath.floor((this.mCurrentBestScore - FloatMath.floor(this.mCurrentBestScore / 100) * 100) / 10));
			this.mBestScoreNumbers.getByIndex(6).setCurrentTileIndex((int) FloatMath.floor(this.mCurrentBestScore % 10));
			this.mBestScoreNumbers.getByIndex(0).setVisible(true);
			this.mBestScoreNumbers.getByIndex(1).setVisible(true);
			this.mBestScoreNumbers.getByIndex(2).setVisible(true);
			this.mBestScoreNumbers.getByIndex(3).setVisible(true);
			this.mBestScoreNumbers.getByIndex(4).setVisible(true);
			this.mBestScoreNumbers.getByIndex(5).setVisible(true);
			this.mBestScoreNumbers.getByIndex(6).setVisible(true);

			this.mBestScoreNumbers.getByIndex(0).setCenterPosition(POSITION_BEST_SCORE_POS_22_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(1).setCenterPosition(POSITION_BEST_SCORE_POS_23_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(2).setCenterPosition(POSITION_BEST_SCORE_POS_24_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(3).setCenterPosition(POSITION_BEST_SCORE_POS_25_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(4).setCenterPosition(POSITION_BEST_SCORE_POS_26_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(5).setCenterPosition(POSITION_BEST_SCORE_POS_27_X, POSITION_BEST_SCORE_POS_Y);
			this.mBestScoreNumbers.getByIndex(6).setCenterPosition(POSITION_BEST_SCORE_POS_28_X, POSITION_BEST_SCORE_POS_Y);
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

		if (Options.isMusicEnabled) {
			if (!Options.mMainSound.isPlaying()) {
				Options.mMainSound.play();
			}

			if (Options.mLevelSound.isPlaying()) {
				Options.mLevelSound.pause();
			}

			if (Options.mEndSound.isPlaying()) {
				Options.mEndSound.pause();
			}
		}

		this.mBestScore = Game.mDatabase.getBestScore();
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

		Game.mScreens.get(Screen.MENU).clearChildScene();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		if (this.mBackButton.isAvailable()) {
			this.mMoveAllUp.reset();
		} else {
			if (this.hasChildScene()) {
				Game.mScreens.clearChildScreens();
			} else {
				Game.mScreens.setChildScreen(Game.mScreens.get(Screen.EXIT), false, false, true);
			}
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================
}