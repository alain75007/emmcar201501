package com.myschool.game.car;

public class BatmanCar extends Car {
	
	private boolean flying;

	public boolean isFlying() {
		return flying;
	}

	public boolean setFlying(boolean flying) {
		if (!flying) {
			if (this.isStarted()) {
				System.out.println("Les ailes de la voiture de " + this.getOwner() + " se rétractent, la voiture atterrie…");
			}				
			this.flying = flying;
			return false;
		}
		else {
			if (this.isStarted()) {
				this.flying = flying;
				System.out.println("Les ailes de la voiture de " + this.getOwner() + " se déploient, la voiture vole…");
				return true;
			}
			else {
				return false;
			}	
		}
	}
	
	public boolean stop() {
		super.stop();
		if (this.isFlying()) {
			System.out.println("La voiture de " + this.getOwner() + " tombe!!!!\n");
		}
		return true;
	}

	@Override
	public boolean start() {
		boolean result = super.start();
		if (result) {
			this.vroomvroom();
		}
		return result;
	}

	public BatmanCar(String owner, int power) {
		// TODO Auto-generated method stub
		super(owner, "black", power, true);
	}

}