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
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Battle
{
   protected Party goodGuys;
   protected Party badGuys;
   protected Random randomGenerator = new Random();
      
   public Battle(Party goodGuys)
   {
      this.goodGuys = goodGuys;
      this.badGuys = generateEnemies();
   }//close Battle EVC

   private Party generateEnemies()
	{
		int enemyCount = randomGenerator.nextInt(goodGuys.size());
      
      Party badGuys = new Party();
      
      for (int i = 0; i <= enemyCount; i++) {         
         badGuys.addMember(new Ogre());
      }
      
      return badGuys;
      
   }//close generateEnemies
   
   public boolean fight()
   {
   	System.out.println("\nYou've been challenged! Let the battle begin!\n");
      
      int currentGoodPos = 0;
      int currentBadPos = 0;

      //while loop to carry out battle
   	while (goodGuys.size() > 0 && badGuys.size() > 0) 
      {
         Character currentGoodGuy = goodGuys.getMember(currentGoodPos);
         Character currentBadGuy = badGuys.getMember(currentBadPos);
         
         if (currentGoodGuy.getSpeed() >= currentBadGuy.getSpeed()) 
         {
            
            int optionsChoice = optionsMenu(currentGoodGuy);
            
            if (optionsChoice == 2) 
            {
                        
               System.out.println("Current good guys: ");
               printStats(goodGuys);
               
               System.out.println("Current bad guys: ");
               printStats(badGuys);

            }
            else if (optionsChoice == 1)
            {
               int choice = chooseAttack(currentGoodGuy);
            
               //choose badguy to attack
               int badGuyUnderAttackPos = chooseBadGuyToAttack();
               
               Character badGuyUnderAttack = badGuys.getMember(badGuyUnderAttackPos);     
         
               //carry out chosen attack              
               currentGoodGuy.attack(badGuyUnderAttack, choice);
               
               if (badGuyUnderAttack.checkForLife() == false) 
               {
                  System.out.println("You defeated " + badGuyUnderAttack.getName() + "!");
                  
                  badGuys.removeMember(badGuyUnderAttackPos);
               }  
            
               //advance turn order
               currentGoodPos++;
            }   
            else 
            {
               return false;
            }    
                              
         }    
     
         //if current character in turn order is a bad guy 
         else 
         {
            //randomly choose which attack monster will do
            int choice = randomGenerator.nextInt(3);
            
            //choose goodguy to attack
            int goodGuyUnderAttackPos = randomGenerator.nextInt(goodGuys.size());
         
            Character goodGuyUnderAttack = goodGuys.getMember(goodGuyUnderAttackPos); 
      
            //carry out chosen attack
      		currentBadGuy.attack(goodGuyUnderAttack, choice);
         
            if (goodGuyUnderAttack.checkForLife() == false) 
            {
               System.out.println(currentBadGuy.getName() + " defeated " + goodGuyUnderAttack.getName() + "!");
               
               goodGuys.removeMember(goodGuyUnderAttackPos);
            }   
            
            //advance turn order
            currentBadPos++;
 
         }//close else
            
      }//while party alive
      
      if (badGuys.size() <= 0)
      {
         System.out.println("You defeated all the enemies! Well done!\n");
      }
      else 
      { 
         System.out.println("You were defeated in battle. Better luck next time!\n"); 
      }   
      
      return true;

   }//close fight
   
   private int optionsMenu(Character currentGoodGuy)
   {
      //allow user to choose an option
      System.out.println(currentGoodGuy.getName() + " is up. What would you like to do?");
      System.out.println("1. Attack \t 2. Print Stats \t 3. Flee");      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      while (choice < 1 || choice > 3)
      {
         try 
         {
   		  choice = kb.nextInt();
           
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }//close try-catch
         
         if (choice < 1 || choice > 3) {
            System.out.println("\nPlease enter a number from the list to choose an option.");
         }   
            
      }
      
      return choice;

   }//close optionsMenu

   
   private int chooseAttack(Character currentGoodGuy)
   {
      //allow user to choose an attack
      System.out.println("Choose an attack:\t1. Regular Attack ");      
   		
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         try 
         {
   		  choice = kb.nextInt();
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list to choose an attack.");
         }//close try-catch
      }
      while (currentGoodGuy.validAttackChoice(choice) == false); 
      
      return choice;

   }//close chooseAttack
   
   private int chooseBadGuyToAttack () 
   {
      Scanner kb = new Scanner(System.in);
      
      int choice = 99;
      
      do 
      {
         System.out.println("Who would you like to attack? ");
         printStats(badGuys);
               
         try 
         {
   		  choice = kb.nextInt();
         } catch (InputMismatchException e) 
         {
            kb.nextLine();
            
            System.out.println("\nPlease enter a number from the list of bad guys.");
         }//close try-catch
      }
      while (choice < 1 || choice > badGuys.size());
      
      return choice - 1;
      
   }//close chooseBadGuyToAttack
   
   private void printStats(Party inputParty)
   {
      Character currCharacter;
      
      for (int i = 0; i < inputParty.size(); i++)
      {
         currCharacter = inputParty.getMember(i);
         
         System.out.println((i + 1) + ". " + currCharacter.getName() + ": " + currCharacter.getHP() + "HP");
      }
      
      System.out.println("");
      
   }//close printStats
   
  /*


   //////////////////////////////
   //Passes a good and bad guy
   //Prints the menu for the player to chose
   //////////////////////////////
   public boolean attackMenu(Character player, Character enemy)
   {
      boolean check = false;
      Scanner kb = new Scanner(System.in);
      System.out.println("\nWhat to do:" +
                         "\n1) Normal attack" +        
                         "\n2) Special attack" +
                         "\n3) Potions" +
                         "\n3) Party members");
      int choice = (kb.nextInt());
      if(choice == 1)
			check = combat(player, enemy);
		else if(choice == 2)
			check = combat(player, enemy);
		else if(choice == 3)
			potionMenu(); //Haven't wrote yet
      else
         partyMenu(player, enemy); //Haven't wrote yet
      return check;
   }
   
   public void potionMenu()
   {
   }
   
   public void partyMenu(Character p, character e)
   {
   }
   
   //////////////////////////////
   //Passes in hero attacker and the arrayList of bad guys
   //Prints each enemy and their remaining life from the array
   //Has the user pick an enemy to attack or flee.
   //////////////////////////////
   public ArrayList evilMenu(Character player, ArrayList<BadGuy> v)
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
      int choice = (kb.nextInt());
      if(choice == 0)
			v = flee(v);
      else
			check = attackMenu(player, v.get(choice-1));
      
      if(check)
         v.remove(choice-1);
         
      return v;
   }
   
   //////////////////////////////
   //Passes in an attacker and defender character
   //Checks to see if the attacker misses the defender
   //If hit, the dmg is created and subtracted from the 
   //    the defender's def stat
   //If misses, it is printed
   //Checks the defender's life after the take
   //If the life is below 0, the defender is removed.
   //////////////////////////////
   public boolean battle(Character attacker, Character defender)
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
   
   
   //////////////////////////////
   //Set the enemies life to 0
   //Call setFlee() method
   //////////////////////////////   
   public void flee(ArrayList<BadGuy> v)
   {
      System.out.println("You ran away");
      for(int i = 0; i < v.size(); i++)
      {
         v.get(i).setHp(0);
      }
      setFlee();
   }
   
   
   //////////////////////////////
   //Set boolean flee to true
   ////////////////////////////// 
   public void setFlee()
   {
      flee = true;
   }
   
   
   //////////////////////////////
   //Randomly generate a number to return to select a hero.
   ////////////////////////////// 
   public int enemySelectHero(int i)
   {
      Random randomGenerator = new Random();
		int choice = randomGenerator.nextInt(i);
		return choice;
   }
   
   public static void selectionSort(int[] a) {
      int i, j, ix, temp;
      
      for (i = a.length - 1; i > 0; i--) {
         ix = 0;
         
         for (j = 1; j <= i; j++) {  
            if (a[j] > a[ix]) {
               ix = j;
            }//close if
         }//close for 
      
         temp = a[ix];
         a[ix] = a[i];
         a[i] = temp;
      
      }//close for
      
   }//close selectionSort*/
} //End of Battle Class