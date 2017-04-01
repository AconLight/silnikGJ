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
		Mebl pufa2 = new Mebl(scene.getWorld(), 800, 800, MebleId.pufajedzenie);
		mapObjects.add(pufa2);
		Mebl stolek = new Mebl(scene.getWorld(), 800, 600, MebleId.stolek);
		mapObjects.add(stolek);
		Mebl szafka = new Mebl(scene.getWorld(), 1000, 1000, MebleId.szafka);
		mapObjects.add(szafka);
		Mebl pufa3 = new Mebl(scene.getWorld(), 1000, 500, MebleId.pufa_mala);
		mapObjects.add(pufa3);
		Mebl kaloryfer = new Mebl(scene.getWorld(), 1700, 900, MebleId.kaloryfer);
		mapObjects.add(kaloryfer);
		Mebl tron = new Mebl(scene.getWorld(), 1450, 1000, MebleId.tron);
		mapObjects.add(tron);
		Mebl fotel = new Mebl(scene.getWorld(), 1450, 300, MebleId.fotel);
		mapObjects.add(fotel);
		for(int i=200;i<400;i=+400){
		Mebl sciana = new Mebl(scene.getWorld(), i, 50, MebleId.sciana);
		mapObjects.add(sciana);
		}
		
		
		//Mebl asd = new Mebl(scene.getWorld(), 200, 200, 1);
		//mapObjects.add(asd);

	}
}
