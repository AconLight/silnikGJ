package com.mygdx.game.editor;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.scenes.GameScene;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;
import com.badlogic.gdx.Input.Keys;

public class EditorController implements InputProcessor{
	private EditorModel model;
	float screenWidth;
	float screenHeight;
	float gameX;
	float gameY;
	public EditorController(EditorModel model) {
		this.model = model;
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		Gdx.app.log("asddas", "clicked");
	}
	


	@Override
	public boolean keyDown(int keycode) {
		Gdx.app.log("asddas", "clicked");
		switch(keycode) {
		case Keys.Q : {
			model.getScene().isQ = true;
			break;
		}
		case Keys.W : {
			model.getScene().isW = true;
			break;
		}
		case Keys.E : {
			model.getScene().isE = true;
			break;
		}
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Keys.Q : {
			model.getScene().isQ = false;
			break;
		}
		case Keys.W : {
			model.getScene().isW = false;
			break;
		}
		case Keys.E : {
			model.getScene().isE = false;
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
		
		boolean isButtonClicked = false;
		
		for(int i = 0; i < model.getScene().buttons.size(); i++) {
			
			if (model.getScene().buttons.get(i).isClicked(gameX, gameY)) {
				isButtonClicked = true;
				switch(model.getScene().buttons.get(i).id) {
				case 0 : {
					
					model.getScene().buttons.get(0).hide();
					for(int j = 1; j < 4; j++) {
						model.getScene().buttons.get(j).show();
					}
					break;
				}
				case 1 : {
					model.getScene().setBoxCreating();
					break;
				}
				case 2 : {
					model.getScene().setCreatureCreating();
					break;
				}
				case 3 : {
					model.getScene().setMapCreating();
					break;
				}
				case 4 : {
					model.getScene().movingOnOff();
					break;
				}
				}
			}
		}
		
		if (!isButtonClicked)
		switch(model.getScene().state) {
		case physicobject : {
			if (model.getScene().isQ)
				model.getScene().addEditorSpriteObjectToCreature();
			else if (model.getScene().isW) {
				Gdx.app.log("W", "clicked");
				for ( int i = 0; i < model.getScene().physicobject.spriteObjects.size(); i++) {
					if (((PhysicSpriteObject)model.getScene().physicobject.spriteObjects.get(i)).isClicked(gameX, gameY)) {
						Gdx.app.log("Joint", "marked " + i);
						model.getScene().markJoint(i);
					}
				}
			}
			break;
		}
		}
		
		Gdx.app.log("asddadagdafadsfdsas", "clicked");
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
		switch(model.getScene().state) {
		case physicobject : {
			if (model.getScene().isE) {
				Gdx.app.log("dragged", "clicked");
				for ( int i = 0; i < model.getScene().physicobject.spriteObjects.size(); i++) {
					if (((PhysicSpriteObject)model.getScene().physicobject.spriteObjects.get(i)).isClicked(gameX, gameY)) {
						((PhysicSpriteObject) model.getScene().physicobject.spriteObjects.get(i)).setPosition(gameX, gameY);

						for ( int j = 0; j < model.getScene().physicobject.joints.size(); j++) {
							float dx = model.getScene().physicobject.joints.get(j).getBodyA().getPosition().x - 
									model.getScene().physicobject.joints.get(j).getBodyB().getPosition().x;
							float dy = model.getScene().physicobject.joints.get(j).getBodyA().getPosition().y - 
									model.getScene().physicobject.joints.get(j).getBodyB().getPosition().y;
							float length = (float) Math.sqrt(dx*dx + dy*dy);
							model.getScene().physicobject.joints.get(j).setLength(length);	
						}

						
						
					}
				}
			}
			break;
		}
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		gameX = GameVars.gameWidth*(screenX/screenWidth) + model.cam.position.x - GameVars.gameWidth/2;
		gameY = GameVars.gameHeight*(1 - screenY/screenHeight) + model.cam.position.y - GameVars.gameHeight/2;
		
		model.getScene().mouseX = gameX;
		model.getScene().mouseY = gameY;
		Gdx.app.log("mouseX: " + gameX, "_:mouseY: " + gameY);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
