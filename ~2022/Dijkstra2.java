import java.util.*;
public class Dijkstra2 {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int e = in.nextInt();
	static int[][] distance = new int[n][n];
	static int[] d = new int[n];
	static boolean[] v = new boolean[n]; // 초기화 안하면 false
	
	public static void setDistance()
	{
		int start ;
		int arrive ;
		for(int i =0; i<n; i++)
		{
			for(int j=0;j<n;j++)
			{
				distance[i][j] = 200001;
			}
		}
		for(int i = 0; i<e; i++) // 배열 입력받기
		{
			start = in.nextInt() -1; 
			arrive = in.nextInt() -1;
			distance[start][arrive] = in.nextInt();
			distance[arrive][start] = distance[start][arrive];
		}
	}
	public static int getSmallIndex(int s)
	{
		int min = 200002;
		int index = 0;
		for(int i=0; i<n; i++) {
			if(distance[s][i] <= min)
			{
				min = distance[s][i];
				index = i;
			}
		}
		return index;
	}
	public static void dijkstra(int s)
	{
		for(int i =0; i<n; i++)
		{
			d[i] = distance[s][i];
		}
		v[s] = true;
		for (int i = 0; i < n; i++) 
		{
			v[i] = false;
		}

		for(int i =0; i<n; i++)
		{
			int current = getSmallIndex(i);
			v[current] = true;
			for(int j =0; j<n; j++)
			{
				if(!v[i] && ((d[s] + distance[i][current]) < d[i] ) )
				{
					d[i] = d[s] + distance[i][current];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		setDistance();
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		
		dijkstra(0);
		int d1 = d[n1-1];
		int d2 = d[n2-1];
		
		dijkstra(n1-1);
		int n1_n2 = d[n2];
		int n1_N = d[n-1];
		
		dijkstra(n2-1);
		int n2_N = d[n-1];
		
		int way1 = d1+ n1_n2 + n2_N ;
		int way2 = d2 + n1_n2 + n1_N;
		
		if(way1 >200000 && way2 > 200000)
		{
			System.out.println("-1");
		}
		else if(way1 >= way2)
		{
			System.out.printf("%d", way2);
		}
		else
		{
			System.out.printf("%d", way1);			
		}

	}

}
