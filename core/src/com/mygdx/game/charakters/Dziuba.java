package com.mygdx.game.charakters;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.components.SinusCurve;
import com.mygdx.game.objects.SpriteObject;

public class Dziuba extends Character{

	public Dziuba() {
		super();
		setup();
	}
	
	void setup() {
		addSkill(); // skill 1
			getLastSkill().addSkillObject(); // 1 obiekt skillas
				getLastSkill().getLastObj().addComponent(new SinusCurve()); // 1 component 1 obiektu 1 skilla
				
			getLastSkill().addSkillObject();
			
			getLastSkill().addSkillObject();
			getLastSkill().getLastObj().addSprite().addTexture(Gdx.files.internal("data/t1.jpg"));
	}
	
	
}
