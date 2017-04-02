package gamejam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.SpriteObject;
import com.mygdx.game.settings.GameVars;

public class Ramka extends Sprajt{
	SpriteObject ramka;
	SpriteObject text;
	SpriteObject text2;
	SpriteObject text3;
	SpriteObject triggered;
	SpriteObject kobietysa;
	SpriteObject korwin;
	SpriteObject korwin1;
	SpriteObject korwin2;
	SpriteObject femi; 
	SpriteObject nosal;
	SpriteObject nosacz;
	SpriteObject testo;
	SpriteObject frank;
	SpriteObject vaper;
	SpriteObject fuck;
	
	boolean up = false;
	int speed = 300;
	int ktoraRamkaKurwa;
	int ktoraRamka = 0;
	private OrthographicCamera cam;
	
	public Ramka(float x, float y, OrthographicCamera cam ) {
		super(x, y);
		this.cam = cam;
		objectViewPriority = 2;
	}
	
	public Ramka(OrthographicCamera cam ) {
		
		super(960, 200);
		objectViewPriority = 2;
		this.cam = cam;
		ramkaKorwin();
		ramkaNosal();
		ramkaVaper();
		
	}
	
	public void ramkaKorwin(){
		
		text = new SpriteObject(this, 0, 0);
		addSprite(text)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = false;
		
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
		.addTexture(Gdx.files.internal("data/feministkaalert.png"))
		.isVisible = true;
		femi.frameTime = 9999999; 
				
		triggered = new SpriteObject(this, 0, -300);
		addSprite(triggered)
		.addTexture(Gdx.files.internal("data/triggered.png"))
		.addTexture(Gdx.files.internal("data/triggered2.png"))
		.isVisible = true;
		triggered.frameTime = 0.5f; 
		//triggered.frameNum = 0; 

		kobietysa = new SpriteObject(this, 0, -300);
		addSprite(kobietysa)
		.addTexture(Gdx.files.internal("data/kobietysa.png"))
		.isVisible = true;
		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = false;

		
	}

	public void ramkaNosal(){
		
		text2 = new SpriteObject(this, 0, 0);
		addSprite(text2)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = false;
		
		testo = new SpriteObject(this, -GameVars.gameWidth/2 - 200, 0);
		addSprite(testo)
		.addTexture(Gdx.files.internal("data/testo.png"))
		.isVisible = false;
		
		nosal = new SpriteObject(this, GameVars.gameWidth/2 + 200, 0);
		addSprite(nosal)
		.addTexture(Gdx.files.internal("data/nosacz.png"))
		.addTexture(Gdx.files.internal("data/nosacz0.png"))
		.isVisible = false;
		nosal.frameTime = 999999; 
				
		triggered = new SpriteObject(this, 0, -300);
		addSprite(triggered)
		.addTexture(Gdx.files.internal("data/triggered.png"))
		.addTexture(Gdx.files.internal("data/triggered2.png"))
		.isVisible = true;
		triggered.frameTime = 0.5f; 
		//triggered.frameNum = 0; 

		nosacz = new SpriteObject(this, 0, -300);
		addSprite(nosacz)
		.addTexture(Gdx.files.internal("data/nosacz1.png"))
		.isVisible = true;

		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = false;

		
	}
	
public void ramkaVaper(){
		
		text3 = new SpriteObject(this, 0, 0);
		addSprite(text3)
		.addTexture(Gdx.files.internal("data/text.png"))
		.isVisible = false;
		
		frank = new SpriteObject(this, -GameVars.gameWidth/2 - 200, 0);
		addSprite(frank)
		.addTexture(Gdx.files.internal("data/frank.png"))
		.isVisible = true;
		
		vaper = new SpriteObject(this, GameVars.gameWidth/2 + 200, 0);
		addSprite(vaper)
		.addTexture(Gdx.files.internal("data/vaper.png"))
		.addTexture(Gdx.files.internal("data/vaperalert.png"))
		.isVisible = true;
		vaper.frameTime = 9999999; 
				
		triggered = new SpriteObject(this, 0, -300);
		addSprite(triggered)
		.addTexture(Gdx.files.internal("data/triggered.png"))
		.addTexture(Gdx.files.internal("data/triggered2.png"))
		.isVisible = true;
		triggered.frameTime = 0.5f; 
		//triggered.frameNum = 0; 

		fuck = new SpriteObject(this, 0, -300);
		addSprite(fuck)
		.addTexture(Gdx.files.internal("data/fuck.png"))
		.isVisible = true;
		
		ramka = new SpriteObject(this, 0, 0);
		addSprite(ramka)
		.addTexture(Gdx.files.internal("data/ramka.png"))
		.isVisible = false;

		
	}
	
	/**
	1- korwin 3 przesuniecia, 2- vaper, 3- nosacz	*/
	
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
		super.update(delta, vx, vy);
		switch (ktoraRamkaKurwa){
		case 1:
			if(ktoraRamka == 1){
				ramka.isVisible = true; 
				text.isVisible = true;
				femi.isVisible = true;
				if(korwin.position.x < (-GameVars.gameWidth/2 + position.x + 200)) korwin.position.x += delta*speed;
				else{
					korwin1.isVisible = true;
					korwin2.isVisible = true;
					
					//korwinMorda(delta);
					move(korwinMorda(),delta);
				}
				
				if(femi.position.x > (GameVars.gameWidth/2 + position.x - 200)) femi.position.x -= delta*speed;
				else femi.position.x = GameVars.gameWidth/2 + position.x - 200;
			
				if( kobietysa.position.y < ( position.y - 100))  kobietysa.position.y += delta*(0.5*speed);
				else{  kobietysa.position.y = position.y - 100;
					//ktoraRamka++;
				}

				
			}

			 if(ktoraRamka == 2){
				triggered.position.y = position.y - 100; 
				femi.frameTime = 0.5f;  
				if( kobietysa.position.y < -150) ktoraRamka++;
				else kobietysa.position.y -= delta*(speed);
				//ktoraRamka++;
			}
			
			else if(ktoraRamka == 3){

				 triggered.position.y = position.y - 100;
				//if(triggered.position.y < ( position.y - 100)) triggered.position.y += delta*(0.5*speed);
				//else{ triggered.position.y = position.y - 100;
				//ktoraRamka++;
			//}
				
			}
			
			else if(ktoraRamka == 4){
				korwin1.isVisible = false;
				korwin2.isVisible = false;
				if(korwin.position.x >= (-GameVars.gameWidth/2 + position.x - 200)) korwin.position.x -= delta*(1.5*speed);
				
				
				if(femi.position.x <= (GameVars.gameWidth/2 + position.x + 200)) femi.position.x += delta*(1.5*speed);
				
				if(triggered.position.y < -150){
					ramka.isVisible = false;
					text.isVisible = false;   
					femi.isVisible = false;
					femi.frameTime = 999999;
					ktoraRamka = 0;
				}
				else triggered.position.y -= delta*(speed);
				
			}
			
		break;
		case 3:
			if(ktoraRamka == 1){
				nosal.isVisible = true;
				testo.isVisible = true;
				ramka.isVisible = true; 
				text2.isVisible = true;
				if(testo.position.x < (-GameVars.gameWidth/2 + position.x + 198)) testo.position.x += delta*speed;

				
				if(nosal.position.x > (GameVars.gameWidth/2 + position.x - 200)) nosal.position.x -= delta*speed;
				else nosal.position.x = GameVars.gameWidth/2 + position.x - 200;
			
				if( nosacz.position.y < ( position.y - 100))  nosacz.position.y += delta*(0.5*speed);
				else{  nosacz.position.y = position.y - 100;
					//ktoraRamka++;
				}
		
			}

			else if(ktoraRamka == 2){
				
				if( nosacz.position.y < -150) ktoraRamka++;
				else nosacz.position.y -= delta*(1.3*speed);
				//ktoraRamka++;
			}
			
			else if(ktoraRamka == 3){
				nosal.frameTime = 0.5f; 
				 triggered.position.y = position.y - 100;
				//if(triggered.position.y < ( position.y - 100)) triggered.position.y += delta*(0.5*speed);
				//else{ triggered.position.y = position.y - 100;
				//ktoraRamka++;
			//}
				
			}
			
			else if(ktoraRamka == 4){
				if(testo.position.x >= (-GameVars.gameWidth/2 + position.x - 250)) testo.position.x -= delta*(1.5*speed);

				if(nosal.position.x <= (GameVars.gameWidth/2 + position.x + 250)) nosal.position.x += delta*(1.5*speed);
				
				if(triggered.position.y < -150){
					ramka.isVisible = false;
					text2.isVisible = false;     
					nosal.isVisible = false;
					testo.isVisible = false;
					nosal.frameTime = 999999; 
					ktoraRamka = 0;
				}
				else triggered.position.y -= delta*(speed);

			}
		break;
		case 2:
			if(ktoraRamka == 1){
				vaper.isVisible = true;
				frank.isVisible = true;
				ramka.isVisible = true; 
				text3.isVisible = true;
				if(frank.position.x < (-GameVars.gameWidth/2 + position.x + 198)) frank.position.x += delta*speed;

				
				if(vaper.position.x > (GameVars.gameWidth/2 + position.x - 200)) vaper.position.x -= delta*speed;
				else vaper.position.x = GameVars.gameWidth/2 + position.x - 200;
			
				if( fuck.position.y < ( position.y - 100))  fuck.position.y += delta*(0.5*speed);
				else{  fuck.position.y = position.y - 100;
					//ktoraRamka++;
				}
		
			}

			else if(ktoraRamka == 2){
				
				if( fuck.position.y < -150) ktoraRamka++;
				else fuck.position.y -= delta*(1.3*speed);
				//ktoraRamka++;
			}
			
			else if(ktoraRamka == 3){
				vaper.frameTime = 0.5f; 
				triggered.position.y = position.y - 100;
				//if(triggered.position.y < ( position.y - 100)) triggered.position.y += delta*(0.5*speed);
				//else{ triggered.position.y = position.y - 100;
				//ktoraRamka++;
			//}
				
			}
			
			else if(ktoraRamka == 4){
				if(frank.position.x >= (-GameVars.gameWidth/2 + position.x - 250)) frank.position.x -= delta*(1.5*speed);

				if(vaper.position.x <= (GameVars.gameWidth/2 + position.x + 250)) vaper.position.x += delta*(1.5*speed);
				
				if(triggered.position.y < -150){
					ramka.isVisible = false;
					text3.isVisible = false;     
					vaper.isVisible = false;
					frank.isVisible = false;
					vaper.frameTime = 999999; 
					ktoraRamka = 0;
				}
				else triggered.position.y -= delta*(speed);

			}
		break;
		}

	}
	public void render(SpriteBatch batch) {
		//float x = cam.position.x;
		//float y = cam.position.y;
		//cam.translate(-cam.position.x, -cam.position.y);
		//cam.update();
		super.render(batch);
		//cam.translate(x, y);
		//cam.update();
	}
}
