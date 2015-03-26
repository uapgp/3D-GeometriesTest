package geometries.Cubes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Cube2 {

	private Model model;
	
	public Cube2() {
		// TODO Auto-generated constructor stub
		
		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f,new Material(ColorAttribute.createDiffuse(Color.GREEN)),
				Usage.Position | Usage.Normal);
		
		
	}
	
	public Model cubeInstance(){
		
		return this.model;
	}

	public void cubDispose(){
		
		model.dispose();
	}
	
}
