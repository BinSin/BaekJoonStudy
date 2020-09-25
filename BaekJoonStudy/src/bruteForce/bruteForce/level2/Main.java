/*
 * BinSin
 * https://www.acmicpc.net/problem/1107
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int posCheck(int i, boolean[] check) {
		int click = 0;
		
		if(i == 0) {
			if(check[i])
				return 0;
			else
				return 1;
		}
		
		while(i != 0) {
			if(check[i % 10]) {
				return 0;
			} else {
				click++;
				i /= 10;
			}
		}
		return click;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String strN = br.readLine();
		int N = Integer.parseInt(strN);
		int M = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[10];
		StringTokenizer st;
		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				check[Integer.parseInt(st.nextToken())] = true;
		}
		
		int channel = 100;
		int click = 0;
		int answer = Math.abs(N - channel);
		
		for(int i=0; i<1000000; i++) {
			click = posCheck(i, check);
			if(click != 0) {
				channel = i;
				answer = Math.min(answer, Math.abs(N - channel) + click);
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
