
/*
 * 데브베이커리에서는 기념일을 맞아 직원들에게 행운쿠키를 선물하기로 하였다.
 *  회사의 간식을 담당하는 철수는 나누어줄 행운 쿠키를 준비하는 역할을 맡게 되었다. 행운쿠키를 만들기 위해서는 N개의 행운반죽을 2개의 오븐을 이용해 구워야 한다. 각각의 행운반죽은 2개의 오븐 중 1개의 오븐에서만 구워져야 하며,
 *   어떤 오븐에서 굽는지에 따라 구워지는데 걸리는 시간이 다르다. 각각의 오븐은 독립적으로 반죽을 구울 수 있으며, 오븐에 반죽을 넣거나 빼는데 걸리는 시간은 없다고 가정하자.
 * 철수는 행운반죽을 모두 구워야 퇴근을 할 수 있다고 한다. 철수가 최대한 빨리 퇴근을 할 수 있도록 행운반죽을 모두 굽는데 걸리는 최소 시간을 구해주자. 
 *
 *-입력-
 *첫 번째 줄에 테스트 케이스의 수 T 가 주어진다.
 *각 케이스의 첫 번째 줄에 철수가 가지고 있는 행운반죽의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
 *그 다음 N개의 줄에 각 행운반죽이 오븐 1에서 구워지는데 걸리는 시간 ai, 오븐 2에서 구워지는데 걸리는 시간 bi가 주어진다. (1 ≤ ai, bi ≤ 100)
 *
 -출력-
 *각 테스트 케이스마다 한 줄씩 철수가 행운반죽을 모두 굽는데 걸리는 최소 시간을 출력한다.
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.*;

public class bj_10982 {
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine()), sum = 0, result = INF;
            int[] a = new int[n], b = new int[n];
            for(int i = 0;i < n;i++) {
                String[] s = br.readLine().split(" ");
                sum += a[i] = Integer.parseInt(s[0]);
                b[i] = Integer.parseInt(s[1]);
            }
            int[][] d = new int[2][1000001];
            for(int i = 0;i < 1000001;i++) {
                d[0][i] = INF;
            }
            d[0][sum] = 0;    d[0][sum-a[0]] = b[0];
            int now = 0;
            for(int i = 0;i < n-1;i++) {
                now = (now+1) % 2;
                int pre = (now+1) % 2;
                for(int j = 0;j < 1000001;j++) {
                    d[now][j] = INF;
                }
                for(int j = 0;j < 1000001;j++) {
                    if(d[pre][j] < INF) {
                        d[now][j] = d[pre][j]; // 예전 수치 불러오기
                        d[now][j-a[i+1]] = MIN(d[now][j-a[i+1]],d[pre][j] + b[i+1]);
                        /* 다음꺼를 a or b에 넣을지 결정 
                         a에 넣기전 최소시간 vs b에 넣고 그 시간 더하기*/
                    }
                }
            }
            for(int i = 0;i < 1000001;i++) {
                result = MIN(result, MAX(i,d[now][i]));
            }
            System.out.println(result);
        }
    }

	public static int MAX(int a, int b) {
		return a < b ? b : a;
	}

	public static int MIN(int a, int b) {
		return a < b ? a : b;
	}

}