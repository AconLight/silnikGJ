package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Sprajty extends Sprajt{

	SpriteObject plansza;
	
	public Sprajty() {
		super(0, 0);
		// TODO Auto-generated constructor stub
	}
	
	void set(int type,float x,float y) {
		switch(type){
		case SprajtyId.plansza: {
			
			plansza = new SpriteObject(this, 0, 0);
			addSprite(plansza)
			.addTexture(Gdx.files.internal("data/plansza.png"));
			break;
		}
		
		}
	
	}
	
}
