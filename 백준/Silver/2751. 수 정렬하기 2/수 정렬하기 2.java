import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.math.*;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
	
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);

		for(Integer c : list) {
			sb.append(c).append("\n");
		}
		
		System.out.println(sb);
	}
		
}
