package model;

import java.util.Comparator;

public class ScoreChecker implements Comparator<ScoreIndependent>{

	
	

	@Override
	public int compare(ScoreIndependent o1, ScoreIndependent o2) {
		// TODO Auto-generated method stub
		if(o1.getScore() < o2.getScore())
		{
			return -1;
		}
		if(o1.getScore() == o2.getScore())
		{
			return 0;
		}
		else{
			return 1;
		}
	}

	

}
