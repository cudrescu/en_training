package com.endava.shape;

public class Rectangle extends Shape{
	
	private float length;
	private float width;
	
	public Rectangle(){
		
		//default values - just for fun
		this.length = 1.0f;
		this.width = 1.0f;
		
	}
	
	public Rectangle(float length, float width){
		
		this.length = length;
		this.width = width;	
	}

	public void setLength(int newLength){
		
		this.length = newLength;
	}
	
	public void setWidth(int newWidth){
		
		this.width = newWidth;
	}
	
	public float getLength(){
		
		return this.length;
	}
	
	public float getWidth(){
		
		return this.width;
	}
	
	
	@Override
	public float computeArea() {
		
		return this.length * this.width;
	}
	
	public void helloWorld(){
		
		super.helloWorld();
		System.out.println("Hello World from a Rectangle");
	}

}
