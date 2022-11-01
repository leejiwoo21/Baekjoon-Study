import java.util.ArrayList;
import java.util.Scanner;

public class RGB2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int total = 0;
		ArrayList R = new ArrayList();
		ArrayList G = new ArrayList();
		ArrayList B = new ArrayList();
		int compare = 0;
		n = in.nextInt();
		int cost = 0;
		int jiwoo = 0;
		for(int i = 0; i < n ; i ++)
		{
			cost = in.nextInt();
			R.add(cost);
			cost = in.nextInt();
			G.add(cost);
			cost = in.nextInt();
			B.add(cost);
		}
		for(int i = 0; i < n; i ++)
		{
			jiwoo = 0;
			compare = (int)R.get(i);
			if(compare>(int)G.get(i))
			{
				compare = (int)G.get(i);
				G.add(0);
				G.set(i+1,1001);
				jiwoo=1;
			}
			if(compare>(int)B.get(i))
			{
				compare = (int)B.get(i);
				B.add(0);
				B.set(i+1,1001);
				jiwoo =1;
			}
			if(jiwoo == 0)
			{
				R.add(0);
				R.set(i+1,1001);
			}
			total += compare;
		}
		System.out.printf("%d",total);
		
		}

}
