package edu.tutor.toast;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Launching");
	    Gps gps = new Gps();
	    Airbag airbag = new Airbag();
	    EmergencyMonitor monitor = new EmergencyMonitor();

	    monitor.setGps(gps);
	    monitor.setAirbag(airbag);
	    monitor.startup();
	    airbag.deploy();
	    monitor.shutdown();

	    System.out.println("Terminating");
	}

}
