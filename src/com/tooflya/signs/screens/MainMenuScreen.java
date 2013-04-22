package com.tooflya.signs.screens;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.ButtonScaleable;
import com.tooflya.signs.entities.Entity;

/**
 * @author Tooflya.com
 * @since
 */
public class MainMenuScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_TEXT_X;
	private static float POSITION_TEXT_Y;
	private static float POSITION_ICON_BACKGROUND_X_1;
	private static float POSITION_ICON_BACKGROUND_Y_1;
	private static float POSITION_ICON_BACKGROUND_X_2;
	private static float POSITION_ICON_BACKGROUND_Y_2;
	private static float POSITION_ICON_X;
	private static float POSITION_ICON_Y;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_TEXT_X = 4f;
			POSITION_TEXT_Y = 30f;
			POSITION_ICON_X = 4f;
			POSITION_ICON_Y = 6f;
			POSITION_ICON_BACKGROUND_X_1 = 45f;
			POSITION_ICON_BACKGROUND_Y_1 = 60f;
			POSITION_ICON_BACKGROUND_X_2 = 55f;
			POSITION_ICON_BACKGROUND_Y_2 = 60f;
			break;
		case Resolutions.HD:
			POSITION_TEXT_X = 8f;
			POSITION_TEXT_Y = 60f;
			POSITION_ICON_X = 4f;
			POSITION_ICON_Y = 6f;
			POSITION_ICON_BACKGROUND_X_1 = 70f;
			POSITION_ICON_BACKGROUND_Y_1 = 100f;
			POSITION_ICON_BACKGROUND_X_2 = 90f;
			POSITION_ICON_BACKGROUND_Y_2 = 100f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private boolean mIsActionConfirmed;

	private final Entity mExitText;

	private final Entity mYIconBackground;
	private final Entity mNIconBackground;

	private final ButtonScaleable mYIcon;
	private final ButtonScaleable mNIcon;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public MainMenuScreen() {
		this.mExitText = new Entity(Resources.mPopupBackMenuTextTextureRegion, this.mPanel);

		this.mYIconBackground = new Entity(Resources.mSoundBackgroundTextureRegion, this.mPanel);
		this.mNIconBackground = new Entity(Resources.mSoundBackgroundTextureRegion, this.mPanel);

		this.mYIcon = new ButtonScaleable(Resources.mPopupYesButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				MainMenuScreen.this.mIsActionConfirmed = true;

				MainMenuScreen.this.modifier2.reset();
			}
		};

		this.mNIcon = new ButtonScaleable(Resources.mPopupNoButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				MainMenuScreen.this.mIsActionConfirmed = false;

				MainMenuScreen.this.modifier2.reset();
			}
		};

		this.mExitText.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_TEXT_X, this.mPanel.getHeight() / 2 - POSITION_TEXT_Y);

		this.mYIconBackground.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_ICON_BACKGROUND_X_1, this.mPanel.getHeight() / 2 + POSITION_ICON_BACKGROUND_Y_1);
		this.mNIconBackground.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_ICON_BACKGROUND_X_2, this.mPanel.getHeight() / 2 + POSITION_ICON_BACKGROUND_Y_2);

		this.mYIcon.create().setCenterPosition(this.mYIconBackground.getCenterX() - POSITION_ICON_X, this.mYIconBackground.getCenterY() - POSITION_ICON_Y);
		this.mNIcon.create().setCenterPosition(this.mNIconBackground.getCenterX() - POSITION_ICON_X, this.mNIconBackground.getCenterY() - POSITION_ICON_Y);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onAttached()
	 */
	@Override
	public void onAttached() {
		super.onAttached();

		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = false;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
		Options.mLevelSound.pause();
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onDetached()
	 */
	@Override
	public void onDetached() {
		if (this.mIsActionConfirmed) {
			Game.mScreens.get(Screen.LEVEL).clearChildScene();
			Game.mScreens.set(Screen.MENU, true);
		} else {
			Game.mScreens.get(Screen.LEVEL).clearChildScene();
		}

		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = true;
	}
}
