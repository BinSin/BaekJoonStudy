/*
 * https://www.acmicpc.net/problem/13023
 * BinSin
 */

package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static class Edge {
		int from, to;
		Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Edge> eList = new ArrayList<Edge>();
		ArrayList<Integer>[] fList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			fList[i] = new ArrayList<Integer>();
		}
		
		boolean[][] check = new boolean[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			eList.add(new Edge(a, b));
			eList.add(new Edge(b, a));
			fList[a].add(b);
			fList[b].add(a);
			check[a][b] = check[b][a] = true;
		}
		
		boolean end = false;
		for(int i=0; i<M*2 ;i++) {
			for(int j=0; j<M*2; j++) {
				if(i == j) continue;
				int A = eList.get(i).from;
				int B = eList.get(i).to;
				int C = eList.get(j).from;
				int D = eList.get(j).to;
				if(A == B || A == C || A == D || B == C || B == D || C == D) continue;
				if(!check[B][C]) continue;
				
				for(int E : fList[D]) {
					if(A == E || B == E || C == E || D == E) continue;
					end = true;
					break;
				}
			}
			if(end) break;
		}
		
		if(end)
			bw.write("1");
		else
			bw.write("0");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
