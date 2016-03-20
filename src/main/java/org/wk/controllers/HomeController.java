package org.wk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String goHome() {
		return "Selenium Testing";
	}
}
