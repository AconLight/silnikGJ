package com.mygdx.game.charakters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.gameobjects.Bullet;
import com.mygdx.game.gameobjects.Bullet.State;
import com.mygdx.game.settings.GameVars;

public class OurPlayer extends Player{
	public boolean isDead;
	public ArrayList<Bullet> bullets;
	public OurPlayer(float x, float y) {
		super(x, y);
		isDead = false;
		dashTimer = -1;
		bullets = new ArrayList<Bullet>();
		
		for(int i = 0; i < GameVars.iHarnas; i++) {
			bullets.add(new Bullet(x, y));
		}
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
		.addTexture(Gdx.files.internal("data/player0.png"))
		.addTexture(Gdx.files.internal("data/player0.png"))
		.addTexture(Gdx.files.internal("data/player1.png"))
		.addTexture(Gdx.files.internal("data/player2.png"))
		.addTexture(Gdx.files.internal("data/player3.png"))
		.addTexture(Gdx.files.internal("data/player4.png"))
		.addTexture(Gdx.files.internal("data/player4.png"))
		.setIsPingpong(true)
		.setFrameTime(0.1f);
		addAlfa = -90;
		
		spriteObjects.get(1).hitbox.circle.radius = 120;
	}
	public void startDashTimer() {
		dashTimer = 0;
	}
	
	public void update(float delta, float vx, float vy) {
		if (!isDead) super.update(delta, vx, vy);
		if (dashTimer >=0) dashTimer += delta;
		
		if (dashTimer >= GameVars.dashTime) { 
			dashTimer =-1;
		}
		
		if (v < 15) {
			for(int i = 0; i < spriteObjects.size(); i++) {
				spriteObjects.get(i).frameNum = 3;
			}
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).state == State.ready) {
				bullets.get(i).position.x = spriteObjects.get(0).position.x;
				bullets.get(i).position.y = spriteObjects.get(0).position.y;
				bullets.get(i).spriteObjects.get(0).position.x = spriteObjects.get(0).position.x;
				bullets.get(i).spriteObjects.get(0).position.y = spriteObjects.get(0).position.y;
			}
			if (bullets.get(i).state == State.plum) {
				bullets.get(i).velocity.x = 0;
				bullets.get(i).velocity.y = 0;
			}
			if (bullets.get(i).state == State.throwing) {
	
			}
		}

		
	}
	
	public void throwHarnas(float vx, float vy) {
		for(int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).state == State.ready && !isDead) {
				bullets.get(i).throwHarnas(vx, vy);
				break;
			}
		}
	}

}
