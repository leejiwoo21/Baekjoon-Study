/* https://www.acmicpc.net/problem/19848
0�� 1�θ� �̷���� ������, 0�� ������ 1�� ������ ������ ���ڿ� S�� �־�����.
����� S�� ������ ���� �۾��� ���� �� ������ �� �ִ�: S�� ���� 2k�� ������ �κй��ڿ��� 
�� k�� ���ڰ� ��� �����ϰ�, ���� �� k�� ���ڰ� ���� �����ϸ�, 0�� 1�� ��� ������ ��, �� �κй��ڿ��� ������ �� �ִ�.

���� ���, S = ��0111000011���� ���,
S�� 2��° ���ں��� 7��° ���ڱ����� ��111000���� �����ϴ� ���� �����ϴ�. �� �۾� �Ŀ��� ���ŵ� �κ��� �պκа� �޺κ��� ����Ǿ� S = ��0011���� �ȴ�. �׷��� ���� �� ���� �۾��� ���� ��0011���� ������ �� �����Ƿ� �ʱ� S = ��0111000011���� �� ���� �۾��� ���� �� ���ڿ��� ���� �� �ִ�.

�������� ��ǥ�� �ּ� Ƚ���� �۾��� ���� S�� �� ���ڿ��� ����� ���̴�.
�ּ� Ƚ���� �۾����� S�� �� ���ڿ��� ����� ������ ���Ͽ���.

-�Է�-
ù �ٿ� 0�� 1�θ� �̷���� ���ڿ� S�� �־�����. S�� ���Ե� 0�� ������ 1�� ������ �����ϴ�.

-���-

�۾����� ���� S�� �� ���ڿ��� ����� ���� �Ұ����ϴٸ� ù �ٿ� -1�� ����Ѵ�.

�׷��� ���� ���, ù �ٿ� �ʿ��� �۾��� �ּ� Ƚ�� K�� ����Ѵ�. �� ���� K�ٿ� ���� ������ �۾��� ���� ������ ����Ѵ�.

K�� �� �� i��° �ٿ��� �� ���� bi�� ei�� ������ ���̿� �ΰ� ����Ѵ�. �̴� i��° �۾����� S�� bi��° ���ں��� ei��° ���ڷ� �̷���� ���ڿ��� �����Ͽ����� ���Ѵ�.

�ּ� Ƚ���� �۾����� ���ڿ��� ����� ����� ���� ������ ��쿡�� �� �� �ƹ� ���̳� ����ص� �ȴ�.
*/

import java.io.*;
import java.util.*;

public class bj_19848 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int count =0;
	private static String test(int n) {
		String zero = "";
		String one = "";
		for (int i = 0; i < n / 2; i++) {
			zero += "0";
			one += "1";
		}
		String zeroone = zero+one;
		return zeroone;
	}

	private static String test_reverse(int n) {
		String zero = "";
		String one = "";
		for (int i = 0; i < n / 2; i++) {
			zero += "0";
			one += "1";
		}
		String onezero = one+zero;
		return onezero;
	}

	private static void search(String s, int n) {
		try {
			while (s != "") {
				if (s.contains(test(n))) {
					String a = s.indexOf(test(n)) + "";
					bw.write(a+" "+(a+n));
					s.replace(test(n),"");
					count++;
					search(s,n);
				}
				else if(s.contains(test_reverse(n))) {
					String a = s.indexOf(test(n)) + "";
					bw.write(a+" "+(a+n));
					s.replace(test(n),"");
					count++;
					search(s,n);
				}
				else {
					search(s,n-2);
				}
			}
		} catch (IOException e) {

		}
	}

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		search(s,s.length());
		bw.flush();
		bw.close();
	}

}
