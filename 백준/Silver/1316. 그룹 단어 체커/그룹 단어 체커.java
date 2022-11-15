import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter; 
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.valueOf(br.readLine());
		int result = 0;

		for(int i = 0; i<N; i++) {
			boolean isgroupWord = true;
			int before = -1;
			int[] check = new int[27];
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				int now = str.codePointAt(j)-97;
				if(check[now] == 0 || before == now) {
					before = now;
					check[now] += 1;
				}
				else {
					isgroupWord = false;
					break;
				}
			}
			if(isgroupWord) {
				result+=1;
			}
		}
		System.out.print(result);
		
	
	}
	
}
