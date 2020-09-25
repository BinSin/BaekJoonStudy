/*
 * BinSin
 * https://www.acmicpc.net/problem/2916
 */

package bruteForce.bruteForce.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] angle = new boolean[360];
		List<Integer> hs = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			angle[a] = true;
			hs.add(a);
		}
		while(true) {
			int before = hs.size();
			for(int i=0; i<before; i++) {
				int a = hs.get(i);
				for(int j=0; j<before; j++) {
					int b = hs.get(j);
					int p = (a + b) % 360;
					if(!hs.contains(p)) {
						hs.add(p);
						angle[p] = true;
					}
					int m = Math.abs(a - b);
					if(!hs.contains(p)) {
						hs.add(m);
						angle[m] = true;
					}
				}
			}
			int after = hs.size();
			if(before == after) break;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(st.nextToken());
			bw.write(angle[n] ? "YES\n" : "NO\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
