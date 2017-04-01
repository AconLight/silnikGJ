package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;

public class PhysicTest extends PhysicObject{

	PhysicSpriteKulka kulka1, kulka2;
	
	public PhysicTest(World world, float x, float y) {
		super(world, x, y);

		kulka1 = new PhysicSpriteKulka(world, this, x-100, y+100, BodyType.DynamicBody);
		kulka1.createBall(30, 1, 1, 1);
		kulka2 = new PhysicSpriteKulka(world, this, x+100, y, BodyType.DynamicBody);
		kulka2.createBall(30, 1, 0, 0);
		
		addSprite(kulka1)
		.addTexture(Gdx.files.internal("data/badlogic.jpg"));
		
		addSprite(kulka2)
		.addTexture(Gdx.files.internal("data/badlogic.jpg"));
		
		addDistanceJoint(kulka1.body, kulka2.body);
	}

}
