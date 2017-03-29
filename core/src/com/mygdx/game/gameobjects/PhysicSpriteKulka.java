package com.mygdx.game.gameobjects;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.PhysicSpriteObject;

public class PhysicSpriteKulka extends PhysicSpriteObject{

	public PhysicSpriteKulka(World world, GameObject parent, float x, float y) {
		super(world, parent, x, y);
		body = world.createBody(createBodyDef(x, y));
	}
	
	public void createBall(float r) {
		body.createFixture(setAsBall(r));
	}
	public void createBall(float r, float density, float friction, float restitution) {
		body.createFixture(setAsBall(r, density, friction, restitution));
	}

}
