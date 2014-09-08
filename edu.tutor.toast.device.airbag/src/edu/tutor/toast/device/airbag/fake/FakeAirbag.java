package edu.tutor.toast.device.airbag.fake;

import java.util.ArrayList;
import java.util.List;

import edu.tutor.toast.device.airbag.Airbag;
import edu.tutor.toast.device.airbag.AirbagListener;

public class FakeAirbag implements Airbag
{
	private List<AirbagListener> listeners;
	private Thread deployTask;
	private boolean isRunning;
	
	/**
	 * Default constructor.
	 */
	public FakeAirbag()
	{
		listeners = new ArrayList<AirbagListener>();
	}
	
	public synchronized void addListener(AirbagListener listener)
	{
		listeners.add(listener);
	}

	public synchronized void removeListener(AirbagListener listener)
	{
		listeners.remove(listener);
	}

	public synchronized void deploy()
	{
		for (AirbagListener curListener : listeners)
		{
			curListener.deployed();
		}
	}
	
	public synchronized void startup()
	{
		isRunning = true;
		deployTask = new Thread()
		{

			@Override
			public void run()
			{
				while (isRunning)
				{
					try
					{
						Thread.sleep(5000);
						deploy();
					}
					catch (InterruptedException e)
					{
						// Terminate process
						return;
					}
				}
			}
		};
		
		deployTask.start();
	}
	
	public synchronized void shutdown()
	{
		isRunning = false;
		
		deployTask.interrupt();
		
		try
		{
			deployTask.join();
		}
		catch (InterruptedException e)
		{
			// Shutting down;  ignoring is okay
		}
	}

}
