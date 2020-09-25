/*
 * https://www.acmicpc.net/problem/1476
 * BinSin
 */

package bruteForce.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken())-1;
		int S = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0;; i++) {
			if(i%15 == E && i%28 == S && i%19 == M) {
				bw.write(i+1 +"");
				break;
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
