package com.mygdx.game.scenes;

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

import gamejam.Map;
import gamejam.Player;
import gamejam.Ramka;

public class GameScene extends Scene{
	
	public Player player;
	public Ramka ramka;
	public Map map;
	
	public GameScene(OrthographicCamera cam) {
		this.cam = cam;
		map = new Map(this);
		player = new Player(world, 600, 600);
		addGameObject(player);
		ramka = new Ramka();
		ramka.ramkaKorwin();
		addGameObject(ramka);
	}
	
	public void createWorld() {
		super.createWorld();		
		
	}
	
	public void setMap() {
		
		
	}
	
	
	
	public void update(float delta) {
		super.update(delta);
		
		
		
		
	}

}
