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
import java.io.IOException;

public class bj_5373 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Side{
		String c1 = "";
		String c2 = "";
		String c3 = "";
		String c4 = "";
		String c5 = "";
		String c6 = "";
		String c7 = "";
		String c8 = "";
		String c9 = "";
		
		public Side(String s) {
			c1 = s;
			c2 = s;
			c3 = s;
			c4 = s;
			c5 = s;
			c6 = s;
			c7 = s;
			c8 = s;
			c9 = s;
		}
	}

	private static void turn(int n) throws IOException {
		Side U = new Side("w");
		Side D = new Side("y");
		Side R = new Side("b");
		Side L = new Side("g");
		Side F = new Side("r");
		Side B = new Side("o");
		
		String[] s = br.readLine().split(" "); // ȸ�� ����
		for(int i = 0; i<n; i++) {
			String turn = s[i];
			if(turn == "U-") {
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		int T = Integer.valueOf(br.readLine()); // �׽�Ʈ���̽� ( 1<= T <= 100)
		
		// ���� �� =  U: �� ��  D: �Ʒ� ��  F: �� ��  B: �� ��  L: ���� ��  R: ������ ��
		// ���� ���� = +: �ð����  -: �ݽð����
		// ������ ������ ���
		
		while(T-->0) {
			
			
			int n = Integer.valueOf(br.readLine()); // turn Ƚ��
			
		}
		
		bw.close();
		bw.flush();
	}

}
