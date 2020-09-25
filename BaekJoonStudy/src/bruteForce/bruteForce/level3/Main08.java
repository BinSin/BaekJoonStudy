/*
 * BinSin
 * https://www.acmicpc.net/problem/3019
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main08 {

	static int C;
	static int P;
	static int[] field;
	
	static int go(int[] block) {
		int len = block.length;
		int count = 0;
		for(int i=0; i<=C-len; i++) {
			int h = field[i] - block[0];
			boolean c = false;
			for(int j=1; j<len; j++) {
				int hh = field[i+j] - block[j];
				if(h != hh) {
					c = true;
					break;
				}
			}
			if(c) continue;
			else count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		field = new int[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) field[i] = Integer.parseInt(st.nextToken());
		int answer = 0;
		if(P == 1) {
			answer = go(new int[] {0}) + go(new int[] {0,0,0,0});
		} else if(P == 2) {
			answer = go(new int[] {0,0});
		} else if(P == 3) {
			answer = go(new int[] {0,0,1}) + go(new int[] {1,0});
		} else if(P == 4) {
			answer = go(new int[] {1,0,0}) + go(new int[] {0,1});
		} else if(P == 5) {
			answer = go(new int[] {0,0,0}) + go(new int[] {1,0}) + go(new int[] {0,1}) + go(new int[] {1,0,1});
		} else if(P == 6) {
			answer = go(new int[] {0,0,0}) + go(new int[] {2,0}) + go(new int[] {0,1,1}) + go(new int[] {0,0});
		} else {
			answer = go(new int[] {0,0,0}) + go(new int[] {0,0}) + go(new int[] {1,1,0}) + go(new int[] {0,2});
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
