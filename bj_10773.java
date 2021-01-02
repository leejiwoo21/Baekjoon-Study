/*https://www.acmicpc.net/problem/10773
 * 
 * ���ڴ� ���� ����̴� ���Ƹ� ȸ���� �غ��ϱ� ���ؼ� ��θ� �����ϴ� ���̴�.
 * �����̴� ����̸� ���ͼ� ���� �����ϴ� ���ε�, �ּ��ϰԵ� �׻� ���ž��� �����̴� ���� �Ǽ��� �߸� �θ��� ��� ġ�� �Ͼ�����.
 * �����̴� �߸��� ���� �θ� ������ 0�� ���ļ�, ���� �ֱٿ� ����̰� �� ���� ����� ��Ų��.
 * ����̴� �̷��� ��� ���� �޾� ���� �� �� ���� ���� �˰� �;� �Ѵ�. ����̸� ��������!
 * -�Է�-
 * ù ��° �ٿ� ���� K�� �־�����. (1 �� K �� 100,000)
 * ���� K���� �ٿ� ������ 1���� �־�����. ������ 0���� 1,000,000 ������ ���� ������,
 * ������ "0" �� ��쿡�� ���� �ֱٿ� �� ���� �����, �ƴ� ��� �ش� ���� ����.
 * ������ "0"�� ��쿡 ���� �� �ִ� ���� ������ ������ �� �ִ�.
 * -���-
 * ����̰� ���������� ���� �� ���� ���� ����Ѵ�. ���������� ��� ���� ���� 231-1���� �۰ų� ���� �����̴�.
 */

import java.util.Scanner;
import java.util.Stack;

public class bj_10773 {

	static Scanner in = new Scanner(System.in);
	static Stack<Integer> s = new Stack<Integer>();
	static int k = in.nextInt(); // ���� k�� �޾Ƽ� ����
	static int nextInt = 0;

	private static void Add() {
		long add = 0; // ����� ��
		for (int i = 0; i < k; i++) {  
			nextInt = in.nextInt();
			if (nextInt == 0 && !s.empty()) { // ���� ���� 0����, stack�� ������� ������ �˻�
				s.pop();
			} else if(nextInt != 0) { // 0�� �ƴ϶�� stack�� �߰�
				s.push(nextInt);
			}
		}
		while(!s.empty()) { // stack�� ��� �ε����� ���Ѵ�
			add += s.pop();
		}
		System.out.println(add);
	}

	public static void main(String[] args) {
		Add();
	}
}
