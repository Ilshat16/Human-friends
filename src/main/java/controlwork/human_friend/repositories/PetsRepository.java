package controlwork.human_friend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import controlwork.human_friend.models.Pets;

@Repository
public interface PetsRepository extends CrudRepository<Pets, Long>{

}
