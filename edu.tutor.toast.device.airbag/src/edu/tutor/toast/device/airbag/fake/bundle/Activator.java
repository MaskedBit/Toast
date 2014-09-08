package edu.tutor.toast.device.airbag.fake.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import edu.tutor.toast.device.airbag.Airbag;
import edu.tutor.toast.device.airbag.fake.FakeAirbag;

public class Activator implements BundleActivator
{
	private ServiceRegistration<Airbag> registration;
	private FakeAirbag airbag;

	@Override
	public void start(BundleContext context) throws Exception
	{
		airbag = new FakeAirbag();
		airbag.startup();
		registration = context.registerService(Airbag.class, airbag, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		registration.unregister();
		airbag.shutdown();
	}

}
