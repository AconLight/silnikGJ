package com.mygdx.game.editor;

import com.mygdx.game.editor.EditorScene.State;
import com.mygdx.game.objects.PhysicObject;
import com.mygdx.game.objects.PhysicSpriteObject;
import com.mygdx.game.objects.Scene;

public class SpriteCreatingScene extends Scene{

	public PhysicObject physicspriteobjectparent;
	public PhysicSpriteObject physicspriteobject;
	
	public SpriteCreatingScene() {
		physicspriteobjectparent = new PhysicObject(world, 300, 300);
		physicspriteobject = new PhysicSpriteObject(world, physicspriteobjectparent, 300, 300);
		//physicspriteobjectparent.addSprite(physicspriteobject); // przy wyborze kszta³tu
		addGameObject(physicspriteobjectparent);
	}
}
