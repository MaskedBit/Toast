import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import edu.tutor.toast.device.airbag.Airbag;
import edu.tutor.toast.device.gps.Gps;
import edu.tutor.toast.monitor.emergency.EmergencyMonitor;


public class Activator implements BundleActivator
{
	private Airbag airbag;
	private Gps gps;
	private EmergencyMonitor monitor;

	@Override
	public void start(BundleContext context) throws Exception
	{
		System.out.println("Launching");

		gps = new Gps();
		airbag = new Airbag();
		monitor = new EmergencyMonitor();
		
		monitor.setGps(gps);
		monitor.setAirbag(airbag);
		
		monitor.startup();
		
		// Trigger an event
		airbag.deploy();
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		monitor.shutdown();
		
		System.out.println("Terminating");
	}

}
