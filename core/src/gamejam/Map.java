package gamejam;

import java.util.ArrayList;

import com.mygdx.game.objects.GameObject;
import com.mygdx.game.scenes.GameScene;

public class Map {

	public ArrayList<GameObject> mapObjects;
	
	public Map(GameScene scene) {
		mapObjects = new ArrayList<GameObject>();
		set1(scene);
		for(int i = 0; i < mapObjects.size(); i++)
		scene.addGameObject(mapObjects.get(i));
	}
	
	void set1(GameScene scene) {
		//Mebl asd = new Mebl(scene.getWorld(), 200, 200, 1);
		//mapObjects.add(asd);
	}
}
