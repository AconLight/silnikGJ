package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;

public class Bullet extends GameObject{

	
	public enum State {ready, throwing, plum};
	public State state;
	float throwTimer;
	float plumTimer;
	
	public boolean isReady() {
		if (state == State.ready) return true;
		else return false;
	}
	
	public boolean isThrowing() {
		if (state == State.throwing) return true;
		else return false;
	}
	
	public boolean isPlum() {
		if (state == State.plum) return true;
		else return false;
	}
	
	public Bullet(float x, float y) {
		super(x, y);
		state = State.ready;
		throwTimer = 0;
		plumTimer = 0;
		addSprite()
		.addTexture(Gdx.files.internal("data/harnas_64.png"))
		.addTexture(Gdx.files.internal("data/harnas_destr.png"))
		.addTexture(Gdx.files.internal("data/blank.png"))
		.setFrameTime(99999999);
		
		spriteObjects.get(0).hitbox.circle.radius = 45;
	}
	
	public void showHarnas() {
		spriteObjects.get(0).frameNum = 0;
	}
	public void showPlum() {
		spriteObjects.get(0).frameNum = 1;
	}
	public void showDisappear() {
		spriteObjects.get(0).frameNum = 2;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		
		
		if (state == State.throwing) {
			spriteObjects.get(0).alfa += delta*GameVars.harnasAlfaSpeed;
			throwTimer += delta;
		}
		if (state == State.plum) plumTimer += delta;
		
		if (throwTimer >= GameVars.throwTime) { 
			throwTimer -= GameVars.throwTime;
			makePlum();
		}
		
		if (plumTimer >= GameVars.plumTime) { 
			plumTimer -= GameVars.plumTime;
			disappear();
		}
	}
	public void throwHarnas(float vx, float vy) {
		velocity.x = vx;
		velocity.y = vy;
		state = State.throwing;
		showHarnas();
	}
	
	public void makePlum() {
		state = State.plum;
		throwTimer = 0;
		showPlum();
	}
	
	public void disappear() {
		state = State.ready;
		showDisappear();
	}
	
	public void render(SpriteBatch batch) {
		super.render(batch);
		Gdx.app.log("harnas!", "krul");
	}
	
	
	
	

}
