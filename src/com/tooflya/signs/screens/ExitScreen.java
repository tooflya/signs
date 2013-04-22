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
public class ExitScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_TEXT_X;
	private static float POSITION_TEXT_Y;
	private static float POSITION_ICON_BACKGROUND_X;
	private static float POSITION_ICON_BACKGROUND_Y;
	private static float POSITION_ICON_X;
	private static float POSITION_ICON_Y;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_TEXT_X = 8f;
			POSITION_TEXT_Y = 40f;
			POSITION_ICON_X = 4f;
			POSITION_ICON_Y = 6f;
			POSITION_ICON_BACKGROUND_X = 40f;
			POSITION_ICON_BACKGROUND_Y = 45f;
			break;
		case Resolutions.HD:
			POSITION_TEXT_X = 8f;
			POSITION_TEXT_Y = 60f;
			POSITION_ICON_X = 4f;
			POSITION_ICON_Y = 6f;
			POSITION_ICON_BACKGROUND_X = 80f;
			POSITION_ICON_BACKGROUND_Y = 100f;
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
	public ExitScreen() {
		this.mExitText = new Entity(Resources.mExitTextTextureRegion, this.mPanel);

		this.mYIconBackground = new Entity(Resources.mSoundBackgroundTextureRegion, this.mPanel);
		this.mNIconBackground = new Entity(Resources.mSoundBackgroundTextureRegion, this.mPanel);

		this.mYIcon = new ButtonScaleable(Resources.mPopupYesButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				ExitScreen.this.mIsActionConfirmed = true;

				ExitScreen.this.modifier2.reset();
			}
		};

		this.mNIcon = new ButtonScaleable(Resources.mPopupNoButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				ExitScreen.this.mIsActionConfirmed = false;

				ExitScreen.this.modifier2.reset();
			}
		};

		this.mExitText.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_TEXT_X, this.mPanel.getHeight() / 2 - POSITION_TEXT_Y);

		this.mYIconBackground.create().setCenterPosition(this.mPanel.getWidth() / 2 - POSITION_ICON_BACKGROUND_X, this.mPanel.getHeight() / 2 + POSITION_ICON_BACKGROUND_Y);
		this.mNIconBackground.create().setCenterPosition(this.mPanel.getWidth() / 2 + POSITION_ICON_BACKGROUND_X, this.mPanel.getHeight() / 2 + POSITION_ICON_BACKGROUND_Y);

		this.mYIcon.create().setCenterPosition(this.mYIconBackground.getCenterX() - POSITION_ICON_X, this.mYIconBackground.getCenterY() - POSITION_ICON_Y);
		this.mNIcon.create().setCenterPosition(this.mNIconBackground.getCenterX() - POSITION_ICON_X, this.mNIconBackground.getCenterY() - POSITION_ICON_Y);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onDetached()
	 */
	@Override
	public void onDetached() {
		if (this.mIsActionConfirmed) {
			Game.close();
		} else {
			Game.mScreens.get(Screen.MENU).clearChildScene();
		}
	}

}
