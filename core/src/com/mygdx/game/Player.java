package com.mygdx.game;

import java.util.List;

public class Player {
	
	private List<Bullet> bullets;
	private int maxBullets;
	
	private float red, green, blue;
	
	private int score;
	
	public Player(int maxBullets)
	{
		this.maxBullets = maxBullets;
		score = 0;
		//empezamos con Rojo.. porque si xd
		red = 255;
		green = 0;
		blue = 0;
	}
	
	public void update()
	{
		for(int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).update();
		}
	}
	
	public void shoot()
	{
		if(bullets.size() < maxBullets)
		{
			int index = bullets.size();
			Bullet b = new Bullet(red, green, blue, this, index);
			bullets.add(b);
		}
	}
	
	public void cubeHit(Bullet bullet)
	{
		score++;
		bullets.remove(bullet.index);
	}
	
}
