package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.SpriteObject;

public class TestObject extends GameObject{
	
	public TestObject() {
		super(0, 0);
		addSprite(new SpriteObject())
		.addTexture(Gdx.files.internal("data/t1.jpg"))
		.addTexture(Gdx.files.internal("data/t2.jpg"))
		.addTexture(Gdx.files.internal("data/t3.jpg"));
		
		addSprite(new SpriteObject())
		.addTexture(Gdx.files.internal("data/t1.jpg"))
		.addTexture(Gdx.files.internal("data/t2.jpg"))
		.addTexture(Gdx.files.internal("data/t3.jpg"));
		
		velocity.x = 1;
		acceleration.set(0, 0);
	}
	
	public void update(float delta) {
		super.update(delta, 0 , 0);
		
	}

}
