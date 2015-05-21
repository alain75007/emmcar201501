package com.myschool.game.car;

public class Start {

	public static void main(String[] args) {
		System.out.println("Car Game lancé");
		Car car1 = new Car();
		BatmanCar car2 = new BatmanCar();
		car1.initialize("Maxime", "rouge", 10);
		car2.initialize("Maëlis", 11);
		car2.start();
		car2.vroomvroom();
		System.out.println("Nombre de voitures : " + Car.getCarCount());
		car2.setFlying(true);
	}
}
