package controlwork.human_friend.services;

import org.springframework.stereotype.Service;

import controlwork.human_friend.models.Pets;
import controlwork.human_friend.repositories.PetsRepository;
import jakarta.transaction.Transactional;

@Service
public class PetsService {
	
	private PetsRepository petRepository;

	public PetsService(PetsRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Iterable<Pets> findAll() {
		return petRepository.findAll();
	}
	
	public Pets findPetById(long id) {
		return petRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void save(Pets pet) {
		petRepository.save(pet);
	}
	
	@Transactional
	public void deletePet(Pets pet) {
		petRepository.delete(pet);
	}
}
