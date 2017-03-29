package com.mygdx.game.components;

import com.mygdx.game.skillhandler.SkillObject;
import com.mygdx.game.skillhandler.SkillObjectComponent;

public class Curve extends SkillObjectComponent{
	
	float angV;
	float angA;
	
	public void update(float delta, SkillObject obj){
		super.update(delta, obj);
		
		float angle;
		
		if(obj.velocity.y <0 )
			angle = (float) (180 + Math.atan(obj.velocity.y / obj.velocity.x));
		else
			angle = (float) Math.atan(obj.velocity.y / obj.velocity.x);
		
		
		angV += angA * delta;
		angle += angV * delta;
		
		float totalV = (float) Math.sqrt(Math.pow(obj.velocity.x, 2) + Math.pow(obj.velocity.y, 2));
		obj.velocity.x = (float) (totalV * Math.cos(angle));
		obj.velocity.y = (float) (totalV * Math.sin(angle));
		
		float totalA = (float) Math.sqrt(Math.pow(obj.acceleration.x, 2) + Math.pow(obj.acceleration.y, 2));
		obj.acceleration.x = (float) (totalA * Math.cos(angle));
		obj.acceleration.y = (float) (totalA * Math.sin(angle));
		
		obj.update(delta);
	}
}
