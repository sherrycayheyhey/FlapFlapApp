package com.chromsicle.flapflap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlapFlap extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;

	Texture[] birbs;
	int flapState = 0; //used to toggle the bird animation
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture(("bg.png"));
		birbs = new Texture[2];
		birbs[0] = new Texture("bird.png");
		birbs[1] = new Texture("bird2.png");

	}

	@Override
	public void render () {

		//this guy is gonna be flappin really fast, look into animation Gdx, texture atlas and texture regions
	    if (flapState == 0) {
	        flapState = 1;
        } else {
	        flapState = 0;
        }

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //not specifying the width and height will just use the image's height and width
		batch.draw(birbs[flapState], Gdx.graphics.getWidth() / 2 - birbs[flapState].getWidth() / 2, Gdx.graphics.getHeight() / 2 - birbs[flapState].getHeight() / 2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
