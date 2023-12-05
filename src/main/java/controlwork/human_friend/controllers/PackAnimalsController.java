package controlwork.human_friend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import controlwork.human_friend.models.PackAnimals;
import controlwork.human_friend.services.PackAnimalsServise;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pack_animals")
public class PackAnimalsController {
	private PackAnimalsServise packAnimalsServise;

	public PackAnimalsController(PackAnimalsServise packAnimalsServise) {
		this.packAnimalsServise = packAnimalsServise;
	}
	
	@GetMapping
	public String showPackAnimals(Model model) {
		model.addAttribute("packAnimals", packAnimalsServise.findAll());
		return "packAnimals/showPackAnimals";
	}
	
	@GetMapping("/{id}")
	public String showPackAnimal(@PathVariable("id") long id, Model model) {
		model.addAttribute("packAnimal", packAnimalsServise.findById(id));
		return "packAnimals/packAnimal";
	}
	
	@GetMapping("/new")
	public String openFormForCreateNewPackAnimal(Model model) {
		model.addAttribute("packAnimal", new PackAnimals());
		return "packAnimals/newPackAnimal";
	}
	
	@PostMapping
	public String createPackAnimal(@ModelAttribute("packAnimal") @Valid PackAnimals packAnimal,
			Errors errors) {
		
		if(errors.hasErrors())
			return "packAnimals/newPackAnimal";
		
		packAnimalsServise.createPackAnimal(packAnimal);
		return "redirect:/pack_animals";
	}
	
	@PostMapping("/{id}")
	public String deletePackAnimal(@PathVariable("id") long id) {
		PackAnimals packAnimal = packAnimalsServise.findById(id);
		packAnimalsServise.deletePackAnimal(packAnimal);
		return "redirect:/pack_animals";
	}
	
	@GetMapping("/{id}/edit")
	public String showEditPackAnimalPage(@PathVariable("id") long id, Model model) {
		model.addAttribute("packAnimal", packAnimalsServise.findById(id));
		return "packanimals/editPackAnimal";
	}
	
	@PostMapping("/{id}/edit")
	public String updatePackAnimal(@PathVariable("id") long id, 
			@ModelAttribute("packAnimal") @Valid PackAnimals packAnimal, Errors errors) {
		if(errors.hasErrors())
			return "packAnimals/editPackAnimal";
		
		packAnimalsServise.updatePackAnimal(packAnimal, id);
		return "redirect:/pack_animals";
	}
}
