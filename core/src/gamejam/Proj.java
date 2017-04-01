package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.gameobjects.Bullet.State;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.SpriteObject;

public class Proj extends SpriteObject{
	public enum State {
		ready, throwing, done
	}
	public Proj(World world, GameObject parent, float x, float y) {
		super(parent, x, y);
		addTexture(Gdx.files.internal("data/banan.png"));
		isVisible = false;
	}
	
	public void throwProj(float alfa, float vx, float vy) {
		velocity.set((float)(400*Math.cos(alfa)), (float)(400*Math.sin(alfa)));
		isVisible = true;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		alfa += 105*delta;
	}

	
	
		
	
	
	
	



}
