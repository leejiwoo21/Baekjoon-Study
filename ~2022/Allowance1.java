import java.util.*;

public class Allowance1 {

	static Scanner in = new Scanner(System.in);
	static int N = in.nextInt(); // 날짜
	static int M = in.nextInt(); // 출금 횟수
	static long Mcount = 0; // 내가 꺼낸 횟수
	static long wallet = 0; // 현재 보유 금액
	static long[] day = new long[N]; // 매일 쓰는 돈 저장 배열
	static long[] arr = new long[N];
	static ArrayList result = new ArrayList(); // 마지막에 사용 가능한 K 값을 저장할 배열
	static long sum = 0;
	static int count=0;
	/*
	 * k 값의 범위는 day의 가장 작은 값과 N*day의 최대값 사이지만 편하게 하려고 N*10000으로 함
	 */
	

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) // 매일 쓰는 돈을 순서대로 배열에 저장
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

	public static long FindM(long K) { // 주어진 K값에서 Mcount 찾아내는 함수
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
		long a = arr[N-1]; // K는 하루에 쓰는 돈 중에 가장 큰 값 저장
		long b = sum;
		long mid = (a + b) / 2;

		while (count < 2) {
			FindM(mid);
			if (Mcount > M) // Mcount 가 M보다 크면 K가 작은 것임 > K에 더 큰 값을 더해줘야 한다.
			{
				a = mid ;
				mid = (a + b) / 2;
			
			} else // 정답이거나 K값을 줄여야함 (Mcount = M인 경우가 여러개 있을 수 있다.)
			{
				result.add(mid); // 사용 가능한 K 값을 배열에 추가한다.
				b = mid ;
				mid = (a + b) / 2;
			}
			if(a == mid) count ++;
		}
	}
}
