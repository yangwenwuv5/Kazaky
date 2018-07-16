package yww.cn;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


public class Search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		String question_tid = request.getParameter("tid");
		System.out.println("tid:" + question_tid);
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from question where tid = '" + question_tid +"'");
			
			String tid = "";
			String question = "";
			String otpA="";
			String otpB="";
			String otpC="";
			String otpD="";
			String answer="";
			//String age = "";
			//String dept = "";
			//String address = "";
			
			while(rs.next()){
				ArrayList<Question> list = new ArrayList<Question>();
				tid=rs.getString(1);
				question=rs.getString(2);
				otpA=rs.getString(3);
				otpB=rs.getString(4);
				otpC=rs.getString(5);
				otpD=rs.getString(6);
				answer=rs.getString(7);
				Question t = new Question(tid, question, otpA, otpB, otpC, otpD, answer); 
				list.add(t);
				//age=rs.getString(3);
				//dept=rs.getString(4);
				//address=rs.getString(5);
			}
			db.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			obj1.put("tid", tid);
			obj1.put("question", question);
			obj1.put("otpA", otpA);
			obj1.put("otpB", otpB);
			obj1.put("otpC", otpC);
			obj1.put("otpD", otpD);
			obj1.put("answer", answer);
			//obj.put("age", age);
			//obj.put("dept", dept);
			//obj.put("address", address);
			
		
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public static void doSearch(String student_id) {
		try {
			
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from question where tid = '" + question_tid +"'");
			
			String tid = "";
			String question = "";
			String otpA = "";
			String otpB = "";
			String otpC = "";
			String otpD = "";
			String answer="";
			//String dept = "";
			//String address = "";
			
			while(rs.next()){
				tid=rs.getString(1);
				question=rs.getString(2);
				otpA=rs.getString(3);
				otpB=rs.getString(4);
				otpC=rs.getString(5);
				otpD=rs.getString(6);
				answer=rs.getString(7);
				//sex=rs.getString(2);
				//dept=rs.getString(3);
				//address=rs.getString(4);
			}
			db.close();
			
			JSONObject obj = new JSONObject();
			
			obj.put("tid", tid);
			obj.put("question", question);
			obj.put("otpA", otpA);
			obj.put("otpB", otpB);
			obj.put("otpC", otpC);
			obj.put("otpD", otpD);
			obj.put("answer", answer);
			//obj.put("dept", dept);
			//obj.put("address", address);
			
			System.out.println(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		doSearch("2");
	}
*/
}
