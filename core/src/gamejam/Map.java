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
		Mebl wiktor = new Mebl(scene.getWorld(), 400, 200, MebleId.wiktor);
		mapObjects.add(wiktor);
		Mebl stefan = new Mebl(scene.getWorld(), 400, 500, MebleId.stefan);
		mapObjects.add(stefan);
		Mebl pufa = new Mebl(scene.getWorld(), 300, 350, MebleId.pufa);
		mapObjects.add(pufa);
		Mebl wojtas = new Mebl(scene.getWorld(), 100, 350, MebleId.wojtas);
		mapObjects.add(wojtas);
		Mebl banany = new Mebl(scene.getWorld(), 700, 700, MebleId.banany);
		mapObjects.add(banany);
		Mebl pizza = new Mebl(scene.getWorld(), 700, 200, MebleId.pizza);
		mapObjects.add(pizza);
		Mebl krzeslo = new Mebl(scene.getWorld(), 860, 200, MebleId.krzeslo);
		mapObjects.add(krzeslo);
		
	}
}
