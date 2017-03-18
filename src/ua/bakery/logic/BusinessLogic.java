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
        System.out.println("************���������************");
		// ��� ���������� ���������� ��������� ���������
		Random random = new Random();

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// �������� ��������� ����������� � �볺���
		User user = (User) em.find(User.class, 2);
		Client client = (Client) em.find(Client.class, 4);
		System.out.println("����������: " + user.toString());
		System.out.println("�볺��    : " + client.toString());
		
		// �������� �� ��������
		Query q = em.createQuery("select p from Production p");
        @SuppressWarnings("unchecked")
		List<Production> productions = q.getResultList();

		// �������� ����������
        Request request = new Request();
        request.setDate_Request(new Date());		// ���������� ���� ���������
        request.setDate_Oformleniya(new Date());	// ���������� ���� ����������
        request.setClient(client);
        request.setUser(user);
        request.setOk(false);
        
		// �������� ������ ���������� ��������
        
        // ������ �������� ����������� ������� ��������� � ��������� - ���� ��� �����ί ���������ֲ�
        int i = 0, MAX = 7;
        
        System.out.println("����������: ");
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
		
		// ��������� �� ��
		em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
        System.out.println("************��������************");
        
        return request.getId();
	}
	
	// ��������� ������� ��������� �� ���
	public static void EditRequest(int id){
		System.out.println("************�����������************");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// �������� ����������
		Request request = (Request) em.find(Request.class, id);
		
		// ����������� ����������
		System.out.println(request);
		
		// ������ ����������
        System.out.println("����������: ");
		em.getTransaction().begin();
		for(RequestProduction requestProduction : request.getRequestProductionCount()){
			requestProduction.setCount(requestProduction.getCount() * 2);
			System.out.println(requestProduction.getProduction().getName() + ": " + requestProduction.getCount());
		}
        em.getTransaction().commit();
        em.close();
		System.out.println("************²�����������************");
	}
	
	public static void DeleteRequest(int id){
		System.out.println("************���������************");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		// �������� ����������
		Request request = (Request) em.find(Request.class, id);
		
		// ����������� ����������
		System.out.println(request);
		
		// �������� ����������
		em.getTransaction().begin();
		em.remove(request);
        em.getTransaction().commit();
        em.close();
		System.out.println("************��������************");
	}
	
}
