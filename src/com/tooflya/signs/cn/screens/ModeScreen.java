package com.tooflya.signs.cn.screens;

import org.anddev.andengine.entity.modifier.MoveYModifier;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.Options.Resolutions;
import com.tooflya.signs.cn.Resources;
import com.tooflya.signs.cn.entities.ButtonDifficulty;
import com.tooflya.signs.cn.entities.ButtonScaleable;
import com.tooflya.signs.cn.entities.Entity;

/**
 * @author Tooflya.com
 * @since
 */
public class ModeScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_BACK_BUTTON_X;
	private static float POSITION_BACK_BUTTON_Y;
	private static float POSITION_BACK_BUTTON_BACKGROUND_X;
	private static float POSITION_BACK_BUTTON_BACKGROUND_Y;
	private static float POSITION_PADDING;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_BACK_BUTTON_X = 30f;
			POSITION_BACK_BUTTON_Y = 70f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 10f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 90f;
			POSITION_PADDING = 50f;
			break;
		case Resolutions.HD:
			POSITION_BACK_BUTTON_X = 60f;
			POSITION_BACK_BUTTON_Y = 140f;
			POSITION_BACK_BUTTON_BACKGROUND_X = 30f;
			POSITION_BACK_BUTTON_BACKGROUND_Y = 170f;
			POSITION_PADDING = 100f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private boolean mIsActionConfirmed;

	private final ButtonDifficulty mButtonDifficulty1;
	private final ButtonDifficulty mButtonDifficulty2;
	private final ButtonDifficulty mButtonDifficulty3;

	private final MoveYModifier mButtonDifficulty1DownModifier;
	private final MoveYModifier mButtonDifficulty2DownModifier;
	private final MoveYModifier mButtonDifficulty3DownModifier;

	private final Entity mBackButtonBackground;
	private final ButtonScaleable mBackButton;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public ModeScreen() {
		this.mBackButtonBackground = new Entity(Resources.mSettingsBackgroundTextureRegion, this.mBackground);
		this.mBackButton = new ButtonScaleable(Resources.mBackButtonTextureRegion, this.mBackground) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				ModeScreen.this.onBackPressed();
			}
		};

		this.mBackButtonBackground.create().setPosition(POSITION_BACK_BUTTON_BACKGROUND_X, Options.cameraHeight - POSITION_BACK_BUTTON_BACKGROUND_Y);
		this.mBackButton.create().setPosition(POSITION_BACK_BUTTON_X, Options.cameraHeight - POSITION_BACK_BUTTON_Y);

		this.mButtonDifficulty1 = new ButtonDifficulty(Resources.mDifficultyExpertButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Options.mElementsCount = 10;

				ModeScreen.this.mIsActionConfirmed = true;

				ModeScreen.this.modifier2.reset();
			}
		};

		this.mButtonDifficulty2 = new ButtonDifficulty(Resources.mDifficultyNormalButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Options.mElementsCount = 7;

				ModeScreen.this.mIsActionConfirmed = true;

				ModeScreen.this.modifier2.reset();
			}
		};

		this.mButtonDifficulty3 = new ButtonDifficulty(Resources.mDifficultyEasyButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
			 */
			@Override
			public void onClick() {
				Options.mElementsCount = 4;

				ModeScreen.this.mIsActionConfirmed = true;

				ModeScreen.this.modifier2.reset();
			}
		};

		this.mButtonDifficulty1.create().setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty2.create().setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty3.create().setCenterPosition(this.mPanel.getWidth() / 2, -1000);

		this.mButtonDifficulty1DownModifier = new MoveYModifier(0.3f, -1000, this.mPanel.getHeight() / 2 + POSITION_PADDING);
		this.mButtonDifficulty2DownModifier = new MoveYModifier(0.4f, -1000, this.mPanel.getHeight() / 2);
		this.mButtonDifficulty3DownModifier = new MoveYModifier(0.5f, -1000, this.mPanel.getHeight() / 2 - POSITION_PADDING);

		this.mButtonDifficulty1.registerEntityModifier(this.mButtonDifficulty1DownModifier);
		this.mButtonDifficulty2.registerEntityModifier(this.mButtonDifficulty2DownModifier);
		this.mButtonDifficulty3.registerEntityModifier(this.mButtonDifficulty3DownModifier);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
		this.mButtonDifficulty1DownModifier.reset();
		this.mButtonDifficulty2DownModifier.reset();
		this.mButtonDifficulty3DownModifier.reset();

		this.mIsActionConfirmed = false;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onDetached()
	 */
	@Override
	public void onDetached() {
		this.mButtonDifficulty1.setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty2.setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty3.setCenterPosition(this.mPanel.getWidth() / 2, -1000);

		if (this.mIsActionConfirmed) {
			Game.mScreens.set(Screen.LEVEL, true);
		}

		Game.mScreens.get(Screen.MENU).clearChildScene();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tooflya.bouncekid.Screen#onDetached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();

		this.mButtonDifficulty1.setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty2.setCenterPosition(this.mPanel.getWidth() / 2, -1000);
		this.mButtonDifficulty3.setCenterPosition(this.mPanel.getWidth() / 2, -1000);
	}
}
