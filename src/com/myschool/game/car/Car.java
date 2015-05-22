package com.myschool.game.car;

public class Car {
	private static int carCount;
	private String color;
	private int power;
	private boolean isStarted = false;
	private String owner;
	private boolean isConvertible;

	public Car() {
		super();
		carCount++;
	}
	public int getPower() {
		return power;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public String getOwner() {
		return owner;
	}
	public boolean isConvertible() {
		return isConvertible;
	}
	public String getColor() {
		return color;
	}

	
	public Car(String owner, String color, int power) {
		this(owner, color, power, false);
	}

	public Car(String owner, String color, int power, boolean isConvertible) {
		this.isConvertible = isConvertible;
		this.color = color;
		this.owner = owner;
		this.power = power;
	}

	public boolean vroomvroom() {
		if (this.isStarted) {
			System.out.println("La voiture de " + this.owner + " fait: Vroom Vroom!!!");
			return true;
		}
		return false;
	}

	public boolean start() {
		this.isStarted = true;
		System.out.println("La voiture de " + this.owner + " démarre!"); 
		return isStarted;
		// TODO Auto-generated method stub
		//return false;
	}
	public boolean stop() {
		System.out.println("La voiture de " + this.getOwner() + " s'arrête");
		this.isStarted = false;
		return isStarted;
	}

	public static int getCarCount() {
		return carCount;
	}

}
