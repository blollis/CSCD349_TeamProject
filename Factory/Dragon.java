import java.util.Random;
import java.util.Scanner;

public class Dragon extends BadGuy {
	public Dragon() {
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

		super.setName("Puff the Magic Dragon");

	}//close Gremlin
   
}//close BadGuy