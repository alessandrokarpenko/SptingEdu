package ru.ak;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ak.model.Item;
import ru.ak.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

            Person person = new Person("Test cascading", 30);
            Item item = new Item("Test cascading item", person);
            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            currentSession.save(person);


            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void cascadeEx() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();

            Person person = new Person("Test cascading", 30);

            person.addItem(new Item("Test cascading item 1"));
            person.addItem(new Item("Test cascading item 2"));
            person.addItem(new Item("Test cascading item 3"));

            currentSession.save(person);

            currentSession.getTransaction().commit();
        }
    }

    private static void hsl() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();

            List<Person> people = currentSession.createQuery("from Person where age > 30").getResultList();

            people.forEach(System.out::println);

            currentSession.getTransaction().commit();
        }
    }

    private static void getPerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 1);
            System.out.println(person.getName() + " " + person.getAge());
            currentSession.getTransaction().commit();
        }
    }

    private static void addPerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();

            Person person1 = new Person("Tom1", 40);
            Person person2 = new Person("Bob1", 50);
            Person person3 = new Person("Jack1", 60);

            currentSession.save(person1);
            currentSession.save(person2);
            currentSession.save(person3);

            currentSession.getTransaction().commit();
        }
    }

    private static void updatePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 2);
            System.out.println(person.getName() + " " + person.getAge());
            person.setName(person.getName() + "_new");
            currentSession.getTransaction().commit();
        }
    }

    private static void deletePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 2);
            currentSession.delete(person);
            currentSession.getTransaction().commit();
        }
    }
}
