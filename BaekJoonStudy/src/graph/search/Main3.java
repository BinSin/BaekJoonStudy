/*
 * https://www.acmicpc.net/problem/1707
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

public class Main3 {

	public static boolean dfs(ArrayList<Integer>[] list, int[] color, int s, int c) {
		color[s] = c;
		for(int next : list[s]) {
			if(color[next] == 0) {		
				if(!dfs(list, color, next, 3-c))
					return false;
			} else if(color[s] == color[next]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		while(K-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}
			int[] color = new int[V+1];
			boolean answer = true;
			for(int i=1; i<=V; i++) {
				if(color[i] == 0)
					if(!dfs(list, color, i, 1)) {
						answer = false;
						break;
					}
			}
			
			bw.write(answer ? "YES\n" : "NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
