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

import gamejam.Kwiatek;
import gamejam.Ramka;

public class GameScene extends Scene{
	

	Kwiatek kw;
	Ramka rm;
	
	public GameScene(OrthographicCamera cam) {
		asd = 0;
		this.cam = cam;
		rm = new Ramka();
		//kw = new Kwiatek(300, 300);
		rm.ramkaKorwin();
		//addGameObject(kw);
		addGameObject(rm);
	}
	
	public void createWorld() {
		super.createWorld();		
		

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
