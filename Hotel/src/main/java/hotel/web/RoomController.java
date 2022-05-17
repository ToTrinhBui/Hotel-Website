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

import hotel.entity.Room;
import hotel.data.RoomRepository;

import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/rooms")
public class RoomController {
	private final RoomRepository roomRepo;

	@Autowired
	public RoomController(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}

	@ModelAttribute
	public void addRoomToModel(Model model) {
		List<Room> rooms = (List<Room>) roomRepo.findAll();
		model.addAttribute("rooms", rooms);
	}

	@GetMapping
	public String showRoom() {
		return "room";
	}
	
	@GetMapping("/detailRoom")
	public String detailRoom(@RequestParam("code") String code, Model model) {
		Optional<Room> roomX = roomRepo.findById(code);
		roomX.ifPresent(room -> model.addAttribute("room", room));
		return "detailRoom";
	}
	
	@GetMapping("/add")
	public String addRoom(Model model) {
		model.addAttribute("room", new Room(null, null, null, null, null, null));
		return "addRoom";
	}

	@GetMapping("/editForm")
	public String editFormRoom(@RequestParam("code") String code, Model model) {
		Optional<Room> roomX = roomRepo.findById(code);
		roomX.ifPresent(room -> model.addAttribute("room", room));
		return "editRoom";
	}
	
	@GetMapping("/confirmDelete")
	public String confirmDeleteRoom(@RequestParam("code") String code, Model model) {
		Optional<Room> roomX = roomRepo.findById(code);
		roomX.ifPresent(room -> model.addAttribute("room", room));
		return "deleteRoom";
	}

	@PostMapping("/delete")
	public String deleteRoom(Room room, Model model) {
		roomRepo.delete(room);
		model.addAttribute(room);
		return "redirect:/rooms";
	}

	@PostMapping("/save")
	public String saveRoom(@Valid Room room, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "addRoom";
		else {
			roomRepo.save(room);
			model.addAttribute(room);
			log.info("Product saved: " + room);
			return "addProductSuccess";
		}
	}

	@PostMapping("/edit")
	public String editProduct(Room room, Model model) {
		roomRepo.save(room);
		model.addAttribute(room);
		log.info("Product saved: " + room);
		return "redirect:/rooms";
	}
}