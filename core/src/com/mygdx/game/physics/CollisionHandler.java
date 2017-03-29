package com.mygdx.game.physics;

import com.badlogic.gdx.math.Intersector;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Hitbox;
import com.mygdx.game.objects.SpriteObject;

public class CollisionHandler {

	public static boolean checkCollision(SpriteObject ob1, SpriteObject ob2) {
		/*if ((ob1.position.x - ob2.position.x)*(ob1.position.x - ob2.position.x) < 10000) {
			return true;
		}*/
		
		
		/*if (ob1.hitbox.sMode == Hitbox.ShapeMode.Circle) {
			if (ob2.hitbox.sMode == Hitbox.ShapeMode.Circle) {
				return Intersector.overlaps(ob1.hitbox.circle, ob2.hitbox.circle);
			}
			else if(ob2.hitbox.sMode == Hitbox.ShapeMode.Polygon) {
				return Intersector.overlaps(ob1.hitbox.circle, ob2.hitbox.circle);
			}
		}
		else if(ob1.hitbox.sMode == Hitbox.ShapeMode.Polygon) {
			if (ob2.hitbox.sMode == Hitbox.ShapeMode.Circle) {
				return Intersector.overlaps(ob1.hitbox.circle, ob2.hitbox.circle);
			}
			else if(ob2.hitbox.sMode == Hitbox.ShapeMode.Polygon) {
				return Intersector.overlaps(ob1.hitbox.circle, ob2.hitbox.circle);
			}
		}*/

		return false;
	}
	
	public static void handleCollision(SpriteObject ob1, SpriteObject ob2) {
		/*switch(ob1.hitbox.bMode) {
		case none: {
			
			break;
		}
		case kinematic: {
			
			break;
		}
		case dynamic: {
			dynamicCollision(ob1, ob2);
			break;
		}
		default : {
			
			break;
		}
		}
		
		switch(ob2.hitbox.bMode) {
		case none: {
			
			break;
		}
		case kinematic: {
			
			break;
		}
		case dynamic: {
			dynamicCollision(ob2, ob1);
			break;
		}
		default : {
			
			break;
		}
		}*/
		
	}
	
	public static void dynamicCollision(SpriteObject ob1, SpriteObject ob2) {
		/*float dx = ob1.position.x - ob2.position.x;
		float dy = ob1.position.y - ob2.position.y;
		float r = ob1.hitbox.circle.radius + ob2.hitbox.circle.radius;
		if (ob1.isSticked) {
			ob1.parent.collisionAcc.add(dx*Consts.physicK/r, dy*Consts.physicK/r);
		}
		else {
			ob1.collisionAcc.set(dx*Consts.physicK/r, dy*Consts.physicK/r);
		}*/
	}
	
}
