package ua.bakery.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Production;
import ua.bakery.db.jpa.Request;
import ua.bakery.db.jpa.RequestProduction;
import ua.bakery.db.jpa.User;

/**
 * Клас для реалізації завдання з лабораторної роботи №11
 * @author Vadym
 * @deprecated
 *
 */
public class Lab11 {

	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
    private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		// Фабричний метод. Отримуємо об'єкт EntityManagerFactory
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		readData();
		int idRequest = writeData();
		editData(idRequest);
		removeData(idRequest);
	}
	
	/**
	 * Вибірка даних
	 */
	public static void readData(){
		EntityManager em = factory.createEntityManager();
		
		// Читання замовлення і продукції в замовленні
		Request request = (Request) em.find(Request.class, 50);
		System.out.println("Заявка: " + request.toString());
		showList(request.getRequestProductionCount());
		
		// Читання усіх користувачів
		Query q = em.createQuery("select user from User user");
        @SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
        showList(users);
	}
	
	/**
	 * Запис даних до БД
	 */
	public static int writeData(){
		System.out.println("----СТВОРЕННЯ ЗАМОВЛЕННЯ----");
		
		Random random = new Random();	// Для генераціїї випадкових кількостей продукції
		EntityManager em = factory.createEntityManager();
		
		// Отримаємо існуючого користувача і клієнта
		User user = (User) em.find(User.class, 2);
		Client client = (Client) em.find(Client.class, 4);
		System.out.println("Користувач: " + user.toString());
		System.out.println("Клієнт    : " + client.toString());
		System.out.println("Дата форм.: " + new Date());
		
		// Отримаємо всі продукти
		Query q = em.createQuery("select product from Production product");
        
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
        int i = 0, MAX = 10;
        
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
				System.out.format("%-35s: %d%n", production.getName(), count);
				
				if(++i>MAX) break;
			}
		}
        
		request.setRequestProductionCount(requestProductions);
		
		// Збережемо до БД
		em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
        System.out.println("----СТВОРЕНО----");
        
        return request.getId();
	}
	
	/**
	 * Редагування даних
	 */
	public static void editData(int requestId){
		System.out.println("----РЕДАГУВАННЯ----");
		EntityManager em = factory.createEntityManager();
		
		Request request = (Request) em.find(Request.class, requestId); // Отримаємо замовлення
		System.out.println(request);
		
		// Змінимо замовлення
        System.out.println("Замовлення: ");
		em.getTransaction().begin();
		for(RequestProduction requestProduction : request.getRequestProductionCount()){
			requestProduction.setCount(requestProduction.getCount() * 2);
			System.out.format("%-35s: %d%n", requestProduction.getProduction().getName(), requestProduction.getCount());
		}
        em.getTransaction().commit();
        em.close();
		System.out.println("----ВІДРЕДАГОВАНО----");
	}
	
	/**
	 * Видалення даних
	 * @param requestId
	 */
	public static void removeData(int requestId){
		System.out.println("----ВИДАЛЕННЯ----");
		EntityManager em = factory.createEntityManager();
		
		Request request = (Request) em.find(Request.class, requestId); // Отримаємо замовлення
		System.out.println(request);
		
		// Видалемо замовлення
		em.getTransaction().begin();
		em.remove(request);
        em.getTransaction().commit();
        em.close();
		System.out.println("----ВИДАЛЕНО----");
	}
	
	/**
	 * Вивід списку
	 * @param list
	 */
	public static void showList(List<?> list){
		
		if(list==null || list.size() == 0){
			System.out.println("Список порожній!");
			return;
		}
		
		System.out.println("----" + list.get(0).getClass() + "----");

		if(list.get(0) instanceof RequestProduction){
			System.out.format("%-35s| %s%n", "Назва ", "К-сть");
			for(Object ent: list){
				System.out.format("%-35s: %d%n", ((RequestProduction)ent).getProduction(), ((RequestProduction)ent).getCount());
			}
		}
		else{
			for(Object ent: list){
				System.out.println(ent.toString());
			}
		}
		
		System.out.println("--------------------------------------");
	}
}