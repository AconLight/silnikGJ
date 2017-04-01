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

import gamejam.Player;

public class GameScene extends Scene{
	
	public Player player;

	
	public GameScene(OrthographicCamera cam) {
		this.cam = cam;
		player = new Player(world, 300, 300);
		addGameObject(player);
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
