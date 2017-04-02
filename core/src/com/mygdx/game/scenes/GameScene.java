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

import gamejam.Fem;
import gamejam.Human;
import gamejam.Map;

import gamejam.Pawian;

import gamejam.Pasek;

import gamejam.Player;
import gamejam.Ramka;

public class GameScene extends Scene{
	float wirX, wirY;
	float pawianX = -200, pawianY = -200;
	public int score;
	public Player player;
	public Ramka ramka;
	public Pasek pasek;
	public Map map;
	public ArrayList<Human> hums;
	public Pawian pawian;
	public Fem fem;
	
	public GameScene(OrthographicCamera cam) {
		this.cam = cam;
		score = 0;
		hums = new ArrayList<Human>();
		map = new Map(this);

		player = new Player(world, 0, 0);
		

		player = new Player(world, 600, 600);
		pasek = new Pasek();

		player = new Player(world, 0, 0);
		addGameObject(player);
		addGameObject(pasek);
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -900, -700, 500));
		hums.add(new Human(world, -700, 700, 500));


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
		
		
		if (fem != null && fem.isOver && score == 3) {
			fem.hitbox.body.setActive(false);
			score++;
			ramka.przestaw(1);
			pasek.setVap();
		}
		
		
		
		for (int x = 0;  x < hums.size(); x++) {
			if (hums.get(x).isDead) {
				
				hums.get(x).applyForce(wirX - hums.get(x).hitbox.position.x, wirY - hums.get(x).hitbox.position.y);
				hums.get(x).small(delta/4);
				if (hums.get(x).isDead && hums.get(x).lewa.scl <= 0) {
					if (score == 3) {
						if(fem == null) {
							fem = new Fem(world, wirX, wirY, 300);
						
						fem.isVisible = true;
						addGameObject(fem);
						}
					}
					if (score == 3+6) {
						if(pawian == null) {
							pawian = new Pawian(world, wirX, wirY, 300);
						
						pawian.isVisible = true;
						addGameObject(pawian);
						}
					}
					
					hums.get(x).hitbox.body.setActive(false);	
				}
			}
		}
		float dx, dy;
		for(int j = 0; j < hums.size(); j++) {
			hums.get(j).setTarget(player.hitbox.position);
			for(int i = 0; i < player.projs.size(); i++) {
				if (player.projs.get(i).isVisible) {
					dx = player.projs.get(i).position.x - hums.get(j).hitbox.position.x;
					dy = player.projs.get(i).position.y - hums.get(j).hitbox.position.y;
					if (Math.sqrt(dx*dx + dy*dy) < 50 && !hums.get(j).isTriggered) {
						player.projs.get(i).isVisible = false;
						hums.get(j).isTriggered = true;
						score++;
						if (score == hums.size()) {
							
							wirX = 0;
							wirY = 0;
							for (int x = 0;  x < hums.size(); x++) {
								hums.get(x).isDead = true;
								wirX += hums.get(x).hitbox.position.x;
								wirY += hums.get(x).hitbox.position.y;
							}
							wirX /= hums.size();
							wirY /= hums.size();
						}
					}
					if (fem != null) {
						dx = player.projs.get(i).position.x - fem.hitbox.position.x;
						dy = player.projs.get(i).position.y - fem.hitbox.position.y;
						if (Math.sqrt(dx*dx + dy*dy) < 50*(1+fem.banany/4f)) {
							fem.banany++;
							player.projs.get(i).isVisible = false;
							if (fem.banany > 15) {
								fem.isDead = true;
							}
						}
					}
				}
			}
			dx = player.hitbox.position.x - hums.get(j).hitbox.position.x;
			dy = player.hitbox.position.y - hums.get(j).hitbox.position.y;
			if (!hums.get(j).isDead && hums.get(j).isTriggered && (Math.sqrt(dx*dx + dy*dy) < 100)) {
				player.isDead = true;
			}
		}
		
	}

}
