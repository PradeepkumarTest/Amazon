import java.util.Scanner;

public class evennumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		System.out.println("Enter value of n:");
		
		int n=s.nextInt();
		
		if(n==0) {
			System.out.println("zero");
			
		}else if(n%2==0) {//-15/2=-5
			if(n>0) {
				System.out.println("+ve even number");
			}else {
				System.out.println("-ve even number");
			}
		}
		else {
			if(n>0) {
				System.out.println("+ve odd number");
			}else {
				System.out.println("-ve odd number");
			}
		}
		
		
	}

}