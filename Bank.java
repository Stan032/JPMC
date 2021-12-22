package jPMC;

public class Bank {
	private int accountNumber;
	private String source1;
	private String source2;
	
		public Bank(String source1, String source2, int accountNumber) {
			this.source1 = source1;
			this.source2 = source2;
			this.accountNumber = accountNumber;
			}

		public int getAccountNumber() {
			return accountNumber;
		}
		public String getSource1() {
			return source1;
			
		}

		public String getSource2() {
			return source2;
		}

}
