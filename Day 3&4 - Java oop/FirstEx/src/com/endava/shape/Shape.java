package com.endava.shape;

public abstract class Shape {

	/** metoda helloWorld 
	 * afiseaza mesajul "Hello World !"
	 */
	public void helloWorld(){
		System.out.println("Hello World !");
	}
	
	/**
	 * Metoda abstracta computeArea
	 * calculeaza aria unei forme geometrice(Shape)
	 */
	public abstract float computeArea();
	
}
