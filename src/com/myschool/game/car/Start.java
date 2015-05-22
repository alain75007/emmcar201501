package com.myschool.game.car;

public class Start {

	public static void main(String[] args) {
		System.out.println("Car Game lancé");
		Car car1 = new Car("Maxime", "rouge", 10);
		BatmanCar car2 = new BatmanCar("Maëlis", 11);
		car2.start();
		car2.vroomvroom();
		System.out.println("Nombre de voitures : " + Car.getCarCount());
		car2.setFlying(true);
	}
}
