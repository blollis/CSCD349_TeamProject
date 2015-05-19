import java.util.*;
import java.io.*;

public class Party {
   private ArrayList<Character> partyMembers;
   private boolean partyActive; 
   private int turnPos;
   protected Random randomGenerator = new Random();
   
	public Party() 
   {
   
      this.partyActive = true;
      ArrayList<Character> partyMembers = new ArrayList<Character>(); 
      this.partyMembers = partyMembers;  
      turnPos = 0;
   
	}//close Party
   
   public void addMember(Character newMember) 
   {
      this.partyMembers.add(newMember);
      sortPartyBySpeed();
   }
   
   public void removeMember(int oldMember) 
   {
      this.partyMembers.remove(oldMember);
   }
   
   public int size() 
   {
      return partyMembers.size();
   }   
   
   public void sortPartyBySpeed() 
   {
      partyMembers.sort(new CharacterSpeedComparator());
   }   
   
   public Character getMember(int i) 
   {
      return partyMembers.get(i);
   }   
   
   public int getTurnPos() {
      return turnPos;
   }  
   
   public void resetTurnPos() {
      turnPos = 0;
   }  
   
   
   public void incrementTurnPos() {
      turnPos++;
   }
   
   public void printStats()
   {
      Character currCharacter;
      
      for (int i = 0; i < this.size(); i++)
      {
         currCharacter = this.getMember(i);
         
         System.out.println((i + 1) + ". " + currCharacter.getName() + ": " + currCharacter.getHP() + "HP");
      }
      
      System.out.println("");
      
   }//close printStats
   
   public void regenerate()
   {
      Character currCharacter;
      
      for (int i = 0; i < this.size(); i++)
      {
         currCharacter = this.getMember(i);
         
         int addedHP = randomGenerator.nextInt(20);
         
         if (currCharacter.getHP() + addedHP < currCharacter.getHPMax())
         {
            currCharacter.setHP(currCharacter.getHP() + addedHP);
         }
         else {
            currCharacter.setHP(currCharacter.getHPMax());
         }   
      }
            
   }//close printStats

   
}//close Party