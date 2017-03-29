package com.mygdx.game.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.gameobjects.Bullet.State;
import com.mygdx.game.settings.GameVars;

public class EditorView {
	private EditorModel model;
	SpriteBatch batch;
	Box2DDebugRenderer debugRenderer;
	
	public EditorView(EditorModel model) {
		this.model = model;
		batch = new SpriteBatch();
		batch.setProjectionMatrix(model.getCam().combined);
		debugRenderer = new Box2DDebugRenderer();
	}
	
	public void render() {
		
		batch.begin();
		for(int i = 0; i < model.sceneIds.size(); i++) {
			model.scenes.get(model.sceneIds.get(i)).render(batch);
		}
		batch.setProjectionMatrix(model.getCam().combined);
		//Gdx.app.log("rendered", "view");
		batch.end();
		debugRenderer.render(model.scenes.get(0).getWorld(), model.getCam2().combined);

	}
}
