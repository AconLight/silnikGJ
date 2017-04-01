package gamejam;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.mygdx.game.gameobjects.PhysicSpriteKulka;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Player extends PhysicObject{
	float time;
	float drenka;
	public PhysicSpriteKulka hitbox;
	public ArrayList<Proj> projs;
	public int projId;
	SpriteObject lewa, prawa;
	public boolean isW, isS, isD, isA;
	float alfa, alfa2;
	float speed;
	public boolean isDead;
	public Player(World world, float x, float y) {
		super(world, x, y);
		isDead = false;
		hitbox = new PhysicSpriteKulka(world, this, x, y, BodyType.DynamicBody);
		hitbox.createBall(50, 10, 0, 0);
		
		lewa = new SpriteObject(this, 0, 0);
		
		prawa = new SpriteObject(this, 0, 0);
		
		addSprite(lewa)
		.addTexture(Gdx.files.internal("data/lewa.png"));
		
		addSprite(prawa)
		.addTexture(Gdx.files.internal("data/prawa.png"));
		
		addSprite(hitbox)
		.addTexture(Gdx.files.internal("data/kadlub.png"));
		
		projs = new ArrayList<Proj>();
		for(int i = 0; i < 16; i++) {
			projs.add(new Proj(world, this, 0, 0));
		}
		spriteObjects.addAll(projs);
		projId = 0;
		speed = 5000;
	}
	
	public void update(float delta, float vx, float vy) {
		if(!isDead) {
		super.update(delta, vx, vy);
		Gdx.app.log("asdasdasd", " " + hitbox.body.getLinearVelocity().x);
		/*if (hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + 
				hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y < Stats.maxSpeed*Stats.maxSpeed)
			applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		else {
			applyForce((float)(-Math.cos(Math.toRadians(alfa))*speed*delta), (float)(-Math.sin(Math.toRadians(alfa))*speed*delta));
		}*/
		

		speed = 4000;

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
		int i = 1;
		alfa = hitbox.alfa;
		hitbox.alfa = (float) Math.toDegrees(hitbox.alfa);
		alfa = hitbox.alfa;
		alfa2 = 0;
		i = 0;
		if (isW && hitbox.body.getLinearVelocity().y < Stats.maxSpeed) {
			alfa2 += 90;
			
			i++;
			
		}
		if (isA && hitbox.body.getLinearVelocity().x > -Stats.maxSpeed) {
			alfa2 += 180;
			i++;
			
		}
		if (isS && hitbox.body.getLinearVelocity().y > -Stats.maxSpeed) {
			alfa2 += 290;
			i++;
			
		}
		if (isD && hitbox.body.getLinearVelocity().x < Stats.maxSpeed) {
			if (alfa2 > 180) alfa2 += 360;
			i++;
		}
		speed = 6000*50000/(50000+v*v);
		//alfa2 = alfa2%360;
		if (i != 0) {
			alfa2 /= i;
		}
		else {
			speed = 0;
			alfa2 = alfa;
		}
		if (alfa - alfa2 > 180) {
			alfa += (alfa2-180)*5;
			alfa /= 6;
		}
		else {
			alfa += (alfa2)*5;
			alfa /= 6;
		}
		alfa = alfa2;
		
		
			
		applyForce((float)(Math.cos(Math.toRadians(alfa))*speed*delta), (float)(Math.sin(Math.toRadians(alfa))*speed*delta));
		
			sclVel(0.97f);
		
			v = (float) (GameVars.box2dScale*Math.sqrt(hitbox.body.getLinearVelocity().x*hitbox.body.getLinearVelocity().x + hitbox.body.getLinearVelocity().y*hitbox.body.getLinearVelocity().y));
			if (v != 0) {
				if (hitbox.body.getLinearVelocity().x >= 0)
					hitbox.alfa = (float) Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v);
				else 
					hitbox.alfa = (float) (Math.PI - Math.asin(hitbox.body.getLinearVelocity().y*GameVars.box2dScale/v));
			}
			else {
				hitbox.alfa = 0;			
			}
			alfa = hitbox.alfa;
			hitbox.alfa = (float) Math.toDegrees(hitbox.alfa);
			prawa.alfa = (float) (hitbox.alfa);
			lewa.alfa = (float) (hitbox.alfa);
			
			//if (v > 30) v = 30;
			time += delta;
			drenka = (float) (Math.sin(time*5)*v/40);
			prawa.position.set(hitbox.position.x + drenka * (float)Math.cos((alfa)), hitbox.position.y + drenka * (float)Math.sin((alfa)));
			lewa.position.set(hitbox.position.x - drenka * (float)Math.cos((alfa)), hitbox.position.y - drenka * (float)Math.sin((alfa)));
	
		
		}
	}
	public void move(float alfa) {
		this.alfa = alfa;		
	}
	public void throwProj() {
		projs.get(projId).position.set(hitbox.position);
		projs.get(projId).throwProj((float) (alfa+Math.toRadians(5)), hitbox.body.getLinearVelocity().x*GameVars.box2dScale, hitbox.body.getLinearVelocity().y*GameVars.box2dScale);
		projId++;
		if (projId > projs.size()-1) projId = 0;
		projs.get(projId).position.set(hitbox.position);
		projs.get(projId).throwProj(alfa, hitbox.body.getLinearVelocity().x*GameVars.box2dScale, hitbox.body.getLinearVelocity().y*GameVars.box2dScale);
		projId++;
		if (projId > projs.size()-1) projId = 0;
		projs.get(projId).position.set(hitbox.position);
		projs.get(projId).throwProj((float) (alfa-Math.toRadians(5)), hitbox.body.getLinearVelocity().x*GameVars.box2dScale, hitbox.body.getLinearVelocity().y*GameVars.box2dScale);
		projId++;
		if (projId > projs.size()-1) projId = 0;
	}

}
