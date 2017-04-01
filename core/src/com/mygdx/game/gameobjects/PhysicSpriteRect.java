package com.mygdx.game.gameobjects;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.PhysicSpriteObject;

public class PhysicSpriteRect extends PhysicSpriteObject{

	public PhysicSpriteRect(World world, GameObject parent, float x, float y, BodyType type) {
		super(world, parent, x, y);
		body = world.createBody(createBodyDef(type, x, y));
	}
	

	public void createRect(float width, float height, float density, float friction, float restitution) {
		body.createFixture(setAsRect(width, height, density, friction, restitution));
	}
	

}
