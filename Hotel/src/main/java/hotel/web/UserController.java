package hotel.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.data.UserRepository;
import hotel.entity.User;
import hotel.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customers")
public class UserController {
	private final UserRepository userRepo;

	@Autowired
	private UserService service;

	@Autowired
	public UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<User> list = service.listAll(keyword);
		model.addAttribute("list", list);
		model.addAttribute("keyword", keyword);
		return "customer";
	}

	@GetMapping("/detailUser")
	public String detailUser(@RequestParam("code") Integer code, Model model) {
		Optional<User> userX = userRepo.findById(code);
		userX.ifPresent(user -> model.addAttribute("user", user));
		return "detailUser";
	}
}
