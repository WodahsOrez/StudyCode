package my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/index")
	@ModelAttribute(value="word")
	public String toindex() {
		return "hi";
	}
}
