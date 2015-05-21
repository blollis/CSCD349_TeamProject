public class BadGuyFactory
{
   public static BadGuy createBadGuy(int badGuyID)
   {
      BadGuy bg; 
      if(badGuyID < 20)
         bg = new Zombie();
         
      else if(badGuyID < 40)
         bg = new Skeleton();
        
      else if(badGuyID < 55)
         bg = new Gremlin();
         
      else if(badGuyID < 68)
         bg = new Ogre();
         
      else if(badGuyID < 80)
         bg = new Orc();
         
      else if(badGuyID < 85)
         bg = new Cyclops();
         
      else if(badGuyID < 95)
         bg = new ManBearPig();
         
      else
         bg = new Dragon();
    
      return bg; 
   }

}