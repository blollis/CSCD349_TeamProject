//interface to be used by all attacks 
public interface Attack {
   abstract void useAttack(Character attacker, Character defender);   
   abstract String getName();
}