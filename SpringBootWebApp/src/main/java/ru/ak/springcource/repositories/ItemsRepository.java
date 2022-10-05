package ru.ak.springcource.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ak.springcource.models.Item;
import ru.ak.springcource.models.Person;


import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

    List<Item> findByOwner(Person owner);

    List<Item> findByItemName(String itemName);
}
