package com.mygdx.game.charakters;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.settings.GameVars;

public class Character2 extends GameObject{
	
	public float alfa;
	public float oldAlfa;
	public float addAlfa;
	protected float v;
	public float dashTimer;
	
	public Character2(float x, float y) {
		super(x, y);
		dashTimer = -1;
		alfa = 0;
		oldAlfa = 0;
		addAlfa = 0;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		v = (float) Math.sqrt(velocity.x*velocity.x + velocity.y*velocity.y);
		if (v != 0) {
			if (velocity.x >= 0)
				alfa = (float) Math.asin(velocity.y/v);
			else 
				alfa = (float) (Math.PI - Math.asin(velocity.y/v));
		}
		else {
			alfa = 0;			
		}


		
		for(int i = 0; i < spriteObjects.size(); i++) {
			if (!(dashTimer >= 0 && dashTimer < GameVars.dashFreezeTime))
				spriteObjects.get(i).frameTime = GameVars.framehuj/v;		}
		
		if (alfa - oldAlfa < -Math.PI) {
			oldAlfa = (float) ((GameVars.alfaDrag*oldAlfa + alfa+2*Math.PI)/(GameVars.alfaDrag+1));
		}
		else if (alfa - oldAlfa > Math.PI) {
			oldAlfa = (float) ((GameVars.alfaDrag*oldAlfa + alfa-2*Math.PI)/(GameVars.alfaDrag+1));
		}
		else {
			oldAlfa = (float) ((GameVars.alfaDrag*oldAlfa + alfa)/(GameVars.alfaDrag+1));
		}
			
		Gdx.app.log("Alfa: ", "" + Math.toDegrees(alfa));
		for(int i = 0; i < spriteObjects.size(); i++) {
			spriteObjects.get(i).alfa = (float) Math.toDegrees(oldAlfa)+addAlfa;
		}
	}
	

}
