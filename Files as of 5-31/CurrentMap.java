import java.util.*;
import java.io.*;
public class CurrentMap
{

	private String filePath; 
	private char[][] map; 
	private int exitX;  
	private int exitY; 
   private int partyX;
   private int partyY;
   private boolean reachedExit;
	
	public CurrentMap()
	{
		this.filePath = filePath; 
		this.exitX = 0; 
		this.exitY = 0; 
	   this.map = buildMap(getMapChoice()); 
      
      partyX = 1;
      partyY = 1;
      
      reachedExit = false;

	}//close DVC
      
   public boolean reachedExit() {
      return reachedExit;
   }//close reachedExit 
	
   //step 1 for creating a map
   //builds a map by writing characters from a given file into a string object
   public char[][] buildMap(String filePath) 
   {
      ArrayList<String> lines = new ArrayList<String>();
      int rows = 0, cols = 0;
	   try
      {
         BufferedReader br = new BufferedReader(new FileReader(filePath));
         String line;
         
         try
         {
            while ((line = br.readLine()) != null) 
            { 
               lines.add(line); 
            }
            
         }
         catch(IOException e)
         {
            System.out.println("IO Exception");
         }
         
            cols = lines.get(0).length();
            rows = lines.size();
            map = new char[rows][cols];  
      }
      
      catch(FileNotFoundException e)
      {
         System.out.println("File not found!");
      }
      
      fillMap(lines); 
      
      return map;    
             
   }//close buildMap
   
   //step 2 for creating a map
   //fills the map with the characters from the string object, sets exit accordingly
   public void fillMap(ArrayList lines)
   {
      int a = map.length;
      int b = map[0].length; 
      for(int i = 0; i < map.length; i++)
      {
         for(int j = 0; j < map[i].length; j++)
         {
            String line = (String)lines.get(i);
            map[i][j] = line.charAt(j);
				if(line.charAt(j) == '2')
				{
					exitX = i;
					exitY = j; 
				} 
         }
      }
   }//close fillMap
   
	//allows user to choose a map (map choices are included as text files)
	public static String getMapChoice()
	{
      System.out.println("Welcome to Heroes and Monsters. Please choose a map difficulty: "); 
      System.out.println("1: Easy");
      System.out.println("2: Medium");
      System.out.println("3: Hard");
        
		String mapChoice = "EasyMap.txt";
		int choice = 0; 
		do{
         Scanner user_input = new Scanner( System.in );
         
         try
         {
            choice = user_input.nextInt(); 
         }
         
         catch(InputMismatchException e)
         {
            System.out.println("You must enter 1, 2, or 3.");
         }
      }while(choice <= 0 || choice > 3);  
		
      if(choice == 1)
			mapChoice = "EasyMap.txt";
			
		else if(choice == 2)
			mapChoice = "MediumMap.txt";
			
		else if(choice == 3)	
			mapChoice = "HardMap.txt";
			
		else
		 	mapChoice = "EasyMap.txt";	
			
		return mapChoice;
	}//close getMapChoice
   
   //allows user to choose a direction to move
	public static String getMoveDirection()
	{
		String dir = "X";
		
      do{
         Scanner user_input = new Scanner( System.in );
         System.out.println("\nPick the direction you'd like to move:"); 
         System.out.println("W: Up   \t S: Down \t A: Left \t D: Right \t 0: Quit");
         
         try
         {
            dir = user_input.nextLine().toUpperCase(); 
         }
         
         catch(Exception e)
         {
            System.out.println("Enter W, A, S, D or 0 please!");
         }
      } while(!checkValidDirInput(dir));  
			
		return dir;
      
	}//close getMoveDirection
   
   //checks that the direction the user asked is a valid direction choice
   private static boolean checkValidDirInput (String x)
   {
      if (x.compareToIgnoreCase("W") == 0) 
      {
         return true;
      }
      else if (x.compareToIgnoreCase("A") == 0) 
      {
         return true;
      }
      else if (x.compareToIgnoreCase("S") == 0) 
      {
         return true;
      }
      else if (x.compareToIgnoreCase("D") == 0) 
      {
         return true;
      }
      else if (x.compareToIgnoreCase("0") == 0) 
      {
         return true;
      }
      else
      {
         return false;
      }   
   
   }//close checkValidDirInput
   
   //gets the opposite direction from what the user just moved
   public String getOppositeDirection(String x)
   {
      if (x.compareToIgnoreCase("W") == 0) 
      {
         return "S";
      }
      else if (x.compareToIgnoreCase("A") == 0) 
      {
         return "D";
      }
      else if (x.compareToIgnoreCase("S") == 0) 
      {
         return "W";
      }
      else
      {
         return "A";
      }
   }//close getOppositeDirection
   
   //moves player the chosen direction
   public void movePlayer(String direction)
	{
		int x = this.partyX;
		int y = this.partyY; 
		
      if (direction.compareToIgnoreCase("W") == 0) 
      {
         y--;
      }
      else if (direction.compareToIgnoreCase("A") == 0) 
      {
         x--;
      }
      else if (direction.compareToIgnoreCase("S") == 0) 
      {
         y++;
      }
      else if (direction.compareToIgnoreCase("D") == 0) 
      {
         x++; 
      }
   
  		boolean validMove = checkIfValidMove(x, y);
		
      if(validMove)
		{
		   this.partyX = x;
			this.partyY = y; 
         
         updateMapForPlayerLocation(partyX, partyY);   
		}
      else 
      {
         System.out.println("Your party can't move this direction.");
         
         String newDirection = getMoveDirection();
         
         movePlayer(newDirection);
      }   

	}//close movePlayer
	
   //checks that the move that the player tried to make is a valid move and if they've reached the exit
	public boolean checkIfValidMove(int x, int y)
	{ 
		char myChar = this.map[y][x];
		
      if(myChar != '*')
		{
         if (myChar == 'X') {
            reachedExit = true;
         }
            
			return true; 
		}	
		
      return false; 
	}//close checkIfValidMove 
   
   //updates player's position on the map
   public void updateMapForPlayerLocation(int x, int y)
	{
		for(int i = 0; i < this.map.length; i++)
      {
         for(int j = 0; j < this.map[i].length; j++)
         {	
				if(this.map[i][j] == 'P')
            	this.map[i][j] = '0'; 					
         }
			this.map[y][x] = 'P'; 
 
      }
	}//close updateMapForPlayerLocation
   
   //use this print map for developer views
   public void printDevMap() 
   {
	   for(int i = 0; i < this.map.length; i++)
      {
         for(int j = 0; j < this.map[i].length; j++)
         {
            System.out.print(this.map[i][j] + " "); 
         }
         System.out.println(); 
      }
      
   }//close printMap
   
   //use this print map for player views
   public void printCurrentMap() 
   {
	   for(int i = 0; i < this.map.length; i++)
      {
         for(int j = 0; j < this.map[i].length; j++)
         {	
				if(this.map[i][j] != '0')
            	System.out.print("[ " + this.map[i][j] + " ]"); 
				else
					System.out.print("[   ]");
         }
         System.out.println(); 
      }
   }//close printCurrentMap
	
}//close CurrentMap