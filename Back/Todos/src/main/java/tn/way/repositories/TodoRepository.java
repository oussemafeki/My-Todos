package tn.way.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.way.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer > {

}
