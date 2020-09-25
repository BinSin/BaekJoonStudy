/*
 * BinSin
 * https://www.acmicpc.net/problem/13913
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br;
	static BufferedWriter bw;
	
	static void print(int[] from, int N, int K) throws IOException {
		if(N != K) {
			print(from, N, from[K]);
		}
		bw.write(K + " ");
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[200001];
		Arrays.fill(distance, -1);
		
		int[] from = new int[200001];
		
		Queue<Integer> q = new LinkedList<>();
		distance[N] = 0;
		q.add(N);
		while(!q.isEmpty()) {
			int location = q.poll();
			int[] next = {location-1, location+1, location*2};
			for(int i=0; i<3; i++) {
				int nextLocation = next[i];
				if(0 <= nextLocation && nextLocation <= 200000) {
					if(distance[nextLocation] == -1) {
						q.add(nextLocation);
						from[nextLocation] = location;
						distance[nextLocation] = distance[location] + 1;
					}
				}
			}
		}
		
		bw.write(distance[K] + "\n");
		
		print(from, N, K);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
