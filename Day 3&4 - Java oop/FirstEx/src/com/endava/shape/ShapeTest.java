package com.endava.shape;

public class ShapeTest {

	public static float computeShapeArea(Shape shape){
		
		return shape.computeArea();
	}
	
	public static void main(String[] args) {
			
		Shape[] shapesArray = new Shape[3];
		
		/* am folosit constructorii impliciti in care am adaugat eu niste valori default sa nu mai stau sa initializez date 
		 * am creat si constructori cu parametrii si metode de modificare a campurilor din fiecare clasa
		 * le gasesti in fiecare clasa
		 * */
		
		shapesArray[0] = new Circle();
		shapesArray[1] = new Rectangle();
		shapesArray[2] = new Triangle();
		
		for(Shape shape: shapesArray){
			
			shape.helloWorld();
			
			if(shape instanceof Circle)
				System.out.println("Circle Area: " + computeShapeArea(shape));
			else
				if(shape instanceof Rectangle)
					System.out.println("Rectangle Area: " + computeShapeArea(shape));
				else
					System.out.println("Triangle Area: " + computeShapeArea(shape));
		}
	}

}
