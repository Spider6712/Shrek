package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.LevelOne;

public class MyGdxGame extends Game
{
	Screen currentScreen;
	SpriteBatch batch;
	
	@Override
	public void create ()
	{
		batch = new SpriteBatch();

		currentScreen = new LevelOne(this);
		setScreen(currentScreen);
	}

	@Override
	public void render ()
	{
		super.render();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}

	public SpriteBatch getBatch()
	{
		return batch;
	}
}
