package com.mygdx.game.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public int id;
	public Vector2 position, velocity, acceleration, collisionAcc;
	public ArrayList<SpriteObject> spriteObjects;
	int objectViewPriority;
	public Hitbox hitbox;
	
	public GameObject(float x, float y) {
		objectViewPriority = 1;
		position = new Vector2(x, y);
		velocity = new Vector2();
		acceleration = new Vector2();
		collisionAcc = new Vector2();
		spriteObjects = new ArrayList<SpriteObject>();
		hitbox = new Hitbox(60, this);
	}
	
	public void transform(float x, float y) {
		position.x += x;
		position.y += y;
		for(int i=0; i<spriteObjects.size();i++)
			spriteObjects.get(i).transform(x, y);
	}
	
	
	public void update(float delta, float vx, float vy) {
		acceleration.add(collisionAcc);
		velocity.add(delta*acceleration.x + vx, delta*acceleration.y + vy);
		position.add(delta*velocity.x, delta*velocity.y);
		for(int i=0; i<spriteObjects.size();i++)
			spriteObjects.get(i).update(delta, velocity.x, velocity.y);
		velocity.sub(vx, vy);
		acceleration.sub(collisionAcc);
		collisionAcc.set(0, 0);
		hitbox.update(position);
	}
	
	public SpriteObject addSprite(SpriteObject e) {
		spriteObjects.add(e);
		return spriteObjects.get(spriteObjects.size()-1);
	}
	
	public SpriteObject addSprite() {
		spriteObjects.add(new SpriteObject(this, 0, 0));
		return spriteObjects.get(spriteObjects.size()-1);
	}
	
	public SpriteObject addSprite(float x, float y) {
		spriteObjects.add(new SpriteObject(this, x, y));
		return spriteObjects.get(spriteObjects.size()-1);
	}
	
	public void render(SpriteBatch batch) {

		for(int i=0; i<spriteObjects.size();i++)
			spriteObjects.get(i).render(batch);
		//Gdx.app.log("rendered", "gameobject");

	}
	
	public void dispose(){
		for(int i=0; i<spriteObjects.size();i++)
			spriteObjects.get(i).dispose();
	}
	
}
