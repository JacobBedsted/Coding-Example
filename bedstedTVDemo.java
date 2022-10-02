//This program was created by: Jacob Bedsted
//Date: 05/10/2022
//This program will create a televsion object then allow a user to interact with it through a menu

//Import Scanner
import java.util.Scanner;

public class bedstedTVDemo
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); //Scanner object for input
		
		//Intro output
		System.out.println("This program simulates interacting with a television, it can:");
		System.out.println("Cycle power, change channels, change volume, and give basic information about itself.");
		System.out.println("Would you like to watch TV? Y/N");
		//Getting input
		char tvChoice = keyboard.next().charAt(0);
		keyboard.nextLine();
		//Data validation
		while (tvChoice != 'Y' && tvChoice != 'N' && tvChoice != 'y' && tvChoice != 'n')
		{
			System.out.println("Only Y or N are allowed as answers");
			System.out.println("Would you like to watch TV? Y/N");
			tvChoice = keyboard.next().charAt(0);
			keyboard.nextLine();
		}
		
		//Creating the Television
		System.out.println("First what brand is the TV?");
		String brand = keyboard.nextLine();
		System.out.println("Second what is the TV's size in inches?");
		int size = keyboard.nextInt();
		//size Data validation
		while (size <= 0)
		{
			System.out.println("TV must be at least 1 inch big");
			System.out.println("Second what is the TV's size in inches?");
			size = keyboard.nextInt();
		}
		Television userTV = new Television(brand, size); //Initializing a Television object.
		
		//Program loop starts
		char tvPowerChoice = 'Y';
		int menuChoice = 0;
		while (tvChoice == 'y' || tvChoice == 'Y')
		{
			tvPowerChoice = tvPowerOn();
		
			//Menu loop starts
			while (tvPowerChoice == 'y' || tvPowerChoice == 'Y')
			{
				System.out.println("You are currently watching channel " + userTV.getChannel() + " the volume is " + userTV.getVolume());
				System.out.println("You can:");
				System.out.println("1: Change Channel");
				System.out.println("2: Raise Volume");
				System.out.println("3: Lower Volume");
				System.out.println("4: Turn the TV Off");
				System.out.println("5: View TV information");
				menuChoice = keyboard.nextInt();
				//menu data validation
				while(menuChoice < 1 || menuChoice > 5)
				{
					System.out.println("Invalid menu selection, try again.");
					System.out.println();
					System.out.println("You can:");
					System.out.println("1: Change Channel");
					System.out.println("2: Raise Volume");
					System.out.println("3: Lower Volume");
					System.out.println("4: Turn the TV Off");
					System.out.println("5: View TV information");
					menuChoice = keyboard.nextInt();
				}
				switch(menuChoice)
				{
					case 1:
						changeChannel(userTV);
						break;
					case 2:
						raiseVolume(userTV);
						break;
					case 3:
						lowerVolume(userTV);
						break;
					case 4:
						tvPowerChoice = 'N';
						tvPowerChoice = tvPowerOn();
						break;
					default:
						televisionInformation(userTV);
				}
			}
			
			//Exit Program Loop
			System.out.println("Would you like to exit? Y/N");
			//Getting input
			tvChoice = keyboard.next().charAt(0);
			keyboard.nextLine();
			//Data validation
			while (tvChoice != 'Y' && tvChoice != 'N' && tvChoice != 'y' && tvChoice != 'n')
			{
				System.out.println("Only Y or N are allowed as answers");
				System.out.println("Would you like to watch TV? Y/N");
				tvChoice = keyboard.next().charAt(0);
				keyboard.nextLine();
			}
			if (tvChoice == 'Y' || tvChoice == 'y')
			{
				tvChoice = 'N';
			}
			else
			{
				tvChoice = 'Y';
			}
		}
		System.out.println("Have a nice day.");
	}
	
	//Channel Control Method
	public static void changeChannel(Television userTV)
	{
		Scanner keyboard = new Scanner(System.in); //Scanner object for input
		int channelNumber;
		System.out.println("Enter a channel number");
		channelNumber = keyboard.nextInt();
		while (channelNumber <= 0)
		{
			System.out.println("Channel number must be greater than 0.");
			System.out.println("Enter a channel number.");
			channelNumber = keyboard.nextInt();
		}
		
		userTV.setChannel(channelNumber);
	}
	
	//Raise Volume Method
	public static void raiseVolume(Television userTV)
	{
		userTV.increaseVolume();
	}
	
	//Lower Volume Method
	public static void lowerVolume(Television userTV)
	{
		userTV.decreaseVolume();
	}
	
	//Turn tv on method
	public static char tvPowerOn()
	{
		Scanner keyboard = new Scanner(System.in); //Scanner object for input
		
		System.out.println("The TV is currently OFF. Turn it on? Y/N");
		//Getting input
		char tvPowerChoice = keyboard.next().charAt(0);
		keyboard.nextLine();
		//Data validation
		while (tvPowerChoice != 'Y' && tvPowerChoice != 'N' && tvPowerChoice != 'y' && tvPowerChoice != 'n')
		{
			System.out.println("Only Y or N are allowed as answers");
			System.out.println("The TV is currently OFF. Turn it on? Y/N");
			tvPowerChoice = keyboard.next().charAt(0);
			keyboard.nextLine();
		}
		return(tvPowerChoice);
	}
	
	//TV information method
	public static void televisionInformation(Television userTV)
	{
		System.out.println("This TV is " + userTV.getScreenSize() + " inches and is manufactured by " + userTV.getManufacturer() + ".");
	}
}
