package src.engine.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import src.engine.entities.Camera;
import src.engine.entities.Entity;
import src.engine.entities.Light;
import src.engine.models.RawModel;
import src.engine.models.TexturedModel;
import src.engine.render.DisplayHandler;
import src.engine.render.Loader;
import src.engine.render.MasterRenderer;
import src.engine.render.OBJLoader;
import src.engine.terrain.Terrain;
import src.engine.textures.ModelTexture;

public class MainGameLoop 
{
	public static void main(String[] args) 
	{
		DisplayHandler.createDisplay();

		Loader loader = new Loader();
		
		RawModel testModel = OBJLoader.loadObjModel("dragon", loader);
		ModelTexture testTexture = new ModelTexture(loader.loadTexture("white"));
		TexturedModel modelTest = new TexturedModel(testModel, testTexture);
		
		Entity test = new Entity(modelTest, new Vector3f(0, 0, -10), 0, 0, 0, 1);
		Light light = new Light(new Vector3f(200, 200, -50), new Vector3f(1, 3, 1));
		
		ModelTexture terrainTexture = new ModelTexture(loader.loadTexture("grass"));
		Terrain terrain = new Terrain(0, 0, loader, terrainTexture);
		Terrain terrain2 = new Terrain(0, -1, loader, terrainTexture);
		Terrain terrain3 = new Terrain(-1, -1, loader, terrainTexture);
		Terrain terrain4 = new Terrain(-1, 0, loader, terrainTexture);
		terrainTexture.setShineDamper(10);
		terrainTexture.setReflectivity(0);
		
		RawModel treeRawModel = OBJLoader.loadObjModel("tree", loader);
		ModelTexture treeTexture = new ModelTexture(loader.loadTexture("tree"));
		TexturedModel treeModel = new TexturedModel(treeRawModel, treeTexture);
		treeTexture.setShineDamper(4);
		treeTexture.setReflectivity(0);
		
		List<Entity> trees = new ArrayList<Entity>();
				
		Camera camera = new Camera(new Vector3f(0, 8, 18), new Vector3f(10, 0, 0));
		
		MasterRenderer renderer = new MasterRenderer();
		
		for (int i = 0; i < 500; i++)
		{
			Random rand = new Random();
			float randPosX = (float) rand.nextInt(200);
			float randPosZ = (float) rand.nextInt(200);
			Entity tree = new Entity(treeModel, new Vector3f(randPosX - 100, 0, randPosZ - 100), 0, 0, 0, 1);
			trees.add(tree);
		}

		while (!Display.isCloseRequested())
		{
			camera.move();
			
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			renderer.processTerrain(terrain3);
			renderer.processTerrain(terrain4);
			
			//renderer.processEntity(test);
			
			for (Entity tree : trees)
			{
				renderer.processEntity(tree);
			}
			
			test.increaseRotation(0, 1, 0);
			
			renderer.render(light, camera);
			
			DisplayHandler.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayHandler.closeDisplay();
	}
}