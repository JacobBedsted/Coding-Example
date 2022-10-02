//Creates Television objects
public class Television
{
	//Variable declaration
	private final String MANUFACTURER;
	private final int SCREEN_SIZE;
	private boolean powerOn;
	private int channel;
	private int volume;
	
	//Constructor
	public Television(String brand, int size)
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	//channel setter
	public void setChannel(int station)
	{
		channel = station;
	}
	
	//power control
	public void power()
	{
		if (powerOn == false)
		{
			powerOn = true;
		}
		else
		{
			powerOn = false;
		}
	}
	
	//increase volume setter
	public void increaseVolume()
	{
		volume = volume + 1;
	}
	
	//decrease volume setter
	public void decreaseVolume()
	{
		if (volume > 0)
		{
			volume = volume - 1;
		}
	}
	
	//Channel getter
	public int getChannel()
	{
		return (channel);
	}
	
	//Volume getter
	public int getVolume()
	{
		return (volume);
	}
	
	//manufacturer getter
	public String getManufacturer()
	{
		return(MANUFACTURER);
	}
	
	//screen size getter
	public int getScreenSize()
	{
		return(SCREEN_SIZE);
	}
}