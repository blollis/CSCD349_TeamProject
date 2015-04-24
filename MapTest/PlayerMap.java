import java.util.*;
import java.io.*;
public class PlayerMap implements Map
{

	private String filePath; 
	private char[][] map; 
	private int exitX;  
	private int exitY; 
	
	public PlayerMap(String filePath)
	{
		this.filePath = filePath; 
		this.exitX = 0; 
		this.exitY = 0; 
	   this.map = buildMap(this.filePath); 

	}

   public void printMap(Map map) 
   {
	   for(int i = 0; i < this.map.length; i++)
      {
         for(int j = 0; j < this.map[i].length; j++)
         {
            System.out.print(this.map[i][j] + " "); 
         }
         System.out.println(); 
      }
      
   }
   
   public void printPlayerMap(Map map) 
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
      
   }
	
   public char[][] buildMap(String filePath) 
   {
      ArrayList<String> lines = new ArrayList();
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
   }
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
					setExitX(i);
					setExitY(j); 
				} 
         }
      }
   }
	
	
	public void setExitX(int x)
	{
		this.exitX = x; 
	}
	
	public void setExitY(int y)
	{
		this.exitY = y; 
	}
	
	public void setChar(int x, int y, char c)
	{
		this.map[y][x] = c; 
	}
	public char getCharAtPosition(int x, int y)
	{
		return this.map[y][x];
	}
	
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

	}
	
	
	
	
	
	
	
}