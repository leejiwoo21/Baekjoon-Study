
/*
 ų�ο� ����� ���� ���κ��� ź��� ����ϴ� ���� �����ߴ�.

 ���� �ް��� ���� ������ ��������� ���� ���·� ���� ������� �����Ǹ鼭 ������ ������ ����ǰ� ����� ������ ��ġ�Ǿ���.
 ������ ����� ų�ο� ���信�� ���� ���� �ٰ����� �����ߴ�.
 ����� ���� ���� ���� �Ÿ��� L m�̸�, �����κ��� i m ������ ���� �ִ� ������ ü���� Zi�̴�. ü���� 0 ���ϰ� �� ����� ���������� �״´�.
 ����� �������� ų�ο� ����� ���� 1 m �̵��� �� ����� �Ǵ� ���� ���� ���⼺ ���ڸ� �� �� ����� �� �ִ�.
 ���� ���� ���⼺ ���ڸ� �ݹ��ϴ� ��� ����ǳ�� ���ϱ� ���� ų�ο� ����� ����� ���� ������ ����� �Ѵ�.
 ��, ���� ���� ���⼺ ���� �ݹ߰� ����� ����� ���ÿ� �� ���� ����.
 ��ȿ ��Ÿ��� ���� �����κ��� ML m�̴�. ��ȿ ��Ÿ� ���� �� 1 m ���� ������ ü���� MK��ŭ �����. 
 ����� ź���� ��û���� ���� �����Ƿ� �Ű澲�� �ʾƵ� �ȴ�. �ѿ� ��ü�� ����, �ѱ� �̻� ���� ����� �ʿ� ���� ��� ����� �� �ִٰ� �����Ѵ�.
 ��ȿ ��Ÿ��� ���� �����κ��� 1 m�̴�. ������ ���� �ٷ� �� 1 m�� ����� ü�°� ������� ������ �� �ִ�.
 ���� ���� ���⼺ ���ڴ� Cammo�� �ִ�. 
 ����� ������� �ϳ� ��ũ��Ʈ�� ������ ��ġī�� �ƴ϶� ���� ������ �ӽ� �����̱� ������ 1 m ������ �� ���� ���� �������� ���Ѵٸ� ����Ѵ�. 
 ���� ų�ο� ����� ��Ƴ��� �� ������?
 
 �Է�
 ù ��° �ٿ��� ����� ���� ���� ���� �Ÿ��� ��Ÿ���� ���� L (1 �� L �� 3 �� 106)�� �־�����. 
 �� ��° �ٿ��� ������� ��ȿ ��Ÿ��� ��Ÿ���� ���� ML (1 �� ML �� 3 �� 106)�� �� 1 m �� ������ ��Ÿ���� ���� MK (1 �� MK �� 100)�� ��ĭ�� ���̿� �ΰ� �־�����.
 �� ��° �ٿ��� ���� ���� ���⼺ ������ ���� Cammo (0 �� Cammo �� 3 �� 106)�� �־�����.
 �� ��° �ٺ��� L���� �ٿ� ���ļ� ������ �ϳ��� �־�����. �� �� i (1 �� i �� L)��° ������ ����� �������� i m ������ ���� ������ ü�� Zi (0 �� Zi �� 3 �� 108)�̴�. Zi�� 0�� ��� i m ������ ���� ���� ���ٴ� ���̴�.

 ���
 ų�ο� ���䰡 ��Ƴ��� �� �ִٸ� YES, ��Ƴ��� �� ���ٸ� NO�� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class bj_19644_3 {

	public static void main(String[] args) throws Exception{
		
		int L, Ml, Mk, C, map[], Bomb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ml = Integer.parseInt(st.nextToken());
		Mk = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		boolean flag = true;
		map = new int[L];
		boolean Bomber[] = new boolean[L];
		int start = -Ml + 1;
		int end = 0;
		Bomb = Ml - 1;
		int shootDam = 0;
		int fullDam = Mk * Ml;
		while (true) {
			map[end] = Integer.parseInt(br.readLine());
			shootDam = fullDam - Bomb * Mk;
			if (shootDam < map[end]) {
				if (--C < 0) {
					flag = false;
					break;
				}
				Bomb++;
				Bomber[end] = true;
			}
			if (start < 0 || Bomber[start]) {
				Bomb--;
			}
			start++;
			if (++end == L)
				break;
		}

		System.out.println(flag ? "YES" : "NO");
	}
}
