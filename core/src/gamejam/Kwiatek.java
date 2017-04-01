package gamejam;


import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;

public class Kwiatek extends Sprajt{
	SpriteObject kwiatek1;
	SpriteObject kwiatek2;
	
	float time = 0;
	
	public Kwiatek(float x, float y) {
		super(x, y);
		kwiatek2 = new SpriteObject(this, 0, 0);
		kwiatek1 = new SpriteObject(this, 0, 0);
		
		addSprite(kwiatek1)
		.addTexture(Gdx.files.internal("data/badlogic.jpg"))
		.addTexture(Gdx.files.internal("data/badlogic2.jpg"))
		.isVisible = true;
		kwiatek1.isPingPong = true;
		
		addSprite(kwiatek2)
		.addTexture(Gdx.files.internal("data/badlogic3.jpg"))
		.isVisible = true;
	}
	
	public void update(float delta, float vx, float vy){
		super.update(delta, vx, vy);
		
		time += delta;
		if(time > 20){
			kwiatek1.isVisible = kwiatek2.isVisible;
			time = 0;
		}
	}
	

	
	
}
