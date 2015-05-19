import java.util.Random;
import java.util.Scanner;

public class Gremlin extends BadGuy {
	public Gremlin() {
		//DVC
		super();
		HP = 90;
		hitChance = 0.5;
		damageMin = 20;
		damageMax = 60;
		chanceToHeal = 0.1;
		healMin = 20;
		healMax = 40;
      speed = 6;

		super.setName("Gargles the Gremlin");

	}//close Gremlin
   
}//close BadGuy