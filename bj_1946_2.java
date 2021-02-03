/* ����
������ �ְ��� �����ϴ� ������ ���� ���� �ֽ�ȸ�簡 �ű� ��� ä���� �ǽ��Ѵ�. ���� ���� ������ 1�� �����ɻ�� 2�� ������������ �̷������. �ְ��� �����Ѵٴ� ����� �̳信 ���� �׵��� �ְ��� ����鸸�� ������� �����ϰ� �;� �Ѵ�.

�׷��� ���� �ֽ�ȸ���, �ٸ� ��� �����ڿ� ������ �� �����ɻ� ������ �������� ���� �� ��� �ϳ��� �ٸ� �����ں��� �������� �ʴ� �ڸ� �����Ѵٴ� ��Ģ�� ������. ��, � ������ A�� ������ �ٸ� � ������ B�� ������ ���� ���� �ɻ� ����� ���� ������ ��� �������ٸ� A�� ���� ���ߵ��� �ʴ´�.

�̷��� ������ ������Ű�鼭, ���� �ֽ�ȸ�簡 �̹� �ű� ��� ä�뿡�� ������ �� �ִ� ���Ի���� �ִ� �ο����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� �׽�Ʈ ���̽��� ���� T(1 �� T �� 20)�� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ� �������� ���� N(1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N�� �ٿ��� ������ �������� �����ɻ� ����, ���� ������ ������ ������ ���̿� �ΰ� �� �ٿ� �־�����. �� ���� ������ ��� 1������ N������ ������ ���� �����ȴٰ� �����Ѵ�.

���
�� �׽�Ʈ ���̽��� ���ؼ� ���� �ֽ�ȸ�簡 ������ �� �ִ� ���Ի���� �ִ� �ο����� �� �ٿ� �ϳ��� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bj_1946_2 {

	static class Man implements Comparable {
		public Man(int a, int b) {
			this.a = a;
			this.b = b;
		}
		int a = 0;
		int b = 0;
		@Override
		public int compareTo(Object o) {
			Man O = (Man)o;
			if(this.a > O.a) {
				return 1;
			}
			else if(this.a < O.a) {
				return -1;
			}
			else {
				if(this.b > O.b) {
					return 1;
				}
				else if(this.b < O.b) {
					return -1;
				}
				return 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		int T = Integer.valueOf(br.readLine());
		while (T-- > 0) {
			int N = Integer.valueOf(br.readLine());
			Man[] list = new Man[N];
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.valueOf(s[0]);
				int b = Integer.valueOf(s[1]);
				Man man = new Man(a,b);
				list[i] = man;
			}
			Arrays.sort(list);
			for(int i =0; i<N; i++) {
				for(int j=i; j<N; j++) {
					if(list[i].b<list[j].b) {
						count++;
						break;
					}
				}
			}
		System.out.println(count);
		}
	}
}
