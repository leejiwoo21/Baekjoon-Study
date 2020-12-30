import java.util.*;

public class Allowance1 {

	static Scanner in = new Scanner(System.in);
	static int N = in.nextInt(); // ��¥
	static int M = in.nextInt(); // ��� Ƚ��
	static long Mcount = 0; // ���� ���� Ƚ��
	static long wallet = 0; // ���� ���� �ݾ�
	static long[] day = new long[N]; // ���� ���� �� ���� �迭
	static long[] arr = new long[N];
	static ArrayList result = new ArrayList(); // �������� ��� ������ K ���� ������ �迭
	static long sum = 0;
	static int count=0;
	/*
	 * k ���� ������ day�� ���� ���� ���� N*day�� �ִ밪 �������� ���ϰ� �Ϸ��� N*10000���� ��
	 */
	

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) // ���� ���� ���� ������� �迭�� ����
		{
			day[i] = in.nextLong();
			arr[i] = day[i];
		}
		Arrays.sort(arr);

		for (int i = 0; i < N ; i++) {
			sum += day[i];
		}
		twojin();

		System.out.println(Collections.min(result));
	}

	public static long FindM(long K) { // �־��� K������ Mcount ã�Ƴ��� �Լ�
		Mcount = 0;
		wallet =0;
		for (int i = 0; i < N; i++) {
			if (wallet < day[i]) {
				Mcount++;
				wallet = K - day[i];
			} else {
				wallet = wallet - day[i];
			}
		}
		return Mcount;
	}

	public static void twojin() {
		long a = arr[N-1]; // K�� �Ϸ翡 ���� �� �߿� ���� ū �� ����
		long b = sum;
		long mid = (a + b) / 2;

		while (count < 2) {
			FindM(mid);
			if (Mcount > M) // Mcount �� M���� ũ�� K�� ���� ���� > K�� �� ū ���� ������� �Ѵ�.
			{
				a = mid ;
				mid = (a + b) / 2;
			
			} else // �����̰ų� K���� �ٿ����� (Mcount = M�� ��찡 ������ ���� �� �ִ�.)
			{
				result.add(mid); // ��� ������ K ���� �迭�� �߰��Ѵ�.
				b = mid ;
				mid = (a + b) / 2;
			}
			if(a == mid) count ++;
		}
	}
}
