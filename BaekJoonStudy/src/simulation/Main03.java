/*
 * BinSin
 * https://www.acmicpc.net/problem/15662
 */

package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main03 {

	public static void move(boolean[][] gear, int num, int dir) {
		if(dir == 1) {
			boolean tmp = gear[num][7];
			for(int i=7; i>0; i--) {
				gear[num][i] = gear[num][i-1];
			}
			gear[num][0] = tmp;
		} else {
			boolean tmp = gear[num][0];
			for(int i=0; i<7; i++) {
				gear[num][i] = gear[num][i+1];
			}
			gear[num][7] = tmp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int  T = Integer.parseInt(br.readLine());
		boolean[][] gear = new boolean[T][8];
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				if(s.charAt(j) == '1') gear[i][j] = true; // N극 false, S극 true
			}
		}
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int[] d = new int[T];
			
			d[num] = dir;
			int d1 = dir;
			for(int i=num; i>0; i--) {
				if(gear[i][6] == gear[i-1][2]) {
					break;
				} else {
					d1 *= -1;
					d[i-1] = d1;
				}
			}
			int d2 = dir;
			for(int i=num; i<T-1; i++) {
				if(gear[i][2] == gear[i+1][6]) {
					break;
				} else {
					d2 *= -1;
					d[i+1] = d2;
				}
			}
			
			for(int i=0; i<T; i++) {
				if(d[i] != 0) move(gear, i, d[i]);
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<T; i++) {
			if(gear[i][0]) answer++;
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
