/*
 * 문제
하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다. 몇 가지 자연수의 예를 들어 보면 다음과 같다.

3 : 3 (한 가지)
41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
53 : 5+7+11+13+17 = 53 (두 가지)
하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다. 7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다. 또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)

출력
첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.
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
