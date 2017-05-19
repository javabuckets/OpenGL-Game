//package src.engine.test;
//
//import org.lwjgl.opengl.Display;
//import org.lwjgl.util.vector.Vector3f;
//
//import src.engine.entities.Camera;
//import src.engine.entities.Entity;
//import src.engine.entities.Light;
//import src.engine.models.RawModel;
//import src.engine.models.TexturedModel;
//import src.engine.render.DisplayHandler;
//import src.engine.render.Loader;
//import src.engine.render.OBJLoader;
//import src.engine.render.EntityRenderer;
//import src.engine.shaders.StaticShader;
//import src.engine.textures.ModelTexture;
//
//public class OldGameLoop 
//{
//	public static void main(String[] args) 
//	{
//		DisplayHandler.createDisplay();
//
//		Loader loader = new Loader();
//		StaticShader shader = new StaticShader();
//		EntityRenderer renderer = new EntityRenderer(shader);
//
//		/*float[] vertices = { -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f, 0.5f, 0f };
//		RawModel model = loader.loadToVAO(vertices); WITHOUT INDICES*/
//
//		/*float[] vertices = 
//		{
//			-.5f, .5f, 0,   //V0
//			-.5f, -.5f, 0,  //V1
//			.5f, -.5f, 0,	//V2
//			.5f, .5f, 0		//V3
//		};
//
//		int[] indices = 
//		{
//			0, 1, 3,		// Top Left Triangle
//			3, 1, 2			// Bottom Right Triangle
//		};
//
//		float[] textureCoords = 
//		{
//			0, 0,			//V0
//			0, 1,			//V1
//			1, 1,			//V2
//			1, 0			//V3
//		};*/
//
////		float[] vertices = 
////			{            
////					-0.5f,0.5f,0,   
////					-0.5f,-0.5f,0,  
////					0.5f,-0.5f,0,   
////					0.5f,0.5f,0,        
////
////					-0.5f,0.5f,1,   
////					-0.5f,-0.5f,1,  
////					0.5f,-0.5f,1,   
////					0.5f,0.5f,1,
////
////					0.5f,0.5f,0,    
////					0.5f,-0.5f,0,   
////					0.5f,-0.5f,1,   
////					0.5f,0.5f,1,
////
////					-0.5f,0.5f,0,   
////					-0.5f,-0.5f,0,  
////					-0.5f,-0.5f,1,  
////					-0.5f,0.5f,1,
////
////					-0.5f,0.5f,1,
////					-0.5f,0.5f,0,
////					0.5f,0.5f,0,
////					0.5f,0.5f,1,
////
////					-0.5f,-0.5f,1,
////					-0.5f,-0.5f,0,
////					0.5f,-0.5f,0,
////					0.5f,-0.5f,1    
////			};
////
////		float[] textureCoords = 
////			{        
////					0,0,
////					0,1,
////					1,1,
////					1,0,            
////					0,0,
////					0,1,
////					1,1,
////					1,0,            
////					0,0,
////					0,1,
////					1,1,
////					1,0,
////					0,0,
////					0,1,
////					1,1,
////					1,0,
////					0,0,
////					0,1,
////					1,1,
////					1,0,
////					0,0,
////					0,1,
////					1,1,
////					1,0      
////			};
////
////		int[] indices = 
////			{
////					0,1,3,  
////					3,1,2,  
////					4,5,7,
////					7,5,6,
////					8,9,11,
////					11,9,10,
////					12,13,15,
////					15,13,14,   
////					16,17,19,
////					19,17,18,
////					20,21,23,
////					23,21,22
////			};
//
//		RawModel model = loader.loadToVAO(vertices, indices, textureCoords);
//		RawModel model = OBJLoader.loadObjModel("box", loader);
//		ModelTexture texture = new ModelTexture(loader.loadTexture("texture"));
//		TexturedModel texturedModel = new TexturedModel(model, texture);
//		
//		RawModel testModel = OBJLoader.loadObjModel("model", loader);
//		ModelTexture testTexture = new ModelTexture(loader.loadTexture("image"));
//		TexturedModel modelTest = new TexturedModel(testModel, testTexture);
//		Entity test = new Entity(modelTest, new Vector3f(0, -2, -10), 0, 0, 0, 1);
//		Light light = new Light(new Vector3f(3, 0, 0), new Vector3f(1,1,1));
//		
////		Entity entity = new Entity(texturedModel, new Vector3f(0, -4, -10), 0, 0, 0, 1);
////		Entity entity2 = new Entity(texturedModel, new Vector3f(2, -4, -10), 0, 0, 0, 1);
////		Entity entity3 = new Entity(texturedModel, new Vector3f(4, -4, -10), 0, 0, 0, 1);
////		Entity entity4 = new Entity(texturedModel, new Vector3f(-2, -4, -10), 0, 0, 0, 1);
////		Entity entity5 = new Entity(texturedModel, new Vector3f(-4, -4, -10), 0, 0, 0, 1);
////		
////		Entity entity6 = new Entity(texturedModel, new Vector3f(0, -4, -8), 0, 0, 0, 1);
////		Entity entity7 = new Entity(texturedModel, new Vector3f(2, -4, -8), 0, 0, 0, 1);
////		Entity entity8 = new Entity(texturedModel, new Vector3f(4, -4, -8), 0, 0, 0, 1);
////		Entity entity9 = new Entity(texturedModel, new Vector3f(-2, -4, -8), 0, 0, 0, 1);
////		Entity entity10 = new Entity(texturedModel, new Vector3f(-4, -4, -8), 0, 0, 0, 1);
////		
////		Entity entity11 = new Entity(texturedModel, new Vector3f(0, -4, -6), 0, 0, 0, 1);
////		Entity entity12 = new Entity(texturedModel, new Vector3f(2, -4, -6), 0, 0, 0, 1);
////		Entity entity13 = new Entity(texturedModel, new Vector3f(4, -4, -6), 0, 0, 0, 1);
////		Entity entity14 = new Entity(texturedModel, new Vector3f(-2, -4, -6), 0, 0, 0, 1);
////		Entity entity15 = new Entity(texturedModel, new Vector3f(-4, -4, -6), 0, 0, 0, 1);
////		
////		Entity entity16 = new Entity(texturedModel, new Vector3f(0, -4, -4), 0, 0, 0, 1);
////		Entity entity17 = new Entity(texturedModel, new Vector3f(2, -4, -4), 0, 0, 0, 1);
////		Entity entity18 = new Entity(texturedModel, new Vector3f(4, -4, -4), 0, 0, 0, 1);
////		Entity entity19 = new Entity(texturedModel, new Vector3f(-2, -4, -4), 0, 0, 0, 1);
////		Entity entity20 = new Entity(texturedModel, new Vector3f(-4, -4, -4), 0, 0, 0, 1);
////		
////		Entity entity21 = new Entity(texturedModel, new Vector3f(0, -4, -2), 0, 0, 0, 1);
////		Entity entity22 = new Entity(texturedModel, new Vector3f(2, -4, -2), 0, 0, 0, 1);
////		Entity entity23 = new Entity(texturedModel, new Vector3f(4, -4, -2), 0, 0, 0, 1);
////		Entity entity24 = new Entity(texturedModel, new Vector3f(-2, -4, -2), 0, 0, 0, 1);
////		Entity entity25 = new Entity(texturedModel, new Vector3f(-4, -4, -2), 0, 0, 0, 1);
//		
//		Camera camera = new Camera();
//
//		while (!Display.isCloseRequested())
//		{
//			camera.move();
//
//			renderer.prepare();
//
//			shader.start();
//			
//			shader.loadLight(light);
//
//			shader.loadViewMatrix(camera);
//
////			renderer.render(entity, shader);
////			renderer.render(entity2, shader);
////			renderer.render(entity3, shader);
////			renderer.render(entity4, shader);
////			renderer.render(entity5, shader);
////			renderer.render(entity6, shader);
////			renderer.render(entity8, shader);
////			renderer.render(entity9, shader);
////			renderer.render(entity10, shader);
////			renderer.render(entity11, shader);
////			renderer.render(entity12, shader);
////			renderer.render(entity13, shader);
////			renderer.render(entity14, shader);
////			renderer.render(entity15, shader);
////			renderer.render(entity16, shader);
////			renderer.render(entity17, shader);
////			renderer.render(entity18, shader);
////			renderer.render(entity19, shader);
////			renderer.render(entity20, shader);
////			renderer.render(entity21, shader);
////			renderer.render(entity22, shader);
////			renderer.render(entity23, shader);
////			renderer.render(entity24, shader);
////			renderer.render(entity25, shader);
//			
//			renderer.render(test, shader);
//			
//			test.increaseRotation(0, 1, 0);
//
//			shader.stop();
//
//			DisplayHandler.updateDisplay();
//		}
//
//		shader.cleanUp();
//		loader.cleanUp();
//		DisplayHandler.closeDisplay();
//	}
//}