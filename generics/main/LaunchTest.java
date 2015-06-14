package main;

public class LaunchTest {
	
	
	public static void main(String[] args)
	{
		Rectangle test1 = new Rectangle(10,2);
		Rectangle test2 = new Rectangle(5,7);
		sumAreas(test1,test2);
		
		//TO GET A COMPILE ERROR RUN THE CODE BELOW
		//Line line = new Line(2,2);
		//sumAreas(test1,line);
	}
	
	public static <E extends Shape> void sumAreas(E o, E o2)
	{
		System.out.println(o.area()+o2.area());
	}

}
