package bfs_concept;

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

public class Bfs {

	private static int N; // ����� ����
	private static int E; // ������ ����
	private static int S; // ���� ����� ��ȣ
	
	private static int x;
	private static int y;
	
	private static ArrayList<Integer> [] graph;
	
	private static ArrayList<Integer> bfs;
	
	private static boolean[] visit; // �̹� �湮�� ����� ������ ���� �迭
	
	private static Queue<Integer> Q;
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		S= Integer.parseInt(st.nextToken());
		
		graph= new ArrayList[E+1];
		
		for(int i= 1; i <= E; i++) { // �� ���� �������� ����Ǿ� �ִ� ���鿡 ���� ������ ���� ����Ʈ�� �ʱ�ȭ
			graph[i]= new ArrayList<Integer>();
		}
		
		for(int i= 0; i< E; i++) {
			st= new StringTokenizer(br.readLine());
			x= Integer.parseInt(st.nextToken());
			y= Integer.parseInt(st.nextToken());
			
			graph[x].add(y); // ���⼺�� ���� �׷����̱� ������ ����Ǵ� ���ʿ� ���ο� ���� ������ �־��ش�.
			graph[y].add(x); 
		}
		
		for(int i= 1; i <= E; i++) { // ����� ���� ������ ����
			Collections.sort(graph[i]);
		}
		
		bfsSolution();
		
		for (int i= 0; i< bfs.size(); i++) {
			System.out.print(bfs.get(i)+ " ");
		}
	}

	private static void bfsSolution() {
		bfs= new ArrayList<Integer>();
		visit= new boolean[E+1];
		Q= new LinkedList<Integer>();
		
		Q.add(S); // ���۳�带 ť�� �ִ´�.
		
		visit[S]= true; // ���۳�带 �湮�ߴٴ� ������ ����
		
		while(!Q.isEmpty()) { // ť�� ��尡 ���� �ִٸ� ��� ����
			int q= Q.poll(); // ť���� ��带 ��
			bfs.add(q);
			
			for(int i : graph[q]) { // ť���� ���� ����� ����Ǿ� �ִ� ������ ť�� �ְ� visit �迭�� üũ 
				if(!visit[i]) {
					Q.add(i);
					visit[i]= true;
				}
			}
		}
	}
}