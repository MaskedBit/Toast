package edu.tutor.toast.device.airbag;

/**
 * Interface for classes wishing to be notified of
 * airbag events.
 * @author Steve
 *
 */
public interface AirbagListener
{

	/**
	 * The airbag was deployed.
	 */
	public void deployed();

}
