package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.settings.GameVars;

public class Player extends PhysicObject{
	PhysicSpriteKulka hitbox;
	public boolean isW, isS, isD, isA;
	float alfa;
	float speed;
	public Player(World world, float x, float y) {
		super(world, x, y);
		hitbox = new PhysicSpriteKulka(world, this, x, y);
		hitbox.createBall(50, 10, 1, 1);
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/badlogic.jpg"));
		speed = 5000;
	}
	
	public void update(float delta, float vx, float vy) {
		super.update(delta, vx, vy);
		Gdx.app.log("asdasdasd", " " + hitbox.body.getLinearVelocity().x);
		/*if (hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + 
				hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y < Stats.maxSpeed*Stats.maxSpeed)
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		else {
			applyForce((float)(-Math.cos(Math.toRadians(alfa))*speed*delta), (float)(-Math.sin(Math.toRadians(alfa))*speed*delta));
		}*/
		

		speed = 5000;
			
		int i = 0;
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed) {
			alfa = 90;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed) {
			alfa = 180;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed) {
			alfa = 270;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed) {
			alfa = 0;
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		}
		
			sclVel(0.95f);
		
			float v = (float) (GameVars.box2dScale*Math.sqrt(hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y));
			if (v != 0) {
				if (hitbox.body.getLinearVelocity().x >= 0)
					hitbox.alfa = (float) Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v);
				else 
					hitbox.alfa = (float) (Math.PI - Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v));
			}
			else {
				hitbox.alfa = 0;			
			}
			hitbox.alfa = (float) Math.toDegrees(hitbox.alfa);

	}
	
	public void move(float alfa) {
		this.alfa = alfa;		
	}

}
