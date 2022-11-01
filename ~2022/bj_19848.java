/* https://www.acmicpc.net/problem/19848
0과 1로만 이루어져 있으며, 0의 개수와 1의 개수가 동일한 문자열 S가 주어진다.
당신은 S에 다음과 같은 작업을 여러 번 수행할 수 있다: S의 길이 2k인 연속한 부분문자열이 
앞 k개 문자가 모두 동일하고, 또한 뒤 k개 문자가 서로 동일하며, 0과 1을 모두 포함할 때, 그 부분문자열을 제거할 수 있다.

예를 들어, S = “0111000011”인 경우,
S의 2번째 문자부터 7번째 문자까지인 “111000”을 제거하는 것이 가능하다. 이 작업 후에는 제거된 부분의 앞부분과 뒷부분이 연결되어 S = “0011”이 된다. 그러면 이제 한 번의 작업을 통해 “0011”을 제거할 수 있으므로 초기 S = “0111000011”는 두 번의 작업을 통해 빈 문자열로 만들 수 있다.

여러분의 목표는 최소 횟수의 작업을 통해 S를 빈 문자열로 만드는 것이다.
최소 횟수의 작업으로 S를 빈 문자열로 만드는 과정을 구하여라.

-입력-
첫 줄에 0과 1로만 이루어진 문자열 S가 주어진다. S에 포함된 0의 개수와 1의 개수는 동일하다.

-출력-

작업들을 통해 S를 빈 문자열로 만드는 것이 불가능하다면 첫 줄에 -1을 출력한다.

그렇지 않은 경우, 첫 줄에 필요한 작업의 최소 횟수 K를 출력한다. 그 다음 K줄에 걸쳐 수행한 작업에 대한 정보를 출력한다.

K개 줄 중 i번째 줄에는 두 정수 bi와 ei를 공백을 사이에 두고 출력한다. 이는 i번째 작업에서 S의 bi번째 문자부터 ei번째 문자로 이루어진 문자열을 제거하였음을 뜻한다.

최소 횟수의 작업으로 문자열을 지우는 방법이 여러 가지인 경우에는 그 중 아무 것이나 출력해도 된다.
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
