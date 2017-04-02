package com.mygdx.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
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
import gamejam.Splash;
import gamejam.Vaper;

public class GameScene extends Scene{
	float wirX, wirY;
	public int score1 = 3;
	public int score2 = 9 + 3;
	public int score3 = 9 + 3;
	float pawianX = -200, pawianY = -200;
	public int score;
	public Player player;
	public Ramka ramka;
	public Pasek pasek;
	public Map map;
	public ArrayList<Human> hums;
	public Pawian pawian;
	public Vaper vaper;
	public Fem fem;
	public Splash splash;
	public int load;
	public GameScene(OrthographicCamera cam) {
		this.cam = cam;
		load = 0;
		splash = new Splash(GameVars.gameWidth/2, GameVars.gameHeight/2);
		addGameObject(splash);
		
	}
	public void load() {
		score = 0;
		hums = new ArrayList<Human>();
		map = new Map(this);
		
		player = new Player(world, 0, 0);
		

		player = new Player(world, 600, 600);
		pasek = new Pasek();

		player = new Player(world, 0, 0);
		addGameObject(player);
		addGameObject(pasek);
		spawn1();
		
		
		ramka = new Ramka(cam);
		addGameObject(ramka);
	}
	
	public void createWorld() {
		super.createWorld();		
		
	}
	public void spawn1() {
		hums.add(new Human(world, -700, 700, 500));

		gameObjects.addAll(hums);
		score1 = hums.size();
	}
	public void spawn2() {
		hums.add(new Human(world, -700, 700, 500));

		gameObjects.addAll(hums);
		score2 = hums.size()+3;
	}
	public void spawn3() {
		hums.add(new Human(world, -700, 700, 500));

		gameObjects.addAll(hums);
		score3 = hums.size()+6;
	}
	
	public void setMap() {
		
		
	}
	
	
	
	public void update(float delta) {
		Gdx.app.log("score", "" + score);
		Gdx.app.log("score3", "" + score3);
		if (load >= 3) {
		super.update(delta);
		cam.position.set(player.hitbox.position.x, player.hitbox.position.y, 0);
		cam.update();
		
		if (pawian != null && pawian.isVisible && pawian.isTriggered) {
			pawian.setTarget(player.hitbox.position, 0.6f);
		}
		if (pawian != null && pawian.isVisible && !pawian.isTriggered) {
			pawian.setTarget(new Vector2(player.hitbox.position.y, player.hitbox.position.x) , 0.3f);
		}
		
		
		if (vaper != null && vaper.isVisible) {
			vaper.setTarget(player.hitbox.position);
		}
		
		if (fem != null && fem.isOver && score == score1) {
			fem.hitbox.body.setActive(false);
			score++;

			pasek.setVap();
		}
		
		if (vaper != null && vaper.isDead && score == score2) {
			vaper.hitbox.body.setActive(false);
			score++;
			pasek.setNosacz();
		}
		
		float dx2, dy2;
		if (vaper != null && !vaper.isDead) { // 
		dx2 = player.hitbox.position.x - vaper.hitbox.position.x;
		dy2 = player.hitbox.position.y - vaper.hitbox.position.y;
		
		if ((Math.sqrt(dx2*dx2 + dy2*dy2) < 100)) {
			player.isDead = true;
		}
		}
		
		if (pawian != null && !pawian.isDead) {
			dx2 = player.hitbox.position.x - pawian.hitbox.position.x;
			dy2 = player.hitbox.position.y - pawian.hitbox.position.y;
			
			if ((Math.sqrt(dx2*dx2 + dy2*dy2) < 100)) {
				player.isDead = true;
			}
			}

		for(int i = 0; i < player.projs.size(); i++) {
			if (vaper != null && player.projs.get(i).isVisible) { //
				dx2 = player.projs.get(i).position.x - vaper.hitbox.position.x;
				dy2 = player.projs.get(i).position.y - vaper.hitbox.position.y;
				if (Math.sqrt(dx2*dx2 + dy2*dy2) < 50) {
					if (vaper.hitbox.frameNum != 13) {
					vaper.hitbox.frameNum++;
					vaper.lives--;
					if (vaper.lives < 0) vaper.isDead = true;
					vaper.setTarget(player.hitbox.position, -1);
					//wvaper.isVisible = false;
					player.projs.get(i).isVisible = false;
					if (vaper.lives < 0) {
						vaper.isDead = true;
						ramka.przestaw(2);
					}
					}
					
				}
			}
			if (pawian != null && player.projs.get(i).isVisible) { //
				dx2 = player.projs.get(i).position.x - pawian.hitbox.position.x;
				dy2 = player.projs.get(i).position.y - pawian.hitbox.position.y;
				if (Math.sqrt(dx2*dx2 + dy2*dy2) < 50) {
					pawian.lives--;
					player.projs.get(i).isVisible = false;
					if (pawian.lives < 0) {
						pawian.isDead = true;
						ramka.przestaw(3);
					}
				}
			}
		}
		
		
		for (int x = 0;  x < hums.size(); x++) {
			if (hums.get(x).isDead) {
				
				hums.get(x).applyForce(wirX - hums.get(x).hitbox.position.x, wirY - hums.get(x).hitbox.position.y);
				hums.get(x).small(delta/4);
				if (hums.get(x).isDead && hums.get(x).lewa.scl <= 0) {
					if (score == score1) {
						if(fem == null) {
							fem = new Fem(world, wirX, wirY, 300);
						
						fem.isVisible = true;
						addGameObject(fem);
						}
					}
					if (score == score2) {
						if(vaper == null) {
							vaper = new Vaper(world, wirX, wirY, 300);
						
						vaper.isVisible = true;
						addGameObject(vaper);
						}
					}
					
					if (score == score3) {
						if(pawian == null) {
							pawian = new Pawian(world, wirX, wirY,  900);
						
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
						if (score == score1 || score == score2 || score == score3) {
							
							wirX = 0;
							wirY = 0;
							int roz = 0;
							for (int x = 0;  x < hums.size(); x++) {
								if (!hums.get(x).isDead) {
									roz++;
									hums.get(x).isDead = true;
									wirX += hums.get(x).hitbox.position.x;
									wirY += hums.get(x).hitbox.position.y;
								}
							}
							wirX /= roz;
							wirY /= roz;
						}
					}
					if (fem != null && !fem.isDead) {
						dx = player.projs.get(i).position.x - fem.hitbox.position.x;
						dy = player.projs.get(i).position.y - fem.hitbox.position.y;
						if (Math.sqrt(dx*dx + dy*dy) < 50*(1+fem.banany/4f)) {
							fem.banany++;
							player.projs.get(i).isVisible = false;
							if (fem.banany > 15) {
								fem.isDead = true;
								ramka.przestaw(1);
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

}
