package com.mygdx.game.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.MotorJointDef;
import com.mygdx.game.settings.GameVars;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Scene {
	
	protected ArrayList<GameObject> gameObjects;
	public Box2DDebugRenderer debugRenderer;
	protected OrthographicCamera cam;
	protected World world;
	public PhysicSpriteObject pobj;
	public Fixture fixture;
	//public Body body;
	public float asd;
	
	public Scene() {
		create();
		createWorld();
	}
	
	public void createWorld() {
		world = new World(new Vector2(0, 0), true); 
	}
	
	public World getWorld() {
		return world;
	}

	
	public BodyDef createBodyDef(float x, float y) {
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(x/GameVars.box2dScale, y/GameVars.box2dScale);
		return bodyDef;
	}
	
	public FixtureDef setAsBall(float r) {

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(r/GameVars.box2dScale);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		return fixtureDef;
		
	}

	public void addGround(float x, float y, float width, float height) {
		// Create our body definition
		BodyDef groundBodyDef = new BodyDef();  
		// Set its world position
		groundBodyDef.position.set(new Vector2(x/GameVars.box2dScale, y/GameVars.box2dScale));  

		// Create a body from the defintion and add it to the world
		Body groundBody = world.createBody(groundBodyDef);  

		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();  
		// Set the polygon shape as a box which is twice the size of our view port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		groundBox.setAsBox(width/2/GameVars.box2dScale, height/2/GameVars.box2dScale);
		// Create a fixture from our polygon shape and add it to our ground body  
		groundBody.createFixture(groundBox, 0.0f); 
		// Clean up after ourselves
		groundBox.dispose();
	}
	
	public void addDistanceJoint(DistanceJointDef jointDef, Body bodyA, Body bodyB) {
		DistanceJointDef defJoint = new DistanceJointDef ();
		defJoint.length = (float) Math.sqrt((bodyA.getPosition().x - bodyB.getPosition().x)*(bodyA.getPosition().x - bodyB.getPosition().x) + 
				(bodyA.getPosition().y - bodyB.getPosition().y)*(bodyA.getPosition().y - bodyB.getPosition().y));
		defJoint.bodyA = bodyA;
		defJoint.bodyB = bodyB;
		world.createJoint(defJoint);
	}
	public GameObject addGameObject(GameObject obj) {
		gameObjects.add(obj);
		obj.id = gameObjects.size()-1;
		return gameObjects.get(gameObjects.size()-1);
	}
	
	public void create() {
		gameObjects = new ArrayList<GameObject>();
		//world = new World(new Vector2(0, 0), true); 
	}
	
	public void render(SpriteBatch batch) {
		for(int i=0; i<gameObjects.size();i++)
			gameObjects.get(i).render(batch);
		//Gdx.app.log("rendered", "scene");
	}

	public void dispose() {
		for(int i=0; i<gameObjects.size();i++)
			gameObjects.get(i).dispose();
		
	}

	public void update(float delta) {
		for(int i=0; i<gameObjects.size();i++)
		gameObjects.get(i).update(delta, 0, 0);
		
		worldUpdate(delta);
	}
	
	public void worldUpdate(float delta) {
		world.step(delta, 10, 10);
	}
	
}
