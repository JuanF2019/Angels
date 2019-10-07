package model;

public class Legion{	
	private String name;	
	Arcangel[] arcangels;
	
	public Legion(String name, int arcangelsNum){
		this.name = name;
		arcangels = new Arcangel[arcangelsNum+1];//Position 0 will be always null.
	}	
	public String getName(){
		return this.name;
	}	
	public void setName(String name){
		this.name = name;
	}
	/**It obtains the information of an instance of class Arcangel, given its attribute name, and sorts it in an array of Strings.
	*<b>pre: </b> The arcangels[] must be initialized and fill with at least with one no null arcangel.
	*<b>pre: </b> An object of class candle must be previously created, initialized and declared as an attribute of an Arcangel.
	*@param name String, name of the arcangel to retrieve the information of. name !=null
	*@return arcInfo String array with the value of each atribute of the arcangel, if no arcangel with the given name is found it returns a null String array.
	*/
	public String[] obtainInfoByName(String name){
		int i = findArcByName(name);
		String[] arcInfo = new String[6];//Creates array of arcInfo
		if (i!=0){
			arcInfo[0] = ("Name: " + arcangels[i].getName());
			arcInfo[1] = ("Photo: " + arcangels[i].getPhoto());
			arcInfo[2] = ("Prayer: " + arcangels[i].getPrayer());
			arcInfo[3] = ("Celebration date: " + arcangels[i].getCelebMonth() + " " + Integer.toString(arcangels[i].getCelebDay()));
			arcInfo[4] = ("Power: " + arcangels[i].getPower());
			arcInfo[5] = ("Candle: " + arcangels[i].getCandleInfo());
		}
		return arcInfo;
	}
	/**It obtains the information of an instance of class Arcangel, given its attribute power, and sorts it in an array of Strings.
	*<b>pre: </b> The arcangels[] must be initialized and fill with at least with one no null arcangel.
	*<b>pre: </b> An object of class candle must be previously created, initialized and declared as an attribute of an Arcangel.
	*@param power String, power of the arcangel to retrieve the information of. power !=null
	*@return arcInfo String array with the value of each atribute of the arcangel, if no arcangel with the given power is found it returns a null String array.
	*/
	public String[] obtainInfoByPower(String power){
		int i = findArcByPower(power);
		String[] arcInfo = new String[6];//Creates array of arcInfo
		if (i!=0){
			arcInfo[0] = ("Name: " + arcangels[i].getName());
			arcInfo[1] = ("Photo: " + arcangels[i].getPhoto());
			arcInfo[2] = ("Prayer: " + arcangels[i].getPrayer());
			arcInfo[3] = ("Celebration date: " + arcangels[i].getCelebMonth() + " " + Integer.toString(arcangels[i].getCelebDay()));
			arcInfo[4] = ("Power: " + arcangels[i].getPower());
			arcInfo[5] = ("Candle: " + arcangels[i].getCandleInfo());
		}
		return arcInfo;
	}
	/**Invokes candle modifier method in class Arcangel.
	<b>pre: </b> An object of class candle must be previously created and initialized.
	*@param color String, color of the candle. color!=null
	*@param	size String, size of the candle: Big, Medium or Small. size!=null
	*@param essence String, essence of the candle. essence!=null
	*@param brightness String, brightness of the candle: High, Normal or Low. brightness!=null.
	*@param i integer, position of the arcangel in the arcangels array.
	*/
	public void candleModifier(String color, String size, String essence, String brightness, int i){
		arcangels[i].candleModifier(color,size,essence,brightness);
	}
	/**Creates an arcangel object given its attributes and returns a message of error or succces.
	*<b>pre: </b>Arcangels array must be created.
	*<b>pre: </b> Name, power, celebDay and celebMonth must be verified first.
	*@param name String, name of the aracangel. name!=null
	*@param photo String, photo name of the arcangel photo!=null
	*@param prayer String, prayer name of the arcangel prayer!=null
	*@param celebDay int, celebration day of the arcangel.
	*@param celebMonth String, celebration month of the arcangel. 
	*@param power String, Power of the arcangel. power!=null.	
	*@return message of error or success in the creation of the object.
	*/
	public String createArc(String name,String photo,String prayer,int celebDay,String celebMonth, String power){
		String msg = "Could not create arcangel, maximum number of arcangels achived.";
		boolean check = false;
		for (int i = 1; i < arcangels.length && !check; i++){
			if (arcangels[i]==null){
				arcangels[i] = new Arcangel(name,photo,prayer,celebDay,celebMonth,power);
				check = true;
				msg = "Arcangel created succesfully.";
			}				
		}
		return msg;
	}		
	/**Returns an arcangel position given its name, if its 0 no arcangel was found
	*<b>pre:</b> Arcangels array must be created.
	*@param name String, name of the arcangel to find. name!=null
	*@return Position of the arcangel, it its 0 no arcangel was found
	*/
	public int findArcByName(String name){
		boolean check = false;
		int arcPos = 0;
		for (int i = 1; i < arcangels.length && !check; i++){
			if (arcangels[i]!=null && (arcangels[i].getName()).equals(name)){
				arcPos = i;
				check = true;
			}				
		}
		return arcPos;
	}
	/**Returns an arcangel position given its power, if its 0 no arcangel was found
	*<b>pre:</b> Arcangels array must be created.
	*@param power String, name of the arcangel to find. power!=null
	*@return Position of the arcangel, it its 0 no arcangel was found
	*/
	public int findArcByPower(String power){
		boolean check = false;
		int arcPos = 0;		
		for (int i = 1; i < arcangels.length && !check; i++){
			if (arcangels[i]!=null && (arcangels[i].getPower()).equals(power)){
				arcPos = i;
				check = true;
			}				
		}
		return arcPos;
	}
	/**Returns the number of created arcangels 
	*<b>pre:</b> Arcangels array must be created.
	*@return Returns the number of added arcangels.	
	*/
	public int countArc(){
		int arcNum = 0;
		for (int i = 1; i < arcangels.length; i++){
			if (arcangels[i]!=null){
				arcNum++;				
			}				
		}
		return arcNum;
	}
	/**Returns a String array of the celebrations given a Month. 
	*<b>pre:</b> Month must be pre-verified.
	*<b>pre:</b> Arcangels array must be created.
	*@param month String, the month that the user wants to know its arcangel celebreations. month!=null
	*@return A String array of the celebrations in that month.
	*/
	public String[] obtainCelebByMonth(String month){
		int i = 0;//To count how many arcangels exist with the given celebration month.
		for (int k = 1;k<arcangels.length;k++){
			if(arcangels[k] != null && arcangels[k].getCelebMonth()==month){
				i++;
			}
		}
		String[] celebInMonth = new String[i];
		int j = 0; //To keep track of the position in the celebInMonth array.
		for (int k = 1; k<arcangels.length;k++){
			if(arcangels[k] != null && arcangels[k].getCelebMonth()==month){
				celebInMonth[j] = (arcangels[k].getName() + ": " + arcangels[k].getCelebMonth() + " " + arcangels[k].getCelebDay() + "\nCandle:" + arcangels[k].getCandleCE());
				j++;
			}
		}
		return celebInMonth;
	}
	/**Returns a String array all the celebrations. 
	*<b>pre:</b> Arcangels array must be created.
	*@return A String array of all the celebrations.
	*/
	public String[] obtainCelebAll(){
		int i = countArc();
		String[] celebAll = new String[i];
		
		int j = 0; //To keep track of the position in the celebAll array.
		for (int k = 1; k<arcangels.length;k++){
			if(arcangels[k] != null){
				celebAll[j] = (arcangels[k].getName() + ": " + arcangels[k].getCelebMonth() + " " + arcangels[k].getCelebDay());
				j++;
			}
		}
		return celebAll;
	}
}