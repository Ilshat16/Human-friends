package controlwork.human_friend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import controlwork.human_friend.models.PackAnimal;

@Repository
public interface PackAnimalRepository extends CrudRepository<PackAnimal, Long>{

}
