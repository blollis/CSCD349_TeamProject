import java.util.*;
import java.io.*;
public class PlayerMap implements Map
{

	private String filePath; 
	private char[][] map;   
	
	public PlayerMap(String filePath)
	{
		this.filePath = filePath; 
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
            System.out.print(this.map[i][j] + " "); 
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
         }
      }
   }
}