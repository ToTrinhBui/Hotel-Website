package hotel.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import hotel.data.OrderRepository;
import hotel.data.StatsRepository;
import hotel.entity.Order;
import hotel.entity.Stats;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	private final OrderRepository orderRepo;
	private final StatsRepository statsRepo;
	
	@Autowired
	public OrderController(OrderRepository orderRepo, StatsRepository statsRepo) {
		this.orderRepo = orderRepo;
		this.statsRepo = statsRepo;
	}

	@ModelAttribute
	public void addOrderToModel(Model model) {
		List<Order> orders = (List<Order>) orderRepo.findAll();
		model.addAttribute("orders", orders);
	}
	@ModelAttribute
	public void addStatsToModel(Model model) {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		model.addAttribute("statsS", statsS);
		
	}

	@GetMapping
	public String showOrder() {
		return "order";
	}
	@RequestMapping("/linechartdata")
	@ResponseBody
	public String getDataFromDB() {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		JsonArray jsonName = new JsonArray();
		JsonArray jsonRevenue = new JsonArray();
		JsonObject json = new JsonObject();
		statsS.forEach(stats->{
			jsonName.add(stats.getName_room());
			jsonRevenue.add(stats.getRevenue());
		});
		json.add("name", jsonName);
		json.add("revenue", jsonRevenue);
		return json.toString();
	}

	@GetMapping("/detailOrder")
	public String detailOrder(@RequestParam("code") String code, Model model) {
		Optional<Order> orderX = orderRepo.findById(code);
		orderX.ifPresent(order -> model.addAttribute("order", order));
		return "detailOrder";
	}
}
