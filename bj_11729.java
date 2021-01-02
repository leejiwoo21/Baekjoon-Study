/*https://www.acmicpc.net/problem/11729
 * 
 * 하노이탑 문제
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
 * 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 * -입력-
 * 첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
 * -출력-
 * 첫째 줄에 옮긴 횟수 K를 출력한다.
 * 두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
 * 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 */

// 이 코드는 시간초과
// count 함수는 괜찮은데 step에서 비교할 때 오래걸리는 것 같다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_11729 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N = 0; // 원판의 갯수
	static int all = 1;
	static int i = 1;

	static void count(int n) {
		while (i < n) {
			all = (2 * all) + 1;
			i++;
		}
	}

	static void step(int n, int a, int k) { // n개를 a번째 탑에서 k번째 탑으로 이동
		try {
			if (a == 1) {
				if (k == 2) {
					if (n == 1) {
						bw.write("1 2\n");
					} else {
						step(n - 1, a, 3);
						bw.write("1 2\n");
						step(n - 1, 3, k);
					}
				} else {
					if (n == 1) {
						bw.write("1 3\n");
					} else {
						step(n - 1, a, 2);
						bw.write("1 3\n");
						step(n - 1, 2, k);
					}
				}
			} else if (a == 2) {

				if (k == 1) {
					if (n == 1) {
						bw.write("2 1\n");
					} else {
						step(n - 1, a, 3);
						bw.write("2 1\n");
						step(n - 1, 3, k);
					}
				} else {
					if (n == 1) {
						bw.write("2 3\n");
					} else {
						step(n - 1, a, 1);
						bw.write("2 3\n");
						step(n - 1, 1, k);
					}
				}
			} else if (a == 3) {
				if (k == 1) {
					if (n == 1) {
						bw.write("3 1\n");
					} else {
						step(n - 1, a, 2);
						bw.write("3 1\n");
						step(n - 1, 2, k);
					}
				} else {
					if (n == 1) {
						bw.write("3 2\n");
					} else {
						step(n - 1, a, 1);
						bw.write("3 2\n");
						step(n - 1, 1, k);
					}
				}
			}

		} catch (IOException e) {

		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		count(N);
		bw.write(all + "\n");
		step(N, 1, 3);
		bw.flush();
		bw.close();
	}
}
