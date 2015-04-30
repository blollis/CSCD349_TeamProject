public class Player
{
	private int xCoord; 
	private int yCoord; 
   private boolean gameOver; 

	public Player(int x, int y) 
	{
		this.xCoord = x; 
		this.yCoord = y; 
      this.gameOver = false; 
	}
	
	public boolean testMovePlayer(int direction, PlayerMap myMap)
	{
		int x = this.getXCoord();
		int y = this.getYCoord(); 
		
		if(direction == 1)
			y--;  
				
		else if(direction == 2)
			y++; 
		
		else if(direction == 3)
			x--;
		
		else if(direction == 4)
			x++; 
		
		else
		{
			x = x; 
			y = y; 
		}
		boolean validMove = checkIfValidMove(x, y, myMap);
		if(validMove)
		{
			updatePlayerLocation(x, y); 
		}
		return validMove;
	}
	
	public boolean checkIfValidMove(int x, int y, PlayerMap myMap)
	{ 
		char myChar = myMap.getCharAtPosition(x, y);
		if(myChar != '*')
		{
			this.setXCoord(x);
			this.setYCoord(y);
         
         if(myChar == 'X')
            this.setGameState(true); 
            
			return true; 
		}	
			return false; 
	}
	public void updatePlayerLocation(int x, int y)
	{
		setXCoord(x);
		setYCoord(y); 
	}
	
	public void setXCoord(int x)
	{
		this.xCoord = x; 
	}
	
	public void setYCoord(int y)
	{
		this.yCoord = y; 
	}
	
	public int getXCoord()
	{
		return this.xCoord; 
	}
	
	public int getYCoord()
	{
		return this.yCoord; 
	}
   
   public boolean getGameState()
	{
		return this.gameOver; 
	}
   
   public void setGameState(boolean gameState)
	{
	   this.gameOver = gameState; 
	}
	
}