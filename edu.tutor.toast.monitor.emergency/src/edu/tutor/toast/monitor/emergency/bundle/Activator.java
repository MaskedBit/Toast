package edu.tutor.toast.monitor.emergency.bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import edu.tutor.toast.device.airbag.Airbag;
import edu.tutor.toast.device.gps.Gps;
import edu.tutor.toast.monitor.emergency.EmergencyMonitor;


public class Activator implements BundleActivator
{
	// Connection to the airbag
	private ServiceReference<Airbag> airbagService;
	private Airbag airbag;
	
	// Connection to the GPS
	private ServiceReference<Gps> gpsService;
	private Gps gps;
	
	// The monitor itself
	private EmergencyMonitor monitor;

	@Override
	public void start(BundleContext context) throws Exception
	{
		System.out.println("Launching");

		monitor = new EmergencyMonitor();
		
		// Acquire the GPS service
		gpsService = context.getServiceReference(Gps.class);
		if (gpsService == null)
		{
			System.err.println("Unable to locate GPS service");
			
			return;
		}
		
		// Acquire the airbag service
		airbagService = context.getServiceReference(Airbag.class);
		if (airbagService == null)
		{
			System.err.println("Unable to locate airbag service");
			
			return;
		}
		
		// Connect to the GPS
		gps = (Gps) context.getService(gpsService);
		if (gps == null)
		{
			System.err.println("Unable to connect to GPS");
			
			return;
		}
		
		// Connect to the airbag
		airbag = (Airbag) context.getService(airbagService);
		if (airbag == null)
		{
			System.err.println("Unable to connect to airbag");
			
			return;
		}
		
		monitor.setGps(gps);
		monitor.setAirbag(airbag);
		
		monitor.startup();
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		monitor.shutdown();
		
		if (gpsService != null)
		{
			context.ungetService(gpsService);
		}

		if (airbagService != null)
		{
			context.ungetService(airbagService);
		}
		
		System.out.println("Terminating");
	}

}
