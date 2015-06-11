package model;

import java.io.Serializable;

public class Score implements Serializable, Comparable<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int player1,player2;
	
	public Score()
	{
		player1=0;
		player2=0;
		
	}
	
	public void resetScores()
	{
		player1=0;
		player2=0;
		
	}
	
	public void IncreaseScore(String player)
	{
		if(player.equals("p1"))
		{
			player1++;
		}
		else{
			player2++;
		}
	}
	
	public int getScore(String player)
	{
		if(player.equals("p1"))
		{
			return player1;
		}
		
		return player2;
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
