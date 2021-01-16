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

public class bj_19644_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int L = (int) Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int ml = (int) Integer.parseInt(s[0]);
			int mk = (int) Integer.parseInt(s[1]);
			int bomb = Integer.parseInt(br.readLine());
			int attack = mk;
			int i = 1;
			int Z = 0;
			
			while(i<L+1){
				Z = (int)Integer.parseInt(br.readLine());
				if(Z <= attack) { // ���� ��������� ���� �� �ִٸ�
					if(attack+mk <= ml*mk) attack += mk;
					i++;
				}
				else { // ��ź�� ����ؾ� �� ���
					if(bomb > 0) { // ��ź�� �ִ�.
						bomb -= 1; 
						i++;
					}
					else { // ��ź�� ����.
						bw.write("NO");
						bw.flush();
						break;
					}
				}			
			}
			if (i == L+1) {
				bw.write("YES");
				bw.flush();
				br.close();
			}
		} catch (IOException e) {
		}

	}
}
