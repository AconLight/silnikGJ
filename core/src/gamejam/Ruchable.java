package gamejam;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.PhysicObject;

public class Ruchable extends PhysicObject{
	public float direction;
	public float speed;
	public Ruchable(World world, float x, float y) {
		super(world, x, y);
		speed = 0;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		//acceleration.set((float)(Math.cos(Math.toDegrees(direction))*speed), (float)(Math.sin(Math.toDegrees(direction))*speed));
		
	}
	public void move(float speed, float direction) {
		
	}

}
