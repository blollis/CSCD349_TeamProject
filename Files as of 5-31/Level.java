public class Level 
{
   private int level;
   
   public void setLevel(int x) 
   {
      this.level = x;
   }
   
   public int getLevel() 
   {
      return this.level;
   } 
   
   public void updateLevel(GoodGuy character)
   {
      int tempLevel = 0;
      
      if (character.getXP() <= 8)
         tempLevel = 0;
         
       else if (character.getXP() > 8 && character.getXP() < 15)
         tempLevel = 1;
      
      else if (character.getXP() >= 15 && character.getXP() < 25)
         tempLevel = 2;
      
      else if (character.getXP() >= 25 && character.getXP() < 45)
         tempLevel = 3;
      
      else if (character.getXP() >= 45 && character.getXP() < 70)
         tempLevel = 4;
      
      else 
         tempLevel = 5;
      
      
      if (tempLevel != this.level) 
      {
         System.out.println("Congratulations! " + character.getName() + " leveled up to " + tempLevel + "!");
         
         if (tempLevel == 1)
         {
            updateLevel_1(character);
            System.out.println(character.getName() + "'s maximum and minimum damage values have increased and all damage has been healed!\n");
         }   
         
         else if (tempLevel == 2)
         {
            updateLevel_2(character);
            System.out.println(character.getName() + "'s maximum HP has increased and all damage has been healed!\n");
         }  
         
         else if (tempLevel == 3)
         {
            updateLevel_3(character);
            System.out.println(character.getName() + " learned a new special attack and all damage has been healed!\n");
         }  
         
         else if (tempLevel == 4)
         {
            updateLevel_4(character);
            System.out.println(character.getName() + "'s speed has increased and all damage has been healed!\n");
         }  
         
         else 
         {
            updateLevel_5(character);
            System.out.println(character.getName() + "'s hit chance is now 100% and all damage has been healed!\n");
         } 
         
         //character's HP gets increased to it's max
         character.setHP(character.getHPMax()); 
         
      }
      
      this.level = tempLevel;
   }
   
   private void updateLevel_1(GoodGuy character) 
   {      
      //character gets increased damageMin and damageMax
      int damageMin = character.getDamageMax();
      
      character.setDamageMin(damageMin);
      
      character.setDamageMax(damageMin *2);
      
   }  
   
   private void updateLevel_2(GoodGuy character) 
   {
      //character gets higher HPMax
      int HPMax = character.getHPMax();
      
      character.setHPMax((int)(HPMax * 0.5) + HPMax); 
   } 
   
   private void updateLevel_3(GoodGuy character) 
   {
      //character learns a new attack
      character.addSecondSpecial();
   } 
   
   private void updateLevel_4(GoodGuy character) 
   {
      //character's speed increases
      character.setSpeed(character.getSpeed() + 2);
   } 
   
   private void updateLevel_5(GoodGuy character) 
   {      
      //character's hit chance becomes 100%
      character.setHitChance(1.0);
   } 
}