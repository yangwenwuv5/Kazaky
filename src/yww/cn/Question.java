package yww.cn;

public class Question {

	public String tid;
	public String question;
	public String otpA;
	public String otpB;
	public String otpC;
	public String otpD;
	public String answer;
	public Question() {
		
	}
	public Question(String tid, 
			String question, String otpA, 
			String otpB,String otpC,String otpD, String answer) {
		this.tid = tid;
		this.question = question;
		this.otpA = otpA;
		this.otpB = otpB;
		this.otpC = otpC;
	    this.otpD= otpD;
	    this.answer= answer;
	}
	public static void main(String[] args) {
		

	}

}
