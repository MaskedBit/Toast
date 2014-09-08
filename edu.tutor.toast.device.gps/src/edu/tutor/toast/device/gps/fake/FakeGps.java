package edu.tutor.toast.device.gps.fake;

import edu.tutor.toast.device.gps.Gps;

public class FakeGps implements Gps
{

	/**
	 * Default constructor.
	 */
	public FakeGps()
	{
		;
	}

	/* (non-Javadoc)
	 * @see edu.tutor.toast.device.gps.Gps#getHeading()
	 */
	@Override
	public int getHeading()
	{
		return (90);
	}

	/* (non-Javadoc)
	 * @see edu.tutor.toast.device.gps.Gps#getLatitude()
	 */
	@Override
	public double getLatitude()
	{
		return (37.76999);
	}

	/* (non-Javadoc)
	 * @see edu.tutor.toast.device.gps.Gps#getLongitude()
	 */
	@Override
	public double getLongitude()
	{
		return (-122.44694);
	}

	/* (non-Javadoc)
	 * @see edu.tutor.toast.device.gps.Gps#getAltitude()
	 */
	@Override
	public double getAltitude()
	{
		return (2286);
	}

	/* (non-Javadoc)
	 * @see edu.tutor.toast.device.gps.Gps#getSpeed()
	 */
	@Override
	public double getSpeed()
	{
		return (53.6448);
	}

}
