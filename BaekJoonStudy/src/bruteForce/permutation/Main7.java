/*
 * https://www.acmicpc.net/problem/14888
 * BinSin
 */

package bruteForce.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main7 {
	
	public static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}
	
	public static int[] nextPermutation(int[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		
		if(I == -1) return new int[] {-1};
		
		for(int j=p.length-1; j>0; j--) {
			if(p[j] > p[I]) {
				J = j;
				break;
			}
		}
		swap(p, I, J);
		
		J = p.length - 1;
		while(I < J) {
			swap(p, I+1, J);
			I++;
			J--;
		}
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
				
		int[] oper = new int[plus + minus + mul + div];
		int k = 0;
		for(int i=0; i<plus; i++) {
			oper[k++] = 1;
		}
		for(int i=0; i<minus; i++) {
			oper[k++] = 2;
		}
		for(int i=0; i<mul; i++) {
			oper[k++] = 3;
		}
		for(int i=0; i<div; i++) {
			oper[k++] = 4;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while(oper[0] != -1) {
			int sum = num[0];
			for(int i=0; i<N-1; i++) {
				int number = num[i+1];
				switch(oper[i]) {
				case 1 : sum += number; break;
				case 2 : sum -= number; break;
				case 3 : sum *= number; break;
				case 4 : sum /= number; break;
				}
			}
			if(sum < min) min = sum;
			if(sum > max) max = sum;
			
			oper = nextPermutation(oper);
		}
		
		bw.write(max + "\n");
		bw.write(min + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
