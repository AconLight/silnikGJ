package com.mygdx.game.gameobjects;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.settings.GameVars;

public class Parowa extends GameObject {
	
	public enum State {On, Loading};
	public State state;
	public float loadTimer;
	Random g;
	
	public Parowa(float x, float y) {
		super(x, y);
		g = new Random();
		state = State.On;
		loadTimer = 0;
		addSprite()
		.addTexture(Gdx.files.internal("data/parowa.png"))
		.addTexture(Gdx.files.internal("data/blank.png"))
		.setFrameTime(99999999)
		.frameNum = 0;
		
		spriteObjects.get(0).hitbox.circle.radius = 25;
		
	}
	
	public boolean isOn() {
		if (state == State.On) return true;
		else return false;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		if (state == State.Loading) {
			loadTimer += delta;
		}
		if (loadTimer > GameVars.parowaTime) {
			loadTimer -= GameVars.parowaTime;
			show();
		}
	}
	
	public void show(float x, float y) {
		state = State.On;
		spriteObjects.get(0).frameNum = 0;
		position.x = x;
		position.y = y;
		spriteObjects.get(0).position.x = x;
		spriteObjects.get(0).position.y = y;
	}
	
	public void show() {
		show(g.nextInt(3000)-1500, g.nextInt(2000)-1000);
	}
	
	public void collect() {
		state = State.Loading;
		spriteObjects.get(0).frameNum = 1;
	}

}
