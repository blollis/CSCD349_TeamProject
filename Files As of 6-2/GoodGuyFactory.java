import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GoodGuyFactory
{
   private ArrayList<GoodGuy> goodGuyChoices;
   
   public GoodGuyFactory ()
   {
      goodGuyChoices = new ArrayList<GoodGuy>();
      
      GoodGuy tempChar;
      
      tempChar = new Archer();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Wizard();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Elf();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Warrior();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Druid();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Paladin();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Cleric();
      goodGuyChoices.add(tempChar);
      
      tempChar = new Necromancer();
      goodGuyChoices.add(tempChar);
   }     

   public void printHeroChoices()
   {
      GoodGuy tempChar;
      
      for (int i = 0; i < goodGuyChoices.size(); i++)
      {
         tempChar = goodGuyChoices.get(i);
         
         System.out.println((i + 1) + ". " + tempChar.printStats());
      }   
   }
 
   public Party chooseHeroes()
   {  
      //create new Party to be returned
      Party goodGuys = new Party();
      
      //get the choice of goodGuy from the user
      Scanner kb = new Scanner(System.in);
      
		for (int i = 0; i <= 3; i++) {         
         System.out.println("Please choose a member for your party:");
      
         //print available goodGuyes
         printHeroChoices();
         
         int choice = 99;
         
         GoodGuy tempChar;
                
         do 
         {
            //checks that the user input was valid      
            try 
            {
         	  choice = kb.nextInt();
            } catch (InputMismatchException e) 
            {
               kb.nextLine();
               
               System.out.println("\nPlease enter a number from the list of good guys.");
            }//close try-catch
         }
         while (choice < 1 || choice > goodGuyChoices.size());
         
         //adds a member to party based on choice
         if (choice == 1) 
            goodGuys.addMember(new Archer());
            
         else if (choice == 2) 
            goodGuys.addMember(new Wizard());
            
         else if (choice == 3) 
            goodGuys.addMember(new Elf());
            
         else if (choice == 4) 
            goodGuys.addMember(new Warrior());   
         
         else if (choice == 5) 
            goodGuys.addMember(new Druid());
            
         else if (choice == 6) 
            goodGuys.addMember(new Paladin());
            
         else if (choice == 7) 
            goodGuys.addMember(new Cleric()); 
            
         else if (choice == 8) 
            goodGuys.addMember(new Necromancer()); 
      }      
    
      return goodGuys; 
   }

}