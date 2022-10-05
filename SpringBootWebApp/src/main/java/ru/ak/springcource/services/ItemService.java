package ru.ak.springcource.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ak.springcource.models.Item;
import ru.ak.springcource.models.Person;
import ru.ak.springcource.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person person) {
        return itemsRepository.findByOwner(person);
    }

}
