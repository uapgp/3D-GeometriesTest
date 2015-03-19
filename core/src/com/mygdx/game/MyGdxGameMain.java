package com.mygdx.game;


import geometries.Cubes.Cube;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class MyGdxGameMain implements ApplicationListener {
	public Environment environment;
	public PerspectiveCamera cam;
	public CameraInputController camController;
	public ModelBatch modelBatch;
//	public Model model;
	public ModelInstance instance;
	public ModelInstance instance2;
	public Cube cub;
	
	

	@Override
	public void create() {
		environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
		
	
		//draw objects
	    cub = new Cube();
	   
		instance = new ModelInstance(cub.cubeInstance());
		
		
		
	
	}

	@Override
	public void render() {
		camController.update();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		modelBatch.render(instance,environment);
		modelBatch.end();
	}

	@Override
	public void dispose() {
		modelBatch.dispose();
		//cub.cubDispose();
		
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
