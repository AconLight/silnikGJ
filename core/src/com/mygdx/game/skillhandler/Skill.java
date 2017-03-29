package com.mygdx.game.skillhandler;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Skill {
	private ArrayList<SkillObject> skillObjects;
	
	
	public Skill() {
		skillObjects = new ArrayList<SkillObject>();
	}
	
	public void update(float delta) {
		for(int i = 0; i < skillObjects.size(); i++) {
			skillObjects.get(i).update(delta); 
		}
	}
	
	public void setup() {
		//TODO
		// podstawowe parametry
	}
	
	public void addSkillObject() {
		skillObjects.add(new SkillObject());
	}
	
	public SkillObject getLastObj() {
		return skillObjects.get(skillObjects.size()-1);
	}
	public void render(SpriteBatch batch) {
		for(int i = 0; i < skillObjects.size()-1; i++)
			skillObjects.get(i).render(batch);
		Gdx.app.log("asd", "skill");
	}
	
}
