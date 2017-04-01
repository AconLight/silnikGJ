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
		

		Sprajty plansza = new Sprajty();
		plansza.set(1, 0, 0);
		mapObjects.add(plansza);
		Mebl sciana1 = new Mebl(scene.getWorld(), 0, 1485, MebleId.sciana);
		mapObjects.add(sciana1);
		Mebl sciana2 = new Mebl(scene.getWorld(), 0, -1485, MebleId.sciana);
		mapObjects.add(sciana2);
		Mebl sciana3 = new Mebl(scene.getWorld(), 1985, 0, MebleId.sciana2);
		mapObjects.add(sciana3);
		Mebl sciana4 = new Mebl(scene.getWorld(), -1985, 0, MebleId.sciana2);
		mapObjects.add(sciana4);
		Mebl pufa = new Mebl(scene.getWorld(), 300, 350, MebleId.pufa);
		mapObjects.add(pufa);
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
		Mebl fotel = new Mebl(scene.getWorld(), 600, -600, MebleId.fotel);
		mapObjects.add(fotel);
		Mebl filar1 = new Mebl(scene.getWorld(), -300, -300, MebleId.filar);
		mapObjects.add(filar1);
		Mebl filar2 = new Mebl(scene.getWorld(), -300, 300, MebleId.filar);
		mapObjects.add(filar2);
		Mebl filar3 = new Mebl(scene.getWorld(), 300, -300, MebleId.filar);
		mapObjects.add(filar3);
		Mebl filar4 = new Mebl(scene.getWorld(), 300, 300, MebleId.filar);
		mapObjects.add(filar4);
		Mebl wiktor2 = new Mebl(scene.getWorld(), 0, -300, MebleId.wiktor);
		mapObjects.add(wiktor2);
		Mebl wojtas2 = new Mebl(scene.getWorld(), -300, 0, MebleId.wojtas);
		mapObjects.add(wojtas2);
		Mebl stefan2 = new Mebl(scene.getWorld(), 0, 300, MebleId.stefan);
		mapObjects.add(stefan2);
		Mebl sub = new Mebl(scene.getWorld(), -900,900 , MebleId.subway);
		mapObjects.add(sub);
		Mebl sub2 = new Mebl(scene.getWorld(), -860,900 , MebleId.subway);
		mapObjects.add(sub2);
		Mebl sub3 = new Mebl(scene.getWorld(), -820,900 , MebleId.subway);
		mapObjects.add(sub3);
		Mebl sub4 = new Mebl(scene.getWorld(), -780,900 , MebleId.subway);
		mapObjects.add(sub4);
		Mebl sub5 = new Mebl(scene.getWorld(), -740,900 , MebleId.subway);
		mapObjects.add(sub5);
		Mebl sub6 = new Mebl(scene.getWorld(), -700,900 , MebleId.subway);
		mapObjects.add(sub6);
		Mebl sub7 = new Mebl(scene.getWorld(), -900,844 , MebleId.subway);
		mapObjects.add(sub7);
		Mebl sub8 = new Mebl(scene.getWorld(), -860,844 , MebleId.subway);
		mapObjects.add(sub8);
		Mebl sub9 = new Mebl(scene.getWorld(), -820,844 , MebleId.subway);
		mapObjects.add(sub9);
		Mebl sub10 = new Mebl(scene.getWorld(), -780,844 , MebleId.subway);
		mapObjects.add(sub10);
		Mebl sub11 = new Mebl(scene.getWorld(), -740,844 , MebleId.subway);
		mapObjects.add(sub11);
		Mebl sub12 = new Mebl(scene.getWorld(), -700,844 , MebleId.subway);
		mapObjects.add(sub12);
		Mebl sub13 = new Mebl(scene.getWorld(), -900,788 , MebleId.subway);
		mapObjects.add(sub13);
		Mebl sub14 = new Mebl(scene.getWorld(), -860,788 , MebleId.subway);
		mapObjects.add(sub14);
		Mebl sub15 = new Mebl(scene.getWorld(), -820,788 , MebleId.subway);
		mapObjects.add(sub15);
		Mebl sub16 = new Mebl(scene.getWorld(), -780,788 , MebleId.subway);
		mapObjects.add(sub16);
		Mebl sub17 = new Mebl(scene.getWorld(), -740,788 , MebleId.subway);
		mapObjects.add(sub17);
		Mebl sub18 = new Mebl(scene.getWorld(), -700,788 , MebleId.subway);
		mapObjects.add(sub18);
		Mebl sub19 = new Mebl(scene.getWorld(), -900,732 , MebleId.subway);
		mapObjects.add(sub19);
		Mebl sub20 = new Mebl(scene.getWorld(), -860,732 , MebleId.subway);
		mapObjects.add(sub20);
		Mebl sub21 = new Mebl(scene.getWorld(), -820,732 , MebleId.subway);
		mapObjects.add(sub21);
		Mebl sub22 = new Mebl(scene.getWorld(), -780,732 , MebleId.subway);
		mapObjects.add(sub22);
		Mebl sub23 = new Mebl(scene.getWorld(), -740,732 , MebleId.subway);
		mapObjects.add(sub23);
		Mebl sub24 = new Mebl(scene.getWorld(), -700,732 , MebleId.subway);
		mapObjects.add(sub24);
		Mebl stol = new Mebl(scene.getWorld(), -400,800 , MebleId.stol);
		mapObjects.add(stol);
		
		
		
		
		//Mebl asd = new Mebl(scene.getWorld(), 200, 200, 1);
		//mapObjects.add(asd);

	}
}
