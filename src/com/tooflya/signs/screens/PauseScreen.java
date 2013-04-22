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
public class PauseScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_CONTINUE_BUTTON_Y;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_CONTINUE_BUTTON_Y = 40f;
			break;
		case Resolutions.HD:
			POSITION_CONTINUE_BUTTON_Y = 100f;
			break;
		}
	}

	public static int ACTION;

	// ===========================================================
	// Fields
	// ===========================================================

	private final Entity mPauseText;

	private final ButtonScaleable mOKIcon;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public PauseScreen() {
		this.mPauseText = new Entity(Resources.mPopupPauseTextureRegion, this.mPanel);

		this.mOKIcon = new ButtonScaleable(Resources.mPopupButtonTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.bubblefun.entities.Button#onClick()
			 */
			@Override
			public void onClick() {
				PauseScreen.this.modifier2.reset();
			}
		};

		this.mPauseText.create().setCenterPosition(this.mPanel.getWidth() / 2 + 4f, this.mPanel.getHeight() / 2 - 30f);
		this.mOKIcon.create().setCenterPosition(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2 + POSITION_CONTINUE_BUTTON_Y);
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
	 * @see com.tooflya.signs.screens.PopupScreen#onDetached()
	 */
	@Override
	public void onDetached() {
		super.onDetached();

		Game.mScreens.get(Screen.LEVEL).clearChildScene();
		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = true;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
		switch (ACTION) {
		case 2:
			Game.mScreens.set(Screen.ACHIEVEMENTS, true);
			break;
		case 3:
			Game.mScreens.set(Screen.SHOP, true);
			break;
		}
	}
}
