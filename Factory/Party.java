import java.util.*;
import java.io.*;

public class Party {
   private ArrayList<Character> partyMembers;
   private boolean partyActive; 
   
	public Party() 
   {
   
      this.partyActive = true;
      ArrayList<Character> partyMembers = new ArrayList<Character>(); 
      this.partyMembers = partyMembers;  
   
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
   
}//close Party