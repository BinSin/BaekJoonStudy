/*
 * BinSin
 * https://www.acmicpc.net/problem/9019
 */

package graph.bfs3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			String[] register = new String[10000];
			register[A] = "";
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			while(!q.isEmpty()) {
				int n = q.poll();
				char[] operation = {'D', 'S', 'L', 'R'};
				for(char oper : operation) {
					int next = n;
					if(oper == 'D') {
						next = (next * 2) % 10000; 
					} else if(oper == 'S') {
						next--;
						if(next == -1) next = 9999;
					} else if(oper == 'L') {
						next = (n % 1000) * 10 + n / 1000;
					} else {
						next = (n % 10) * 1000 + n / 10;
					}
					
					if(0 <= next && next < 10000) {
						if(register[next] == null) {
							q.add(next);
							register[next] = register[n] + oper;
						}
					}
				}
			}
			
			bw.write(register[B] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
