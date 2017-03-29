package com.mygdx.game.charakters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.skillhandler.Skill;

public class Character extends GameObject {
	
	private ArrayList<Skill> skills;
	
	public Character() {
		super(0, 0);
		skills = new ArrayList<Skill>();
		//TODO
	}
	
	public void addSkill() {
		skills.add(new Skill());// ew parametry
	}
	
	public Skill getLastSkill() {
		return skills.get(skills.size()-1);
	}
	public void render(SpriteBatch batch) {
		super.render(batch);
		for(int i = 0; i < skills.size()-1; i++)
			skills.get(i).render(batch);
		Gdx.app.log("asd", "character");
	}

}
