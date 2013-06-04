package com.tooflya.signs.cn.entities;

import org.anddev.andengine.entity.modifier.ScaleModifier;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class ExesNumber extends Entity {

	private final ScaleModifier modifier1 = new ScaleModifier(0.3f, 1.6f, 1f);

	public ExesNumber(final TiledTextureRegion pTiledTextureRegion, final org.anddev.andengine.entity.Entity pParentScreen) {
		super(pTiledTextureRegion, pParentScreen);

		this.registerEntityModifier(this.modifier1);
	}

	public void animate() {
		this.modifier1.reset();
	}
}
