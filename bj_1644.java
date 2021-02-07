/*
 * ����
�ϳ� �̻��� ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ� �ڿ������� �ִ�. �� ���� �ڿ����� ���� ��� ���� ������ ����.

3 : 3 (�� ����)
41 : 2+3+5+7+11+13 = 11+13+17 = 41 (�� ����)
53 : 5+7+11+13+17 = 53 (�� ����)
������ ���ӵ� �Ҽ��� ������ ��Ÿ�� �� ���� �ڿ����鵵 �ִµ�, 20�� �� ���̴�. 7+13�� ����ϸ� 20�� �Ǳ�� �ϳ� 7�� 13�� ������ �ƴϱ⿡ ������ ǥ���� �ƴϴ�. ���� �� �Ҽ��� �ݵ�� �� ���� ������ ���� �� �ֱ� ������, 3+5+5+7�� ���� ǥ���� �������� �ʴ�.

�ڿ����� �־����� ��, �� �ڿ����� ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N�� �־�����. (1 �� N �� 4,000,000)

���
ù° �ٿ� �ڿ��� N�� ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ����Ѵ�.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class bj_1644 {

	private static boolean isPrime(int n) {
		for(int i=2; i<n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	private static int listAdd(int[] list,int first,int second) {
		int sum = 0;
		for(int i=first;i<=second;i++) {
			sum += list[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i =2; i<=N; i++) {
			if(isPrime(i)) {
				Integer a = i;
				arr.add(a);
			}
		}
		
		int[] list = new int[arr.size()];
		for(int i =0; i<arr.size(); i++){
			list[i] = arr.get(i);
		}
		
		int first = 0;
		int second = 0;
		int count = 0;
		int n =0;
		while(true) {
			n =listAdd(list,first,second);
			if( n == N) {
				count++;
				second++;
			}
			else if( n < N) {
				second++;
			}
			else if( n >N) {
				first++;
			}
			if((first == list.length-1) &&(second >= list.length)) {
				break;
			}
		}
		System.out.println(count);
	}

}
