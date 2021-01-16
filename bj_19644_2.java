/*
 킬로와 헥토는 좀비 떼로부터 탄약고를 사수하는 데에 성공했다.

 포상 휴가나 조기 전역을 기대했으나 좀비 사태로 인해 계엄령이 선포되면서 오히려 전역이 연기되고 기관총 진지에 배치되었다.
 전역이 연기된 킬로와 헥토에게 좀비 떼가 다가오기 시작했다.
 기관총 진지 앞쪽 길의 거리는 L m이며, 진지로부터 i m 떨어진 곳에 있는 좀비의 체력은 Zi이다. 체력이 0 이하가 된 좀비는 영구적으로 죽는다.
 기관총 진지에서 킬로와 헥토는 좀비가 1 m 이동할 때 기관총 또는 수평 세열 지향성 지뢰를 한 번 사용할 수 있다.
 수평 세열 지향성 지뢰를 격발하는 경우 후폭풍을 피하기 위해 킬로와 헥토는 기관총 진지 밑으로 숨어야 한다.
 즉, 수평 세열 지향성 지뢰 격발과 기관총 사격을 동시에 할 수는 없다.
 유효 사거리는 진지 앞으로부터 ML m이다. 유효 사거리 내의 각 1 m 마다 좀비의 체력을 MK만큼 낮춘다. 
 기관총 탄약은 엄청나게 많이 있으므로 신경쓰지 않아도 된다. 총열 교체나 장전, 총기 이상 등을 고려할 필요 없이 계속 사격할 수 있다고 가정한다.
 유효 사거리는 진지 앞으로부터 1 m이다. 하지만 진지 바로 앞 1 m의 좀비는 체력과 상관없이 제압할 수 있다.
 수평 세열 지향성 지뢰는 Cammo개 있다. 
 기관총 진지라곤 하나 콘크리트로 지어진 토치카가 아니라 사대로 구축한 임시 진지이기 때문에 1 m 떨어진 길 위의 좀비를 제압하지 못한다면 사망한다. 
 과연 킬로와 헥토는 살아남을 수 있을까?
 
 입력
 첫 번째 줄에는 기관총 진지 앞쪽 길의 거리를 나타내는 정수 L (1 ≤ L ≤ 3 × 106)이 주어진다. 
 두 번째 줄에는 기관총의 유효 사거리를 나타내는 정수 ML (1 ≤ ML ≤ 3 × 106)과 각 1 m 당 살상력을 나타내는 정수 MK (1 ≤ MK ≤ 100)가 빈칸을 사이에 두고 주어진다.
 세 번째 줄에는 수평 세열 지향성 지뢰의 개수 Cammo (0 ≤ Cammo ≤ 3 × 106)가 주어진다.
 네 번째 줄부터 L개의 줄에 걸쳐서 정수가 하나씩 주어진다. 이 때 i (1 ≤ i ≤ L)번째 정수는 기관총 진지에서 i m 떨어진 곳의 좀비의 체력 Zi (0 ≤ Zi ≤ 3 × 108)이다. Zi가 0인 경우 i m 떨어진 곳에 좀비가 없다는 뜻이다.

 출력
 킬로와 헥토가 살아남을 수 있다면 YES, 살아남을 수 없다면 NO를 출력한다.
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
				if(Z <= attack) { // 좀비를 기관총으로 죽일 수 있다면
					if(attack+mk <= ml*mk) attack += mk;
					i++;
				}
				else { // 폭탄을 사용해야 할 경우
					if(bomb > 0) { // 폭탄이 있다.
						bomb -= 1; 
						i++;
					}
					else { // 폭탄이 없다.
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
