import java.util.Scanner;

public class Study_201031_1{

	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n=0;
	short add = 0;
	short distance1 = 0;
	short distance2 = 0;
	short distance3 = 0;
	short compare = 0;
	
	System.out.println("input N : ");
	n = in.nextInt();
	for(int i = 0; i<n; i++)
	{
		System.out.println("input 3 distance : ");
		distance1 = in.nextShort();
		distance2 = in.nextShort();
		distance3 = in.nextShort();
		compare = distance1;
		if(distance1<distance2)
			compare = distance2;
		if(distance2<distance3)
			compare = distance3;
		add += compare;
	}
	System.out.printf("%n",add);
	
	}

}
