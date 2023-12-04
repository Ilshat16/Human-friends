package controlwork.human_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		petsService.savePet(pet);
		return "redirect:/pets";
	}
	
	@GetMapping("/{id}")
	public String showPet(@PathVariable("id") long id, Model model) {
		model.addAttribute("pet", petsService.findPetById(id));
		return "pets/pet";
	}
	
	@PostMapping("/{id}")
	public String deletePet(@PathVariable("id") long id) {
		Pets pet = petsService.findPetById(id);
		petsService.deletePet(pet);
		return "redirect:/pets";
	}
	
	@GetMapping("/{id}/edit")
	public String showEditPet(@PathVariable("id") long id, Model model) {
		model.addAttribute("pet", petsService.findPetById(id));
		return "pets/editPet";
	}
	
	@PostMapping("/{id}/edit")
	public String updatePet(@PathVariable("id") long id, Pets pet) {
		petsService.updatePet(pet, id);
		return "redirect:/pets";
	}

}
