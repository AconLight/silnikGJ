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

public class GameScene extends Scene{
	
	GameObject parent;
	public PhysicSpriteObject ob1, ob2;
	public Body kolko1, kolko2;
	DistanceJointDef joint1;
	
	public PhysicTest test;
	
	public GameScene(OrthographicCamera cam) {
		asd = 0;
		this.cam = cam;
	}
	
	public void createWorld() {
		super.createWorld();		
		
		test = new PhysicTest(world, 300, 300);
		
		addGameObject(test);
		
		addGround(400, 220, 600, 25);
		//kolko1.setLinearVelocity(-100, 200);
	}
	
	
	
	
	public void update(float delta) {
		super.update(delta);
		asd += delta;
		if (asd > 3) {
			asd = 0;
			//kolko1.applyForce(40,  100,  0, 0, true);
			//kolko1.setLinearVelocity(-100, 200);
		}
		//Gdx.app.log("body", "" + kolko1.getPosition().y);
	}

}
