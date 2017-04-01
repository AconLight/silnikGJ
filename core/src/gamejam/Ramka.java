package gamejam;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Ramka extends Sprajt{
	SpriteObject ramka;
	SpriteObject text;
	SpriteObject korwin;
	SpriteObject korwin1;
	SpriteObject korwin2;
	SpriteObject femi; 
	SpriteObject nosal;
	SpriteObject testo;
	
	boolean up = false;
	int speed = 300;
	int ktoraRamkaKurwa;
	int ktoraRamka = 0;
	
	
	public Ramka(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Ramka() {
		super(960, 200);
		ramkaKorwin();
		ramkaNosal();
	}
	
	public void ramkaKorwin(){
		
		korwin = new SpriteObject(this, -GameVars.gameWidth/2 - 200, 0);
		addSprite(korwin)
		.addTexture(Gdx.files.internal("data/korwinramka.png"))
		.isVisible = true;
		
		korwin1 = new SpriteObject(this, -GameVars.gameWidth/2 + 200, 0);
		addSprite(korwin1)
		.addTexture(Gdx.files.internal("data/korwin1.png"))
		.isVisible = false;
		
		korwin2 = new SpriteObject(this, -GameVars.gameWidth/2 + 200, 0);
		addSprite(korwin2)
		.addTexture(Gdx.files.internal("data/korwin2.png"))
		.isVisible = false;
		
		femi = new SpriteObject(this, GameVars.gameWidth/2 + 200, 0);
		addSprite(femi)
		.addTexture(Gdx.files.internal("data/feministka.png"))
		.isVisible = true;
		
		text = new SpriteObject(this, 0, -300);
		addSprite(text)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = true;
		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = false;

		
	}

	public void ramkaNosal(){
		
		testo = new SpriteObject(this, -GameVars.gameWidth/2 - 200, 0);
		addSprite(testo)
		.addTexture(Gdx.files.internal("data/testo.png"))
		.isVisible = true;
		
		nosal = new SpriteObject(this, GameVars.gameWidth/2 + 200, 0);
		addSprite(nosal)
		.addTexture(Gdx.files.internal("data/nosacz.png"))
		.isVisible = true;
		
		text = new SpriteObject(this, 0, -300);
		addSprite(text)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = true;
		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = false;

		
	}
	
	/**
	1- korwin 3 przesuniecia, 2- nosacz
	*/
	
	public void przestaw(int ktoraRamkaKurwa){ //0 nic, 1 korwin, 2 nosacz

		this.ktoraRamkaKurwa = ktoraRamkaKurwa;
		ktoraRamka++; 
	}
	
	
	Boolean korwinMorda(){
		
		if(korwin2.position.y >= (position.y )) up = false;
		else if( korwin2.position.y < position.y - 11) up = true;
		return up;
	}
	
	void move(Boolean up, float delta){
		if(up){
			korwin2.position.y += delta*0.2*speed;	
			korwin2.position.x += delta*0.05*speed;
		}
		else{
			korwin2.position.y -= delta*0.2*speed;
			korwin2.position.x -= delta*0.05*speed;
		}
	}
	
	public void update(float delta, float vx, float vy){

		switch (ktoraRamkaKurwa){
		case 1:
			if(ktoraRamka == 1){
				ramka.isVisible = true; 
				if(korwin.position.x < (-GameVars.gameWidth/2 + position.x + 200)) korwin.position.x += delta*speed;
				else{
					korwin1.isVisible = true;
					korwin2.isVisible = true;
					//korwinMorda(delta);
					move(korwinMorda(),delta);
				}
				
				if(femi.position.x > (GameVars.gameWidth/2 + position.x - 200)) femi.position.x -= delta*speed;
				else femi.position.x = GameVars.gameWidth/2 + position.x - 200;
			
				if(text.position.y < ( position.y - 100)) text.position.y += delta*(0.5*speed);
				else{ text.position.y = position.y - 100;
					//ktoraRamka++;
				}

				
			}

			else if(ktoraRamka == 2){

				if(text.position.y < -150) ktoraRamka++;
				else text.position.y -= delta*(speed);
				
			}
			
			else if(ktoraRamka == 3){

					
				if(text.position.y < ( position.y - 100)) text.position.y += delta*(0.5*speed);
				else{ text.position.y = position.y - 100;
				//ktoraRamka++;
			}
				
			}
			
			else if(ktoraRamka == 4){
				korwin1.isVisible = false;
				korwin2.isVisible = false;
				if(korwin.position.x >= (-GameVars.gameWidth/2 + position.x - 200)) korwin.position.x -= delta*(1.5*speed);
				
				
				if(femi.position.x <= (GameVars.gameWidth/2 + position.x + 200)) femi.position.x += delta*(1.5*speed);
				
				if(text.position.y < -150) ramka.isVisible = false;
				else text.position.y -= delta*(speed);
				
			}
		break;
		case 2:
			if(ktoraRamka == 1){
				ramka.isVisible = true; 
				if(testo.position.x < (-GameVars.gameWidth/2 + position.x + 200)) testo.position.x += delta*speed;
				else testo.position.x = -GameVars.gameWidth/2 + position.x + 200;
				
				if(nosal.position.x > (GameVars.gameWidth/2 + position.x - 200)) nosal.position.x -= delta*speed;
				else nosal.position.x = GameVars.gameWidth/2 + position.x - 200;
			
				if(text.position.y < ( position.y - 100)) text.position.y += delta*(0.5*speed);
				else{ text.position.y = position.y - 100;
				//	ktoraRamka++;
				}

			}

			else if(ktoraRamka == 2){

				if(text.position.y < -150) ktoraRamka++;
				else text.position.y -= delta*(speed);
				
			}
			
			else if(ktoraRamka == 3){

					
				if(text.position.y < ( position.y - 100)) text.position.y += delta*(0.5*speed);
				else{ text.position.y = position.y - 100;
				//ktoraRamka++;
				}
				
			}
			
			else if(ktoraRamka == 4){
				if(testo.position.x >= (-GameVars.gameWidth/2 + position.x - 200)) testo.position.x -= delta*(1.5*speed);
				if(nosal.position.x <= (GameVars.gameWidth/2 + position.x + 200)) nosal.position.x += delta*(1.5*speed);
				if(text.position.y < -150) ramka.isVisible = false;
				else text.position.y -= delta*(speed);
		
			}
		break;
		}

	}
}
