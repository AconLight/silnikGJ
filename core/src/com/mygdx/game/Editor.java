package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.editor.EditorController;
import com.mygdx.game.editor.EditorModel;
import com.mygdx.game.editor.EditorView;
import com.mygdx.game.mvc.Controller;
import com.mygdx.game.mvc.Model;
import com.mygdx.game.mvc.View;

public class Editor extends ApplicationAdapter {

	EditorModel model;
	EditorView view;
	EditorController controller;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		model = new EditorModel();
		view = new EditorView(model);
		controller = new EditorController(model);
		Gdx.input.setInputProcessor(controller);
		//Gdx.input.setCursorCatched(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		model.update(Gdx.graphics.getDeltaTime());
		view.render();
	}
	
	@Override
	public void dispose () {

		model.dispose();

	}
}
