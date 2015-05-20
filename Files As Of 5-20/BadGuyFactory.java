public class BadGuyFactory
{
   public static BadGuy createBadGuy(int badGuyID)
   {
      BadGuy bg; 
      if(badGuyID < 15)
         bg = new Ogre();
         
      else if(badGuyID < 26)
         bg = new Gremlin();
        
      else if(badGuyID < 40)
         bg = new Skeleton();
         
      else if(badGuyID < 58)
         bg = new Zombie();
         
      else if(badGuyID < 72)
         bg = new ManBearPig();
         
      else if(badGuyID < 85)
         bg = new Cyclops();
         
      else if(badGuyID < 95)
         bg = new Orc();
         
      else
         bg = new Dragon();
    
      return bg; 
   }

}