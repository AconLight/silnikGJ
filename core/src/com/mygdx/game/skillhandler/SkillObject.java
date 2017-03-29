package com.mygdx.game.skillhandler;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Hitbox;

public class SkillObject extends GameObject{
	
	private ArrayList<SkillObjectComponent> components;
	
	
	public SkillObject () {
		super(0, 0);
		components = new ArrayList<SkillObjectComponent>();
	}
	
	public SkillObject(float radius){
		super(0, 0);
		components = new ArrayList<SkillObjectComponent>();
		hitbox = new Hitbox(radius, this);
	}
	
	public SkillObject(float [] verticles){
		super(0, 0);
		components = new ArrayList<SkillObjectComponent>();
		hitbox = new Hitbox(verticles);
	}
	
	
	public void update(float delta) {
		super.update(delta, 0, 0);
		for(int i = 0; i < components.size(); i++) {
			components.get(i).update(delta, this);
		}
	}
	
	public void render(SpriteBatch batch) {
		for(int i=0; i<spriteObjects.size();i++)
			spriteObjects.get(i).render(batch);
		Gdx.app.log("asd", "skillobject");
	}
	
	public void addComponent(SkillObjectComponent component) {
		components.add(component);
	}
	
	public SkillObjectComponent getLast() {
		return components.get(components.size()-1);
	}
	
	public void setAsCircle(float radius){
		hitbox = new Hitbox(radius, this);
	}
	
	public void setAsPolygon(float [] verticles){
		hitbox = new Hitbox(verticles);
	}
}
