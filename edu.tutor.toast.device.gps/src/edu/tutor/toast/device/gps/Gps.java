package edu.tutor.toast.device.gps;

public class Gps
{

	/**
	 * Default constructor.
	 */
	public Gps()
	{
		;
	}

	/**
	 * Heading in degrees from magnetic north.
	 * @return
	 */
	public int getHeading()
	{
		return (90);
	}

	/**
	 * Latitude:  positive is North, negative is South.
	 * @return
	 */
	public double getLatitude()
	{
		return (37.76999);
	}

	/**
	 * Longitude: positive is East, negative is West.
	 * @return
	 */
	public double getLongitude()
	{
		return (-122.44694);
	}

	/**
	 * Altitude in meters.
	 * @return
	 */
	public double getAltitude()
	{
		return (2286);
	}

	/**
	 * Speed in meters per second.
	 * @return
	 */
	public double getSpeed()
	{
		return (53.6448);
	}

}
