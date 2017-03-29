package com.mygdx.game.charakters;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.settings.GameVars;

public class Player extends Character2{

	public Vector2 input;
	public Vector2 drag;
	
	public Player(float x, float y) {
		super(x, y);
		input = new Vector2(0, 0);
		drag = new Vector2(0, 0);
	}
	
	public void update(float delta, float vx, float vy) {
		acceleration.add(input);
		super.update(delta, 0, 0);
		acceleration.sub(input);
		velocity.scl(1/(1+GameVars.dragSense));
	}
	
	

}
