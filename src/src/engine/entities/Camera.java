package src.engine.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera 
{
	private Vector3f position = new Vector3f(0, 0, 0);
	private float pitch, yaw, roll;
	
	public Camera() 
	{
		
	}
	
	public Camera(Vector3f position, Vector3f orientation)
	{
		this.position.x = position.x;
		this.position.y = position.y;
		this.position.z = position.z;
		
		this.pitch = orientation.x;
		this.yaw = orientation.y;
		this.roll = orientation.z;
	}
	
	private float speed = 1f;
	
	public void move()
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
		{
			speed = .3f;
		}
		else
		{
			speed = 1f;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			position.z -= .6f * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			position.z += .6f * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			position.x += .6f * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			position.x -= .6f * speed;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_T))
		{
			pitch += .4f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Y))
		{
			pitch -= .4f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			yaw += .4f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_H))
		{
			yaw -= .4f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			position.y += .4f * speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			position.y -= .4f * speed;
		}
	}

	public Vector3f getPosition() 
	{
		return position;
	}

	public float getPitch() 
	{
		return pitch;
	}

	public float getYaw() 
	{
		return yaw;
	}

	public float getRoll() 
	{
		return roll;
	}
}