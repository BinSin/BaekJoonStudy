/*
 * https://www.acmicpc.net/problem/14226
 * BinSin
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
	
	public static class Info {
		int screen, clipboard;
		Info(int screen, int clipboard) {
			this.screen = screen;
			this.clipboard = clipboard;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = Integer.parseInt(br.readLine());
		
		int[][] val = new int[S+1][S+1];
		for(int i=0; i<=S; i++) {
			Arrays.fill(val[i], -1);
		}
		Queue<Info> q = new LinkedList<Info>();
		val[0][0] = 1; val[1][0] = 0; val[1][1] = 1;
		q.add(new Info(1, 1));
		while(!q.isEmpty()) {
			Info now = q.poll();
			int nowScreen = now.screen;
			int nowClipboard = now.clipboard;
			Info[] next = {new Info(nowScreen - 1, nowClipboard), new Info(nowScreen + nowClipboard, nowClipboard), new Info(nowScreen, nowScreen)};
			for(int i=0; i<3; i++) {
				int ns = next[i].screen;
				int nc = next[i].clipboard;
				if(0 <= ns && ns <= S && 0 <= nc && nc <= S) {
					if(val[ns][nc] == -1) {
						q.add(new Info(ns, nc));
						val[ns][nc] = val[nowScreen][nowClipboard] + 1;
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=S; i++) {
			if(val[S][i] != -1 && val[S][i] < min) min = val[S][i];
		}
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
