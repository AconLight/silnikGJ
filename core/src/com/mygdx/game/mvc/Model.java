package com.mygdx.game.mvc;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.scenes.GameOverScene;
import com.mygdx.game.scenes.GameScene;
import com.mygdx.game.scenes.SplashScene;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;
import com.mygdx.game.settings.LogicHelp;

public class Model {
	
	public ArrayList<Scene> scenes;
	public ArrayList<Integer> sceneIds;
	static int id;
	OrthographicCamera cam, cam2;
	World world;
	Body body;
	Fixture fixture;
	
	GameScene gra;
	
	public Model() {

		sceneIds = new ArrayList<Integer>();
		setCam(new OrthographicCamera());
		setCam2(new OrthographicCamera());
		create();
		sceneIds.add(0);
		LogicHelp.isEnd = false;
	}
	
	
	public void create() {
		scenes = new ArrayList<Scene>();
		getCam().setToOrtho(false, GameVars.gameWidth, GameVars.gameHeight);
		getCam2().setToOrtho(false, GameVars.gameWidth/GameVars.box2dScale, GameVars.gameHeight/GameVars.box2dScale);
		id = 0;
		gra = new GameScene(getCam());

		
		
		
		
		
		
		
		
		//addGround(400, 100, 800, 50);
		addScene(gra);
		//gra.world = new World(new Vector2(0, -10), true); 
		//scenes.get(0).world = new World(new Vector2(0, -10), true); 
		//scenes.get(0).addBall(100, 100, 60);
		
		
	}
	
	public void addBall(float x, float y, float r) {
		BodyDef bodyDef = new BodyDef();
		// We set our body to dynamic, for something like ground which doesn't move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
		// Set our body's starting position in the world
		bodyDef.position.set(x, y);

		// Create our body in the world using our body definition
		body = world.createBody(bodyDef);

		// Create a circle shape and set its radius to 6
		CircleShape circle = new CircleShape();
		circle.setRadius(r);

		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit

		// Create our fixture and attach it to the body
		fixture = body.createFixture(fixtureDef);
		circle.dispose();
	}
	
	public void addGround(float x, float y, float width, float height) {
		// Create our body definition
		BodyDef groundBodyDef = new BodyDef();  
		// Set its world position
		groundBodyDef.position.set(new Vector2(x, y));  

		// Create a body from the defintion and add it to the world
		Body groundBody = world.createBody(groundBodyDef);  

		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();  
		// Set the polygon shape as a box which is twice the size of our view port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		groundBox.setAsBox(width/2, height/2);
		// Create a fixture from our polygon shape and add it to our ground body  
		groundBody.createFixture(groundBox, 0.0f); 
		// Clean up after ourselves
		groundBox.dispose();
	}
	
	public void update(float delta) {
		for(int i = 0; i < sceneIds.size(); i++) {
			scenes.get(sceneIds.get(i)).update(delta);
		}
		//body.setLinearVelocity(0, 1400);
		
		// state machine
		
		
		
		//Gdx.app.log("body: ", "" + body.getLinearVelocity().y);
		//scenes.get(0).world.step(delta*5, 20, 20);
		scenes.get(0).update(delta);
	}
	
	public void render() {
		//TODO  scenes render
		// state machine
	}
	
	public void addScene(Scene scene){
		scenes.add(scene);
		//scenes.get(scenes.size()-1).create();
		//scenes.get(scenes.size()-1).createWorld();
		//sceneIds.add(id);
		//id++;
		
	}
	
	public GameScene getScene() {
		return (GameScene) scenes.get(0);
	}
	
	public void dispose(){
		for(int i=0; i<scenes.size();i++)
			scenes.get(i).dispose();
	}

	public OrthographicCamera getCam() {
		return cam;
	}
	
	public OrthographicCamera getCam2() {
		return cam2;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}
	public void setCam2(OrthographicCamera cam) {
		this.cam2 = cam;
	}
	
}
