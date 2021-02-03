
/*����
�� ������ ���� ����� �賶�� ���� �����̴�.

�� �� �ĸ� ������ �θ��� �ް� �Ǵ� �ؼ��� ������ ������ �Ѵ�. ������� ������ �����ϸ� �ִ��� ���� ���� �����̱� ������, ������ �ٴ� �賶 ���� �ִ��� ��ġ �ְ� �η��� �Ѵ�.

�ؼ��� ���࿡ �ʿ��ϴٰ� �����ϴ� N���� ������ �ִ�. �� ������ ���� W�� ��ġ V�� �����µ�, �ش� ������ �賶�� �־ ���� �ؼ��� V��ŭ ��� �� �ִ�. ���� �౺�� �غ� ���� ���� �ؼ��� �ִ� K��ŭ�� ���Ը��� ���� �� �ִ� �賶�� ��� �ٴ� �� �ִ�. �ؼ��� �ִ��� ��ſ� ������ �ϱ� ���� �賶�� ���� �� �ִ� ���ǵ��� ��ġ�� �ִ��� �˷�����.

�Է�
ù �ٿ� ��ǰ�� �� N(1 �� N �� 100)�� �ؼ��� ��ƿ �� �ִ� ���� K(1 �� K �� 100,000)�� �־�����. �� ��° �ٺ��� N���� �ٿ� ���� �� ������ ���� W(1 �� W �� 100,000)�� �ش� ������ ��ġ V(0 �� V �� 1,000)�� �־�����.

�Է����� �־����� ��� ���� �����̴�.

���
�� �ٿ� �賶�� ���� �� �ִ� ���ǵ��� ��ġ���� �ִ��� ����Ѵ�.
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.valueOf(s[0]);
		int K = Integer.valueOf(s[1]);
		bag(N,K);
	}

	private static void bag(int N, int K) throws IOException {
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i < N+1; i++) {
			String[] s = br.readLine().split(" ");
			int w = Integer.valueOf(s[0]);
			int v = Integer.valueOf(s[1]);
			for (int j = 1; j < K+1; j++) {
				if(w<=j) {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
				}
				else if(w>j) {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
