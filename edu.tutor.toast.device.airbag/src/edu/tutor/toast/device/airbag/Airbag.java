package edu.tutor.toast.device.airbag;

public interface Airbag
{
	public void addListener(AirbagListener listener);

	public  void removeListener(AirbagListener listener);
}
