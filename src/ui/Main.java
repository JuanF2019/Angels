package ui;
import model.*;
import java.util.Scanner;

public class Main{
	//Relations
	private Legion legion;
	
	//Scanners
	Scanner inputNum;
	Scanner inputStr;
	
	public Main(int arcMaxNum){
		legion = new Legion("Superior Maxima", arcMaxNum);
	}
	public static void main(String[] args){
		Scanner inputStrS = new Scanner(System.in);
		Scanner inputNumS = new Scanner(System.in);
		
		boolean menu = true;
		int menuOpt = 0;
		int arcMaxNum = 0;
		
		System.out.println("Setup: ");
		System.out.println("Please type the maximum number of arcangels do you want to have:");
		boolean check = false;
		boolean check2 = false;
		
		while(!check){
			arcMaxNum = inputNumS.nextInt();
			if(arcMaxNum<0){
				System.out.println("Negative value? Please type a number larger than 0.");
			}
			else if(arcMaxNum==0){
				System.out.println("Zero? Please type a number larger than 0.");
			}
			else{
				check = true;
			}
		}
		Main obj = new Main(arcMaxNum);
		obj.createTestArc();//Creates test arcangel
		System.out.println("Welcome to Angels v1.0");
		while(menu){
			System.out.println("\n----------");
			
			System.out.println("Menu:");
			
			System.out.println("1. Add arcangel.");
			System.out.println("2. Count added arcangels");
			System.out.println("3. Display arcangel information given it's name.");
			System.out.println("4. Display arcangel information given it's power.");
			System.out.println("5. Display celebrations given a month");
			System.out.println("6. Display all celebrations");
			System.out.println("7. Exit");
			System.out.println("What do you want to do?");
			menuOpt = inputNumS.nextInt();
			System.out.println("----------\n");
			switch(menuOpt){
				case 1:
					obj.createArc(arcMaxNum);
				break;
				
				case 2:
					System.out.println("You have created " + Integer.toString(obj.countArc()) + " arcangels.");
				break;
					
				case 3:
					obj.obtainInfoByName();
				break;
				
				case 4:
					obj.obtainInfoByPower();
				break;
				
				case 5:
					obj.obtainCelebByMonth();
				break;
				
				case 6:
					obj.obtainCelebAll();
				break;
				
				case 7:
					System.out.println("Closing program...");
					menu = false;
				break;
				default:
					System.out.println("Invalid option, type a valid one.");
			}
		}		
	}	
	/**Creates an arcangel, asking for the attributes and invoking legion.createArc(param) and legion.candleModifier(param) methods
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.
	*@param arcMaxNum int, maximum number of arcangels to create, used before to define the size of the arcangels array in class Legion.
	*/
	public void createArc(int arcMaxNum){
		inputStr = new Scanner(System.in);
		inputNum = new Scanner(System.in);
		
		String arcName = "";
		String arcPhoto = "";
		String arcPrayer = "";
		int arcCelebDay = 0;
		String arcCelebMonth = "";
		String arcPower = "";
		String arcCandleColor = "";
		String arcCandleSize = "";
		int arcCandleSizeOpt = 0;
		String arcCandleEssence = "";		
		String arcCandleBrightness = "";
		int arcCandleBrightnessOpt = 0; 
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String month = "";
		
		boolean check = false;
		boolean check2 = false;
		
		if (arcMaxNum > countArc()){
			System.out.println("Type arcangel name: ");
			while(!check){
				arcName = inputStr.nextLine();
				arcName = arcName.toLowerCase();						
				if(legion.findArcByName(arcName) != 0){
					System.out.println("Name not saved, arcangel already exists, type a different name.");
				}
				else{
					System.out.println("Name saved correctly \n");
					check = true;
				}
			}
			
			System.out.println("Type arcangel photo name(photoname.fileformat): ");
			arcPhoto = inputStr.nextLine();
			
			System.out.println("\nType arcangel prayer name: ");
			arcPrayer = inputStr.nextLine();
			
						
			System.out.println("\nType arcangel celebration month (e.g January, february...): ");
			check = false;
			while(!check){
				arcCelebMonth = inputStr.nextLine();
				arcCelebMonth = arcCelebMonth.toLowerCase();						
				check2 = false;
				for (int i = 0; i<months.length && !check2;i++){
					if (arcCelebMonth.equals(months[i].toLowerCase())){
						arcCelebMonth = months[i];
						check2 = true;
						check = true;
					}							
				}
				if (check2==false){
					System.out.println("Type a valid month:");
				}
			}
			
			check = false;
			System.out.println("\nType arcangel celebration day: ");
			while(!check){
				arcCelebDay = inputNum.nextInt();
										
				if(arcCelebDay<=0 || arcCelebDay>31){
					System.out.println("Type a valid day: ");
				}
				else if (arcCelebDay == 31 && arcCelebMonth=="February" && arcCelebMonth=="April" && arcCelebMonth=="June" && arcCelebMonth=="September" && arcCelebMonth=="November"){
					System.out.println("Type a valid day: ");
				}
				else if (arcCelebDay == 30 && arcCelebMonth=="February"){
					System.out.println("Type a valid day: ");
				}
				else{
					check = true;
				}
			}
			
			check = false;
			System.out.println("\nType arcangel power: ");
			while(!check){
				arcPower = inputStr.nextLine();
				arcPower = arcPower.toLowerCase();						
				if((legion.findArcByPower(arcPower)) != 0){
					System.out.println("Power not saved, arcangel with that power already exists, type a different power.");
				}
				else{
					System.out.println("Power saved correctly \n");
					check = true;
				}
			}		
			
			String msg = legion.createArc(arcName,arcPhoto,arcPrayer,arcCelebDay,arcCelebMonth,arcPower);
			System.out.println(msg);
			
			System.out.println("\nNow, that the arcangel is created, it is time for creating a candle.");
				
			System.out.println("\nType arcangel candle color: ");
			arcCandleColor = inputStr.nextLine();
				
				
			System.out.println("\nType the number corresponding to the arcangel candle size you want: ");
				
			check = false;					
			while(!check){
				System.out.println("1. Big");
				System.out.println("2. Medium");
				System.out.println("3. Small");
				
				arcCandleSizeOpt = inputNum.nextInt();
				switch(arcCandleSizeOpt){
					case 1:
						arcCandleSize = "Big";
						check = true;
					break;
						
					case 2:
						arcCandleSize = "Medium";
						check = true;
					break;
					
					case 3:
						arcCandleSize = "Small";
						check = true;
					break;
					default:
						System.out.println("Type a valid option:");
				}
			}
			
			System.out.println("\nType arcangel candle essense: ");
			arcCandleEssence = inputStr.nextLine();
			
			System.out.println("\ntype the number corresponding to the arcangel candle brightness you want: ");
			
			check = false;					
			while(!check){
				System.out.println("1. High");
				System.out.println("2. Normal");
				System.out.println("3. Low");
				
				arcCandleBrightnessOpt = inputNum.nextInt();
				switch(arcCandleSizeOpt){
					case 1:
						arcCandleBrightness = "High";
						check = true;
					break;
					
					case 2:
						arcCandleBrightness = "Normal";
						check = true;
					break;
					
					case 3:
						arcCandleBrightness = "Low";
						check = true;
					break; 
					default:
						System.out.println("Type a valid option:");
				}
			}
			
			legion.candleModifier(arcCandleColor, arcCandleSize, arcCandleEssence, arcCandleBrightness, legion.findArcByName(arcName));
			System.out.println("\nCandle created succesfully\n");
		}
		else{
			System.out.println("Could not create arcangel, maximum number of arcangels achived.");
		}
	}	
	/** Obtains(invoking legion.obtainInfoByName(arcName) method) and prints(invoking printArcInfo(arcInfo) method) the information of an arcangel given its name.
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.	
	*/
	public void obtainInfoByName(){
		inputStr = new Scanner(System.in);
		System.out.println("Type the name of the arcangel:");
		String arcName = inputStr.nextLine();
		arcName = arcName.toLowerCase();
		String[] arcInfo = legion.obtainInfoByName(arcName);
		printArcInfo(arcInfo);
	}
	/** Obtains(invoking legion.obtainInfoByName(arcName) method) and prints(invoking printArcInfo(arcInfo) method) the information of an arcangel given its power.
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.		*/
	public void obtainInfoByPower(){
		inputStr = new Scanner(System.in);
		System.out.println("Type the power of the arcangel:");
		String arcPower = inputStr.nextLine();
		arcPower = arcPower.toLowerCase();
		System.out.println(arcPower);
		String[] arcInfo = legion.obtainInfoByPower(arcPower);
		printArcInfo(arcInfo);		
	}	
	/**Prints arcangel information given the array with the information corresponding to one arcangel.
	**<b>pre: </b> Main obj and Legion legion must be created and initialized.
	*@param arcInfo String array with the information. arcInfo!=null.
	*/
	public void printArcInfo(String[] arcInfo){
		if (arcInfo[0] == null){
			System.out.println("No arcangel found.");
		}												
		else{
			for (int i = 0; i<arcInfo.length; i++){
				System.out.println(arcInfo[i]);
			} 
		}
	}
	/**Invokes legion.countArc() method to count the number of arcangels.
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.
	@return Number of arcangels created.
	*/
	public int countArc(){
		return legion.countArc();
	}
	/**Obtains the celebrations of a month asking for it and invoking legion.obtainCelebByMonth(month) methodd. If there are no celebrations it prints a error message.
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.
	*/
	public void obtainCelebByMonth(){
		inputStr = new Scanner(System.in);
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String month = "";
		System.out.println("\nType month to display celebrations of: (e.g January, february...): ");
		boolean check = false;
		boolean check2 = false;
		while(!check){
			month = inputStr.nextLine();
			month = month.toLowerCase();
			check2 = false;
			for (int i = 0; i<months.length && !check2;i++){
				if (month.equals(months[i].toLowerCase())){
					month = months[i];
					check2 = true;
					check = true;
				}
			}
			if (check2==false){
				System.out.println("Type a valid month:");
			}
		}
		
		
		
		String[] celebInMonth = legion.obtainCelebByMonth(month);
		if(celebInMonth.length>0){
			System.out.println("Celebrations in " + month + " are:");
			check = false;
			for (int j =0; j<celebInMonth.length && !check;j++){
				if (celebInMonth[j]!= null ){
					System.out.println(celebInMonth[j]);
				}
				else{
					check = true;
				}
			}
		}
		else{
			System.out.println("No arcangels celebrations found in the given month.");
		}
	}
	/**Obtains all the celebrations invoking legion.obtainCelebAll() methodd. If there are no celebrations it prints a error message.
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.
	*/
	public void obtainCelebAll(){
		System.out.println("All celebrations:");
		String[] celebAll = legion.obtainCelebAll();
		if(celebAll.length>0){
			for (int i = 0; i<celebAll.length;i++){
				System.out.println(celebAll[i]);
			}
		}
		else{
			System.out.println("No arcangels celebrations found.");
		}		
	}
	/**Creates test Arcangel. 
	*<b>pre: </b> Main obj and Legion legion must be created and initialized.
	*/
	public void createTestArc(){
		String name = "juan";
		System.out.println("Test " + legion.createArc(name,"juan.jpg","Padre nuestro",24,"May","silence"));
		legion.candleModifier("Black","Medium","Darkness","Low",legion.findArcByName(name));
	}
}