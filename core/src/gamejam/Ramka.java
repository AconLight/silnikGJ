package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Ramka extends Sprajt{
	SpriteObject ramka;
	SpriteObject korwin;
	SpriteObject femi; 
	SpriteObject text;
	
	int speed = 300;
	
	public Ramka(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Ramka() {
		super(960, 200);
	}
	
	public void ramkaKorwin(){
		
		korwin = new SpriteObject(this, -GameVars.gameWidth/2 - 200, 0);
		addSprite(korwin)
		.addTexture(Gdx.files.internal("data/korwinramka.png"))
		.isVisible = true;
		
		femi = new SpriteObject(this, GameVars.gameWidth/2 + 200, 0);
		addSprite(femi)
		.addTexture(Gdx.files.internal("data/korwinramka.png"))
		.isVisible = true;
		
		text = new SpriteObject(this, 0, -300);
		addSprite(text)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = true;
		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = true;

		
	}

	public void przestaw(int ktoraRamkaKurwa){ //0 nic, 1 korwin,  
			
		switch(ktoraRamkaKurwa){
		
		case 1: break;
		
		case 2: break;
			
		}
		
	}
	
	public void update(float delta, float vx, float vy){
		
		if(korwin.position.x < (-GameVars.gameWidth/2 + position.x + 200)) korwin.position.x += delta*speed;
		else korwin.position.x = -GameVars.gameWidth/2 + position.x + 200;
		
		if(femi.position.x > (GameVars.gameWidth/2 + position.x - 200)) femi.position.x -= delta*speed;
		else femi.position.x = GameVars.gameWidth/2 + position.x - 200;
	
		if(text.position.y < ( position.y - 100)) text.position.y += delta*(0.5*speed);
		else text.position.y = position.y - 100;
	}
}
