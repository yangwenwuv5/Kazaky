package yww.cn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {


	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			String sql = "insert into question(tid,question,otpA,otpB,otpC,otpD,answer) values('','','','','','','')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from question");
			
			ArrayList<Question> list = new ArrayList<Question>();
			while(rs.next()){
				String tid = rs.getString(1);
				String question = rs.getString(2);
			    String otpA = rs.getString(3);
				String otpB = rs.getString(4);
				String otpC = rs.getString(5);
				String otpD = rs.getString(6);
				String answer = rs.getString(7);
				Question t = new Question(tid, question, otpA, otpB, otpC, otpD, answer);
				list.add(t);
			}
			b.close();
			int N=10;
			Random r = new Random();
			int j=0; int k=0;
			int[] g= {-1,-1,-1,-1};
			while(j<4) {
				int num = r.nextInt(N);
				while(k<4){
					if(g[k]==num)
						break;
					k++;
				}
				if(k==4){
			g[j] = num;
			j++;
			System.out.println(num);
				}
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
