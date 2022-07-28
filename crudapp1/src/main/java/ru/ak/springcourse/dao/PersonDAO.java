package ru.ak.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.ak.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final List<Person> people;
    private static int PEOPLE_COUNT = 0;

    {
        people = new ArrayList<>();
        people.add(new Person(PEOPLE_COUNT++, "Tom"));
        people.add(new Person(PEOPLE_COUNT++, "Bob"));
        people.add(new Person(PEOPLE_COUNT++, "Jack"));
        people.add(new Person(PEOPLE_COUNT++, "Mike"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(x -> x.getId() == id);
    }
}
