package com.mygdx.game.components;

import com.mygdx.game.skillhandler.SkillObject;
import com.mygdx.game.skillhandler.SkillObjectComponent;

public class Linear extends SkillObjectComponent{
	
	public void update(float delta, SkillObject obj){
		super.update(delta, obj);
		obj.update(delta);
	}
}
