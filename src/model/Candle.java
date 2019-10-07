package model;

public class Candle{
	
	//Constants
	public final String BIG = "Big";
	public final String MEDIUM = "Medium";
	public final String SMALL = "Small";
	public final String HIGH = "High";
	public final String NORMAL = "Normal";
	public final String LOW = "Low";
	
	//Atributes
	private String color;
	private String size;
	private String essence;
	private String brightness;
	
	//Sets
	public void setColor(String color){
		this.color = color;
	}
	public void setSize(String size){
		this.size = size;
	}
	public void setEssence(String essence){
		this.essence = essence;
	}
	public void setBrightness(String brightness){
		this.brightness = brightness;
	}
	
	//Gets
	public String getColor(){
		return this.color;
	}
	public String getSize(){
		return this.size;
	}
	public String getEssence(){
		return this.essence;
	}
	public String getBrightness(){
		return this.brightness;
	}
}