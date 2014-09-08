package edu.tutor.toast.device.gps.fake.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import edu.tutor.toast.device.gps.FakeGps;
import edu.tutor.toast.device.gps.Gps;

public class Activator implements BundleActivator
{
	private ServiceRegistration<Gps> registration;

	@Override
	public void start(BundleContext context) throws Exception
	{
		FakeGps gps = new FakeGps();
		registration = context.registerService(Gps.class, gps, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		registration.unregister();
	}

}
