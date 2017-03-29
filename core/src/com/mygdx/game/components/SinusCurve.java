package com.mygdx.game.components;

import com.mygdx.game.skillhandler.SkillObject;

public class SinusCurve extends Curve {
	
	float time = 0;
	
	public void update(float delta, SkillObject obj){
		super.update(delta, obj);
		
		time += delta;
		angA = (float) (angA * Math.sin(time));
		
	}
	
	

}
