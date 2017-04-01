package com.mygdx.game.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;

public class PhysicObject extends GameObject{
	
	protected World world;
	public ArrayList<DistanceJoint> joints;
	public PhysicObject(World world, float x, float y) {
		super(x, y);
		this.world = world;
		joints = new ArrayList<DistanceJoint>();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PhysicSpriteObject addSprite(PhysicSpriteObject e) {
		spriteObjects.add(e);
		return (PhysicSpriteObject) spriteObjects.get(spriteObjects.size()-1);
	}
	
	public PhysicSpriteObject addSprite() {
		spriteObjects.add(new PhysicSpriteObject(world, this, 0, 0));
		return (PhysicSpriteObject) spriteObjects.get(spriteObjects.size()-1);
	}
	
	
	public void addDistanceJoint(Body bodyA, Body bodyB) {
		DistanceJointDef defJoint = new DistanceJointDef ();
		defJoint.length = (float) Math.sqrt((bodyA.getPosition().x - bodyB.getPosition().x)*(bodyA.getPosition().x - bodyB.getPosition().x) + 
				(bodyA.getPosition().y - bodyB.getPosition().y)*(bodyA.getPosition().y - bodyB.getPosition().y));
		defJoint.bodyA = bodyA;
		defJoint.bodyB = bodyB;
		joints.add((DistanceJoint) world.createJoint(defJoint));
	}
	
	
	
	public void applyForce(float vx, float vy) {
		for(int i = 0; i < spriteObjects.size(); i++) {
			if (((PhysicSpriteObject)spriteObjects.get(i)).body != null ) {
				((PhysicSpriteObject)spriteObjects.get(i)).body.applyForceToCenter(vx, vy, true);
			}
		}
	}
	
	public void sclVel(float scl) {
		for(int i = 0; i < spriteObjects.size(); i++) {
			if (((PhysicSpriteObject)spriteObjects.get(i)).body != null ) {
				((PhysicSpriteObject)spriteObjects.get(i)).body.setLinearVelocity
				(((PhysicSpriteObject)spriteObjects.get(i)).body.getLinearVelocity().scl(scl));
			}
		}
	}
	
	public void update(float delta) {
		super.update(delta, 0, 0);
	}

}
