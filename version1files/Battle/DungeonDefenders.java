//Coded by Jacob Weeden
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class DungeonDefenders
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		while(true)
		{
         ArrayList<GoodGuy> heroes = new ArrayList();
         heroes = createHeroes(heroes);
         
         //character walks through map
         
         boolean victory;
         Encounter battle = new Encounter(heroes);
         victory = battle.combat();
         
         
         
         System.out.println("--------------------------------\n");
			System.out.println("1-Play again\n2-Quit");
			int quit = kb.nextInt();
			System.out.println("--------------------------------\n");
			if(quit == 2)
			{
				break;
			}
		}
      
		
	} //End of Main
   
   
   public ArrayList createHeroes(ArrayList<GoodGuy> heroes)
   {
      GoodGuy player1 = selectHero();
      GoodGuy player2 = selectHero();
      GoodGuy player3 = selectHero();
      GoodGuy player4 = selectHero();
      heroes.add(player1);
      heroes.add(player2);
      heroes.add(player3);
      heroes.add(player4);
      return heroes;   
   }
   
   
   public GoodGuy selectHero()
   {//Where the player can choose which character to play as
      Scanner kb = new Scanner(System.in);
      System.out.println("\nSelect your character:" +
                         "\n1) Human Defender" +
                         "\n2) Dwarf Ranger" +
                         "\n3) Elf Wizard" +
                         "\n4) Orc Warrior" +
                         "\n5) Monk Cleric");
      int choice = (kb.nextInt());
      if(choice == 1)
			return new Defender();
		/*else if(choice == 2)
			return new Ranger();
		else if(choice == 3)
			return new Wizard();
      else if(choice == 4)
			return new Warrior();
      else if(choice == 5)
			return new Cleric();*/
      else
			System.exit(-1);
   }//End of heroSelection()

      
} //End of DungeonDefenders
