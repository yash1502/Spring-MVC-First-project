package com.yash.tusk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yash.tusk.entity.Questions;

@Component
public class QuestionDao {

public void addQues(Questions q) throws ClassNotFoundException, SQLException	{
	
	String sql= "insert into question values('"+q.getId()+"', '"+q.getQuestion()+"', '"+q.getOptionA()+"', '"+q.getOptionB()+"', '"+q.getOptionC()+"','"+q.getOptionD()+"','"+q.getAnswer()+"')";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telusko", "root", "qwerty");
	Statement st = con.createStatement();
	st.executeUpdate(sql);
		System.out.println("questions added");	
}

public List<Questions> GetQuestion() throws ClassNotFoundException, SQLException{

	List<Questions> list = new ArrayList();
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telusko", "root", "qwerty");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from question");
	
	while(rs.next()) {
	Questions qu = new Questions();	
	qu.setId(rs.getInt("id"));
	qu.setQuestion(rs.getString("question"));
	qu.setOptionA(rs.getString("option1"));
	qu.setOptionB(rs.getString("option2"));
	qu.setOptionC(rs.getString("option3"));
	qu.setOptionD(rs.getString("option4"));
	qu.setAnswer(rs.getString("answer"));
	list.add(qu);  
	}
	return list;
	
}
}
