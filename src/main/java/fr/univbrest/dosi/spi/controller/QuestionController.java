package fr.univbrest.dosi.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.spi.bean.Etudiant;
import fr.univbrest.dosi.spi.bean.Promotion;
import fr.univbrest.dosi.spi.bean.PromotionEtudiant;
import fr.univbrest.dosi.spi.bean.Question;
import fr.univbrest.dosi.spi.service.QuestionService;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAll() {
		return questionService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addQuestion(@RequestBody Question qst) {
		questionService.addQuestion(qst);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{idQuestion}")
	public void deleteQuestion(@PathVariable int idQuestion) {
		questionService.deleteQuestion(idQuestion);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{IdQuestion}")
	public Question getQuestion(@PathVariable("IdQuestion") int idqst)
	{
		return questionService.getQuestion(idqst);
	}

}
