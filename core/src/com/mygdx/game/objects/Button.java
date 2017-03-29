package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;

public class Button extends GameObject{
	public int id;
	public float onX, onY, offX, offY, width, height;
	public boolean isOn;
	public Button(float x, float y, int width, int height, int id, String path) {
		super(x, y);
		addSprite(new SpriteObject(this, 0, 0))
		.addTexture(Gdx.files.internal(path));
		
		this.id = id;
		offX = 999999;
		offY = 999999;
		onX = x;
		onY = y;
		isOn = true;
		spriteObjects.get(0).regionList.get(0).setRegionWidth(width);
		spriteObjects.get(0).regionList.get(0).setRegionHeight(height);
		this.width = width;
		this.height = height;
	}
	
	public void show() {
		transform(onX-position.x, onY-position.y);
		isOn = true;
	}
	
	public void hide() {
		transform(offX-position.x, offY-position.y);
		isOn = false;
	}
	
	public boolean isClicked(float x, float y) {
		Gdx.app.log("dupa", "dupa");
		return (x > position.x - width/2 && x < position.x + width/2 &&
				y > position.y - height/2 && y < position.y + height/2);
	}
	
}
