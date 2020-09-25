/*
 * https://www.acmicpc.net/problem/11724
 * BinSin
 */

package graph.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

	public static void dfs(ArrayList<Integer>[] list, boolean[] visited, int s) {
		if(visited[s]) return;
		visited[s] = true;
		for(int next : list[s]) {
			if(!visited[next])
				dfs(list, visited, next);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		int answer = 0;
		boolean[] visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(list, visited, i);
				answer++;
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		br.close();
		bw.close();
	}
}
