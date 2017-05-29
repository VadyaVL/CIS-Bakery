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
 * ���� ��� ��������� �������� � ����������� ������ �11
 * @author Vadym
 * @deprecated
 *
 */
public class Lab11 {

	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
    private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		// ��������� �����. �������� ��'��� EntityManagerFactory
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		readData();
		int idRequest = writeData();
		editData(idRequest);
		removeData(idRequest);
	}
	
	/**
	 * ������ �����
	 */
	public static void readData(){
		EntityManager em = factory.createEntityManager();
		
		// ������� ���������� � ��������� � ���������
		Request request = (Request) em.find(Request.class, 50);
		System.out.println("������: " + request.toString());
		showList(request.getRequestProductionCount());
		
		// ������� ��� ������������
		Query q = em.createQuery("select user from User user");
        @SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
        showList(users);
	}
	
	/**
	 * ����� ����� �� ��
	 */
	public static int writeData(){
		System.out.println("----��������� ����������----");
		
		Random random = new Random();	// ��� ���������� ���������� ��������� ���������
		EntityManager em = factory.createEntityManager();
		
		// �������� ��������� ����������� � �볺���
		User user = (User) em.find(User.class, 2);
		Client client = (Client) em.find(Client.class, 4);
		System.out.println("����������: " + user.toString());
		System.out.println("�볺��    : " + client.toString());
		System.out.println("���� ����.: " + new Date());
		
		// �������� �� ��������
		Query q = em.createQuery("select product from Production product");
        
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
        int i = 0, MAX = 10;
        
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
				System.out.format("%-35s: %d%n", production.getName(), count);
				
				if(++i>MAX) break;
			}
		}
        
		request.setRequestProductionCount(requestProductions);
		
		// ��������� �� ��
		em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
        em.close();
        System.out.println("----��������----");
        
        return request.getId();
	}
	
	/**
	 * ����������� �����
	 */
	public static void editData(int requestId){
		System.out.println("----�����������----");
		EntityManager em = factory.createEntityManager();
		
		Request request = (Request) em.find(Request.class, requestId); // �������� ����������
		System.out.println(request);
		
		// ������ ����������
        System.out.println("����������: ");
		em.getTransaction().begin();
		for(RequestProduction requestProduction : request.getRequestProductionCount()){
			requestProduction.setCount(requestProduction.getCount() * 2);
			System.out.format("%-35s: %d%n", requestProduction.getProduction().getName(), requestProduction.getCount());
		}
        em.getTransaction().commit();
        em.close();
		System.out.println("----²�����������----");
	}
	
	/**
	 * ��������� �����
	 * @param requestId
	 */
	public static void removeData(int requestId){
		System.out.println("----���������----");
		EntityManager em = factory.createEntityManager();
		
		Request request = (Request) em.find(Request.class, requestId); // �������� ����������
		System.out.println(request);
		
		// �������� ����������
		em.getTransaction().begin();
		em.remove(request);
        em.getTransaction().commit();
        em.close();
		System.out.println("----��������----");
	}
	
	/**
	 * ���� ������
	 * @param list
	 */
	public static void showList(List<?> list){
		
		if(list==null || list.size() == 0){
			System.out.println("������ �������!");
			return;
		}
		
		System.out.println("----" + list.get(0).getClass() + "----");

		if(list.get(0) instanceof RequestProduction){
			System.out.format("%-35s| %s%n", "����� ", "�-���");
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