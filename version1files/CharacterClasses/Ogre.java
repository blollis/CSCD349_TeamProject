import java.util.Random;
import java.util.Scanner;

public class Ogre extends BadGuy {
	public Ogre() {
		//DVC
		super();
		HP = 200;
		hitChance = 0.6;
		damageMin = 30;
		damageMax = 60;
		chanceToHeal = 0.1;
		healMin = 30;
		healMax = 60;

		super.setName("Oddly the Ogre");

	}//close Ogre
   
}//close BadGuy