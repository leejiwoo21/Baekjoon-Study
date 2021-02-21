
/*
 * ����
��� ť��� ������ �����̴�. ���� ��� ť��� 3��3��3���� ���� ������ü�� �̷���� �ִ�. ������ Ǯ���� �� �鿡 �ִ� ��ȩ ���� ���� ������ü�� ���� �����ؾ� �Ѵ�.

ť��� �� ���� ��������� 90�� ��ŭ ���� �� �ֵ��� ������� �ִ�. ȸ���� ��ģ ���Ŀ���, �ٸ� ���� ���� �� �ִ�. �̷��� ť���� ���� �ٸ� ���� ������ ����, ���� ���� �� �ִ�.

�� ���������� ��� ť�갡 ��� Ǯ�� ���¿��� �����Ѵ�. �� ���� ���, �Ʒ� ���� �����, �� ���� ������, �� ���� ��������, ���� ���� �ʷϻ�, ������ ���� �Ķ����̴�.

��� ť�긦 ���� ����� ������� �־�����. �̶�, ��� ���� ������ ���� �� ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �׽�Ʈ ���̽��� �ִ� 100���̴�. �� �׽�Ʈ ���̽��� ������ ���� �����Ǿ��� �ִ�.

ù° �ٿ� ť�긦 ���� Ƚ�� n�� �־�����. (1 �� n �� 1000)
��° �ٿ��� ť�긦 ���� ����� �־�����. �� ����� �������� ���еǾ��� ������, ù ��° ���ڴ� ���� ���̴�. U: �� ��, D: �Ʒ� ��, F: �� ��, B: �� ��, L: ���� ��, R: ������ ���̴�. �� ��° ���ڴ� ���� �����̴�. +�� ��쿡�� �ð� ���� (�� ���� �ٶ���� ���� ����), -�� ��쿡�� �ݽð� �����̴�.
���
�� �׽�Ʈ ���̽��� ���ؼ� ť�긦 ��� ���� ���� �� ���� ������ ����Ѵ�. ù ��° �ٿ��� �� ��� ���ϴ� ĭ�� ���� ����ϰ�, �� ��°, �� ��° ���� ������� ����ϸ� �ȴ�. ����� w, ������� y, �������� r, ���������� o, �ʷϻ��� g, �Ķ����� b.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class bj_5373_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static HashMap<Integer, String> U = new HashMap<Integer, String>();
	static HashMap<Integer, String> D = new HashMap<Integer, String>();
	static HashMap<Integer, String> R = new HashMap<Integer, String>();
	static HashMap<Integer, String> L = new HashMap<Integer, String>();
	static HashMap<Integer, String> F = new HashMap<Integer, String>();
	static HashMap<Integer, String> B = new HashMap<Integer, String>();
	static HashMap<Integer, String> C = new HashMap<Integer, String>(); // C = Copy�� ����

	private static void Turn(int n) throws IOException {

		String[] s = br.readLine().split(" "); // ȸ�� ����
		
		for (int i = 0; i < n; i++) {
			String turn = s[i];
			// UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUuu
			if (turn.equals("U-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, U.get(j));
				}
				// ����
				U.put(1, C.get(3));
				U.put(2, C.get(6));
				U.put(3, C.get(9));
				U.put(4, C.get(2));
				U.put(5, C.get(5));
				U.put(6, C.get(8));
				U.put(7, C.get(1));
				U.put(8, C.get(4));
				U.put(9, C.get(7));
				// ����
				for (int j = 1; j < 4; j++) {
					C.put(j, F.get(j));
				}
				for (int j = 1; j < 4; j++) {
					F.put(j, L.get(j));
				}
				L.put(1, B.get(3));
				L.put(2, B.get(2));
				L.put(3, B.get(1));
				
				B.put(1, R.get(3));
				B.put(2, R.get(2));
				B.put(3, R.get(1));
				
				for (int j = 1; j < 4; j++) {
					R.put(j, C.get(j));
				}
			} else if (turn.equals("U+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, U.get(j));
				}
				U.put(1, C.get(7));
				U.put(2, C.get(4));
				U.put(3, C.get(1));
				U.put(4, C.get(8));
				U.put(5, C.get(5));
				U.put(6, C.get(2));
				U.put(7, C.get(9));
				U.put(8, C.get(6));
				U.put(9, C.get(3));
				
				for (int j = 1; j < 4; j++) {
					C.put(j, F.get(j));
				}
				for (int j = 1; j < 4; j++) {
					F.put(j, R.get(j));
				}
				R.put(1, B.get(3));
				R.put(2, B.get(2));
				R.put(3, B.get(1));
				
				B.put(1, L.get(3));
				B.put(2, L.get(2));
				B.put(3, L.get(1));
				
				for (int j = 1; j < 4; j++) {
					L.put(i, C.get(i));
				}
			}
			// FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
			else if (turn.equals("F-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, F.get(j));
				}
				// ����
				F.put(1, C.get(3));
				F.put(2, C.get(6));
				F.put(3, C.get(9));
				F.put(4, C.get(2));
				F.put(5, C.get(5));
				F.put(6, C.get(8));
				F.put(7, C.get(1));
				F.put(8, C.get(4));
				F.put(9, C.get(7));
				// ����
				for (int j = 1; j < 4; j++) {
					C.put(j, D.get(j));
				}
				D.put(1, L.get(3));
				D.put(2, L.get(6));
				D.put(3, L.get(9));

				L.put(3, U.get(9));
				L.put(6, U.get(8));
				L.put(9, U.get(7));

				U.put(7, R.get(1));
				U.put(8, R.get(4));
				U.put(9, R.get(7));

				R.put(1, C.get(3));
				R.put(4, C.get(2));
				R.put(7, C.get(1));

			} else if (turn.equals("F+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, F.get(j));
				}
				F.put(1, C.get(7));
				F.put(2, C.get(4));
				F.put(3, C.get(1));
				F.put(4, C.get(8));
				F.put(5, C.get(5));
				F.put(6, C.get(2));
				F.put(7, C.get(9));
				F.put(8, C.get(6));
				F.put(9, C.get(3));

				for (int j = 1; j < 4; j++) {
					C.put(j, D.get(j));
				}

				D.put(1, R.get(7));
				D.put(2, R.get(4));
				D.put(3, R.get(1));

				R.put(1, U.get(7));
				R.put(4, U.get(8));
				R.put(7, U.get(9));

				U.put(7, L.get(9));
				U.put(8, L.get(6));
				U.put(9, L.get(3));

				L.put(3, C.get(1));
				L.put(6, C.get(2));
				L.put(9, C.get(3));
			}
			// LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
			else if (turn.equals("L-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, L.get(j));
				}
				// ����
				L.put(1, C.get(3));
				L.put(2, C.get(6));
				L.put(3, C.get(9));
				L.put(4, C.get(2));
				L.put(5, C.get(5));
				L.put(6, C.get(8));
				L.put(7, C.get(1));
				L.put(8, C.get(4));
				L.put(9, C.get(7));
				// ����

				C.put(1, F.get(1));
				C.put(4, F.get(4));
				C.put(7, F.get(7));

				F.put(1, D.get(1));
				F.put(4, D.get(4));
				F.put(7, D.get(7));

				D.put(1, B.get(7));
				D.put(4, B.get(4));
				D.put(7, B.get(1));

				B.put(1, U.get(7));
				B.put(4, U.get(4));
				B.put(7, U.get(1));

				U.put(1, C.get(1));
				U.put(4, C.get(4));
				U.put(7, C.get(7));

			} else if (turn.equals("L+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, L.get(j));
				}
				L.put(1, C.get(7));
				L.put(2, C.get(4));
				L.put(3, C.get(1));
				L.put(4, C.get(8));
				L.put(5, C.get(5));
				L.put(6, C.get(2));
				L.put(7, C.get(9));
				L.put(8, C.get(6));
				L.put(9, C.get(3));
				// ����

				C.put(1, F.get(1));
				C.put(4, F.get(4));
				C.put(7, F.get(7));

				F.put(1, U.get(1));
				F.put(4, U.get(4));
				F.put(7, U.get(7));

				U.put(1, B.get(7));
				U.put(4, B.get(4));
				U.put(7, B.get(1));

				B.put(1, D.get(7));
				B.put(4, D.get(4));
				B.put(7, D.get(1));

				D.put(1, C.get(1));
				D.put(4, C.get(4));
				D.put(7, C.get(7));

			}
			// RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
			else if (turn.equals("R-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, R.get(j));
				}
				// ����
				R.put(1, C.get(3));
				R.put(2, C.get(6));
				R.put(3, C.get(9));
				R.put(4, C.get(2));
				R.put(5, C.get(5));
				R.put(6, C.get(8));
				R.put(7, C.get(1));
				R.put(8, C.get(4));
				R.put(9, C.get(7));
				// ����

				C.put(3, F.get(3));
				C.put(6, F.get(6));
				C.put(9, F.get(9));

				F.put(3, U.get(3));
				F.put(6, U.get(6));
				F.put(9, U.get(9));

				U.put(3, B.get(9));
				U.put(6, B.get(6));
				U.put(9, B.get(3));

				B.put(3, D.get(9));
				B.put(6, D.get(6));
				B.put(9, D.get(3));

				D.put(3, C.get(3));
				D.put(6, C.get(6));
				D.put(9, C.get(9));

			} else if (turn.equals("R+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, R.get(j));
				}
				R.put(1, C.get(7));
				R.put(2, C.get(4));
				R.put(3, C.get(1));
				R.put(4, C.get(8));
				R.put(5, C.get(5));
				R.put(6, C.get(2));
				R.put(7, C.get(9));
				R.put(8, C.get(6));
				R.put(9, C.get(3));
				// ����

				C.put(3, F.get(3));
				C.put(6, F.get(6));
				C.put(9, F.get(9));

				F.put(3, D.get(3));
				F.put(6, D.get(6));
				F.put(9, D.get(9));

				D.put(3, B.get(9));
				D.put(6, B.get(6));
				D.put(9, B.get(3));

				B.put(3, U.get(9));
				B.put(6, U.get(6));
				B.put(9, U.get(3));

				U.put(3, C.get(3));
				U.put(6, C.get(6));
				U.put(9, C.get(9));
			}
			// BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB
			else if (turn.equals("B-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, B.get(j));
				}
				// ����
				B.put(1, C.get(3));
				B.put(2, C.get(6));
				B.put(3, C.get(9));
				B.put(4, C.get(2));
				B.put(5, C.get(5));
				B.put(6, C.get(8));
				B.put(7, C.get(1));
				B.put(8, C.get(4));
				B.put(9, C.get(7));
				// ����

				C.put(1, U.get(1));
				C.put(2, U.get(2));
				C.put(3, U.get(3));

				U.put(1, L.get(7));
				U.put(2, L.get(4));
				U.put(3, L.get(1));

				L.put(1, D.get(7));
				L.put(4, D.get(8));
				L.put(7, D.get(9));

				D.put(7, R.get(9));
				D.put(8, R.get(6));
				D.put(9, R.get(3));

				R.put(3, C.get(1));
				R.put(6, C.get(2));
				R.put(9, C.get(3));

			} else if (turn.equals("B+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, B.get(j));
				}
				B.put(1, C.get(7));
				B.put(2, C.get(4));
				B.put(3, C.get(1));
				B.put(4, C.get(8));
				B.put(5, C.get(5));
				B.put(6, C.get(2));
				B.put(7, C.get(9));
				B.put(8, C.get(6));
				B.put(9, C.get(3));
				// ����

				C.put(1, U.get(1));
				C.put(2, U.get(2));
				C.put(3, U.get(3));

				U.put(1, R.get(3));
				U.put(2, R.get(6));
				U.put(3, R.get(9));

				R.put(3, D.get(9));
				R.put(6, D.get(8));
				R.put(9, D.get(7));

				D.put(7, L.get(1));
				D.put(8, L.get(4));
				D.put(9, L.get(7));

				L.put(1, C.get(3));
				L.put(4, C.get(2));
				L.put(7, C.get(1));
			}
			// DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
			else if (turn.equals("D-")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, D.get(j));
				}
				// ����
				D.put(1, C.get(3));
				D.put(2, C.get(6));
				D.put(3, C.get(9));
				D.put(4, C.get(2));
				D.put(5, C.get(5));
				D.put(6, C.get(8));
				D.put(7, C.get(1));
				D.put(8, C.get(4));
				D.put(9, C.get(7));
				// ����

				C.put(7, F.get(7));
				C.put(8, F.get(8));
				C.put(9, F.get(9));

				F.put(7, R.get(7));
				F.put(8, R.get(8));
				F.put(9, R.get(9));

				R.put(7, B.get(9));
				R.put(8, B.get(8));
				R.put(9, B.get(7));

				B.put(7, L.get(9));
				B.put(8, L.get(8));
				B.put(9, L.get(7));

				L.put(7, C.get(7));
				L.put(8, C.get(8));
				L.put(9, C.get(9));

			} else if (turn.equals("D+")) {
				for (int j = 1; j < 10; j++) {
					C.put(j, D.get(j));
				}
				D.put(1, C.get(7));
				D.put(2, C.get(4));
				D.put(3, C.get(1));
				D.put(4, C.get(8));
				D.put(5, C.get(5));
				D.put(6, C.get(2));
				D.put(7, C.get(9));
				D.put(8, C.get(6));
				D.put(9, C.get(3));
				// ����

				C.put(7, F.get(7));
				C.put(8, F.get(8));
				C.put(9, F.get(9));

				F.put(7, L.get(7));
				F.put(8, L.get(8));
				F.put(9, L.get(9));

				L.put(7, B.get(9));
				L.put(8, B.get(8));
				L.put(9, B.get(7));

				B.put(7, R.get(9));
				B.put(8, R.get(8));
				B.put(9, R.get(7));

				R.put(7, C.get(7));
				R.put(8, C.get(8));
				R.put(9, C.get(9));
			}
		}
	}

	private static void start() {
		U.clear();
		D.clear();
		F.clear();
		B.clear();
		R.clear();
		L.clear();
		C.clear();

		for (int i = 1; i < 10; i++) {
			U.put(i, "w");
		}
		for (int i = 1; i < 10; i++) {
			D.put(i, "y");
		}
		for (int i = 1; i < 10; i++) {
			R.put(i, "b");
		}
		for (int i = 1; i < 10; i++) {
			L.put(i, "g");
		}
		for (int i = 1; i < 10; i++) {
			F.put(i, "r");
		}
		for (int i = 1; i < 10; i++) {
			B.put(i, "o");
		}
		for (int i = 1; i < 10; i++) {
			C.put(i, "c");
		}

	}

	public static void main(String[] args) throws IOException {

		int T = Integer.valueOf(br.readLine()); // �׽�Ʈ���̽� ( 1<= T <= 100)

		// ���� �� = U: �� �� D: �Ʒ� �� F: �� �� B: �� �� L: ���� �� R: ������ ��
		// ���� ���� = +: �ð���� -: �ݽð����
		// ������ ������ ���

		while (T-- > 0) {
			start();
			int n = Integer.valueOf(br.readLine()); // turn Ƚ��
			Turn(n);

			System.out.print(U.get(1));
			System.out.print(U.get(2));
			System.out.println(U.get(3));
			System.out.print(U.get(4));
			System.out.print(U.get(5));
			System.out.println(U.get(6));
			System.out.print(U.get(7));
			System.out.print(U.get(8));
			System.out.println(U.get(9));
			
			
		}
		br.close();
		bw.flush();
		bw.close();
		
	}

}
