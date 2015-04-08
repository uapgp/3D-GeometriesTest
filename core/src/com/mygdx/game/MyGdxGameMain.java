package com.mygdx.game;


import geometries.Cubes.Cube;
import geometries.Cubes.Cube2;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGameMain implements ApplicationListener {
	public Environment environment;
	public PerspectiveCamera cam;
	public CameraInputController camController;
	public ModelBatch modelBatch;
//	public Model model;
	public ModelInstance instance;
	public ModelInstance instance2;
	public Cube cub;
	public Cube2 cub2;
	public Vector3 position1;
	
	

	@Override
	public void create() {
		environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		modelBatch = new ModelBatch();
		
		//draw objects
	    cub = new Cube();
	    cub2 = new Cube2();
		instance = new ModelInstance(cub.cubeInstance());
		position1 = new Vector3();
		position1.set(5f, 3f, 2.5f);
		instance.transform.setToTranslation(position1);
		instance2 = new ModelInstance(cub2.cubeInstance());
		
		//Cam
		cam = new PerspectiveCamera(80, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(position1);
		cam.near =1f;
		cam.far = 300f;
		cam.rotate(-38, 0, 1, 0);
		cam.update();
		//camController = new CameraInputController(cam);
		//Gdx.input.setInputProcessor(camController);
		
	
		
		
		
	
	}
	//MASTER HILO PRINCIPAL
	@Override
	public void render() {
		//camController.update();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);
		
		
		modelBatch.render(instance,environment);
		//instance.transform.rotate(1, 0, 0, 0.1f);
		modelBatch.render(instance2,environment);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				
				position1.set(position1.x-0.1f,position1.y,position1.z);
				instance.transform.getTranslation(position1);
			}
			
			 instance.transform.setTranslation(position1.x-0.1f,position1.y,position1.z);
			 System.out.println("position"+position1.x);
			 
			 cam.lookAt(position1);
			 cam.position.set(position1.x,10,10);
			 
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				
				position1.set(position1.x+0.1f,position1.y,position1.z);
				instance.transform.getTranslation(position1);
				
			}
			
			
			 instance.transform.setTranslation(position1.x+0.1f,position1.y,position1.z);
			 System.out.println("position"+position1.x);
			
			 cam.lookAt(position1);
			 cam.position.set(position1.x,10,10);
			
			
		}
	
		 
		cam.update();
		
		modelBatch.begin(cam);
		modelBatch.end();
	}

	@Override
	public void dispose() {
		modelBatch.dispose();
		cub.cubDispose();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
}
