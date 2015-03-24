package com.mygdx.game;

import geometries.Cubes.Cube;

public class Bullet {

	public float r,g,b;
	public Player player;
	public int index;
	
	//position, speed etc..
	
	public Bullet(float r, float g, float b, Player player, int index)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.player = player;
		this.index = index;
	}
	

	public void update()
	{
		//hacer cosas de fisicas y colisiones etc..		
	}
	
	
	//llamar a esta funcion cuando el Bullet colisione con un cubo
	public void onCollide(Cube cube)
	{
		cube.onCubeHit(this);
	}
}
