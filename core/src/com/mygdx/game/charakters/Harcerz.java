package com.mygdx.game.charakters;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;

public class Harcerz extends Player{

	public enum State {dead, alive};
	public State state;
	public float disapperTimer;
	Random g;
	public int id;
	public Harcerz(float x, float y, int id) {
		super(x, y);
		this.id = id;
		state = State.alive;
		disapperTimer = 0;
		g = new Random();
		addSprite()
		.addTexture(Gdx.files.internal("data/playerlegs0.png"))
		.addTexture(Gdx.files.internal("data/playerlegs1.png"))
		.addTexture(Gdx.files.internal("data/playerlegs2.png"))
		.addTexture(Gdx.files.internal("data/playerlegs3.png"))
		.addTexture(Gdx.files.internal("data/playerlegs4.png"))
		.addTexture(Gdx.files.internal("data/playerlegs5.png"))
		.addTexture(Gdx.files.internal("data/playerlegs6.png"))
		.setIsPingpong(true)
		.setFrameTime(0.1f);
		addAlfa = -90;
		
		
		addSprite()
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.addTexture(Gdx.files.internal("data/zhp.png"))
		.setIsPingpong(true)
		.setFrameTime(0.1f);
		addAlfa = -90;
		
		addSprite()
		.addTexture(Gdx.files.internal("data/zhpdead.png"));
		
		
		spriteObjects.get(0).hitbox.circle.radius = 70;
		spriteObjects.get(1).hitbox.circle.radius = 25;
		spriteObjects.get(2).isVisible = false;
	}
	
	public void slow() {
		velocity.scl(GameVars.harcerzSlow);
	}
	
	public void die() {
		state = State.dead;
		spriteObjects.get(0).isVisible = false;
		spriteObjects.get(1).isVisible = false;
		spriteObjects.get(2).isVisible = true;
		disapperTimer = 0;

	}
	public void disappear() {
		spriteObjects.get(0).isVisible = false;
		spriteObjects.get(1).isVisible = false;
		spriteObjects.get(2).isVisible = false;
	}
	
	public void spawn(float x, float y) {
		position.x = x;
		position.y = y;
		spriteObjects.get(0).position.x = x;
		spriteObjects.get(0).position.y = y;
		spriteObjects.get(1).position.x = x;
		spriteObjects.get(1).position.y = y;
		spriteObjects.get(2).position.x = x;
		spriteObjects.get(2).position.y = y;
	}
	
	public void spawn() {
		spawn(g.nextInt(2)*2900-1450 + g.nextInt(10)*10 - 50, g.nextInt(2)*1900-950 + g.nextInt(10)*10 - 50);
	}
	public void setTarget(Vector2 playerPos) {
		float dx = playerPos.x - position.x;
		float dy = playerPos.y - position.y;
		float dr = (float) Math.sqrt(dx*dx + dy*dy);
		
		acceleration.x = GameVars.harcerzAcc*dx/dr;
		
		acceleration.y = GameVars.harcerzAcc*dy/dr;
		
	}
	public void update(float delta, float vx, float vy) {
		if (velocity.x > 300) velocity.x = 300;
		if (velocity.x < -300) velocity.x = -300;
		if (velocity.y > 300) velocity.y = 300;
		if (velocity.y < -300) velocity.y = -300;
		if (state == State.alive) super.update(delta, vx, vy);
		
		if (state == State.dead) disapperTimer += delta;
		
		if (disapperTimer > GameVars.harcerzDisTime) {
			disappear();
		}
		
	}

}
