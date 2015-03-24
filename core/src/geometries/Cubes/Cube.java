package geometries.Cubes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import com.mygdx.game.*;

public class Cube{

	private Model model;
	private float red, green, blue;
	
	
	public Cube(float x, float y, float z, float r, float g, float b) {
		// TODO Auto-generated constructor stub
		
		red = r;
		green = g;
		blue = b;
		
		ModelBuilder modelBuilder = new ModelBuilder();
		//crear un cubo en la posicion (X,Y,Z) con el color (R,G,B,255) -> alpha a 255 para que no sea transparente
		model = modelBuilder.createBox(x, y, z, new Material(ColorAttribute.createDiffuse(r,g,b, 255)),
				Usage.Position | Usage.Normal);		
	}
	
	public Model cubeInstance(){
		
		return this.model;
	}

	public void cubeDispose(){
		
		model.dispose();
	}
	
	//se llama desde el bullet cuando toca un cubo 
	public void onCubeHit(Bullet bullet)
	{
		float r = bullet.r;
		float g = bullet.g;
		float b = bullet.b;
		
		if(r == red && b == green && g == blue)
		{
			//es el color correcto
			//avisar al jugador que ha disparado que realmente le ha dado
			bullet.player.cubeHit(bullet);
			//eliminar el cubo
			this.cubeDispose();			
		}
	}
	
}
