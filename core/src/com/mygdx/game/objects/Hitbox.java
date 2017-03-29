package com.mygdx.game.objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Hitbox {
	public enum ShapeMode { Circle, Polygon };
	public enum BehaviorMode { none, kinematic, dynamic };
	public ShapeMode sMode;
	public BehaviorMode bMode;
	public Circle circle;
	public Polygon polygon;
	public float colRadius;
	private Vector2 oldPosition;
	
	public Hitbox(float radius, GameObject obj){
			sMode = ShapeMode.Circle;
			bMode = BehaviorMode.dynamic;
			circle = new Circle(obj.position.x, obj.position.y, radius);
			colRadius = radius;
			oldPosition = new Vector2(obj.position.x, obj.position.y);
	}
	
	public Hitbox(float x, float y, float radius){
		sMode = ShapeMode.Circle;
		bMode = BehaviorMode.dynamic;
		circle = new Circle(x, y, radius);
		colRadius = radius;
		oldPosition = new Vector2(x, y);
	}
	
	public Hitbox(float[] verticles){
		sMode = ShapeMode.Polygon;
		bMode = BehaviorMode.dynamic;
		polygon = new Polygon(verticles);
		colRadius = 100;
	}
	
	public void update(Vector2 position) {
		if (sMode == ShapeMode.Circle) circle.setPosition(circle.x + (position.x - oldPosition.x), circle.y + (position.y - oldPosition.y));
		
		else if (sMode == ShapeMode.Polygon) polygon.translate((position.x - oldPosition.x), (position.y - oldPosition.y));
	
		oldPosition = new Vector2(position);
	}
	
	
}
