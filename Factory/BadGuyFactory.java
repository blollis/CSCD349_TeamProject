public class BadGuyFactory
{
   public static BadGuy createBadGuy(int badGuyID)
   {
      BadGuy bg; 
      if(badGuyID < 50)
         bg = new Undead();
         
      else if(badGuyID < 75)
         bg = new Gremlin();
        
      else if(badGuyID < 90)
         bg = new Orge();
         
      else if(badGuyID < 98)
         bg = new ManBearPig();
         
      else
         bg = new Dragon();
    
      return bg; 
   }

}