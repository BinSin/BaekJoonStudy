/*
 * https://www.acmicpc.net/problem/1260
 * BinSin
 */

package graph.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void dfs(ArrayList<Integer>[] list, boolean[] visited, int s) throws IOException {
		if(visited[s]) return;
		visited[s] = true;
		bw.write(s + " ");
		for(int next : list[s]) {
			if(!visited[next])
				dfs(list, visited, next);
		}
	}

	public static void bfs(ArrayList<Integer>[] list, boolean[] visited, int s) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int first = q.poll();
			bw.write(first+ " ");
			for(int next : list[first]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=N; i++)
			Collections.sort(list[i]);
		
		boolean[] visited = new boolean[N+1];
		dfs(list, visited, start);
		bw.write("\n");
		visited = new boolean[N+1];
		bfs(list, visited, start);
		
		bw.flush();
		br.close();
		bw.close();
	}
}
