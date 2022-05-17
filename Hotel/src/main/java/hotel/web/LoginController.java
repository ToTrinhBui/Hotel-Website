package hotel.web;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String login(Model model) {
		//model.addAttribute("user", new User());
		return "login";
	}
	/*@PostMapping
	public String processOrder(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			return "login";
		}
		log.info("User submitted: " + user);
		return "redirect:/";

	}*/
}
