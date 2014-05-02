package com.endava.shape;

public class Circle extends Shape{

	private static final float PI = 3.14f;
	private float radius;
	
	public Circle(){
		
		//default value
		this.radius = 1.0f;
	}
	
	public Circle(float radius){
		this.radius = radius;
	}
	
	public void setRadius(float newRadius){
		this.radius = newRadius;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	@Override
	public float computeArea() {
		
		return (float) (PI * Math.pow(this.radius, 2));
	}
	
	public void helloWorld(){
		
		super.helloWorld();
		System.out.println("Hello World from a Circle");
	}
}
