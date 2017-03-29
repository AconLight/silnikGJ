package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.settings.GameVars;

public class Mebel extends GameObject{
	
	public Mebel(float x, float y, int type) {
		super(x, y);
		setAs(type);
	}
	
	public void setAs(int type) {
		switch (type) {
		case 1: {
			addSprite()
			.addTexture(Gdx.files.internal("data/krzeslo.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 10;
			break;
		}
		case 2: {
			addSprite()
			.addTexture(Gdx.files.internal("data/krzeslo2.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 10;
			break;
		}
		case 3: {
			addSprite()
			.addTexture(Gdx.files.internal("data/kosz.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 10;
			break;
		}
		case 4: {
			addSprite()
			.addTexture(Gdx.files.internal("data/kosz2.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 10;
			break;
		}
		case 5: {
			addSprite()
			.addTexture(Gdx.files.internal("data/stol.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 40;
			break;
		}
		case 6: {
			addSprite()
			.addTexture(Gdx.files.internal("data/roslinka.png"))
			.hitbox.circle.radius = 
			spriteObjects.get(0).regionList.get(0).getRegionWidth()/2 - 10;
			break;
		}
		}
	}
	
	public void update(float delta, float vx, float vy) {
		velocity.scl(GameVars.mebleDrag);
		super.update(delta, vx, vy);
	}

}
