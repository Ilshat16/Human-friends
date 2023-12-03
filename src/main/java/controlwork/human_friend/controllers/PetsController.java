package controlwork.human_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import controlwork.human_friend.models.Pets;
import controlwork.human_friend.services.PetsService;

@Controller
@RequestMapping("/home")
public class PetsController {
	
	private PetsService petService;

	public PetsController(PetsService petService) {
		this.petService = petService;
	}
	
	@GetMapping
	public String homePage(Model model) {
		model.addAttribute("pets", petService.findAll());
		return "home";
	}
}
