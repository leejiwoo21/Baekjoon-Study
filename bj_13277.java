/* ����
 * �� ���� A�� B�� �־����� ��, �� ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * �Է�
 * ù° �ٿ� ���� A�� B�� �־�����. �� ������ 0���� ũ�ų� ���� �����̸�, 0�� ������ ������ 0���� �������� ������, ���� �տ� ���ʿ��� 0�� �ִ� ��쵵 ����. ����, ���� ���̴� 300,000�ڸ��� ���� �ʴ´�.
 * 
 * ��� 
 * �� ���� ���� ����Ѵ�.
 */

import java.math.BigInteger;
import java.util.Scanner;
public class bj_13277 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String[] s = in.nextLine().split(" ");
		
		BigInteger A = new BigInteger(s[0]);
		BigInteger B = new BigInteger(s[1]);
		
		System.out.print(A.multiply(B));
	}
}
