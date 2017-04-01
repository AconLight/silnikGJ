package com.mygdx.game.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpriteObject extends GameObject {
	
	//ArrayList<Texture> texList;
	public boolean isPhysic;
	public ArrayList<TextureRegion> regionList;
	public int frameNum;
	public float frameTime;
	float frameDt;
	public boolean isPingPong;
	boolean isLeft;
	int spriteViewPriority;
	public boolean isSticked = true;
	public float alfa;
	public boolean isVisible;
	
	public GameObject parent;
	
	public SpriteObject(GameObject parent, float x, float y){
		super(parent.position.x + x, parent.position.y + y);
		isVisible = true;
		alfa = 0;
		spriteViewPriority = 1;
		regionList = new ArrayList<TextureRegion>();
		frameNum=0;
		frameTime=1f;
		isPingPong=false;
		this.parent = parent;
	}
	public SpriteObject(){
		super(0, 0);
		isVisible = true;
		alfa = 0;
		spriteViewPriority = 1;
		regionList = new ArrayList<TextureRegion>();
		frameNum=0;
		frameTime=1f;
		isPingPong=false;
	}
	
	
	public SpriteObject addTexture(FileHandle file){
		Texture tex = new Texture(file);
		regionList.add(new TextureRegion(tex));
		return this;
	}
	
	public void update(float delta, float vx, float vy) { 
		super.update(delta, vx, vy);
		frameDt+=delta;
		if(frameDt>frameTime){
			if(isPingPong==true)
			{
				if(isLeft == false )
				{
					frameNum++;
					if(frameNum == regionList.size()-1)
						isLeft = true;
				}
				else
				{
					frameNum--;
					if(frameNum==0)
						isLeft = false;
				}
					
				
			}
			else
			{
				if(frameNum<regionList.size()-1)
					frameNum++;
				else
					frameNum = 0;
			}
			
			frameDt -=frameTime;
			
		}
		
	}
	
	public SpriteObject setIsPingpong(boolean e) {
		isPingPong = e;
		return this;
	}
	
	public SpriteObject setFrameTime(float time) {
		frameTime = time;
		return this;
	}
	
	public void render(SpriteBatch batch) {
		//batch.draw(regionList.get(frameNum), position.x - regionList.get(frameNum).getRegionWidth()/2,
				//position.y - regionList.get(frameNum).getRegionHeight()/2);
		if (isVisible && regionList.size() != 0) {
			batch.draw(regionList.get(frameNum), position.x - regionList.get(frameNum).getRegionWidth()/2,
		
				position.y - regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth()/2, regionList.get(frameNum).getRegionHeight()/2,
				regionList.get(frameNum).getRegionWidth(), regionList.get(frameNum).getRegionHeight(),
				1, 1, alfa);
			//Gdx.app.log("rendered", "spriteobject");
		}
		
	}
	
	public void dispose() {

		super.dispose();
		for(int i=0; i<regionList.size();i++)
			regionList.get(i).getTexture().dispose();

	}

}
