package ua.bakery.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Log;
import ua.bakery.db.jpa.Request;
import ua.bakery.db.jpa.User;

public class SecondLabMain {
	
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            // read the existing entries and write to console
            Query q = em.createQuery("select l from Client l");
            List<Client> todoList = q.getResultList();
            for (Client todo : todoList) {
                System.out.println(todo);
                System.out.println("********************");
                for(Request r : todo.getRequests()){
                    System.out.println(r);
                }
                System.out.println("--------------------");
            }
            System.out.println("Size: " + todoList.size());

            // create new todo
            /*em.getTransaction().begin();
            
            User todo = new User();
            todo.setUsername("TestJPA");
            todo.setPassword("Pass TestJPA");
            todo.setRealName("TestJPA TestJPA");
            todo.setPhoto("Photo TestJPA");
            todo.setAccessLevel(0);
            em.persist(todo);
            em.getTransaction().commit();

            em.close();
            */
    }
	
}
