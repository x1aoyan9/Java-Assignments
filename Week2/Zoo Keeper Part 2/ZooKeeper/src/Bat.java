public class Bat extends Mammal{
	public Bat() {
		super(300);
	}
	public void canFly() {
		System.out.println("Flap flap");
		energyLevel -= 50;
		displayEnergy();
	}
	public void eatHuman() {
		System.out.println("RIP");
		energyLevel += 25;
		displayEnergy();
	}
	public void attackTown() {
		System.out.println("Fire crackling");
		energyLevel -= 100;
		displayEnergy();
	}
}