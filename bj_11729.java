/*https://www.acmicpc.net/problem/11729
 * 
 * �ϳ���ž ����
 * �� ���� ��밡 �ְ� ù ��° ��뿡�� �ݰ��� ���� �ٸ� n���� ������ �׿� �ִ�. 
 * �� ������ �ݰ��� ū ������� �׿��ִ�. ���� �����µ��� ���� ��Ģ�� ���� ù ��° ��뿡�� �� ��° ���� �ű�� �Ѵ�.
 * �� ���� �� ���� ���Ǹ��� �ٸ� ž���� �ű� �� �ִ�.
 * �׾� ���� ������ �׻� ���� ���� �Ʒ��� �ͺ��� �۾ƾ� �Ѵ�.
 * �� �۾��� �����ϴµ� �ʿ��� �̵� ������ ����ϴ� ���α׷��� �ۼ��϶�. ��, �̵� Ƚ���� �ּҰ� �Ǿ�� �Ѵ�.
 * -�Է�-
 * ù° �ٿ� ù ��° ��뿡 ���� ������ ���� N (1 �� N �� 20)�� �־�����.
 * -���-
 * ù° �ٿ� �ű� Ƚ�� K�� ����Ѵ�.
 * �� ��° �ٺ��� ���� ������ ����Ѵ�. �� ��° �ٺ��� K���� �ٿ� ���� �� ���� A B�� ��ĭ�� ���̿� �ΰ� ����ϴµ�,
 * �̴� A��° ž�� ���� ���� �ִ� ������ B��° ž�� ���� ���� �ű�ٴ� ���̴�.
 */

// �� �ڵ�� �ð��ʰ�
// count �Լ��� �������� step���� ���� �� �����ɸ��� �� ����.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_11729 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N = 0; // ������ ����
	static int all = 1;
	static int i = 1;

	static void count(int n) {
		while (i < n) {
			all = (2 * all) + 1;
			i++;
		}
	}

	static void step(int n, int a, int k) { // n���� a��° ž���� k��° ž���� �̵�
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
