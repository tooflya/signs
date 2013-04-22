package com.tooflya.signs;

import org.anddev.andengine.audio.music.Music;
import org.anddev.andengine.audio.sound.Sound;

/**
 * @author Tooflya.com
 * @since
 */
public class Options {

	// ===========================================================
	// Compile options
	// ===========================================================

	public static final boolean DEBUG = false;
	public static final boolean IS_DELTA_TIMING_ON = false;

	// ===========================================================
	// Math options
	// ===========================================================

	public static float PI = (float) (2 * Math.asin(1));

	// ===========================================================
	// Camera options
	// ===========================================================

	public final static float cameraRatioCenter = 520f;

	public static int cameraWidth;
	public static int cameraHeight;
	public static int cameraCenterX;
	public static int cameraCenterY;

	public static float screenWidth;
	public static float screenHeight;
	public static int screenCenterX;
	public static int screenCenterY;

	public static float cameraRatioFactor;

	public final static float framesPerSeconds = 0.016f;

	public static boolean isMusicEnabled;
	public static boolean isSoundEnabled;

	public static String CR;

	public static int Resolution;

	// ===========================================================
	// Elements options
	// ===========================================================

	public static int mElementsCount;

	// ===========================================================
	// Count of elements which will be created  immediately
	// ===========================================================

	// ===========================================================
	// Sound elements
	// ===========================================================

	public static Music mMainSound;
	public static Music mLevelSound;
	public static Music mEndSound;

	public static Music mLastPlayedMusic;

	public static Sound mButtonSound;

	public static Sound mSmashSound1;
	public static Sound mSmashSound2;
	public static Sound mSmashSound3;
	public static Sound mSmashSound4;
	public static Sound mSmashSound5;
	public static Sound mSmashSound6;

	public static Sound mClockSound;

	public static class Resolutions {
		public static final int SD = 0;
		public static final int HD = 1;
	}
}
