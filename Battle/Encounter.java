//////////////////////////////////
//Player walks around the map until an enemy appears.
//which then triggers a new Encounter;
//
//boolean victory;
//Encounter battle = new Encounter(heroes);
//victory = battle.combat();
//
//where heroes is an ArrayList<GoodGuy> of the players characters
//when the battle is created it randomly selects a monster and how many
//combat(); determines the turnorder of combat as well as goes through each turn
//until either the GoodGuy List or the BadGuy List is empty.
//if GoodGuy list is empty all the heroes died and it returns false
//if badguy list is empty all the enemies died and it returns true
//////////////////////////////////

import java.util.Random;
import java.util.ArrayList;

public class Encounter
{
   protected ArrayList<GoodGuy> good;
   protected ArrayList<BadGuy> bad;
   protected Random rand = new Random();
      
   public Encounter(ArrayList<GoodGuy> g)
   {
      good = g;
      bad = enemySelection();
   }

   ////////////////////////////////
   //Randomly choose an enemy and number of enemies and return an ArrayList.
   ////////////////////////////////
   public ArrayList enemySelection()
	{
		ArrayList<BadGuy> enemyList = new ArrayList();
      int choice = rand.nextInt(19) + 1;
      int numEn = rand.nextInt(3) + 1;
		if(choice <= 9)
      {
			Undead enemy = new Undead();
         enemyList.add(enemy);
         
         for(int i = 1; i < numEn; i++)
         {
            enemy = new Undead();
            enemyList.add(enemy);
         }
         return enemyList;
      }
		else if(choice > 9 && choice <= 14)
		{
         Goblin enemy = new Goblin();
         enemyList.add(enemy);
         
         for(int i = 1; i < numEn; i++)
         {
            enemy = new Goblin();
            enemyList.add(enemy);
         }
         return enemyList;
      }
		else if(choice > 14 && choice <= 17)
      {
         Thief enemy = new Thief();
         enemyList.add(enemy);
         
         for(int i = 1; i < numEn; i++)
         {
            enemy = new Thief();
            enemyList.add(enemy);
         }
         return enemyList;
      }
      else if(choice > 17 && choice <= 19)
      {
         Manticore enemy = new Manticore();
         enemyList.add(enemy);
         
         for(int i = 1; i < numEn; i++)
         {
            enemy = new Manticore();
            enemyList.add(enemy);
         }
         return enemyList;
      }
      else
      {
         Dragon enemy = new Dragon();
         enemyList.add(enemy);
         
         for(int i = 1; i < numEn; i++)
         {
            enemy = new Dragon();
            enemyList.add(enemy);
         }
         return enemyList;
      }
	} //End of enemySelection()
   

   //////////////////////////////
   //Sorts the heroes into TurnOrder based on their speed.
   //Sorts the enemies into TurnOrder based on a random number between 0 & their speed
   //Cycles through TurnOrder calling Turn depending on whos turn it is
   //We pass in the good list to the badguys and the bad list to the good guys as an easy way to target in combat
   //without having to mess with TurnOrder.
   //Since we recreate the good and bad lists between each attack they will always have the most up to date list of targets.
   //if its the players turn it will use the bad list to display the enemies that can be attacked.
   //once an enemy has been chosen from that list you will have to search for it in turnOrder and use that one of the attack
   //use turnOrder.indexOf((Character)bad.get(target)) to get the location of the target in turnOrder
   //After attacking that index if the hp has reached 0 remove that index from TurnOrder.
   //////////////////////////////
   public boolean combat()
   {
      ArrayList<Character> turnOrder = new ArrayList<Character>();
      
   	for(int x = 0; x < good.size(); x++)
   	{         
   		if(turnOrder.size() == 0)
   		{
   			turnOrder.add(good.get(x));
   		}
   		else
   		{
   			for(int y = 0; y < turnOrder.size(); y++)
   			{
   				if(good.get(x).getSpd() > turnOrder.get(y).getSpd())
   					turnOrder.add(y, good.get(x));
               else
                  turnOrder.add(good.get(x));
   			}
   		}
   	}
   	
   	for(int x = 0; x < bad.size(); x++)
   	{
   		bad.get(x).setSpd(rand.nextInt(bad.get(x).getSpd()));
   		if(turnOrder.size() == 0)
   		{
   			turnOrder.add(bad.get(x));
   		}
   		else
   		{
   			for(int y = 0; y < turnOrder.size(); y++)
   			{
   				if(bad.get(x).getSpd() > turnOrder.get(y).getSpd())
   					turnOrder.add(y, bad.get(x));
   				else
                  turnOrder.add(bad.get(x));
   			}
   		}
   	}
   	
   	do
   	{
   		for(int x = 0; x < turnOrder.size(); x++)
   		{
            if(turnOrder.get(x).isNPC)
   			   enemyTurn((BadGuy)turnOrder.get(x), good);
            else
   			   playerTurn((GoodGuy)turnOrder.get(x), bad);
   			
   			good = new ArrayList();
   			bad = new ArrayList();
   			for(int y = 0; y < turnOrder.size(); y++)
   			{
   				if(turnOrder.get(y).isNPC())
   					bad.add((BadGuy)turnOrder.get(y));
   				else
   					good.add((GoodGuy)turnOrder.get(y));
   			}
         }
   	}while(good.size() > 0 && bad.size() > 0);
   	
   	if(bad.size() == 0)
      {
   		System.out.println("Victory! All forces of evil have been eliminated!!");
         return true;
   	}
      else
      {
   		System.out.println("Game Over... All Heroes have been vanquished!");
         return false;
      }
   }

   public void enemyTurn(BadGuy attacker, ArrayList<GoodGuy> goodList)
   {
      
   }
   
   public void playerTurn(GoodGuy attacker, ArrayList<BadGuy> badList)
   {
   
   }


/*havent gotten around to where this is used yet but should be soon in the enemy/player turn.
   public boolean attackMenu(Character player, Character enemy)
   {
      boolean check = false;
      Scanner kb = new Scanner(System.in);
      System.out.println("\nWhat to do:" +
                         "\n1) Normal attack" +        
                         "\n2) Special attack" +
                         "\n3) Potions" +
                         "\n3) Party members");
      int choice = (kb.nextInt())
      if(choice == 1)
			check = combat(player, enemy);
		else if(choice == 2)
			check = combat(player, enemy);
		else if(choice == 3)
			potionMenu();
      else
         partyMenu(player, enemy);
      return check;
   }
   
   public ArrayList evilMenu(Character player, ArrayList<Character> v)
   {
      boolean check = false;
      Scanner kb = new Scanner(System.in);
      System.out.println("\nChoose enemy to attack");
      int i;
      for(i = 0; i < v.size(); i++)
      {
         System.out.println("\n" + i+1 + ") " + v.get(i).getName() + " HP: " + v.get(i).getHP());
      }
      System.out.println("\n0) Flee"); // Option to run
      int choice = (kb.nextInt())
      if(choice == 0)
			flee();
		else
			check = attackMenu(player, v.get(choice-1));
      
      if(check)
         v.remove(choice-1);
   }
   
      
   public static boolean combat(character attacker, character defender)
   {
      System.out.println(attacker.getName() + " attacks " + defender.getName());
      int evasion = defender.getEva();
      Random rand = new Random();
      if((rand.nextInt(99) + 1) > evasion) 
      {
         int dmg = attaker.getAtk();
         Random randomGenerator = new Random();
         dmg = randomGenerator.nextInt(dmg) + 1;
         dmg = dmg - defender.getDef();
         System.out.println(attacker.getName() + " hit for " + dmg + " damage.");
         if(dmg > 0)
         {
            int newHP = defender.getHp() - dmg;
            defender.setHp(newHP);
            if(defender.getHp() <= 0)
               return true;
            else
               return false;
         }
      }
      else
         System.out.println(attacker.getName() + " missed.");
   }//End of Combat()
      
   public void flee(Character enemy1, Character enemy2, Character enemy3, Character enemy4)
   {
      System.out.println("You ran away");
      if(enemy1 != null)
         enemy1.setHp(0);
      if(enemy2 != null)
         enemy2.setHp(0);
      if(enemy3 != null)
         enemy3.setHp(0);
      if(enemy4 != null)
         enemy4.setHp(0);
      setFlee();
   }
   
   public void setFlee()
   {
      flee = true;
   }
   
   public int enemySelectHero(int i)
   {
      Random randomGenerator = new Random();
		int choice = randomGenerator.nextInt(i);
		return choice;
   }
*/
} //End of Battle Class