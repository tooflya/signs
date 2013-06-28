package com.tooflya.signs.managers;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.entity.modifier.AlphaModifier;
import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.entity.primitive.Rectangle;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Resources;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.screens.ArchiementsScreen;
import com.tooflya.signs.screens.CoinsScreen;
import com.tooflya.signs.screens.ExitScreen;
import com.tooflya.signs.screens.LevelEndScreen;
import com.tooflya.signs.screens.LevelScreen;
import com.tooflya.signs.screens.MainMenuScreen;
import com.tooflya.signs.screens.MenuScreen;
import com.tooflya.signs.screens.ModeScreen;
import com.tooflya.signs.screens.PauseScreen;
import com.tooflya.signs.screens.RestartScreen;
import com.tooflya.signs.screens.Screen;
import com.tooflya.signs.screens.ShopScreen;

/**
 * @author Tooflya.com
 * @since
 */
public class ScreenManager {

	// ===========================================================
	// Constants
	// ===========================================================

	private static int RECTANGLE_SIZE;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			RECTANGLE_SIZE = 1000;
			break;
		case Resolutions.HD:
			RECTANGLE_SIZE = 2000;
			break;
		}
	}

	public static int mChangeAction = 0;

	private static Screen tempScreen;

	// ===========================================================
	// Fields
	// ===========================================================

	private Entity mCircle;

	private final HUD mHeadUpDisplay = new HUD();

	/** List of available screens */
	private Screen[] screens;

	private Rectangle rectangle;

	/**
	 * 
	 */
	private final AlphaModifier modifierOn = new AlphaModifier(0.4f, 0f, 1f) {

		@Override
		public void onFinished() {
			Game.mEngine.getScene().onDetached();

			if (Screen.screen != -1) {
				Game.mEngine.setScene(screens[Screen.screen]);
				screens[Screen.screen].onAttached();
			} else {
				Game.mEngine.setScene(tempScreen);
				tempScreen.onAttached();
			}

			modifierOff.reset();
		}
	};

	/**
	 * 
	 */
	private final AlphaModifier modifierOff = new AlphaModifier(0.4f, 1f, 0f) {
		@Override
		public void onFinished() {
			((Screen) Game.mEngine.getScene()).onPostAttached();
		}
	};

	private final ScaleModifier mCircleOnModifier = new ScaleModifier(0.6f, 2f + Options.cameraRatioFactor, 0f) {

		@Override
		public void onStarted() {
			ScreenManager.this.mCircle.setVisible(true);
		}

		@Override
		public void onFinished() {
			Game.mEngine.getScene().onDetached();

			if (Screen.screen != -1) {
				Game.mEngine.setScene(screens[Screen.screen]);
				screens[Screen.screen].onAttached();
			} else {
				Game.mEngine.setScene(tempScreen);
				tempScreen.onAttached();
			}

			mCircleOffModifier.reset();
		}
	};

	private final ScaleModifier mCircleOffModifier = new ScaleModifier(0.6f, 0f, 2f + Options.cameraRatioFactor) {

		@Override
		public void onFinished() {
			ScreenManager.this.mCircle.setVisible(false);

			((Screen) Game.mEngine.getScene()).onPostAttached();
		}
	};

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public ScreenManager() {
		this.rectangle = this.makeColoredRectangle(0, 0, 0f, 0f, 0f);

		this.rectangle.registerEntityModifier(this.modifierOn);
		this.rectangle.registerEntityModifier(this.modifierOff);

		Game.mCamera.setHUD(this.mHeadUpDisplay);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * 
	 */
	public void createSurfaces() {
		this.screens = new Screen[Screen.SCREENS_COUNT];

		/** Create all scenes */
		this.screens[Screen.MENU] = new MenuScreen();
		this.screens[Screen.EXIT] = new ExitScreen();
		this.screens[Screen.LEVEL] = new LevelScreen();
		this.screens[Screen.MODE] = new ModeScreen();
		this.screens[Screen.PAUSE] = new PauseScreen();
		this.screens[Screen.RESTART] = new RestartScreen();
		this.screens[Screen.MAIN] = new MainMenuScreen();
		this.screens[Screen.LEVELEND] = new LevelEndScreen();
		this.screens[Screen.SHOP] = new ShopScreen();
		this.screens[Screen.ACHIEVEMENTS] = new ArchiementsScreen();
		this.screens[Screen.COINS] = new CoinsScreen();

		/** */
		this.mCircle = new Entity(Resources.mBlackCircleTextureRegion, this.mHeadUpDisplay);

		final Rectangle r1 = new Rectangle(0, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(ScreenManager.this.mCircle.getX() - this.getWidthScaled() / 2, ScreenManager.this.mCircle.getY() - this.getHeightScaled() - (ScreenManager.this.mCircle.getHeightScaled() - ScreenManager.this.mCircle.getHeight()) / 2);
				this.setVisible(ScreenManager.this.mCircle.isVisible());
			}
		};

		final Rectangle r2 = new Rectangle(0, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(ScreenManager.this.mCircle.getX() - this.getWidthScaled() / 2, ScreenManager.this.mCircle.getY() + ScreenManager.this.mCircle.getHeight() + (ScreenManager.this.mCircle.getHeightScaled() - ScreenManager.this.mCircle.getHeight()) / 2);
				this.setVisible(ScreenManager.this.mCircle.isVisible());
			}
		};

		final Rectangle r3 = new Rectangle(0, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(ScreenManager.this.mCircle.getX() - this.getWidthScaled() - (ScreenManager.this.mCircle.getWidthScaled() - ScreenManager.this.mCircle.getWidth()) / 2 + 2f, ScreenManager.this.mCircle.getY() - this.getHeightScaled() / 2);
				this.setVisible(ScreenManager.this.mCircle.isVisible());
			}
		};

		final Rectangle r4 = new Rectangle(0, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(ScreenManager.this.mCircle.getX() + ScreenManager.this.mCircle.getWidth() + (ScreenManager.this.mCircle.getWidthScaled() - ScreenManager.this.mCircle.getWidth()) / 2 - 2f, ScreenManager.this.mCircle.getY() - this.getHeightScaled() / 2);
				this.setVisible(ScreenManager.this.mCircle.isVisible());
			}
		};

		r1.setVisible(false);
		r2.setVisible(false);
		r3.setVisible(false);
		r4.setVisible(false);

		r1.setColor(0f, 0f, 0f);
		r2.setColor(0f, 0f, 0f);
		r3.setColor(0f, 0f, 0f);
		r4.setColor(0f, 0f, 0f);

		r1.setCullingEnabled(true);
		r2.setCullingEnabled(true);
		r3.setCullingEnabled(true);
		r4.setCullingEnabled(true);

		this.mHeadUpDisplay.attachChild(r1);
		this.mHeadUpDisplay.attachChild(r2);
		this.mHeadUpDisplay.attachChild(r3);
		this.mHeadUpDisplay.attachChild(r4);

		this.mCircle.create().setCenterPosition(Options.screenCenterX, Options.screenCenterY);
		this.mCircle.setScaleCenter(this.mCircle.getBaseWidth() / 2, this.mCircle.getBaseHeight() / 2);
		this.mCircle.setScale(2f + Options.cameraRatioFactor);
		this.mCircle.setVisible(false);

		this.mCircle.registerEntityModifier(this.mCircleOnModifier);
		this.mCircle.registerEntityModifier(this.mCircleOffModifier);
	}

	// ===========================================================
	// Setters
	// ===========================================================

	/**
	 * @param pScreen
	 */
	public void set(final int pScreen) {
		if (Screen.screen == pScreen)
			return;

		Screen.screen = pScreen;

		this.modifierOn.reset();
	}

	public void set(final int pScreen, final boolean pSetScreenWithSpecialAnimation) {
		if (Screen.screen == pScreen)
			return;

		Screen.screen = pScreen;

		this.mCircleOnModifier.reset();
	}

	/**
	 * @param pScreen
	 */
	public void set(final Screen pScreen) {
		tempScreen = pScreen;

		this.modifierOn.reset();
	}

	// ===========================================================
	// Getters
	// ===========================================================

	/**
	 * @param pScreen
	 * @return
	 */
	public Screen get(final int pScreen) throws NullPointerException {
		return screens[pScreen];
	}

	/**
	 * @return
	 */
	public Screen getCurrent() {
		return screens[Screen.screen];
	}

	// ===========================================================
	// Child screens
	// ===========================================================

	/**
	 * @param pScreen
	 * @param pModalDraw
	 * @param pModalUpdate
	 * @param pModalTouch
	 */
	public void setChildScreen(final Screen pScreen, final boolean pModalDraw, final boolean pModalUpdate, final boolean pModalTouch) {
		try{this.getCurrent().setChildScene(pScreen, pModalDraw, pModalUpdate, pModalTouch);
		pScreen.onAttached();

	} catch(NullPointerException ex)
	{
		
	}
	}

	/**
	 * 
	 */
	public void clearChildScreens() {
		((Screen) this.getCurrent().getChildScene()).onBackPressed();
	}

	/**
	 * @param pX
	 * @param pY
	 * @param pRed
	 * @param pGreen
	 * @param pBlue
	 * @return
	 */
	private Rectangle makeColoredRectangle(final float pX, final float pY, final float pRed, final float pGreen, final float pBlue) {
		final Rectangle coloredRect = new Rectangle(pX, pY, Options.screenWidth, Options.screenHeight);
		coloredRect.setColor(pRed, pGreen, pBlue);
		coloredRect.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		coloredRect.setAlpha(0f);

		this.mHeadUpDisplay.attachChild(coloredRect);

		return coloredRect;
	}
}
