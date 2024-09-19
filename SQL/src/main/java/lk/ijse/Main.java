package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query =session.createNativeQuery("select * from User");
        query.addEntity(User.class);
        List<User> list = query.getResultList();
        for (User user : list){
            System.out.println(user.getUId());
        }

        /* insert--------------------------------------------------------------------------------------*/
        NativeQuery query1= session.createNativeQuery("INSERT INTO User (UId,name,age) VALUES (:UId, :name, :age)");
        query1.setParameter("UId", "3");
        query1.setParameter("name", "Ayesha");
        query1.setParameter("age", "23");
        query1.executeUpdate();

        NativeQuery query2 = session.createNativeQuery("INSERT INTO User (UId,name,age) VALUES (?1, ?2,?3)");
        query2.setParameter(1, 5);
        query2.setParameter(2, "ushi");
        query2.setParameter(3, "23");
        query2.executeUpdate();

        /*update-----------------------------------------------------------------------------------*/
         NativeQuery query3 = session.createNativeQuery("UPDATE User SET name = 'Ayesha' WHERE UId = :UId");
         query3.setParameter("UId", 1);

        NativeQuery query4 = session.createNativeQuery("UPDATE User SET name = ?1 WHERE UId = ?2");
         query4.setParameter(1, "pawan");
         query4.setParameter(2,5);
         query4.executeUpdate();


        /* delete-----------------------------------------------------------------------------------*/
         NativeQuery query5 = session.createNativeQuery("DELETE FROM User WHERE UId = :UId");
         query5.setParameter("no", 3);
        /* delete-----------------------------------------------------------------------------------*/
         NativeQuery query6 = session.createNativeQuery("DELETE FROM User WHERE UId = ?1");
         query6.setParameter(1, 5);
         query6.executeUpdate();

        /* search-----------------------------------------------------------------------------------*/
         NativeQuery query7 = session.createNativeQuery("SELECT * FROM User WHERE name = :name", User.class);
         query7.setParameter("name", "dileksha");
         NativeQuery query8 = session.createNativeQuery("SELECT * FROM User WHERE name = ?1", User.class);
         query8.setParameter(1, "Nimala");
         List<User> userlist = query.getResultList();
         for (User user : list) {
            System.out.println(user.getUId() + " " + user.getName() + " " + user.getAge());
         }

        /*joinQuery-----------------------------------------------------------------------------------------*/
      /*  Query query9 = session.createQuery("SELECT u.UId, u.name , u.age FROM User u INNER JOIN Phone p ON u.UId = p.PId");
        List<Object[]> results = query.list();
        for (Object[] result : results) {
            String userId = (String) result[0];
            String userName = (String) result[1];
            String userAge = (String) result[2];
            System.out.println(userId + " " + userName + " " + userAge);
        }

        String PId = (String) result[0];
        String brand = (String) result[1];
        String price = (String) results.get(2);
        System.out.println(PId + " " + brand );
    }*/


            transaction.commit();
        session.close();

    }
}