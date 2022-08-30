package ru.ak;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ak.model.Person;

public class App {
    public static void main(String[] args) {
        deletePerson();
    }

    private static void getPerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 1);
            System.out.println(person.getName() + " " + person.getAge());
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void addPerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.beginTransaction();

            Person person1 = new Person("Tom", 10);
            Person person2 = new Person("Bob", 20);
            Person person3 = new Person("Jack", 30);

            currentSession.save(person1);
            currentSession.save(person2);
            currentSession.save(person3);

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void updatePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 2);
            System.out.println(person.getName() + " " + person.getAge());
            person.setName(person.getName() + "_new");
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void deletePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            currentSession.beginTransaction();
            Person person = currentSession.get(Person.class, 2);
            currentSession.delete(person);
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
