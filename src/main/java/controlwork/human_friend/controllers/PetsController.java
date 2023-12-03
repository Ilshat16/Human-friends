package controlwork.human_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import controlwork.human_friend.models.Pets;
import controlwork.human_friend.services.PetsService;

@Controller
@RequestMapping("/pets")
public class PetsController {
	
	private PetsService petsService;

	public PetsController(PetsService petsService) {
		this.petsService = petsService;
	}
	
	@GetMapping
	public String showPets(Model model) {
		model.addAttribute("pets", petsService.findAll());
		return "pets/showPets";
	}
	
	@GetMapping("/new")
	public String openFormForCreateNewPet(Model model) {
		model.addAttribute("pet", new Pets());
		return "pets/newPet";
	}
	
	@PostMapping
	public String savePet(Pets pet) {
		petsService.save(pet);
		return "redirect:/pets";
	}

}
