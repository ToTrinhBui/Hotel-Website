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

import hotel.data.OrderRepository;
import hotel.entity.Order;

import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	private final OrderRepository orderRepo;

	@Autowired
	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}

	@ModelAttribute
	public void addOrderToModel(Model model) {
		List<Order> orders = (List<Order>) orderRepo.findAll();
		model.addAttribute("orders", orders);
	}

	@GetMapping
	public String showOrder() {
		return "order";
	}

	@GetMapping("/detailOrder")
	public String detailOrder(@RequestParam("code") String code, Model model) {
		Optional<Order> orderX = orderRepo.findById(code);
		orderX.ifPresent(order -> model.addAttribute("order", order));
		return "detailOrder";
	}
}
