package com.endava.shape;

public class Triangle extends Shape{

	private float side1;
	private float side2;
	private float side3;
	
	public Triangle(){
		
		//default values
		this.side1 = 1.0f;
		this.side2 = 1.0f;
		this.side3 = 1.0f;
	}
	
	public Triangle(float side1, float side2, float side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	
	public void setSides(float newSide1, float newSide2, float newSide3){
		
		this.side1 = newSide1;
		this.side2 = newSide2;
		this.side3 = newSide3;
	}
	
	public float getSide(int sideIndex){
		
		switch(sideIndex){
			
		case 1:
			return this.side1;
		case 2:
			return this.side2;
		case 3:
			return this.side3;
		default:
			System.out.println("Wrong side index !");
			break;
		}
		
		return 0;
	}
	
	@Override
	public float computeArea() {
		
		/* compute area using Heron's formula */
		float sp = (this.side1 + this.side2 + this.side3)/2;
		
		float area = (float)Math.sqrt((double)(sp *(sp - this.side1) * (sp-this.side2) * (sp-this.side3))); 
		
		return area;
	}
	
	public void helloWorld(){
		
		super.helloWorld();
		System.out.println("Hello World from a Triangle");
	}

}
