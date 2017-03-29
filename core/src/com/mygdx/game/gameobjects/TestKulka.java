package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.SpriteObject;

public class TestKulka extends SpriteObject{
	private GameObject parent;
	
	public TestKulka(GameObject parent) {
		this.parent = parent;
		position.y = 30;
		velocity.x = 10;
		velocity.y = 10;
		//acceleration.x = 0;
		//acceleration.y = -4;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		acceleration.x = (parent.position.x-position.x)*0.7f;
		acceleration.y = (parent.position.y-position.y)*0.7f;
		
	}

}
