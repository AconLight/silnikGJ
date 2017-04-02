package com.mygdx.game.scenes;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
	float timer;
	Random g = new Random();
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
	public Music music = Gdx.audio.newMusic(Gdx.files.internal("data/track.mp3"));
	public Sound s1 = Gdx.audio.newSound(Gdx.files.internal("data/amasz.mp3"));
	public Sound s2 = Gdx.audio.newSound(Gdx.files.internal("data/bananowycios.mp3"));
	public Sound s3 = Gdx.audio.newSound(Gdx.files.internal("data/rzutbananem.mp3"));
	public Sound s4 = Gdx.audio.newSound(Gdx.files.internal("data/gin.mp3"));
	public Sound s5 = Gdx.audio.newSound(Gdx.files.internal("data/prank.mp3"));
	public Sound s6 = Gdx.audio.newSound(Gdx.files.internal("data/prank1.mp3"));
	public Sound s7 = Gdx.audio.newSound(Gdx.files.internal("data/prank3.mp3"));
	public Sound f1 = Gdx.audio.newSound(Gdx.files.internal("data/traktory.mp3"));
	public Sound f2 = Gdx.audio.newSound(Gdx.files.internal("data/niesprawiesliwosc.mp3"));
	public Sound f3 = Gdx.audio.newSound(Gdx.files.internal("data/miam.mp3"));
	public Sound f4 = Gdx.audio.newSound(Gdx.files.internal("data/dobrybananek.mp3"));
	public Sound f5 = Gdx.audio.newSound(Gdx.files.internal("data/cielesne.mp3"));
	public Sound k1 = Gdx.audio.newSound(Gdx.files.internal("data/korwin.mp3"));
	public Sound v1 = Gdx.audio.newSound(Gdx.files.internal("data/sztach.mp3"));
	public Sound v2 = Gdx.audio.newSound(Gdx.files.internal("data/paletylko.mp3"));
	public Sound v3 = Gdx.audio.newSound(Gdx.files.internal("data/kaszel1.mp3"));
	public Sound v4 = Gdx.audio.newSound(Gdx.files.internal("data/kaszel2.mp3"));
	public Sound v5 = Gdx.audio.newSound(Gdx.files.internal("data/kaszel3.mp3"));
	public Sound v6 = Gdx.audio.newSound(Gdx.files.internal("data/grzala.mp3"));
	public Sound n1 = Gdx.audio.newSound(Gdx.files.internal("data/grzybki.mp3"));
	public Sound n2 = Gdx.audio.newSound(Gdx.files.internal("data/malpabanany.mp3"));
	public Sound n3 = Gdx.audio.newSound(Gdx.files.internal("data/niepolskie.mp3"));
	public Sound n4 = Gdx.audio.newSound(Gdx.files.internal("data/polskiejabuka.mp3"));
	public Sound n5 = Gdx.audio.newSound(Gdx.files.internal("data/bankioszukaly.mp3"));
	public Sound g1 = Gdx.audio.newSound(Gdx.files.internal("data/particle.mp3"));
	public Sound g2 = Gdx.audio.newSound(Gdx.files.internal("data/particle.mp3"));
	public Sound g3 = Gdx.audio.newSound(Gdx.files.internal("data/unity.mp3"));
	public Sound g4 = Gdx.audio.newSound(Gdx.files.internal("data/java.mp3"));
	public Sound g5 = Gdx.audio.newSound(Gdx.files.internal("data/muzyka.mp3"));
	public Sound t1 = Gdx.audio.newSound(Gdx.files.internal("data/bogactwo.mp3"));
	public Sound fr1 = Gdx.audio.newSound(Gdx.files.internal("data/gotprank.mp3"));
	
	
	
	public GameScene(OrthographicCamera cam) {
		music.play();
		timer = 0;
		this.cam = cam;
		load = 0;
		splash = new Splash(GameVars.gameWidth/2, GameVars.gameHeight/2);
		addGameObject(splash);
		
	}
	public void load() {
		score = 0;
		hums = new ArrayList<Human>();
		map = new Map(this);

		pawian = new Pawian(world, 600, 300, 100);
		addGameObject(pawian);
		
		player = new Player(world, 0, 0);
		

		player = new Player(world, 0, 0);
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
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));

		

		gameObjects.addAll(hums);
		score1 = hums.size();
	}
	public void spawn2() {
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		gameObjects.addAll(hums);
		score2 = hums.size()+3;
	}
	public void spawn3() {
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		hums.add(new Human(world, -700, 700, 500));
		gameObjects.addAll(hums);
		score3 = hums.size()+6;
	}
	
	public void setMap() {
		
		
	}
	
	
	
	public void update(float delta) {
		Gdx.app.log("score", "" + score);
		Gdx.app.log("score3", "" + score3);
		if (timer >= 0) timer += delta;
		if (timer > 8) {
			timer = -1;
		}
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
			k1.play();
			ramka.przestaw(1);
			pasek.setVap();
		}
		if (fem != null && !fem.isDead  && timer  < 0) {
			timer = 0;
			switch (g.nextInt(5)) {
			case 0 : {
				f1.play();
				break;
			}
			case 1 : {
				f2.play();
				break;
			}
			case 2 : {
				f3.play();
				break;
			}
			case 3 : {
				f4.play();
				break;
			}
			case 4 : {
				f5.play();
				break;
			}
			}
		}
		
		else if (vaper != null && !vaper.isDead  && timer  < 0) {
			timer = 0;
			switch (g.nextInt(5)) {
			case 0 : {
				v1.play();
				break;
			}
			case 1 : {
				v2.play();
				break;
			}
			case 2 : {
				v3.play();
				break;
			}
			case 3 : {
				v5.play();
				break;
			}
			case 4 : {
				v6.play();
				break;
			}
			}
		}
		
		else if (pawian != null && !pawian.isDead  && timer  < 0) {
			timer = 0;
			switch (g.nextInt(4)) {
			case 0 : {
				n1.play();
				break;
			}
			case 1 : {
				n2.play();
				break;
			}
			case 2 : {
				n3.play();
				break;
			}
			case 3 : {
				n4.play();
				break;
			}
			}
		}
		else if (timer  < 0) {
			timer = 0;
			switch (g.nextInt(7+5)) {
			case 0 : {
				s1.play();
				break;
			}
			case 1 : {
				s2.play();
				break;
			}
			case 2 : {
				s3.play();
				break;
			}
			case 3 : {
				s4.play();
				break;
			}
			case 4 : {
				s5.play();
				break;
			}
			case 5 : {
				s6.play();
				break;
			}
			case 6 : {
				s7.play();
				break;
			}
			case 7 : {
				g1.play();
				break;
			}
			case 8 : {
				g2.play();
				break;
			}
			case 9 : {
				g3.play();
				break;
			}
			case 10 : {
				g4.play();
				break;
			}
			case 11 : {
				g5.play();
				break;
			}
			}
		}
		
		
		if (vaper != null && vaper.isDead && score == score2) {
			vaper.hitbox.body.setActive(false);
			score++;
			fr1.play();
			ramka.przestaw(2);
			pasek.setNosacz();
		}
		
		if (pawian != null && pawian.isDead && score != 1000) {
			pawian.hitbox.body.setActive(false);
			score = 1000;
			t1.play();
			ramka.przestaw(3);
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
						v4.play();
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
						n5.play();
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
							f3.play();
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

}
