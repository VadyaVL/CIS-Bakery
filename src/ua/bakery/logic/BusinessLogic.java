package ua.bakery.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ua.bakery.db.jpa.*;

public final class BusinessLogic {
	
	private BusinessLogic() { }
	
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
    private static EntityManagerFactory factory;
    
	public static int AddNewRequest(){
        System.out.println("************СТВОРЕННЯ************");
		// Для генераціїї випадкових кількостей продукції
		Random random = new Random();

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// Отримаємо існуючого користувача і клієнта
		User user = (User) em.find(User.class, 2);
		Client client = (Client) em.find(Client.class, 4);
		System.out.println("Користувач: " + user.toString());
		System.out.println("Клієнт    : " + client.toString());
		
		// Отримаємо всі продукти
		Query q = em.createQuery("select p from Production p");
        @SuppressWarnings("unchecked")
		List<Production> productions = q.getResultList();

		// Створимо замовлення
        Request request = new Request();
        request.setDate_Request(new Date());		// Встановити дату виконання
        request.setDate_Oformleniya(new Date());	// Встановити дату формування
        request.setClient(client);
        request.setUser(user);
        request.setOk(false);
        
		// Сформуємо список необхідних продуктів
        
        // Штучно обмежимо максимальну кількість продукції в замовленні - ЛИШЕ ДЛЯ ЗРУЧНОЇ ДЕМОНСТРАЦІЇ
        int i = 0, MAX = 7;
        
        System.out.println("Замовлення: ");
        List<RequestProduction> requestProductions = new ArrayList<>();
		for(Production production : productions){
			
			int count = random.nextInt(100);
			
			if(count != 0){
				RequestProduction rp = new RequestProduction();
				rp.setProduction(production);
				rp.setRequest(request);
				rp.setCount(count);
				requestProductions.add(rp);
				System.out.println(production.getName() + ": " + count);
				
				if(++i>MAX) break;
			}
		}
        
		request.setRequestProductionCount(requestProductions);
		
		// Збережемо до БД
		em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
        System.out.println("************СТВОРЕНО************");
        
        return request.getId();
	}
	
	// Помножити кількість продукції на два
	public static void EditRequest(int id){
		System.out.println("************РЕДАГУВАННЯ************");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// Отримаємо замовлення
		Request request = (Request) em.find(Request.class, id);
		
		// Переглянемо замовлення
		System.out.println(request);
		
		// Змінимо замовлення
        System.out.println("Замовлення: ");
		em.getTransaction().begin();
		for(RequestProduction requestProduction : request.getRequestProductionCount()){
			requestProduction.setCount(requestProduction.getCount() * 2);
			System.out.println(requestProduction.getProduction().getName() + ": " + requestProduction.getCount());
		}
        em.getTransaction().commit();
        em.close();
		System.out.println("************ВІДРЕДАГОВАНО************");
	}
	
	public static void DeleteRequest(int id){
		System.out.println("************ВИДАЛЕННЯ************");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// Отримаємо замовлення
		Request request = (Request) em.find(Request.class, id);
		
		// Переглянемо замовлення
		System.out.println(request);
		
		// Видалемо замовлення
		em.getTransaction().begin();
		em.remove(request);
        em.getTransaction().commit();
        em.close();
		System.out.println("************ВИДАЛЕНО************");
	}
	
}
