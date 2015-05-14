public class BadGuyFactory
{
   public static BadGuy createBadGuy(int badGuyID)
   {
      BadGuy bg; 
      if(badGuyID < 20)
         bg = new Ogre();
         
      else if(badGuyID < 40)
         bg = new Undead();
        
      else if(badGuyID < 60)
         bg = new Gremlin();
         
      else if(badGuyID < 80)
         bg = new ManBearPig();
         
      else
         bg = new Dragon();
    
      return bg; 
   }

}