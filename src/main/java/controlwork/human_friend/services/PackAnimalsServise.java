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
	
	public PackAnimals findById(long id) {
		return packAnimalRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void createPackAnimal(PackAnimals packAnimals) {
		packAnimalRepository.save(packAnimals);
	}
	
	@Transactional
	public void deletePackAnimal(PackAnimals packAnimal) {
		packAnimalRepository.delete(packAnimal);
	}
	
	@Transactional
	public void updatePackAnimal(PackAnimals packAnimal, long id) {
		packAnimal.setId(id);
		packAnimalRepository.save(packAnimal);
	}
}
