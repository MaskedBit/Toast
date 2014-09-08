package edu.tutor.toast.device.gps;

public interface Gps {

	/**
	 * Heading in degrees from magnetic north.
	 * @return
	 */
	public abstract int getHeading();

	/**
	 * Latitude:  positive is North, negative is South.
	 * @return
	 */
	public abstract double getLatitude();

	/**
	 * Longitude: positive is East, negative is West.
	 * @return
	 */
	public abstract double getLongitude();

	/**
	 * Altitude in meters.
	 * @return
	 */
	public abstract double getAltitude();

	/**
	 * Speed in meters per second.
	 * @return
	 */
	public abstract double getSpeed();

}