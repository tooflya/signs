package com.tooflya.signs.cn.managers;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

/**
 * @author Tooflya.com
 * @since
 */
abstract public class EntityManager<T> {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mCurrentElemetCount;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * @return
	 */
	public T create() {
		this.mCurrentElemetCount++;

		return null;
	}

	/**
	 * Method which will destroy an element with pIndex index.
	 * 
	 * @param pIndex
	 *            index of element.
	 */
	public void destroy(final int pIndex) {
		this.mCurrentElemetCount--;
	}

	/**
	 * @return
	 */
	public int getCount() {
		return this.mCurrentElemetCount;
	}

	/**
	 * Method which return an element with need index.
	 * 
	 * @param pIndex
	 *            index of elements in list.
	 * @return (T) element.
	 */
	abstract public T getByIndex(final int pIndex);

	/**
	 * Method which myst destroy all elements in list.
	 */
	abstract public void clear();

	/**
	 * Method which changing graphics texture in all elements of list.
	 * 
	 * @param pTiledTextureRegion
	 *            new TiledTextureRegion.
	 */
	abstract public void changeTextureRegion(final TiledTextureRegion pTiledTextureRegion);
}