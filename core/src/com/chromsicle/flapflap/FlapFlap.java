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

	//birb gravity stuff
	float birbY = 0; //position
	float velocity = 0; //how fast the birb is moving
	float gravity = 2;

	int gameState = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture(("bg.png"));

		birbs = new Texture[2];
		birbs[0] = new Texture("bird.png");
		birbs[1] = new Texture("bird2.png");

		birbY = Gdx.graphics.getHeight() / 2 - birbs[0].getHeight() / 2;

	}

	@Override
	public void render () {
		if (gameState != 0) {
			//the game is being played
			//this is called each time the screen is tapped
			if (Gdx.input.justTouched()) {
				//give the birb a shove upward
				velocity = -30;
			}
			//stop the birb from falling off the screen forever, helps a lot with testing 
			if (birbY > 0 || velocity < 0) {
				//increase the velocity each time the render loop is called
				velocity += gravity;
				//decrease the y (position) by the velocity
				birbY -= velocity;
			}
		} else {
			//this is called each time the screen is tapped
			if (Gdx.input.justTouched()) {
				//the player touched the screen so start the game
				gameState = 1;
			}
		}
		//this guy is gonna be flappin really fast, look into animation Gdx, texture atlas and texture regions
		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//not specifying the width and height will just use the image's height and width
		batch.draw(birbs[flapState], Gdx.graphics.getWidth() / 2 - birbs[flapState].getWidth() / 2, birbY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
