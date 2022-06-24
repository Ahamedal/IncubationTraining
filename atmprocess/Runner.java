package atmprocess;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ATMProcess atmProcess=new ATMProcess();
		atmProcess.initialSetUp();
		System.out.println("Enter no Of 2000's");
		int noOf2000=sc.nextInt();
		System.out.println("Enter no of 500's");
		int noOf500=sc.nextInt();
		System.out.println("Enter no of 100's");
		int noOf100=sc.nextInt();
		
		atmProcess.setAtmAmount(noOf2000,noOf500,noOf100);
		
		
		
		
	}
}
