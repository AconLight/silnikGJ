package com.mygdx.game.editor;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.Button;
import com.mygdx.game.objects.Map;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.settings.GameVars;

public class EditorScene extends Scene{
	
	ArrayList<Button> buttons;
	boolean isFrozenWorld;
	public boolean isQ, isW, isE;
	public float mouseX, mouseY;
	public int joint1Id = -1, joint2Id = -1;
	
	public PhysicObject physicspriteobjectparent;
	public PhysicSpriteObject physicspriteobject;
	public PhysicObject physicobject;
	public Map map;
	
	public enum State {
			menu, physicobject, physicspriteobject, map;
	}
	
	
	public EditorScene() {
		state = State.menu;
		buttons = new ArrayList<Button>();
		setup();
		setButtons();
	}
	
	public State state;
	
	public void addEditorSpriteObject() {
		
	}
	
	public void addEditorSpriteObjectToCreature() {
		PhysicSpriteKulka e = new PhysicSpriteKulka(world, physicobject, mouseX, mouseY, BodyType.DynamicBody);
		e.createBall(30, 1, 1, 1);
		physicobject.addSprite(e);		
	}
	
	public void markJoint(int id) {
		if (joint1Id == -1) joint1Id = id;
		else if (joint2Id == -1) {
			joint2Id = id;
			addJointToCreature(joint1Id, joint2Id);
			joint1Id = -1;
			joint2Id = -1;
		}
	}
	
	public void addJointToCreature(int id1, int id2) {
		physicobject.addDistanceJoint(((PhysicSpriteObject)physicobject.spriteObjects.get(id1)).body,
				((PhysicSpriteObject)physicobject.spriteObjects.get(id2)).body);
	}
	
	
	public void setBoxCreating() {
		buttons.get(1).hide();
		buttons.get(2).hide();
		buttons.get(3).hide();
		state = State.physicspriteobject;
		physicspriteobjectparent = new PhysicObject(world, 300, 300);
		physicspriteobject = new PhysicSpriteObject(world, physicspriteobjectparent, 300, 300);
		//physicspriteobjectparent.addSprite(physicspriteobject); // przy wyborze kszta³tu
		addGameObject(physicspriteobjectparent);
	}
	
	public void setCreatureCreating() {
		world.setGravity(new Vector2(0, -1));
		isFrozenWorld = true;
		buttons.get(1).hide();
		buttons.get(2).hide();
		buttons.get(3).hide();
		
		buttons.get(4).show();
		state = State.physicobject;
		physicobject = new PhysicObject(world, 300, 300);
		addGameObject(physicobject);
		addGround(600, 120, 1100, 25);
	}

	public void setMapCreating() {
		buttons.get(1).hide();
		buttons.get(2).hide();
		buttons.get(3).hide();
		state = State.map;
		//addGameObject(map); //TODO
	}
	
	public void setup() {
		buttons.add(new Button(GameVars.gameWidth/2, GameVars.gameHeight/2, 100, 50, 0, "data/badlogic.jpg"));//start
		buttons.add(new Button(50+15, GameVars.gameHeight-25-15, 100, 50, 1, "data/badlogic.jpg"));//menu-box creating
		buttons.get(buttons.size()-1).hide();
		buttons.add(new Button(150+30, GameVars.gameHeight-25-15, 100, 50, 2, "data/badlogic.jpg"));//menu-creature creating
		buttons.get(buttons.size()-1).hide();
		buttons.add(new Button(250+45, GameVars.gameHeight-25-15, 100, 50, 3, "data/badlogic.jpg"));//menu-map creating
		buttons.get(buttons.size()-1).hide();
		//creature
		buttons.add(new Button(GameVars.gameWidth -50-15, GameVars.gameHeight-25-15, 100, 50, 4, "data/badlogic.jpg"));//enable gravity
		buttons.get(4).hide();

	}
	
	public void update(float delta) {
		if(!isFrozenWorld) super.update(delta);
		
	}
	
	public void movingOnOff() {
		isFrozenWorld = !isFrozenWorld;
	}
	
	public void setButtons() {
		for(int i = 0; i < buttons.size(); i++) {
			addGameObject(buttons.get(i));
		}
	}
}
