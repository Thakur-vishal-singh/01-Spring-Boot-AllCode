package tech.vishal.Repo;

import org.springframework.data.repository.CrudRepository;

import tech.vishal.Entity.EmpEntity;

public interface EmpRepo extends CrudRepository<EmpEntity, Integer>{

}
