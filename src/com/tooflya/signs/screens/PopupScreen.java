package com.tooflya.signs.screens;

import org.anddev.andengine.entity.modifier.ScaleModifier;

import com.tooflya.signs.Game;
import com.tooflya.signs.Options;
import com.tooflya.signs.Options.Resolutions;
import com.tooflya.signs.Resources;
import com.tooflya.signs.entities.Entity;
import com.tooflya.signs.entities.Rectangle;
import com.tooflya.signs.entities.Spiral;
import com.tooflya.signs.managers.EntityManager;
import com.tooflya.signs.managers.ListEntityManager;

public class PopupScreen extends Screen {

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

	// ===========================================================
	// Fields
	// ===========================================================

	protected final ScaleModifier modifier1 = new ScaleModifier(0.3f, 0f, Options.cameraRatioFactor) {

		@Override
		public void onStarted() {
			PopupScreen.this.mCircleOnModifier.reset();
		}

		@Override
		public void onFinished() {
			PopupScreen.this.onPostAttached();
		}
	};

	protected final ScaleModifier modifier2 = new ScaleModifier(0.3f, Options.cameraRatioFactor, 0f) {

		@Override
		public void onStarted() {
			PopupScreen.this.mCircleOffModifier.reset();

			for (int i = 0; i < PopupScreen.this.mSpirals.getCount(); i++) {
				PopupScreen.this.mSpirals.getByIndex(i).goAway();
			}
		}

		@Override
		public void onFinished() {
			PopupScreen.this.mSpirals.clear();

			PopupScreen.this.onDetached();
		}
	};

	private final ScaleModifier mCircleOnModifier = new ScaleModifier(0.3f, 2f + Options.cameraRatioFactor, 0f);
	private final ScaleModifier mCircleOffModifier = new ScaleModifier(0.3f, 0f, 2f + Options.cameraRatioFactor);

	protected final Entity mPanel;
	protected final Entity mCircle;

	protected final Rectangle mBackground;

	private final EntityManager<Spiral> mSpirals;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PopupScreen() {
		this.setBackgroundEnabled(false);

		this.mBackground = new com.tooflya.signs.entities.Rectangle();

		this.mCircle = new Entity(Resources.mCircleTextureRegion, this);

		final Rectangle r1 = new Rectangle(-1, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(PopupScreen.this.mCircle.getX() - this.getWidthScaled() / 2, PopupScreen.this.mCircle.getY() - this.getHeightScaled() - (PopupScreen.this.mCircle.getHeightScaled() - PopupScreen.this.mCircle.getHeight()) / 2);
				this.setVisible(PopupScreen.this.mCircle.isVisible());
			}
		};

		final Rectangle r2 = new Rectangle(-1, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(PopupScreen.this.mCircle.getX() - this.getWidthScaled() / 2, PopupScreen.this.mCircle.getY() + PopupScreen.this.mCircle.getHeight() + (PopupScreen.this.mCircle.getHeightScaled() - PopupScreen.this.mCircle.getHeight()) / 2);
				this.setVisible(PopupScreen.this.mCircle.isVisible());
			}
		};

		final Rectangle r3 = new Rectangle(-1, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(PopupScreen.this.mCircle.getX() - this.getWidthScaled() - (PopupScreen.this.mCircle.getWidthScaled() - PopupScreen.this.mCircle.getWidth()) / 2 + 2f, PopupScreen.this.mCircle.getY() - this.getHeightScaled() / 2);
				this.setVisible(PopupScreen.this.mCircle.isVisible());
			}
		};

		final Rectangle r4 = new Rectangle(-1, 0, RECTANGLE_SIZE, RECTANGLE_SIZE) {

			@Override
			protected void onManagedUpdate(final float pSecondsElapsed) {
				super.onManagedUpdate(pSecondsElapsed);

				this.setPosition(PopupScreen.this.mCircle.getX() + PopupScreen.this.mCircle.getWidth() + (PopupScreen.this.mCircle.getWidthScaled() - PopupScreen.this.mCircle.getWidth()) / 2 - 2f, PopupScreen.this.mCircle.getY() - this.getHeightScaled() / 2);
				this.setVisible(PopupScreen.this.mCircle.isVisible());
			}
		};

		r1.setColor(255f / 255f, 252f / 255f, 232f / 255f);
		r2.setColor(255f / 255f, 252f / 255f, 232f / 255f);
		r3.setColor(255f / 255f, 252f / 255f, 232f / 255f);
		r4.setColor(255f / 255f, 252f / 255f, 232f / 255f);

		r1.setVisible(false);
		r2.setVisible(false);
		r3.setVisible(false);
		r4.setVisible(false);

		this.attachChild(r1);
		this.attachChild(r2);
		this.attachChild(r3);
		this.attachChild(r4);

		this.mCircle.create().setCenterPosition(Options.screenCenterX, Options.screenCenterY);
		this.mCircle.setScaleCenter(this.mCircle.getBaseWidth() / 2, this.mCircle.getBaseHeight() / 2);
		this.mCircle.setScale(2f + Options.cameraRatioFactor);
		this.mCircle.registerEntityModifier(this.mCircleOnModifier);
		this.mCircle.registerEntityModifier(this.mCircleOffModifier);
		this.mCircle.enableFullBlendFunction();

		this.attachChild(this.mBackground);
		this.mBackground.setBackgroundCenterPosition();

		this.mSpirals = new ListEntityManager<Spiral>(new Spiral(Resources.mPopupRandomSprite1TextureRegion, this.mBackground));

		this.mPanel = new Entity(Resources.mPopupTextureRegion, this);
		this.mPanel.create();
		this.mPanel.setScaleCenter(this.mPanel.getWidth() / 2, this.mPanel.getHeight() / 2);
		this.mPanel.setCenterPosition(Options.screenCenterX, Options.screenCenterY);

		this.mPanel.registerEntityModifier(modifier1);
		this.mPanel.registerEntityModifier(modifier2);

		this.mPanel.setScale(0f);
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	private float mTimeToCreateSpiral = 0;

	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.mTimeToCreateSpiral += pSecondsElapsed;

		if (this.mTimeToCreateSpiral >= 0.1f && this.mSpirals.getCount() < 50) {
			this.mTimeToCreateSpiral = 0;

			final Spiral spiral = this.mSpirals.create();
			if (spiral != null) {
				spiral.setCenterPosition(Game.random.nextInt(Options.cameraWidth), Game.random.nextInt(Options.cameraHeight));
				spiral.setCurrentTileIndex(Game.random.nextInt(6));
			}
		}

	}

	@Override
	public void onAttached() {
		super.onAttached();

		this.modifier1.reset();

		switch (Game.random.nextInt(7)) {
		case 0:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite1TextureRegion);
			break;
		case 1:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite2TextureRegion);
			break;
		case 2:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite3TextureRegion);
			break;
		case 3:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite4TextureRegion);
			break;
		case 4:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite5TextureRegion);
			break;
		case 5:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite6TextureRegion);
			break;
		case 6:
			this.mSpirals.changeTextureRegion(Resources.mPopupRandomSprite7TextureRegion);
			break;
		}
	}

	@Override
	public void onPostAttached() {
	}

	@Override
	public void onDetached() {
	}

	@Override
	public final void onBackPressed() {
		this.modifier2.reset();
	}

	// ===========================================================
	// Methods
	// ===========================================================
}
