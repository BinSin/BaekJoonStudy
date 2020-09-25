/*
 * BinSin
 * https://www.acmicpc.net/problem/1339
 */

package bruteForce.bruteForce.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main4 {
	
	public static boolean next_permutation(int[] p) {
		int i = p.length - 1;
		while(i > 0 && p[i-1] >= p[i]) {
			i--;
		}
		
		if(i <= 0)
			return false;
		
		int j = p.length - 1;
		while(p[i-1] >= p[j]) {
			j--;
		}
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		j = p.length - 1;
		while(i < j) {
			tmp = p[i];
			p[i++] = p[j];
			p[j--] = tmp;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0, j=0; i<N; i++) {
			words[i] = br.readLine();
			for(Character c : words[i].toCharArray()) {
				if(!hm.containsKey(c)) hm.put(c, j++);
			}
		}
		
		int[] perm = new int[hm.size()];
		for(int i=0; i<hm.size(); i++) {
			perm[i] = 9 - i;
		}
		Arrays.sort(perm);
		
		int max = 0;
		do {
			int sum = 0;
			for(int i=0; i<words.length; i++) {
				int n = 0;
				int k = 1;
				for(int j=words[i].length()-1; j>=0; j--) {
					int w = hm.get(words[i].charAt(j));
					n += perm[w] * k;
					k *= 10;
				}
				sum += n;
			}
			
			if(max < sum)
				max = sum;
			
		} while(next_permutation(perm));
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
