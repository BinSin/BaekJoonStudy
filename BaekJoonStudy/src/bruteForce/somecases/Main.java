/*
 * BinSin
 * https://www.acmicpc.net/problem/2003
 */

package bruteForce.somecases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] cases = new int[N+1];
		int i = 0;
		while(st.hasMoreTokens())
			cases[i++] = Integer.parseInt(st.nextToken());
		
		int left = 0;
        int right = 0;
        int sum = cases[0];
        int count = 0;
        while (left <= right && right < N) {
            if (sum < M) {
                sum += cases[++right];
            } else if (sum == M) {
                count++;
                sum += cases[++right];
            } else {
                sum -= cases[left++];
                if (left > right && left < N) {
                    right = left;
                    sum = cases[left];
                }
            }
        }
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
