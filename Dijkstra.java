import java.util.Scanner;

public class Dijkstra {
	static Scanner in = new Scanner(System.in);
	static int n = 0;
	int e = 0;
	int start = 0; // ���� ����
	int arrive = 0; // ���� ����
	static int[][] arr = new int[800][800]; // start > arrive ���������� �Ÿ�
	static boolean v[]; // ������ �������� Ȯ���� �迭
	static int[] dStart; // ������������ �� ���������� �Ÿ��� ������ �迭

	public static int getSmallIndex(int start) // start �������� ���� ����� ������ ã���ش�
	{
		int min = 200001; // �ּҰŸ� ����
		int index = 0; // ����
		for (int i = 0; i < n; i++) 
		{
			if (arr[start][i] < min && v[i] == false) 
			{
				min = arr[start][i] ;   //������
				index = i;
			}
		}
		return index;
	}

	public static void dijkstra(int start) {
		for (int i = 0; i < n; i++) {
			dStart[i] = arr[start][i];
		}
		dStart[start]=0;
		for (int i = 0; i < n; i++) {
			int current = getSmallIndex(start);
			v[current] = true;
			for (int j = 0; j < n; j++) {
				if (!v[j]) {
					if (dStart[current] + arr[current][j] < dStart[j]) {
						dStart[j] = dStart[current] + arr[current][j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = in.nextInt(); // ������ ��
		int e = in.nextInt(); // ����� ��
		int start = 0; // ���� ����
		int arrive = 0; // ���� ����
		int[][] Arr = new int[n][n]; // start > arrive ���������� �Ÿ�
		boolean v[] = new boolean[n]; // ������ �������� Ȯ���� �迭
		int[] dStart = new int[n]; // ������������ �� ���������� �Ÿ��� ������ �迭
		
		for (int i = 0; i < n; i++) // ó���� �ƹ����� �� ��ȱ� ������ false�� �ʱ�ȭ
		{
			v[i] = false;
		}
		for (int i = 0; i < n; i++) // ��� ����� �Ÿ��� ���� ������ ����(���߿� ���ͽ�Ʈ�� �Լ��� ����� �� 0���� ������ �ʵ��� �ϱ�����)
		{

			for (int j = 0; j < n; j++) {
				arr[i][j] = 200001;
			}
		}
		for (int i = 0; i < e; i++) // ���������� �Ÿ� �Է¹ޱ�
		{
			start = in.nextInt();
			arrive = in.nextInt();
			Arr[start-1][arrive-1] = in.nextInt();
		}
		int n1 = in.nextInt(); // ��������1
		int n2 = in.nextInt(); // ��������2
		
		dijkstra(0);
		int d1 = dStart[n1-1]; // 0�������� ��������1���� �Ÿ� ����
		int d2 = dStart[n2-1]; // 0�������� ��������2���� �Ÿ� ����
		for (int i = 0; i < n; i++) // ó���� �ƹ����� �� ��ȱ� ������ false�� �ʱ�ȭ
		{
			v[i] = false;
		}
		
		dijkstra(n1-1);
		int n1_N = dStart[n-1]; // 1�� ������������ N���� �Ÿ�
		int n1_n2 = dStart[n2-1]; // �������� ������ �Ÿ�
		for (int i = 0; i < n; i++) // ó���� �ƹ����� �� ��ȱ� ������ false�� �ʱ�ȭ
		{
			v[i] = false;
		}
		
		dijkstra(n2-1);
		int n2_N = dStart[n-1]; // 2�� ������������ N���� �Ÿ�
		
		if((d1 + n1_n2 + n2_N >= 200000) && (d2 + n1_n2 + n2_N >= 200000))
		{
			System.out.println("-1");
		}
		else if((d1 + n1_n2 + n2_N) >= (d2 + n1_n2 + n2_N))
		{
			System.out.printf("%d",d2 + n1_n2 + n2_N );
		}
		else
		{
			System.out.printf("%d",d1 + n1_n2 + n2_N);
		}

	}
}
