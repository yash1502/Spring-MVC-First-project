package com.yash.tusk;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.tusk.dao.FeedbackDao;
import com.yash.tusk.entity.Feedback;


@Controller
public class IndexController {

@Autowired
FeedbackDao fdao;


@RequestMapping("/")	
public String Home() {
	
	return "index.jsp";
}

@RequestMapping("/feedback.htm")
public String feedback() {  //this method is calling the feedback page
	
	return "feedback.jsp";
}

@RequestMapping("/addFeedback")
public String addFeedback(@RequestParam("name") String name, @RequestParam("email") String email,
		@RequestParam("reg") String reg, @RequestParam("code") String code, @RequestParam("comments") String msg,
		@RequestParam("rating") int rating) throws ClassNotFoundException, SQLException { // we want these values to go in the database 
	
	//FeedbackDao fdao = new FeedbackDao(); not a good practise to use new keyword. use dependency injection
  Feedback feedback = new Feedback(name, email, reg, code,msg, rating);
  
	fdao.addFeed(feedback);
	return "welcome.jsp";
}

@RequestMapping("/getFeedbacks.htm")
public ModelAndView getFeedbacks() throws ClassNotFoundException, SQLException {
	
ModelAndView mv = new ModelAndView();
mv.setViewName("feedbacks.jsp");
mv.addObject("AllFeedbacks", fdao.getFeedbacks());
return mv;
	
}
}
