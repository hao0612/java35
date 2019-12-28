package cn.itxdl.client;

import java.util.Scanner;

public class ClientScanner {
	public static Scanner sc = new Scanner(System.in); 
	public static Scanner getSc() {
		return sc;
	}
	public static void cioseSc() {
		sc.close();
	}
	
	
}
