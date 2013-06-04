package com.tooflya.signs.cn.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tooflya.signs.cn.Game;
import com.tooflya.signs.cn.Options;

/**
 * @author Tooflya.com
 * @since
 */
public class DataStorage extends SQLiteOpenHelper {

	// ===========================================================
	// Constants
	// ===========================================================

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "storage";

	private static final String SCORE_TABLE = "score";
	private static final String STARS_TABLE = "stars";
	private static final String ITEMS_TABLE = "items";

	private static final String SCORE_1 = "score_1";
	private static final String SCORE_2 = "score_2";
	private static final String SCORE_3 = "score_3";

	private static final String STARS = "stars";

	private static final String ITEM_ID = "id";
	private static final String ITEM_STATUS = "status";

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * 
	 */
	public DataStorage() {
		super(Game.mContext, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Stars
	// ===========================================================

	/**
	 * 
	 */
	public int getStarsCount() {
		Cursor cursor = this.getReadableDatabase().query(STARS_TABLE, new String[] { STARS }, null, null, null, null, null, null);

		cursor.moveToFirst();

		final int result = cursor.getInt(0);

		cursor.close();

		return result;
	}

	/**
	 * 
	 */
	public void setStarsCount(final int pStars) {
		final ContentValues values = new ContentValues();

		values.put(STARS, this.getStarsCount() + pStars);

		this.getReadableDatabase().update(STARS_TABLE, values, null, null);
	}

	/**
	 * 
	 */
	public void removeStarsCount(final int pStars) {
		final ContentValues values = new ContentValues();

		values.put(STARS, this.getStarsCount() - pStars);

		this.getReadableDatabase().update(STARS_TABLE, values, null, null);
	}

	// ===========================================================
	// Score
	// ===========================================================

	/**
	 * 
	 */
	public int getCurrentBestScore() {
		Cursor cursor = null;

		switch (Options.mElementsCount) {
		case 4:
			cursor = this.getReadableDatabase().query(SCORE_TABLE, new String[] { SCORE_1 }, null, null, null, null, null, null);
			break;
		case 7:
			cursor = this.getReadableDatabase().query(SCORE_TABLE, new String[] { SCORE_2 }, null, null, null, null, null, null);
			break;
		case 10:
			cursor = this.getReadableDatabase().query(SCORE_TABLE, new String[] { SCORE_3 }, null, null, null, null, null, null);
			break;
		}

		cursor.moveToFirst();

		final int result = cursor.getInt(0);

		cursor.close();

		return result;
	}

	/**
	 * 
	 */
	public void setCurrentBestScore(final int pScore) {
		final ContentValues values = new ContentValues();

		switch (Options.mElementsCount) {
		case 4:
			values.put(SCORE_1, pScore);
			break;
		case 7:
			values.put(SCORE_2, pScore);
			break;
		case 10:
			values.put(SCORE_3, pScore);
			break;
		}

		this.getReadableDatabase().update(SCORE_TABLE, values, null, null);
	}

	/**
	 * 
	 */
	public int getBestScore() {
		final Cursor cursor = this.getReadableDatabase().query(SCORE_TABLE, new String[] { SCORE_1, SCORE_2, SCORE_3 }, null, null, null, null, null, null);
		cursor.moveToFirst();

		final int result1 = cursor.getInt(0);
		final int result2 = cursor.getInt(1);
		final int result3 = cursor.getInt(2);

		final int result = Math.max(Math.max(result1, result2), result3);

		cursor.close();

		return result;
	}

	// ===========================================================
	// Items
	// ===========================================================

	/**
	 * 
	 */
	public boolean isItemAvailable(final int pIndex) {
		Cursor cursor = this.getReadableDatabase().rawQuery("SELECT " + ITEM_STATUS + " FROM " + ITEMS_TABLE + " WHERE " + ITEM_ID + " = " + pIndex, null);

		cursor.moveToFirst();

		final boolean result = cursor.getInt(0) != 1;

		cursor.close();

		return result;
	}

	/**
	 * 
	 */
	public void removeItem(final int pIndex) {
		final Cursor cursor = this.getReadableDatabase().rawQuery("UPDATE " + ITEMS_TABLE + " SET " + ITEM_STATUS + " = 1 WHERE " + ITEM_ID + " = " + pIndex, null);
		cursor.moveToFirst();
		cursor.close();
	}

	// ===========================================================
	// Virtual methods
	// ===========================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + SCORE_TABLE + "(" + SCORE_1 + "  INTEGER DEFAULT 0," + SCORE_2 + " INTEGER DEFAULT 0,  " + SCORE_3 + " INTEGER DEFAULT 0" + ")");
		db.execSQL("CREATE TABLE " + STARS_TABLE + "(" + STARS + "  INTEGER DEFAULT 0" + ")");
		db.execSQL("CREATE TABLE " + ITEMS_TABLE + "(" + ITEM_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT," + ITEM_STATUS + "  INTEGER DEFAULT 0" + ")");

		final ContentValues values = new ContentValues();
		values.put(SCORE_1, 0);
		values.put(SCORE_2, 0);
		values.put(SCORE_3, 0);

		db.insert(SCORE_TABLE, null, values);

		final ContentValues values2 = new ContentValues();
		values2.put(STARS, 0);

		db.insert(STARS_TABLE, null, values2);

		for (int i = 0; i < 28; i++) {
			final ContentValues values3 = new ContentValues();
			values3.put(ITEM_STATUS, 0);

			db.insert(ITEMS_TABLE, null, values3);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE);

		this.onCreate(db);
	}
}
