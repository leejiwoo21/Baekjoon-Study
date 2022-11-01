import java.util.*;

public class Ball {
	 

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String s = in.nextLine();
		String word = in.nextLine();
		String[] ball;
		ball = word.split("");
		
		int start = 0;
		int countLR = 0;
		int countLB =0;
		int countRB = 0;
		int countRR =0;
		int a = 0;
		ArrayList arr = new ArrayList();
		
		for(int i=0;i<N; i++) //왼쪽으로 R모으기
		{
			if(ball[i].equals("R") && start == 1)
			{
				countLR++;
			}
			else if(ball[i].equals("R") && (start== 0)){	
			}
			else if(ball[i].equals("B") && (start == 0))
			{
				start = 1;
			}
			else a++;
		} 
		start = 0;
		
		for(int i=0;i<N; i++) //왼쪽으로 B모으기
		{
			if(ball[i].equals("B") && start == 1)
			{
				countLB++;
			}
			else if(ball[i].equals("B") && (start== 0)){	
			}
			else if(ball[i].equals("R") && (start == 0))
			{
				start = 1;
			}
			else a++;
		} 
		start = 0;
		
		for(int i= N-1; i>-1; i--) // 오른쪽으로 R모으기
		{
			if(ball[i].equals("R") && start == 1)
			{
				countRR++;
			}
			else if(ball[i].equals("R") && (start== 0)){	
			}
			else if(ball[i].equals("B") && (start == 0))
			{
				start = 1;
			}
			else a++;
		} 
		start = 0;
		
		for(int i=N-1;i >-1; i--) //오른쪽으로 B모으기
		{
			if(ball[i].equals("B") && start == 1)
			{
				countRB++;
			}
			else if(ball[i].equals("B") && (start== 0)){	
			}
			else if(ball[i].equals("R") && (start == 0))
			{
				start = 1;
			}
			else a++;
		} 
		
		arr.add(countLB);
		arr.add(countLR);
		arr.add(countRB);
		arr.add(countRR);
		System.out.println(Collections.min(arr));
	}

}
