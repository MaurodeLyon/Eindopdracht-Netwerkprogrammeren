package model;

public class ScoreIndependent implements Comparable<ScoreIndependent> {
	
	private int score;
	
	public ScoreIndependent()
	{
		score=0;
	}
	
	public void resetScores()
	{
		score=0;
		
	}
	
	public void IncreaseScore()
	{
		score++;
	}
	
	public int getScore()
	{
		return score;
	}

	@Override
	public int compareTo(ScoreIndependent o) {
		// TODO Auto-generated method stub
		if(score < o.getScore())
		{
			return -1;
		}
		if(score == o.getScore())
		{
			return 0;
		}
		else{
			return 1;
		}
	}


}
