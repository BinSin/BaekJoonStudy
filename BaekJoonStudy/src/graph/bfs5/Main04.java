/*
 * BinSin
 * https://www.acmicpc.net/problem/5014
 */

package graph.bfs5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 건물 층
		int S = Integer.parseInt(st.nextToken()); // 강호 위치
		int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] button = new int[2];
		button[0] = U;
		button[1] = -D;
		int[] count = new int[F+1];
		Arrays.fill(count, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		count[S] = 0;
		while(!q.isEmpty()) {
			int f = q.remove();
			for(int b : button) {
				int nf = f + b;
				if(nf < 1 || nf > F) continue;
				if(count[nf] != -1) continue;
				count[nf] = count[f] + 1;
				q.add(nf);
			}
		}
		if(count[G] == -1) bw.write("use the stairs");
		else bw.write(count[G] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
