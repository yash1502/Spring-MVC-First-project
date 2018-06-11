package com.yash.tusk;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.tusk.dao.QuestionDao;
import com.yash.tusk.entity.Questions;

@Controller
public class QuestionController {
@Autowired
QuestionDao qdao;	
@RequestMapping("/addQuestion")	
public String addQues(@RequestParam("id") int id, @RequestParam("question") String question
		             ,@RequestParam("A") String optionA, @RequestParam("B") String optionB,
		             @RequestParam("C") String optionC, @RequestParam("D") String optionD,
		             @RequestParam("answer") String answer) throws ClassNotFoundException, SQLException {
Questions ques = new Questions(id,question,optionA,optionB,optionC,optionD,answer);

qdao.addQues(ques);
	
return "check.jsp";	
}

@RequestMapping("/getQuestion")
public ModelAndView getQues() throws ClassNotFoundException, SQLException {

	ModelAndView mv = new ModelAndView();
	mv.setViewName("seeQuestion.jsp");
	mv.addObject("see", qdao.GetQuestion());
	
	return mv;
	
}
}
