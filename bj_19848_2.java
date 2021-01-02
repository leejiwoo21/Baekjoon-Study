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

public class bj_19848_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder zero = new StringBuilder();
	static StringBuilder one = new StringBuilder();
	static int count =0;
	
	private static String test(int n) {
		for(int i=0; i<n/2; i++) {
			zero.append("0");
			one.append("1");
		}
		String s = zero.append(one).toString();
		zero.delete(0,zero.length());
		one.delete(0,one.length());
		return s;
	}
	private static String test_reverse(int n) {
		for(int i=0; i<n/2; i++) {
			zero.append("0");
			one.append("1");
		}
		String s = one.append(zero).toString();
		zero.delete(0,zero.length());
		one.delete(0,one.length());
		return s;
	}
	
	private static void search(StringBuilder sb, int n) {
		try {
			while (!sb.toString().isEmpty()) {
				if (sb.toString().contains(test(n))) {
					String a = sb.indexOf(test(n)) + "";
					bw.write(a+" "+(a+n)+"\n");
					sb.delete(sb.indexOf(test(n)),sb.indexOf(test(n))+n);
					count++;
					search(sb,n);
				}
				else if(sb.toString().contains(test_reverse(n))) {
					String a = sb.indexOf(test(n)) + "";
					bw.write(a+" "+(a+n)+"\n");
					sb.delete(sb.indexOf(test(n)),sb.indexOf(test(n))+n);
					count++;
					search(sb,n);
				}
				else {
					search(sb,n-2);
				}
			}
		} catch (IOException e) {

		}
	}

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s);
		search(sb,sb.length());
		int a = 333333;
		bw.write(a+" ");
		
		bw.flush();
		bw.close();
	}
}

