package controlwork.human_friend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import controlwork.human_friend.models.PackAnimals;

@Repository
public interface PackAnimalRepository extends CrudRepository<PackAnimals, Long>{

}
