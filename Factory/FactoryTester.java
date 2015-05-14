import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class FactoryTester
{  

   public static void main(String [] args)
   {  
      int goodGuySize = 10;
      Random randomGenerator = new Random();
      int enemyCount = randomGenerator.nextInt(goodGuySize);//changed this becuase I'm lazy
      Party badGuys = new Party();
      
      for (int i = 0; i <= enemyCount; i++) { //had to change here too dont forget        
         int badGuyID = randomGenerator.nextInt(100);
         BadGuy bg = BadGuyFactory.createBadGuy(badGuyID);
         badGuys.addMember(bg);
      }
      
      System.out.println(); 
   }

}