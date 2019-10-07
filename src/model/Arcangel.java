package model;

public class Arcangel{
	
	//Atributes
	private String name;
	private String photo;
	private String prayer;
	private int celebDay;
	private String celebMonth;
	private String power;
	
	//Relations
	private Candle candle;
	
	//Constructor
	public Arcangel(String name,String photo,String prayer,int celebDay,String celebMonth, String power){
		this.name = name;
		this.photo = photo;
		this.prayer = prayer;
		this.celebDay = celebDay;
		this.celebMonth = celebMonth;
		this.power = power;
		this.candle = new Candle();		
	}
	
	//Sets	
	public void setName(String name){
		this.name = name;
	}
	public void setPhoto(String photo){
		this.photo = photo;
	}
	public void setPrayer(String prayer){
		this.prayer = prayer;
	}
	public void setCelebDay(int celebDay){
		this.celebDay = celebDay;
	}
	public void setCelebMonth(String celebMonth){
		this.celebMonth = celebMonth;
	}	
	public void setPower(String power){
		this.power = power;
	}
	
	//Gets
	public String getName(){
		return this.name;
	}
	public String getPhoto(){
		return this.photo;
	}
	public String getPrayer(){
		return this.prayer;
	}
	public int getCelebDay(){
		return this.celebDay;
	}
	public String getCelebMonth(){
		return this.celebMonth;
	}
	public String getPower(){
		return this.power;
	}
	
	//Methods	
	/**Modifies all the attributes of an instance of candle class,
	* given its respective value.<br>
	*<b>pre: </b> An object of class candle must be previously created and initialized.
	*<b>post: </b> Attributes of the object candle changed.
	*@param color String, color of the candle. color!=null
	*@param	size String, size of the candle: Big, Medium or Small. size!=null
	*@param essence String, essence of the candle. essence!=null
	*@param brightness String, Brightness of the candle: High, Normal or Low. brightness!=null  
	*/		
	public void candleModifier(String color, String size, String essence, String brightness){
		candle.setColor(color);
		candle.setSize(size);
		candle.setEssence(essence);
		candle.setBrightness(brightness);
	}
	/**Returns an string with the value of each attribute of the candle.
	*<b>pre: </b> An object of class candle must be previously created and initialized.
	*@return candleInfo String with the information of each attribute of the candle.
	*/
	public String getCandleInfo(){
		String candleInfo = ("\n" + " Color: " + candle.getColor() + "\n" + " Size: " + candle.getSize() + "\n" + " Essence: " + candle.getEssence() + "\n" + " Brightness: " + candle.getBrightness() + "\n");
		return candleInfo;
	}
	/**Returns an string with the value of color and essence of the candle.
	*<b>pre: </b> An object of class candle must be previously created and initialized.
	*@return candleInfo String with the information of color and essence of the candle.
	*/
	public String getCandleCE(){
		String candleInfo = ("\n" + " Color: " + candle.getColor() + "\n" + " Essence: " + candle.getEssence());
		return candleInfo;
	}
	
}