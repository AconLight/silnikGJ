package com.mygdx.game.mvc;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.scenes.GameScene;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;
import com.badlogic.gdx.Input.Keys;

public class Controller implements InputProcessor{
	private Model model;
	float screenWidth;
	float screenHeight;
	float gameX;
	float gameY;
	public Controller(Model model) {
		this.model = model;
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		Gdx.app.log("asddas", "clicked");
	}
	


	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode) {
		case Keys.W: {
			model.getScene().player.isW = true;
			break;
		}
		case Keys.S: {
			model.getScene().player.isS = true;
			break;
		}
		case Keys.D: {
			model.getScene().player.isD = true;
			break;
		}
		case Keys.A: {
			model.getScene().player.isA = true;
			break;
		}
		case Keys.ENTER: {
			if (model.getScene().load == 0) {
				model.getScene().load++;
				model.getScene().splash.start.frameNum = 1;
			}
			else if (model.getScene().load == 1) {
				model.getScene().load++;
				model.getScene().splash.start.frameNum = 2;
				
			}
			else if (model.getScene().load == 2) {
				model.getScene().load++;
				model.getScene().load();
			}
			else if (model.getScene().score > model.getScene().score1 && model.getScene().score < model.getScene().score1+3) {
				model.getScene().ramka.przestaw(1);
				model.getScene().score++;
				if (model.getScene().score == model.getScene().score1 + 2) {
					model.getScene().spawn2();
				}
			}
			else if (model.getScene().score > model.getScene().score2 && model.getScene().score < model.getScene().score2+3) {
				model.getScene().ramka.przestaw(2);
				model.getScene().score++;
				if (model.getScene().score == model.getScene().score2 + 2) {
					model.getScene().spawn3 ();
				}
			}
			else if (model.getScene().score ==1000) {
				model.getScene().ramka.przestaw(3);
				if (model.getScene().score == model.getScene().score3 + 2) {
					model.getScene().pasek.setPoNosaczu();
				}
			}
			break;
		}
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode) {
		case Keys.W: {
			model.getScene().player.isW = false;
			break;
		}
		case Keys.S: {
			model.getScene().player.isS = false;
			break;
		}
		case Keys.D: {
			model.getScene().player.isD = false;
			break;
		}
		case Keys.A: {
			model.getScene().player.isA = false;
			break;
		}
		case Keys.SPACE: {
			model.getScene().player.throwProj();
			break;
		}
		case Keys.Q: {
			model.getScene().ramka.przestaw(1);
			break;
		}
		case Keys.E: {
			model.getScene().ramka.przestaw(2);
			break;
		}
		case Keys.R: {
			model.getScene().ramka.przestaw(3);
			break;
		}
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		gameX = GameVars.gameWidth*(screenX/screenWidth) + model.cam.position.x - GameVars.gameWidth/2;
		gameY = GameVars.gameHeight*(1 - screenY/screenHeight) + model.cam.position.y - GameVars.gameHeight/2;


			
		Gdx.app.log("asddas", "clicked");

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		gameX = GameVars.gameWidth*(screenX/screenWidth) + model.cam.position.x - GameVars.gameWidth/2;
		gameY = GameVars.gameHeight*(1 - screenY/screenHeight) + model.cam.position.y - GameVars.gameHeight/2;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		gameX = GameVars.gameWidth*(screenX/screenWidth) + model.cam.position.x - GameVars.gameWidth/2;
		gameY = GameVars.gameHeight*(1 - screenY/screenHeight) + model.cam.position.y - GameVars.gameHeight/2;
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
