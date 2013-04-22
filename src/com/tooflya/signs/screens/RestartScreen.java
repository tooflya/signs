package com.tooflya.signs.screens;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.Counter;
import com.tooflya.signs.entities.Entity;

/**
 * @author Tooflya.com
 * @since
 */
public class RestartScreen extends PopupScreen {

	// ===========================================================
	// Constants
	// ===========================================================

	private static float POSITION_RESTART_TEXT_Y;
	private static float POSITION_COUNTER_Y;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_RESTART_TEXT_Y = 30f;
			POSITION_COUNTER_Y = 30f;
			break;
		case Resolutions.HD:
			POSITION_RESTART_TEXT_Y = 60f;
			POSITION_COUNTER_Y = 60f;
			break;
		}
	}

	// ===========================================================
	// Fields
	// ===========================================================

	private final Entity mRestartText;

	private final Counter mCounter;

	// ===========================================================
	// Constructors
	// ===========================================================

	public RestartScreen() {
		this.mRestartText = new Entity(Resources.mPopupRestartTextTextureRegion, this.mPanel);

		this.mCounter = new Counter(Resources.mPopupNumbersTextureRegion, this.mPanel) {

			/* (non-Javadoc)
			 * @see com.tooflya.signs.entities.Counter#onFinished()
			 */
			@Override
			public void onFinished() {
				((LevelScreen) Game.mScreens.get(Screen.LEVEL)).init();
				RestartScreen.this.modifier2.reset();
			}
		};

		this.mRestartText.create().setCenterPosition(this.mPanel.getWidth() / 2 + 4f, this.mPanel.getHeight() / 2 - POSITION_RESTART_TEXT_Y);

		this.mCounter.create().setCenterPosition(this.mPanel.getWidth() / 2f, this.mPanel.getHeight() / 2 + POSITION_COUNTER_Y);
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
		Game.mScreens.get(Screen.LEVEL).clearChildScene();

		((LevelScreen) Game.mScreens.get(Screen.LEVEL)).running = true;
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.screens.PopupScreen#onPostAttached()
	 */
	@Override
	public void onPostAttached() {
		this.mCounter.create();
	}

}
