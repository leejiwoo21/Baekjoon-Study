
/*
 * ���꺣��Ŀ�������� ������� �¾� �����鿡�� �����Ű�� �����ϱ�� �Ͽ���.
 *  ȸ���� ������ ����ϴ� ö���� �������� ��� ��Ű�� �غ��ϴ� ������ �ð� �Ǿ���. �����Ű�� ����� ���ؼ��� N���� �������� 2���� ������ �̿��� ������ �Ѵ�. ������ �������� 2���� ���� �� 1���� ���쿡���� �������� �ϸ�,
 *   � ���쿡�� �������� ���� �������µ� �ɸ��� �ð��� �ٸ���. ������ ������ ���������� ������ ���� �� ������, ���쿡 ������ �ְų� ���µ� �ɸ��� �ð��� ���ٰ� ��������.
 * ö���� �������� ��� ������ ����� �� �� �ִٰ� �Ѵ�. ö���� �ִ��� ���� ����� �� �� �ֵ��� �������� ��� ���µ� �ɸ��� �ּ� �ð��� ��������. 
 *
 *-�Է�-
 *ù ��° �ٿ� �׽�Ʈ ���̽��� �� T �� �־�����.
 *�� ���̽��� ù ��° �ٿ� ö���� ������ �ִ� �������� ���� N(1 �� N �� 1,000)�� �־�����.
 *�� ���� N���� �ٿ� �� �������� ���� 1���� �������µ� �ɸ��� �ð� ai, ���� 2���� �������µ� �ɸ��� �ð� bi�� �־�����. (1 �� ai, bi �� 100)
 *
 -���-
 *�� �׽�Ʈ ���̽����� �� �پ� ö���� �������� ��� ���µ� �ɸ��� �ּ� �ð��� ����Ѵ�.
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
                        d[now][j] = d[pre][j]; // ���� ��ġ �ҷ�����
                        d[now][j-a[i+1]] = MIN(d[now][j-a[i+1]],d[pre][j] + b[i+1]);
                        /* �������� a or b�� ������ ���� 
                         a�� �ֱ��� �ּҽð� vs b�� �ְ� �� �ð� ���ϱ�*/
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