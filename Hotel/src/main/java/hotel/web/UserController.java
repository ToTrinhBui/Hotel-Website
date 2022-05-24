package hotel.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.data.UserRepository;
import hotel.entity.User;

import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customers")
public class UserController {
	private final UserRepository userRepo;

	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@ModelAttribute
	public void addUserToModel(Model model) {
		List<User> users = (List<User>) userRepo.findAll();
		model.addAttribute("users", users);
	}

	@GetMapping
	public String showCostumer() {
		return "customer";
	}

	@GetMapping("/detailUser")
	public String detailUser(@RequestParam("code") Integer code, Model model) {
		Optional<User> userX = userRepo.findById(code);
		userX.ifPresent(user -> model.addAttribute("user", user));
		return "detailUser";
	}
}
