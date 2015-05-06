import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class CharacterTester {

	public static void main (String[] args) {
		Random randomGenerator = new Random();
      
      //while quit loop keeps the game running until user chooses to quit
		boolean quit = false;
      
		while (quit == false) {
			
         //set hero
         GoodGuy currentGoodGuy = new Elf();
			
         //set monster
         BadGuy currentBadGuy = new Ogre();
         
			System.out.println("\nLet the battle begin!\n");

         //while loop to carry out battle
			while (currentBadGuy.checkForLife() == true && currentGoodGuy.checkForLife() == true) {
				//keep track of number of rounds
            int roundCounter = 1;
                        
            //allow user to choose an attack
				System.out.println("\tChoose an attack:\t1. Regular Attack\t2. " + currentGoodGuy.specialAttack);      
				
            Scanner kb = new Scanner(System.in);
            
            int choice =0;
            
            //check that input is a valid choice
            while (choice != 1 && choice != 2) {
               try {
         		   choice = kb.nextInt();
               } catch (InputMismatchException e) {
                  kb.nextLine();
               }//close try-catch
               
               //reprompt if input was not a valid choice
               if (choice != 1 && choice != 2) {
                     System.out.println("\nPlease enter 1 or 2 to choose an attack.");
               }//close if
            }//close while

            //carry out chosen attack
				currentGoodGuy.attack(currentBadGuy, choice);
               
            //if to carry out monster attack
				if (currentBadGuy.checkForLife() == true && currentGoodGuy.checkForLife() == true) {
					
               //randomly choose which attack monster will do
               choice = randomGenerator.nextInt(3);
               
               //carry out chosen monster attack
					currentBadGuy.attack(currentGoodGuy, choice);
				
            }//close if to carry out monster attack
            
            //if to check whether either character is dead and update user if not
            if (currentBadGuy.checkForLife() == true && currentGoodGuy.checkForLife() == true) {
   				//update user
               System.out.println("You have reached the end of round " + roundCounter + " \nYou currently have " + currentGoodGuy.getHP() + " HP remaining and " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " HP remaining.\n");
                
            }//close if to check monster and hero still alive at end of round
            //else either monster or user is dead
            else {
               //if monster is dead
               if (currentBadGuy.checkForLife() == false) {
   					System.out.println("Congratulations " + currentGoodGuy.getName() + "! You have beaten " + currentBadGuy.getName() + " in battle!");                        
   				}//close if to check monster HP
               
               //if hero is dead
   				else if  (currentGoodGuy.checkForLife() == false) {
   					System.out.println(currentGoodGuy.getName() +", you were beaten in battle by the monster. Better luck next time!");                        
   				}//close if to check hero HP
   
               //give user option to play again
   				System.out.println("Choose N to quit now or any other key to play again.");
               
   				String choice2 = kb.next();
               
               //if user chooses to quit, then exit outer while loop
   				if (choice2.equalsIgnoreCase("N")) {
   					quit = true;
   					System.out.println("Thanks for playing!");
   				}//close if to check if user chose to quit
            }//close else to check monster and hero still alive at end of round   

			}//close while in battle
         
      }//close while quit = false

	}//close main


//didn't delete because we can use this for the opening menu later
/*	public static GoodGuy chooseGoodGuy() {
		//print choose hero menu
      System.out.print("Welcome To GoodGuyes and BadGuys!\n    Please choose a hero:\n\t1. Warrior\n\t2. Sorceress\n\t3. Thief\n\t4. Elf\n");
      
      //allow user to choose
		Scanner kb = new Scanner(System.in);
      
      int choice = 0;
      
      //check that input was a valid choice
      while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
         try {
   		   choice = kb.nextInt();
         } catch (InputMismatchException e) {
            kb.nextLine();
         }//close try-catch
         
         //reprompt if input was an int but not a valid choice
         if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
               System.out.println("\nPlease enter 1, 2, 3, or 4 to choose a hero.");
         }//close if
      }//close while     
      
      //initialize current hero (wasn't working if I didn't initialize it outside if statement, so is initialized then overwritten)
		GoodGuy currentGoodGuy = new Warrior();
		
      
      //while waiting loop forces user to pick one of the choices
      boolean waiting = true;
      
		while (waiting == true) {
			if (choice == 1) {
				currentGoodGuy = new Warrior();
				System.out.print("You have chosen the path of the brave warrior.");
				waiting = false;
			}
			else if (choice == 2) {
				currentGoodGuy = new Sorceress();
				System.out.print("You have chosen the path of the mighty sorceress.");
				waiting = false;
			}
			else if (choice == 3) {
				currentGoodGuy = new Thief();
				System.out.print("You have chosen the path of the cunning thief.");
				waiting = false;
			}
			else if (choice == 4) {
				currentGoodGuy = new Elf();
				System.out.print("You have chosen the path of the majestic elf.");
				waiting = false;
			}
		}//close while 

		return currentGoodGuy;    
	}//close chooseGoodGuy

	public static BadGuy chooseBadGuy() {
		//randomly choose a monster
      Random randomGenerator = new Random();

		int choice = randomGenerator.nextInt(3) + 1;

		BadGuy currentBadGuy = new Ogre();

		if (choice == 1) {
			currentBadGuy = new Ogre();
		}// close if 1
		else if (choice == 2) {
			currentBadGuy = new Gremlin();
		}//close else if 2
		else if (choice == 3) {
			currentBadGuy = new Skeleton();
		}//close else if 3

		return currentBadGuy;
	}//close chooseBadGuy
   
   */

}//close GoodGuyesVersusBadGuys   