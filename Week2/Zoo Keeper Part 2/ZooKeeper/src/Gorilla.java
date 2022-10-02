public class Gorilla extends Mammal {
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	public void throwSomething() {
		System.out.println("throwing bananas here");
		energyLevel -= 5;
		displayEnergy();
	}
	public void eatBanana() {
		System.out.println("eating bananas");
		energyLevel += 10;
		displayEnergy();
	}
	public void climb() {
		System.out.println("climbing bananas here");
		energyLevel -= 10;
		displayEnergy();
	}
}