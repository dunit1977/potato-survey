package com.libertymutual.goforcode.hello_world_again.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.hello_world_again.models.SurveyResults;

@Controller
public class HomeController {

	private SurveyResults results = new SurveyResults();

	@RequestMapping("/")
	public String defaultPage() {
		return "potato";
	}

	@RequestMapping("/twice-baked")
	public ModelAndView twiceBaked() {
		ModelAndView carbs = new ModelAndView();
		carbs.setViewName("spuds");
		carbs.addObject("variety", "fingerling");
		carbs.addObject("temperature", 425);
		return carbs;
	}

	@RequestMapping("/survey")
	public ModelAndView survey(String answer) {
		ModelAndView survey = new ModelAndView();
		survey.setViewName("results");
		survey.addObject("userResponse", answer);

		if (answer.equals("Sweet")) {
			results.registerSweetVote();
		}
		if (answer.equals("Russet")) {
			results.registerRussetVote();
		}
		if (answer.equals("Golden")) {
			results.registerGoldenVote();
		}
		survey.addObject("results", results);

		return survey;
	}
}
