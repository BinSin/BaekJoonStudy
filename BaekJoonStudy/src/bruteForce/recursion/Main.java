/*
 * https://www.acmicpc.net/problem/9095
 * BinSin
 */

package bruteForce.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static int go(int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		for(int i=1; i<=3; i++) {
			now += go(sum+i, goal);
		}
		return now;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int count = go(0, n);
			bw.write(count + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
