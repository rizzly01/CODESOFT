package task3;
import java.util.Scanner;

public class AtmApplication {

	public static void main(String[] args) {
		
		 BankAccount userAccount = new BankAccount(1000.0); 
	        ATM atm = new ATM(userAccount);
	        atm.run();

	}

}
