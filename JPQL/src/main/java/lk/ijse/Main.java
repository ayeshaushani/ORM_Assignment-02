package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Phone;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //SELECT
        Query query = session.createQuery("select UId from User u");
        List<User> userList = query.getResultList();
        for (User user : userList){
            System.out.println(user);
        }
        //UPDATE
        Query query1 = session.createQuery("update User  u set u.name = :age, u.name = :name  where u.UId = :UId");
        query1.setParameter("age","25");
        query1.setParameter("name","Sana");
        query1.setParameter("UId","5");
        query1.executeUpdate();
        //DELETE
        Query query2 = session.createQuery("delete from User u where u.UId = :UId");
        query2.setParameter("UId","2");
        query2.executeUpdate();
        //SEARCH BY ID
        Query query3 = session.createQuery("select u from User u where u.UId = :UId");
        query3.setParameter("UId","3");
        List<User> userList1 = query3.list();
        for (User user : userList1){
            System.out.println(user);
        }
        //JOINQUERY
        Query query4 = session.createQuery("select p from User u join u.id p where u.UId = :UId");
        query4.setParameter("UId","2");
        List<Phone> phones = query4.list();
        for (Phone phone : phones){
            System.out.println("Phone brand :"+phone.getBrand());
        }
        transaction.commit();
        session.close();
    }
    }
