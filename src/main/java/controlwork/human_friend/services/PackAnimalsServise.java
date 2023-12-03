package controlwork.human_friend.services;

import org.springframework.stereotype.Service;

import controlwork.human_friend.models.PackAnimals;
import controlwork.human_friend.repositories.PackAnimalRepository;
import jakarta.transaction.Transactional;

@Service
public class PackAnimalsServise {
	
	private PackAnimalRepository packAnimalRepository;

	public PackAnimalsServise(PackAnimalRepository packAnimalRepository) {
		this.packAnimalRepository = packAnimalRepository;
	}
	
	public Iterable<PackAnimals> findAll() {
		return packAnimalRepository.findAll();
	}
	
	@Transactional
	public void save(PackAnimals packAnimals) {
		packAnimalRepository.save(packAnimals);
	}

}
