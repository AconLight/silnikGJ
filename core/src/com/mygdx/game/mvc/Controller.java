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
		Gdx.app.log("asddas", "clicked");

		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
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
		if (screenX > screenWidth/2)
			model.getScene().test.applyForce(3, 3);
		else
			model.getScene().test.applyForce(-3, 3);
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
