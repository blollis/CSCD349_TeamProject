import java.util.Scanner;
import java.util.Random;

public abstract class BadGuy extends Character {
	protected double chanceToHeal;
	protected int healMin;
	protected int healMax;

	public BadGuy() {
		super();
		healMin = 0;
		healMax = 0;
	}//close BadGuy

	public void setHealMin(int healMinInput) {
		healMin = healMinInput;
	}//close sethealMin    

	public int getHealMin() {
		return healMin;
	}//close gethealMin

	public void setHealMax(int healMaxInput) {
		healMax = healMaxInput;
	}//close sethealMax    

	public int getHealMax() {
		return healMax;
	}//close gethealMax

	public void setChanceToHeal(double chanceToHealInput) {
		chanceToHeal = chanceToHealInput;
	}//close setchanceToHeal    

	public double getChanceToHeal() {
		return chanceToHeal;
	}//close getchanceToHeal
   
  	public void attack(GoodGuy currentGoodGuy, int choiceInput) {
		Random randomGenerator = new Random();
      
      //randomly generates to determine if attack will succeed
		double hitChanceTemp = randomGenerator.nextDouble();

		if (hitChanceTemp < currentGoodGuy.getHitChance()) {
			//randomly generated in driver and passed in
         int choice = choiceInput;

			//randomly generates to determine if hero will block attack
         double blockChanceTemp = randomGenerator.nextDouble();

			//generates amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt((damageMax - damageMin) + 1) + damageMin;
         
         //apply damage to hero
			currentGoodGuy.setHP(currentGoodGuy.getHP() - damageAmountTemp);
			System.out.println(name + " attacked you for " + damageAmountTemp + " points damage! You have " + currentGoodGuy.getHP() + " hit points remaining.\n");
		          
		}//close if hit chance
      
      //else attack did not succeed
		else {
			System.out.println(name + " attempted to attack but was unsuccessful. You have " + currentGoodGuy.getHP() + " hit points remaining.\n");       
		}//close else

	}//close attack 

}//close BadGuy