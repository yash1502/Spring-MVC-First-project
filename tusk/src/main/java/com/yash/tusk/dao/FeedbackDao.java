package com.yash.tusk.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.yash.tusk.entity.Feedback;

@Component
public class FeedbackDao {
	
	public void addFeed(Feedback fb) throws ClassNotFoundException, SQLException {

String sql = "insert into feedback values ('"+fb.getName()+"','"+fb.getEmail()+"','"+fb.getMsg()+"','"+fb.getReg()+"', '"+fb.getCode()+"', '"+fb.getRating()+"')";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://yash.cupt6nxtdna3.us-east-1.rds.amazonaws.com:3306/yash", "yash1502", "12345678");
Statement st = con.createStatement();
st.executeUpdate(sql);
	System.out.println("feedback added");
}
	
  public List<Feedback> getFeedbacks() throws ClassNotFoundException, SQLException {
	 
List<Feedback> feedbacks = new ArrayList();
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://yash.cupt6nxtdna3.us-east-1.rds.amazonaws.com:3306/yash",
        "yash1502", "12345678");

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from feedback");
while(rs.next()) {		
Feedback fb1  = new Feedback();
    fb1.setName(rs.getString("name"));
    fb1.setEmail(rs.getString("email"));
    fb1.setMsg(rs.getString("message"));
    fb1.setReg(rs.getString("regarding"));
    fb1.setCode(rs.getString("code"));
    fb1.setRating(rs.getInt("rating"));
    feedbacks.add(fb1);
}	
return feedbacks;
		}

	  
	  
  }

