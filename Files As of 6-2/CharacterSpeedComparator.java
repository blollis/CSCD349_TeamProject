import java.util.Comparator;

public class CharacterSpeedComparator implements Comparator<Character>
{
   @Override
   public int compare(Character char1, Character char2) 
   {     
      return char1.getSpeed() - char2.getSpeed();
   }
}