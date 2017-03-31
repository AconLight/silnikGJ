package gamejam;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.objects.PhysicObject;

public class Proj extends PhysicObject{

	public enum State {
		ready, throwing, done
	}
	public Proj(World world, float x, float y) {
		super(world, x, y);
		// TODO Auto-generated constructor stub
	}

}
