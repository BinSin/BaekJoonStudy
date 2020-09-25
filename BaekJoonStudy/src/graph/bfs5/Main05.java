/*
 * BinSin
 * https://www.acmicpc.net/problem/12886
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main05 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int s = A + B + C;
		if(A == B && B == C) {
			bw.write("1");
		} else if(s % 3 != 0) {
			bw.write("0");
		} else {
			Queue<int[]> q = new LinkedList<>();
			int[] group = new int[] {A, B, C};
			q.add(group);
			boolean[][] check = new boolean[1501][1501];
			while(!q.isEmpty()) {
				int[] g = q.remove();
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(g[i] < g[j]) {
							int[] gc = g.clone();
							gc[i] += g[i];
							gc[j] -= g[i];
							if(check[gc[i]][gc[j]]) continue;
							q.add(gc);
							check[gc[i]][gc[j]] = true;
						}
					}
				}
			}
			if(check[s/3][s/3]) bw.write("1");
			else bw.write("0");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
