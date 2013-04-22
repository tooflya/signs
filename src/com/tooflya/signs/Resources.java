package com.tooflya.signs;

import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.font.FontFactory;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.graphics.Color;

import com.tooflya.signs.Options.Resolutions;

public class Resources {

	// ===========================================================
	// Texture Atlases
	// ===========================================================

	public final static BitmapTextureAtlas mElementsTextureAtlas1;
	public final static BitmapTextureAtlas mElementsTextureAtlas2;
	public final static BitmapTextureAtlas mElementsTextureAtlas3;
	public final static BitmapTextureAtlas mElementsTextureAtlas4;
	public final static BitmapTextureAtlas mElementsTextureAtlas5;

	public static final Font mFont;

	// ===========================================================
	// Blank PNG 1024x1024
	// ===========================================================

	// ===========================================================
	// Texture Regions
	// ===========================================================

	public final static TiledTextureRegion mMainMenuBackgroundTextureRegion;
	public final static TiledTextureRegion mAchievementButtonTextureRegion;
	public final static TiledTextureRegion mCreditsButtonTextureRegion;
	public final static TiledTextureRegion mFacebookButtonTextureRegion;
	public final static TiledTextureRegion mMoreButtonTextureRegion;
	public final static TiledTextureRegion mPlayBackgroundTextureRegion;
	public final static TiledTextureRegion mPlayButtonTextureRegion;
	public final static TiledTextureRegion mSettingsBackgroundTextureRegion;
	public final static TiledTextureRegion mSettingsButtonTextureRegion;
	public final static TiledTextureRegion mShopButtonTextureRegion;
	public final static TiledTextureRegion mSoundBackgroundTextureRegion;
	public final static TiledTextureRegion mSoundButtonTextureRegion;
	public final static TiledTextureRegion mTwitterButtonTextureRegion;
	public final static TiledTextureRegion mSocialBackgroundTextureRegion;
	public final static TiledTextureRegion mS1BackgroundCircleTextureRegion;
	public final static TiledTextureRegion mIBackgroundCircleTextureRegion;
	public final static TiledTextureRegion mGBackgroundCircleTextureRegion;
	public final static TiledTextureRegion mNBackgroundCircleTextureRegion;
	public final static TiledTextureRegion mS2BackgroundCircleTextureRegion;
	public final static TiledTextureRegion mS1LetterTextureRegion;
	public final static TiledTextureRegion mILetterTextureRegion;
	public final static TiledTextureRegion mGLetterTextureRegion;
	public final static TiledTextureRegion mNLetterTextureRegion;
	public final static TiledTextureRegion mS2LetterTextureRegion;
	public final static TiledTextureRegion mBackButtonTextureRegion;
	public final static TiledTextureRegion mPopupTextureRegion;
	public final static TiledTextureRegion mDifficultyExpertButtonTextureRegion;
	public final static TiledTextureRegion mDifficultyNormalButtonTextureRegion;
	public final static TiledTextureRegion mDifficultyEasyButtonTextureRegion;
	public final static TiledTextureRegion mBonusBackgroundTextureRegion;
	public final static TiledTextureRegion mBonusNumbersTextureRegion;
	public final static TiledTextureRegion mGameAchievementsButtonTextureRegion;
	public final static TiledTextureRegion mGameMenuButtonTextureRegion;
	public final static TiledTextureRegion mGamePauseButtonTextureRegion;
	public final static TiledTextureRegion mGameRestartButtonTextureRegion;
	public final static TiledTextureRegion mGameRollBackgroundTextureRegion;
	public final static TiledTextureRegion mGameRollButtonTextureRegion;
	public final static TiledTextureRegion mGameShopButtonTextureRegion;
	public final static TiledTextureRegion mPopupNoButtonTextureRegion;
	public final static TiledTextureRegion mPopupYesButtonTextureRegion;
	public final static TiledTextureRegion mPopupBackMenuTextTextureRegion;
	public final static TiledTextureRegion mPanelStarTextureRegion;
	public final static TiledTextureRegion mPanelTextureRegion;
	public final static TiledTextureRegion mPopupButtonTextureRegion;
	public final static TiledTextureRegion mPopupPauseTextureRegion;
	public final static TiledTextureRegion mPopupNumbersTextureRegion;
	public final static TiledTextureRegion mPopupRestartTextTextureRegion;
	public final static TiledTextureRegion mScoreNumbersTextureRegion;
	public final static TiledTextureRegion mScoreTextTextureRegion;
	public final static TiledTextureRegion mHarryTextureRegion;
	public final static TiledTextureRegion mSpotsTextureRegion;

	public final static TiledTextureRegion mBlackCircleTextureRegion;
	public final static TiledTextureRegion mCircleTextureRegion;
	public final static TiledTextureRegion mExitTextTextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite1TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite2TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite3TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite4TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite5TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite6TextureRegion;
	public final static TiledTextureRegion mPopupRandomSprite7TextureRegion;
	public final static TiledTextureRegion mGameTableTextureRegion;

	public final static TiledTextureRegion mBestScoreNumbersTextureRegion;
	public final static TiledTextureRegion mTapToPlayButtonTextureRegion;
	public final static TiledTextureRegion mDeviderTextureRegion;
	public final static TiledTextureRegion mStarsIconTextureRegion;
	public final static TiledTextureRegion mBestScoreTextTextureRegion;
	public final static TiledTextureRegion mEasyTextModeTextureRegion;
	public final static TiledTextureRegion mExpertTextModeTextureRegion;
	public final static TiledTextureRegion mNormalTextModeTextureRegion;
	public final static TiledTextureRegion mTextSCoreTextureRegion;
	public final static TiledTextureRegion mTextStarsTextureRegion;
	public final static TiledTextureRegion mWhiteNubersTextureRegion;
	public final static TiledTextureRegion mEndPopupTextureRegion;

	public final static TiledTextureRegion mSignETextureRegion;
	public final static TiledTextureRegion mSignTextureRegion;

	public final static TiledTextureRegion mEndShopBackgroundTextureRegion;
	public final static TiledTextureRegion mEndShopButtonTextureRegion;
	public final static TiledTextureRegion mEyeAppleTextureRegion;

	public final static TiledTextureRegion mShowTextureRegion;
	public final static TiledTextureRegion mStarsTextureRegion;

	public final static TiledTextureRegion mGetStars1TextureRegion;
	public final static TiledTextureRegion mGetStars2TextureRegion;
	public final static TiledTextureRegion mGetStars3TextureRegion;
	public final static TiledTextureRegion mGetStars4TextureRegion;
	public final static TiledTextureRegion mGetStarsTxtTextureRegion;
	public final static TiledTextureRegion mShopBackgroundTextureRegion;
	public final static TiledTextureRegion mBuyButtonBackgroundTextureRegion;
	public final static TiledTextureRegion mBuyButtonTextureRegion;
	public final static TiledTextureRegion mGetStarsBackgroundTextureRegion;
	public final static TiledTextureRegion mGetStarsTextureRegion;
	public final static TiledTextureRegion mScrollTextureRegion;
	public final static TiledTextureRegion mStarsBackgroundTextureRegion;
	public final static TiledTextureRegion mStarsNumbersTextureRegion;

	public final static TiledTextureRegion mAchievementsIconTextureRegion;
	public final static TiledTextureRegion mFunnyFacesTextTextureRegion;
	public final static TiledTextureRegion mHeadStafTextTextureRegion;
	public final static TiledTextureRegion mMustacheTextTextureRegion;
	public final static TiledTextureRegion mGlassesTextTextureRegion;

	public final static TiledTextureRegion mScoreNumbersBigTextureRegion;
	public final static TiledTextureRegion mAlertBackgroundTextureRegion;
	public final static TiledTextureRegion mHaveOneMinuteTextureRegion;
	public final static TiledTextureRegion mHarryUpTextureRegion;
	public final static TiledTextureRegion mBestScoreTextureRegion;

	public final static TiledTextureRegion mGameTopElementsTextureRegion;
	public final static TiledTextureRegion mShopElementsTextureRegion;
	public final static TiledTextureRegion mMusicButtonTextureRegion;
	public final static TiledTextureRegion mTimerSecTextureRegion;
	public final static TiledTextureRegion mRedTimerSecTextureRegion;
	public final static TiledTextureRegion mPurchasedTextureRegion;
	public final static TiledTextureRegion mRedBonusNumbersTextureRegion;
	public final static TiledTextureRegion mBestScoreBackgroundTextureRegion;
	public final static TiledTextureRegion mPurchaseItemsCountBackgroundTextureRegion;
	public final static TiledTextureRegion mTooflyaLogo;

	public static final TiledTextureRegion mBlank1024Png1;
	public static final TiledTextureRegion mBlank1024Png2;
	public static final TiledTextureRegion mBlank1024Png3;
	public static final TiledTextureRegion mBlank1024Png4;
	public static final TiledTextureRegion mBlank1024Png5;

	public static TiledTextureRegion m2;

	// ===========================================================
	// Constructors
	// ===========================================================

	static
	{
		switch (Options.Resolution) {
		default:
			mElementsTextureAtlas1 = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas2 = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas3 = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas4 = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas5 = new BitmapTextureAtlas(1024, 1024, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

			mBlank1024Png1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "blank1024.png", 0, 0, 1, 1);
			mBlank1024Png2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "blank1024.png", 0, 0, 1, 1);
			mBlank1024Png3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "blank1024.png", 0, 0, 1, 1);
			mBlank1024Png4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "blank1024.png", 0, 0, 1, 1);
			mBlank1024Png5 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas5, Game.mContext, "blank1024.png", 0, 0, 1, 1);

			mFont = FontFactory.createFromAsset(mElementsTextureAtlas5, Game.mContext, "font/TitanOne-Regular.ttf", 15f * Options.cameraRatioFactor, true, Color.BLACK);

			mBackButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-back.png", 659, 753, 1, 1);
			mDifficultyEasyButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-easy.png", 776, 759, 1, 1);
			mDifficultyExpertButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-expert.png", 776, 719, 1, 1);
			mDifficultyNormalButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-normal.png", 763, 983, 1, 1);
			mPopupTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-popup.png", 2, 438, 1, 1);
			//mAchivTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-achiv-text-popup.png", 748, 832, 1, 1);
			mBonusBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-bg.png", 713, 652, 1, 1);
			mRedBonusNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-num-sprite-red.png", 2, 791, 14, 1);
			mBonusNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-num-sprite.png", 398, 900, 14, 1);
			mGameAchievementsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-achiv.png", 904, 913, 1, 1);
			mGameMenuButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-menu.png", 718, 744, 1, 1);
			mGamePauseButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-pause.png", 974, 546, 1, 1);
			mGameRestartButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-restart.png", 776, 933, 1, 1);
			mGameRollBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-roll-bg.png", 928, 2, 1, 1);
			mGameRollButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-roll.png", 847, 913, 1, 1);
			mGameShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-shop.png", 968, 500, 1, 1);
			mShowTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-light-sprite.png", 2, 2, 10, 1);
			mPopupNoButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-btn-no.png", 931, 832, 1, 1);
			mPopupYesButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-btn-yes.png", 952, 643, 1, 1);
			mPopupBackMenuTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-text.png", 603, 478, 1, 1);
			mPanelStarTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-panel-star.png", 377, 943, 1, 1);
			mPanelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-panel.png", 379, 438, 1, 1);
			mPopupButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-pause-popup-btn.png", 592, 983, 1, 1);
			mPopupPauseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-pause-popup-text.png", 578, 557, 1, 1);
			mPopupNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-restart-popup-num-sprite.png", 668, 933, 3, 1);
			mPopupRestartTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-restart-popup-text.png", 235, 975, 1, 1);
			mScoreNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-num-sprite.png", 608, 377, 13, 1);
			mScoreNumbersBigTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-popup-num-sprite.png", 2, 900, 13, 1);
			mScoreTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-text.png", 878, 377, 1, 1);
			mStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-star-sprite.png", 2, 824, 10, 1);
			mGameTableTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-table.png", 2, 101, 1, 1);
			mBestScoreTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-bestscore.png", 847, 832, 1, 1);
			mHarryTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-hurryup.png", 768, 879, 1, 1);
			mHaveOneMinuteTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-minute.png", 736, 557, 1, 1);
			mAlertBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup.png", 485, 652, 1, 1);
			mRedTimerSecTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-text-sec-red.png", 951, 913, 1, 1);
			mTimerSecTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-text-sec.png", 951, 950, 1, 1);
			mBestScoreNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-best-score-num-sprite.png", 776, 667, 10, 1);
			mEndShopBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-shop-bg.png", 485, 438, 1, 1);
			mEndShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-shop.png", 485, 550, 1, 1);
			mTapToPlayButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-taptoplay.png", 608, 424, 1, 1);
			mDeviderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-devide.png", 608, 408, 1, 1);
			mStarsIconTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-ico-stars.png", 717, 713, 1, 1);
			mPurchaseItemsCountBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-shop-msg.png", 931, 877, 1, 1);
			mBestScoreTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-best.png", 878, 416, 1, 1);
			mEasyTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-easy.png", 235, 943, 1, 1);
			mExpertTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-expert.png", 776, 800, 1, 1);
			mNormalTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-normal.png", 776, 691, 1, 1);
			mTextSCoreTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-score.png", 634, 727, 1, 1);
			mTextStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-stars.png", 847, 886, 1, 1);
			mWhiteNubersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-white-num-sprite.png", 776, 643, 10, 1);
			mGetStars1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-1.png", 797, 239, 1, 1);
			mGetStars2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-2.png", 797, 101, 1, 1);
			mGetStars3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-3.png", 608, 239, 1, 1);
			mGetStars4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-4.png", 608, 101, 1, 1);
			mGetStarsTxtTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-text.png", 2, 943, 1, 1);
			mPopupRandomSprite1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-1.png", 398, 933, 6, 1);
			mPopupRandomSprite2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-2.png", 800, 596, 4, 1);
			mPopupRandomSprite3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-3.png", 800, 548, 4, 1);
			mPopupRandomSprite4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-4.png", 794, 500, 4, 1);
			mPopupRandomSprite5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-5.png", 845, 452, 4, 1);
			mPopupRandomSprite6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-6.png", 485, 753, 4, 1);
			mPopupRandomSprite7TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-7.png", 418, 975, 4, 1);
			mHarryUpTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-hurryup.png", 768, 879, 1, 1);

			mBestScoreBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-best-score-popup.png", 481, 958, 1, 1);
			mSpotsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-bg-spots.png", 2, 78, 1, 1);
			mMainMenuBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-bg.png", 2, 464, 1, 1);
			mAchievementButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-achievement.png", 796, 487, 1, 1);
			mCreditsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-credits.png", 156, 978, 1, 1);
			mFacebookButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-fb.png", 381, 960, 1, 1);
			mMusicButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-melody-sprite.png", 718, 487, 1, 2);
			mMoreButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-more.png", 861, 373, 1, 1);
			mPlayBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-play-bg.png", 110, 850, 1, 1);
			mPlayButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-play.png", 246, 850, 1, 1);
			mSettingsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-settings-bg.png", 472, 850, 1, 1);
			mSettingsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-settings.png", 861, 430, 1, 1);
			mShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-shop.png", 687, 850, 1, 1);
			mSoundBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-sound-bg.png", 932, 318, 1, 1);
			mSoundButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-sound-sprite.png", 894, 210, 1, 2);
			mTwitterButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-tw.png", 872, 308, 1, 1);
			mGBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-g-bg.png", 894, 510, 1, 1);
			mGLetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-g.png", 960, 2, 1, 1);
			mIBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-i-bg.png", 796, 589, 1, 1);
			mILetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-i.png", 438, 960, 1, 1);
			mNBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-n-bg.png", 579, 850, 1, 1);
			mNLetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-n.png", 948, 145, 1, 1);
			mS1BackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-first-bg.png", 920, 410, 1, 1);
			mS1LetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-first.png", 960, 70, 1, 1);
			mS2BackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-last-bg.png", 358, 850, 1, 1);
			mS2LetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-last.png", 948, 249, 1, 1);
			mExitTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-quit-popup-text.png", 742, 115, 1, 1);
			mSocialBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-soc-bg.png", 748, 2, 1, 1);
			mAchievementsIconTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-achiv-ico.png", 743, 953, 1, 1);
			mBuyButtonBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-btn-buy-bg.png", 885, 602, 1, 1);
			mBuyButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-btn-buy.png", 2, 981, 1, 1);
			mGetStarsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-btn-get-stars-bg.png", 718, 342, 1, 1);
			mGetStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-btn-get-stars.png", 796, 675, 1, 1);
			mPurchasedTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-btn-purchased.png", 608, 954, 1, 1);
			mScrollTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-scroll.png", 718, 78, 1, 1);
			mStarsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stars-bg.png", 2, 850, 1, 1);
			mStarsNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stars-num-sprite.png", 718, 210, 10, 1);
			mFunnyFacesTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stuff-text-1.png", 40, 981, 1, 1);
			mHeadStafTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stuff-text-2.png", 203, 978, 1, 1);
			mMustacheTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stuff-text-3.png", 298, 972, 1, 1);
			mGlassesTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "popup-shop/popup-shop-stuff-text-4.png", 948, 223, 1, 1);
			mEyeAppleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-apple.png", 718, 126, 1, 1);
			mSignETextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-eye-animation.png", 718, 234, 2, 1);
			mSignTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-sprite.png", 2, 2, 10, 1);

			mEndPopupTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "popup-end-lvl/popup-end-lvl.png", 532, 478, 1, 1);
			mShopBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "popup-shop/popup-shop-bg-01.png", 2, 288, 1, 1);
			mShopElementsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "sign-char/sign-char-shop-sprite.png", 532, 288, 9, 4);
			mGameTopElementsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "sign-char/sign-char-shop-staffs-sprite.png", 2, 2, 9, 4);

			mBlackCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "black_circle.png", 2, 488, 1, 1);
			mCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "difficulty-menu/circle.png", 2, 2, 1, 1);
			mTooflyaLogo = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "logo_small_zero.png", 402, 402, 1, 1);
			m2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "popup-shop/popup-achiv-lock.png", 402, 452, 1, 1);
			break;
		case Resolutions.HD:
			mElementsTextureAtlas1 = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas2 = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas3 = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas4 = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
			mElementsTextureAtlas5 = new BitmapTextureAtlas(2048, 2048, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

			mBlank1024Png1 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "blank2048.png", 0, 0, 1, 1);
			mBlank1024Png2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "blank2048.png", 0, 0, 1, 1);
			mBlank1024Png3 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "blank2048.png", 0, 0, 1, 1);
			mBlank1024Png4 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "blank2048.png", 0, 0, 1, 1);
			mBlank1024Png5 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas5, Game.mContext, "blank2048.png", 0, 0, 1, 1);

			mFont = FontFactory.createFromAsset(mElementsTextureAtlas5, Game.mContext, "font/TitanOne-Regular.ttf", 21f * Options.cameraRatioFactor, true, Color.BLACK);

			mBackButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-back.png", 732, 1907, 1, 1);
			mDifficultyEasyButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-easy.png", 1428, 1433, 1, 1);
			mDifficultyExpertButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-expert.png", 1428, 1362, 1, 1);
			mDifficultyNormalButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-btn-normal.png", 1111, 1397, 1, 1);
			mPopupTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "difficulty-menu/difficulty-menu-popup.png", 1143, 559, 1, 1);
			//mAchivTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-achiv-text-popup.png", 1851, 740, 1, 1);
			mBonusBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-bg.png", 621, 1907, 1, 1);
			mRedBonusNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-num-sprite-red.png", 486, 1156, 14, 1);
			mBonusNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-bonus-num-sprite.png", 1125, 1224, 14, 1);
			mGameAchievementsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-achiv.png", 1423, 1524, 1, 1);
			mGameMenuButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-menu.png", 1745, 1443, 1, 1);
			mGamePauseButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-pause.png", 1368, 1652, 1, 1);
			mGameRestartButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-restart.png", 1745, 1362, 1, 1);
			mGameRollBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-roll-bg.png", 1916, 505, 1, 1);
			mGameRollButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-roll.png", 710, 1208, 1, 1);
			mGameShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-btn-shop.png", 1286, 1773, 1, 1);
			mShowTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-light-sprite.png", 2, 2, 10, 1);
			mPopupNoButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-btn-no.png", 710, 1393, 1, 1);
			mPopupYesButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-btn-yes.png", 1286, 1693, 1, 1);
			mPopupBackMenuTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-menu-popup-text.png", 1678, 2, 1, 1);
			mPanelStarTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-panel-star.png", 1649, 180, 1, 1);
			mPanelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-panel.png", 1851, 1181, 1, 1);
			mPopupButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-pause-popup-btn.png", 793, 1397, 1, 1);
			mPopupPauseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-pause-popup-text.png", 836, 983, 1, 1);
			mPopupNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-restart-popup-num-sprite.png", 1851, 654, 3, 1);
			mPopupRestartTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-restart-popup-text.png", 1143, 391, 1, 1);
			mScoreNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-num-sprite.png", 1143, 202, 13, 1);
			mScoreNumbersBigTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-popup-num-sprite.png", 1143, 477, 13, 1);
			mScoreTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-score-text.png", 2, 1156, 1, 1);
			mStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-star-sprite.png", 2, 812, 10, 1);
			mGameTableTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-table.png", 2, 180, 1, 1);
			mBestScoreTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-bestscore.png", 836, 1907, 1, 1);
			mHarryTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-hurryup.png", 988, 1907, 1, 1);
			mHaveOneMinuteTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-minute.png", 2, 1907, 1, 1);
			mAlertBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup.png", 1146, 1468, 1, 1);
			mRedTimerSecTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-text-sec-red.png", 1580, 438, 1, 1);
			mTimerSecTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-text-sec.png", 1665, 438, 1, 1);
			mAchievementsIconTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-achiv-ico.png", 1489, 349, 1, 1);
			mBestScoreNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-best-score-num-sprite.png", 1675, 187, 10, 1);
			mEndShopBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-shop-bg.png", 2, 930, 1, 1);
			mEndShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-shop.png", 1851, 863, 1, 1);
			mTapToPlayButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-btn-taptoplay.png", 1143, 252, 1, 1);
			mDeviderTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-devide.png", 1143, 180, 1, 1);
			mStarsIconTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-ico-stars.png", 1916, 438, 1, 1);
			mPurchaseItemsCountBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-shop-msg.png", 710, 1306, 1, 1);
			mBestScoreTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-best.png", 1656, 229, 1, 1);
			mEasyTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-easy.png", 507, 1102, 1, 1);
			mExpertTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-expert.png", 836, 930, 1, 1);
			mNormalTextModeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-mode-normal.png", 836, 2001, 1, 1);
			mTextSCoreTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-score.png", 1309, 2000, 1, 1);
			mTextStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-text-stars.png", 1160, 2000, 1, 1);
			mWhiteNubersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-end-lvl/popup-end-lvl-white-num-sprite.png", 1678, 145, 10, 1);
			mEndPopupTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "popup-end-lvl/popup-end-lvl.png", 2, 1224, 1, 1);
			mGetStars1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-1.png", 998, 1710, 1, 1);
			mGetStars2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-2.png", 218, 930, 1, 1);
			mGetStars3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-3.png", 710, 1716, 1, 1);
			mGetStars4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-btn-4.png", 836, 1208, 1, 1);
			mGetStarsTxtTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-get-stars/popup-get-stars-text.png", 1586, 291, 1, 1);
			mBuyButtonBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-btn-buy-bg.png", 398, 1907, 1, 1);
			mBuyButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-btn-buy.png", 1851, 559, 1, 1);
			mGetStarsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-btn-get-stars-bg.png", 908, 1468, 1, 1);
			mGetStarsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-btn-get-stars.png", 1851, 1028, 1, 1);
			mPurchasedTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-btn-purchased.png", 1129, 1907, 1, 1);
			mScrollTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-scroll.png", 1617, 207, 1, 1);
			mStarsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stars-bg.png", 710, 1473, 1, 1);
			mStarsNumbersTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stars-num-sprite.png", 1143, 349, 10, 1);
			mFunnyFacesTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stuff-text-1.png", 1146, 1652, 1, 1);
			mHeadStafTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stuff-text-2.png", 1851, 822, 1, 1);
			mMustacheTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stuff-text-3.png", 1730, 1993, 1, 1);
			mGlassesTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-shop/popup-shop-stuff-text-4.png", 1922, 229, 1, 1);
			mPopupRandomSprite1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-1.png", 1460, 1993, 6, 1);
			mPopupRandomSprite2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-2.png", 1451, 1276, 4, 1);
			mPopupRandomSprite3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-3.png", 1125, 1276, 4, 1);
			mPopupRandomSprite4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-4.png", 1678, 1907, 4, 1);
			mPopupRandomSprite5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-5.png", 1352, 1907, 4, 1);
			mPopupRandomSprite6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-6.png", 507, 1016, 4, 1);
			mPopupRandomSprite7TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "popup-sprites/popup-sprite-7.png", 507, 930, 4, 1);
			mEyeAppleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "sign-char/sign-char-apple.png", 2021, 187, 1, 1);
			mSignETextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "sign-char/sign-char-eye-animation.png", 114, 1907, 2, 1);
			mHarryUpTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas1, Game.mContext, "game-gui/game-gui-timer-popup-hurryup.png", 988, 1907, 1, 1);

			mBestScoreBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-best-score-popup.png", 1723, 237, 1, 1);
			mMainMenuBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-bg.png", 2, 138, 1, 1);
			mAchievementButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-achievement.png", 1716, 535, 1, 1);
			mCreditsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-credits.png", 1959, 237, 1, 1);
			mFacebookButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-fb.png", 1250, 864, 1, 1);
			mMusicButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-melody-sprite.png", 1487, 849, 1, 2);
			mMoreButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-more.png", 1912, 914, 1, 1);
			mPlayBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-play-bg.png", 1769, 2, 1, 1);
			mPlayButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-play.png", 1895, 683, 1, 1);
			mSettingsBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-settings-bg.png", 1547, 525, 1, 1);
			mSettingsButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-settings.png", 1912, 812, 1, 1);
			mShopButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-shop.png", 1723, 346, 1, 1);
			mSoundBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-sound-bg.png", 1547, 1200, 1, 1);
			mSoundButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-sound-sprite.png", 1695, 722, 1, 2);
			mTwitterButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-btn-tw.png", 1805, 812, 1, 1);
			mGBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-g-bg.png", 1536, 696, 1, 1);
			mGLetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-g.png", 1354, 856, 1, 1);
			mIBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-i-bg.png", 1895, 544, 1, 1);
			mILetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-i.png", 1959, 318, 1, 1);
			mNBackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-n-bg.png", 1354, 544, 1, 1);
			mNLetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-n.png", 1354, 718, 1, 1);
			mS1BackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-first-bg.png", 1547, 357, 1, 1);
			mS1LetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-first.png", 1351, 970, 1, 1);
			mS2BackgroundCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-last-bg.png", 1354, 357, 1, 1);
			mS2LetterTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-name-s-last.png", 1921, 425, 1, 1);
			mExitTextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-quit-popup-text.png", 1388, 2, 1, 1);
			mSocialBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "main-menu/main-menu-soc-bg.png", 1354, 175, 1, 1);
			mShopElementsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-shop-sprite.png", 2, 1390, 9, 4);
			mGameTopElementsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-shop-staffs-sprite.png", 2, 864, 9, 4);
			mSignTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas2, Game.mContext, "sign-char/sign-char-sprite.png", 2, 2, 10, 1);

			mBlackCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "black_circle.png", 2, 2, 1, 1);
			mCircleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "difficulty-menu/circle.png", 2, 802, 1, 1);
			mSpotsTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "main-menu/main-menu-bg-spots.png", 2, 2, 1, 1);
			mShopBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas3, Game.mContext, "popup-shop/popup-shop-bg.png", 766, 728, 1, 1);
			mTooflyaLogo = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "logo_small_zero.png", 802, 402, 1, 1);
			m2 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mElementsTextureAtlas4, Game.mContext, "popup-shop/popup-achiv-lock.png", 802, 452, 1, 1);
			break;
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public final static void loadResources() {
		switch (Options.Resolution) {
		default:
			Game.loadTextures(mElementsTextureAtlas1, mElementsTextureAtlas2, mElementsTextureAtlas3, mElementsTextureAtlas4, mElementsTextureAtlas5);
			Game.mEngine.getFontManager().loadFont(mFont);
			break;
		case Resolutions.HD:
			Game.loadTextures(mElementsTextureAtlas1, mElementsTextureAtlas2, mElementsTextureAtlas3, mElementsTextureAtlas4, mElementsTextureAtlas5);
			Game.mEngine.getFontManager().loadFont(mFont);
			break;
		}
	}

	public final static void unloadFirstResources() {
	}
}