package edu.tutor.toast;

import java.util.ArrayList;
import java.util.List;

public class Airbag
{
	private List<AirbagListener> listeners;
	
	/**
	 * Default constructor.
	 */
	public Airbag()
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

}
