package src.engine.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

import src.engine.entities.Camera;
import src.engine.entities.Entity;
import src.engine.entities.Light;
import src.engine.models.TexturedModel;
import src.engine.shaders.StaticShader;
import src.engine.shaders.TerrainShader;
import src.engine.terrain.Terrain;

public class MasterRenderer 
{
	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000f;
	
	private Matrix4f projectionMatrix;
	
	private StaticShader shader = new StaticShader();
	private EntityRenderer renderer;
	
	private TerrainShader terrainShader = new TerrainShader();
	private TerrainRenderer terrainRenderer;
	
	private Map<TexturedModel, List<Entity>> entities = new HashMap<TexturedModel, List<Entity>>();
	private List<Terrain> terrains = new ArrayList<Terrain>();
	
	public MasterRenderer() 
	{
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		createProjectionMatrix();
		renderer = new EntityRenderer(shader, projectionMatrix);
		terrainRenderer = new TerrainRenderer(terrainShader, projectionMatrix);
	}
	
	public void render(Light light, Camera camera)
	{
		prepare();
		
		// Entity Shader
		
		shader.start();
		shader.loadLight(light);
		shader.loadViewMatrix(camera);
		
		renderer.render(entities);
		
		shader.stop();
		
		// Terrain Shader
		
		terrainShader.start();
		terrainShader.loadLight(light);
		terrainShader.loadViewMatrix(camera);
		
		terrainRenderer.render(terrains);
		
		terrainShader.stop();
		
		terrains.clear();
		entities.clear();
	}
	
	public void processTerrain(Terrain terrain)
	{
		terrains.add(terrain);
	}
	
	public void processEntity(Entity entity)
	{
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		
		if (batch != null)
		{
			batch.add(entity);
		}
		else
		{
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}
	
	public void prepare()
	{
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		setDisplayBackgroundColor(96, 186, 255);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public void setDisplayBackgroundColor(int r, int g, int b)
	{
		GL11.glClearColor((float)r/255, (float)g/255, (float)b/255, 1);
	}
	
	private void createProjectionMatrix()
	{
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float yScale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float xScale = yScale / aspectRatio;
		float frustumLength = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = xScale;
		projectionMatrix.m11 = yScale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustumLength);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * NEAR_PLANE + FAR_PLANE) / frustumLength);
		projectionMatrix.m33 = 0;
	}
	
	public void cleanUp()
	{
		shader.cleanUp();
		terrainShader.cleanUp();
	}
}