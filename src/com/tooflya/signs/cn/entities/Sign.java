package com.tooflya.signs.cn.entities;

import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;
import com.tooflya.signs.cn.Options.Resolutions;
import com.tooflya.signs.cn.screens.LevelScreen;
import com.tooflya.signs.cn.screens.Screen;

public class Sign extends ButtonScaleable {

	private static float POSITION_START_PADDIG_X;
	private static float POSITION_START_PADDIG_Y;
	private static float POSITION_ELEMENTS_PADDIG;
	private static float SPEED_ELEMENTS_MOVE_X;

	static {
		switch (Options.Resolution) {
		case Resolutions.SD:
			POSITION_START_PADDIG_X = 50f;
			POSITION_START_PADDIG_Y = 42f;
			POSITION_ELEMENTS_PADDIG = 83f;
			SPEED_ELEMENTS_MOVE_X = 10;
			break;
		case Resolutions.HD:
			POSITION_START_PADDIG_X = 100f;
			POSITION_START_PADDIG_Y = 84f;
			POSITION_ELEMENTS_PADDIG = 157f;
			SPEED_ELEMENTS_MOVE_X = 20;
			break;
		}
	}

	public int state = -1;
	public int r;
	public int c;

	public boolean w;
	public boolean marked;
	public boolean tr = false;

	private Entity eye;
	private Apple apple;

	private Entity mDecoration;

	public static int[] ITEMS = new int[10];

	public Sign(TiledTextureRegion pTiledTextureRegion, org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);
	}

	/* (non-Javadoc)
	 * @see com.tooflya.signs.entities.ButtonScaleable#onClick()
	 */
	@Override
	public void onClick() {
		if (!this.clickable) {
			return;
		}

		final LevelScreen screen = ((LevelScreen) Game.mScreens.get(Screen.LEVEL));

		if (r != 0 && r != 6 && screen.mShows.getCount() - LevelScreen.FAKE_SHOWS <= 0 && LevelScreen.FAKE_SHOWS != 999) {
			((LevelScreen) Game.mScreens.get(Screen.LEVEL)).findPairs(state, r, c);
		}
	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.AnimatedSprite#onManagedUpdate(float)
	 */
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		super.onManagedUpdate(pSecondsElapsed);

		this.eye.setCenterPosition(this.getCenterX(), this.getCenterY());
		this.eye.setScale(this.getScaleX());

		this.apple.setCenterPosition(this.eye.getCenterX(), this.eye.getCenterY());
		this.apple.setScale(this.getScaleX());

		this.mDecoration.setCenterPosition(this.getCenterX(), this.getCenterY());
		this.mDecoration.setScale(this.getScaleX());

		final LevelScreen screen = ((LevelScreen) Game.mScreens.get(Screen.LEVEL));

		if (this.m == 0 && (this.r == 0 || this.r == 6)) {
			this.eye.setCurrentTileIndex(1);
			this.apple.setVisible(false);
		} else {
			this.eye.setCurrentTileIndex(0);
			this.apple.setVisible(true);
		}

		if (this.w) {
			this.mScaleX -= 0.05f;
			this.mScaleY -= 0.05f;

			if (this.mScaleX <= 0f) {
				((LevelScreen) Game.mScreens.get(Screen.LEVEL)).mElements[r][c] = null;
				super.destroy();
			}
		} else {
			int u = 0;
			while (m != 0 && u < SPEED_ELEMENTS_MOVE_X) {
				if (m > 0) {
					this.mX += 1;
					m--;
					u++;

					this.eye.setCenterPosition(this.getCenterX(), this.getCenterY());
					this.eye.setScale(this.getScaleX());

					this.apple.setCenterPosition(this.eye.getCenterX(), this.eye.getCenterY());
					this.apple.setScale(this.getScaleX());

					this.mDecoration.setCenterPosition(this.getCenterX(), this.getCenterY());
					this.mDecoration.setScale(this.getScaleX());
				} else {
					this.mX -= 1;
					m++;
					u++;

					this.eye.setCenterPosition(this.getCenterX(), this.getCenterY());
					this.eye.setScale(this.getScaleX());

					this.apple.setCenterPosition(this.eye.getCenterX(), this.eye.getCenterY());
					this.apple.setScale(this.getScaleX());

					this.mDecoration.setCenterPosition(this.getCenterX(), this.getCenterY());
					this.mDecoration.setScale(this.getScaleX());
				}
			}

			if (m == 0 && this.state == -2) {
				this.destroy();

				return;
			}

			if (m == 0 && this.state == -4) {
				this.state = this.getCurrentTileIndex();
			}

			if (state < 0 || tr)
				return;

			if (state != -1 && this.isVisible() && r != 3 && !screen.block) {
				if (r < 3) {
					if (screen.mElements[r + 1][c] == null) {
						screen.mElements[r + 1][c] = this;
						screen.mElements[r][c] = null;
						r++;

						this.addMove(POSITION_ELEMENTS_PADDIG);

						if (r - 1 == 0) {
							final int state = Game.random.nextInt(Options.mElementsCount);

							final Sign e = screen.mSigns.create();
							e.setCenterPosition(0f - e.getWidth() / 2, POSITION_START_PADDIG_Y + POSITION_ELEMENTS_PADDIG * c);
							e.addMove(POSITION_ELEMENTS_PADDIG);
							e.state = state;

							e.r = 0;
							e.c = c;

							e.setCurrentTileIndex(state);

							screen.mElements[0][c] = e;
						}
					}
				} else {
					if (screen.mElements[r - 1][c] == null) {
						screen.mElements[r - 1][c] = this;
						screen.mElements[r][c] = null;
						r--;

						this.addMove(-POSITION_ELEMENTS_PADDIG);

						if (r + 1 == 6) {
							final int state = Game.random.nextInt(Options.mElementsCount);

							final Sign e = screen.mSigns.create();
							e.setCenterPosition(POSITION_START_PADDIG_X + POSITION_ELEMENTS_PADDIG * (r + 1), POSITION_START_PADDIG_Y + POSITION_ELEMENTS_PADDIG * c);
							e.state = state;

							e.r = 6;
							e.c = c;

							e.setCurrentTileIndex(state);

							screen.mElements[6][c] = e;
						}
					}
				}
			}
		}

		if ((this.mX < -this.mWidth || this.mX > Options.cameraWidth) && this.state != -4) {
			this.destroy();
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();

		this.m = 0;

		this.r = -1;
		this.c = -1;
		this.state = -1;

		this.w = false;
		this.marked = false;
		this.clickable = true;

		this.mAlpha = 1f;
		this.mScaleX = 1f;
		this.mScaleY = 1f;

		this.eye = ((LevelScreen) Game.mScreens.get(Screen.LEVEL)).mSignsEyes.create();
		this.apple = ((LevelScreen) Game.mScreens.get(Screen.LEVEL)).mSignsEyesApples.create();
		this.mDecoration = ((LevelScreen) Game.mScreens.get(Screen.LEVEL)).mDecorators.create();
	}

	public void destroy(boolean n) {
		final LevelScreen screen = ((LevelScreen) Game.mScreens.get(Screen.LEVEL));

		this.w = true;
		screen.cblock = true;
		this.clickable = false;

		final Entity show = screen.mShows.create();
		show.setCenterPosition(this.getCenterX(), this.getCenterY());
		show.setCurrentTileIndex(state);

		for (int i = 0; i < 3; i++) {
			screen.mStars.create().create(this.getCenterX(), this.getCenterY()).setCurrentTileIndex(state);
		}

		if (this.c > 0) {
			screen.mElements[this.r][this.c - 1].lookDown();
		}

		if (this.c < 3) {
			screen.mElements[this.r][this.c + 1].lookUp();
		}

		if (this.r > 1) {
			screen.mElements[this.r + 1][this.c].lookLeft();
		}

		if (this.r < 6) {
			screen.mElements[this.r - 1][this.c].lookRight();
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		final LevelScreen screen = ((LevelScreen) Game.mScreens.get(Screen.LEVEL));
		
		r = -1;
		c = -1;
		state = -1;

		tr = false;

		this.eye.destroy();
		this.apple.destroy();
		this.mDecoration.destroy();

		screen.cblock = false;

		this.m = 0;
	}

	private float m = 0;

	public void addMove(final float pX) {
		m += pX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.anddev.andengine.entity.shape.Shape#onAreaTouched(org.anddev.andengine.input.touch.TouchEvent, float, float)
	 */
	@Override
	public boolean onAreaTouched(final TouchEvent pAreaTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
		if (!this.clickable) {
			return false;
		}

		switch (pAreaTouchEvent.getAction()) {
		case TouchEvent.ACTION_DOWN:
			this.mLastClickedX = pTouchAreaLocalX;
			this.mLastClickedY = pTouchAreaLocalY;

			this.isClicked = true;

			return false;

		case TouchEvent.ACTION_UP:
			if (this.isClicked) {

				this.onClick();
			}

			this.isClicked = false;

			return false;
		case TouchEvent.ACTION_MOVE:
			if (this.isClicked) {
				if (Math.abs(this.mLastClickedX - pTouchAreaLocalX) > 1000f || Math.abs(this.mLastClickedY - pTouchAreaLocalY) > 1000f) {
					this.isClicked = false;
				}
			}

			return false;
		}

		return false;
	}

	public void onChangePosition() {

	}

	/* (non-Javadoc)
	 * @see org.anddev.andengine.entity.sprite.TiledSprite#setCurrentTileIndex(int)
	 */
	@Override
	public void setCurrentTileIndex(final int pTileIndex) {
		super.setCurrentTileIndex(pTileIndex);

		this.mDecoration.setCurrentTileIndex(ITEMS[this.state]);

		if (ITEMS[this.state] == -1) {
			this.mDecoration.setVisible(false);
		}
	}

	public void lookLeft() {
		this.apple.lookLeft();
	}

	public void lookRight() {
		this.apple.lookRight();
	}

	public void lookUp() {
		this.apple.lookUp();
	}

	public void lookDown() {
		this.apple.lookDown();
	}

	//

	public void lookFromLeftToRight() {
		this.apple.lookFromLeftToRight();
	}

	public void lookFromRightToLeft() {
		this.apple.lookFromRightToLeft();
	}

	public void lookFromUpToDown() {
		this.apple.lookFromUpToDown();
	}

	public void lookFromDownToUp() {
		this.apple.lookFromDownToUp();
	}
}
