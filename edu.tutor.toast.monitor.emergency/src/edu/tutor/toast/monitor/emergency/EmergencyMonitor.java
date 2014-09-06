package edu.tutor.toast.monitor.emergency;

import edu.tutor.toast.device.airbag.Airbag;
import edu.tutor.toast.device.airbag.AirbagListener;
import edu.tutor.toast.device.gps.Gps;

public class EmergencyMonitor implements AirbagListener
{
	private Airbag airbag;
	private Gps gps;

	public void deployed()
	{
		System.out.println("Emergency occurred at lat=" + gps.getLatitude()
				+ " lon=" + gps.getLongitude()
				+ " heading=" + gps.getHeading()
				+ " altitude=" + gps.getAltitude()
				+ " speed=" + gps.getSpeed());
	}

	public void setAirbag(Airbag value)
	{
		airbag = value;
	}

	public void setGps(Gps value)
	{
		gps = value;
	}

	public void shutdown()
	{
		airbag.removeListener(this);
	}

	public void startup()
	{
		airbag.addListener(this);
	}
}