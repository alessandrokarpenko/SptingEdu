package ru.ak;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ak.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();





            session.getTransaction().commit();
        }
    }

    private static void manyToMany() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("pulp fiction", 1994);
//            Actor actor1 = new Actor("harvey keitel", 81);
//            Actor actor2 = new Actor("samuel l. jackson", 72);
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie.getActors());

//            Movie movie = new Movie("reservoir dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);

            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);



            session.getTransaction().commit();
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

//            person.addItem(new Item("Test cascading item 1"));
//            person.addItem(new Item("Test cascading item 2"));
//            person.addItem(new Item("Test cascading item 3"));

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
