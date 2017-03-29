package com.mygdx.game.scenes;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.Scene;
import com.mygdx.game.settings.GameVars;

public class SplashScene extends Scene{


	public SplashScene() {
		addGameObject(new GameObject(+GameVars.gameWidth/2, +GameVars.gameHeight/2))
		.addSprite()
		.addTexture(Gdx.files.internal("data/splash.png"));
	}
	
	public void update(float delta) {
		super.update(delta);
		
		
	}
}
