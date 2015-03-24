package com.mygdx.game;

import java.util.List;

public class Player {
	
	private List<Bullet> bullets;
	private int maxBullets;
	
	private float red, green, blue;
	
	private int score;
	
	//position, speed etc...
	
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
			//delegamos el update a los bullets, para que actualicen su position etc segun su velocidad y chequeen las colisiones
			bullets.get(i).update();
		}
	}
	
	public void shoot()
	{
		//al disparar comprobamos que no hayamos alcanzado el max de disparos
		if(bullets.size() < maxBullets)
		{
			//metemos los datos dentro del bullet para cuando haya la colision (el index nos ayuda a eliminar el bullet de vuelta)
			int index = bullets.size();
			Bullet b = new Bullet(red, green, blue, this, index);
			//añadimos el bullet a la lista para ir actualizandolo
			bullets.add(b);
		}
		
		//cambiar color al acabar (al bar) de disparar
		//red = ...;
		//green = ...;
		//blue = ...;
	}
	
	public void cubeHit(Bullet bullet)
	{
		//cuando nos avisen de que ha habido una colision y es certera (mismo color)
		//subimos el score
		score++;
		//eliminamos el bullet
		bullets.remove(bullet.index);
	}
	
}
