package ru.ak.springrestapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ak.springrestapp.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
