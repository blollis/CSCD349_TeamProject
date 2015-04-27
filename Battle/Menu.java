public class Menu
{
   public static Good heroSelection()
   {//Where the player can choose which character to play as
      Scanner kb = new Scanner(System.in);
      System.out.println("\nSelect your character:" +
                         "\n1) Human Defender" +
                         "\n2) Dwarf Ranger" +
                         "\n3) Elf Wizard" +
                         "\n4) Orc Warrior" +
                         "\n5) Monk Cleric");
      int choice = (kb.nextInt())
      if(choice == 1)
			return new Defender();
		else if(choice == 2)
			return new Ranger();
		else if(choice == 3)
			return new Wizard();
      else if(choice == 4)
			return new Warrior();
      else if(choice == 5)
			return new Cleric();
      else
			System.exit(-1);
   }//End of heroSelection()
   
   public void startMenu()
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("\nStart Menu:" +
                         "\n1) Move" +          //takes you to the move menu
                         "\n2) Invetory" +      //takes you to the inventory menu
                         "\n3) Party Members" + //party menu
                         "\n4) Quite");         //exits the game
      int choice = (kb.nextInt())
      if(choice == 1)
			moveMenu();
		else if(choice == 2)
			invetoryMenu();
		else if(choice == 3)
			partyMenu();
      else if(choice == 4)
			System.exit(-1);
      else
		   startMenu();//restarts the menu (like a while loop and could be changed to a loop)
         
   }//End of startMenu()
      
   public void invetoryMenu()
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("\nWhat Items do you want to look at:" +
                         "\n1) Weapons" +        
                         "\n2) Armor" +
                         "\n3) Potions" +
                         "\n4) Start Menu");  //Goes back to the start menu
      int choice = (kb.nextInt())
      if(choice == 1)
			weaponsMenu();
		else if(choice == 2)
			armorMenu();
		else if(choice == 3)
			potionMenu();
      else
		   startMenu();
   }

   public void partyMenu(Character player, Character enemy)
   {
      System.out.println(player.getName() + " HP: " + player.getHp());
      attackMenu(player, enemy);
   }

}