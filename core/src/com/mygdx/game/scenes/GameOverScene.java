package com.mygdx.game.scenes;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.settings.AssetLoader;
import com.mygdx.game.settings.GameVars;

public class GameOverScene extends Scene{


	
	public GameOverScene() {
		addGameObject(new GameObject(+GameVars.gameWidth/2, +GameVars.gameHeight/2))
		.addSprite()
		.addTexture(Gdx.files.internal("data/gameover.png"));
		
	}
	
	public void update(float delta) {
		super.update(delta);
		
		
	}
}
