package com.mygdx.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.MotorJointDef;
import com.mygdx.game.gameobjects.PhysicTest;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.settings.GameVars;

import gamejam.Human;
import gamejam.Map;

import gamejam.Pawian;

import gamejam.Pasek;

import gamejam.Player;
import gamejam.Ramka;

public class GameScene extends Scene{
	float pawianX = 200, pawianY = 200;
	int score;
	public Player player;
	public Ramka ramka;
	public Pasek pasek;
	public Map map;
	public ArrayList<Human> hums;
	public Pawian pawian;
	public GameScene(OrthographicCamera cam) {
		this.cam = cam;
		score = 0;
		hums = new ArrayList<Human>();
		map = new Map(this);

		player = new Player(world, 0, 0);
		pawian = new Pawian(world, 600, 300, 100);
		addGameObject(pawian);

		player = new Player(world, 600, 600);
		pasek = new Pasek();

		player = new Player(world, 0, 0);
		addGameObject(player);
		addGameObject(pasek);
		hums.add(new Human(world, 700, 700, 500));


		gameObjects.addAll(hums);
		ramka = new Ramka(cam);
		addGameObject(ramka);
		
	}
	
	public void createWorld() {
		super.createWorld();		
		
	}
	
	public void setMap() {
		
		
	}
	
	
	
	public void update(float delta) {
		super.update(delta);
		cam.position.set(player.hitbox.position.x, player.hitbox.position.y, 0);
		cam.update();
		float dx, dy;
		for(int j = 0; j < hums.size(); j++) {
			hums.get(j).setTarget(player.hitbox.position);
			for(int i = 0; i < player.projs.size(); i++) {
				if (player.projs.get(i).isVisible) {
					dx = player.projs.get(i).position.x - hums.get(j).hitbox.position.x;
					dy = player.projs.get(i).position.y - hums.get(j).hitbox.position.y;
					if (Math.sqrt(dx*dx + dy*dy) < 50) {
						player.projs.get(i).isVisible = false;
						hums.get(j).isTriggered = true;
						score++;
						if (score == hums.size()) {
							pawian.isVisible = true;
							
						}
					}
				}
			}
			dx = player.hitbox.position.x - hums.get(j).hitbox.position.x;
			dy = player.hitbox.position.y - hums.get(j).hitbox.position.y;
			if (hums.get(j).isTriggered && (Math.sqrt(dx*dx + dy*dy) < 100)) {
				player.isDead = true;
			}
		}
		
	}

}
