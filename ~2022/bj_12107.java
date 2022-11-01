/*
 * 문제
A와 B가 약수 지우기 게임을 한다. 약수 지우기 게임은 두 사람이 즐기는 게임이다.

칠판에 1부터 N까지의 자연수가 적혀 있다. 각 사람은 자신의 턴에 칠판에 적힌 자연수 하나를 지우고, 그 자연수의 약수 중 칠판에 남아 있는 수들을 모두 지운다. 예를 들어, 칠판에 2,3,4,5,6이 적혀 있을 때, 6을 지우면, 그 약수인 2와 3 역시 지워야 한다. 자신의 턴에 숫자를 지우지 않을 수는 없다. 마지막 숫자를 지우는 사람이 지게 된다.

A와 B가 최적의 방법으로 게임을 할 때, 이기는 사람을 출력한다. 게임은 A가 먼저 시작한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 A가 이기는 경우 A, B가 이기는 경우 B를 출력한다.
 */
import java.util.Scanner;
public class bj_12107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("B");
		}
		else{
			System.out.println("A");
		}
	}
}
