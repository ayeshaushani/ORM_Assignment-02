package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Phone;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Query query =  session.createQuery("from User");
        List<User> userlist = query.list();
        for (User user : userlist){
            System.out.println(user.getUId());
        }

       /* Query query1 =  session.createQuery("  from User where UId =1 ");
        Query query2 =  session.createQuery("from User where UId = 1");
        List<User> userList = query1.list();
        for (User user :userList)
*/
   /* {
        System.out.println(user.getUId());
    }*/



       Query query3 =  session.createQuery("from User where UId = (?,?)");
        Query query4 =  session.createQuery("from User where UId = (?,?)");
        query3.setParameter(1,2);
        List<User> userlist2 = query4.list();
        for (User user : userlist2){
            System.out.println(user.getName());
        }


                /* --------------------------------------------------------------------------------*/

                /*HQL does not have direct insert query*/

        User user= new User();
        user.setUId("5");
        user.setName("menaka");
        user.setAge("60");
        Phone phone = new Phone();
        phone.setPId("2");
        phone.setBrand("samsung");
        phone.setPrice("50000");
        phone.setUser(user);
        List<Phone>list=new ArrayList<>();
        list.add(phone);
        phone.getUser(list);
        session.save(user);
        session.save(phone);

                /* --------------------------------------------------------------------------------*/


                /*update*/

        Query query5 = session.createQuery("UPDATE User SET name = :name WHERE UId = :UId");
        query5.setParameter("name","sidevi");
        query5.setParameter("no",1);
        query5.executeUpdate();

                /* --------------------------------------------------------------------------------*/
//       delete

            Query query6 = session.createQuery("DELETE FROM User where UId =:UId");
            query6.setParameter("UId","4");
            query6.executeUpdate();

                /* --------------------------------------------------------------------------------*/

                /* search*/

        Query query7 = session.createQuery("FROM User WHERE UId = :UId", User.class);
        query7.setParameter("UId", "3");
        List<User> users = query.list();
        for (User user1 : users){
            System.out.println("UId: "+user.getUId()+"name: "+user.getName()+"age: "+user.getAge());
        }

                /* --------------------------------------------------------------------------------*/


        Query query8 = session.createQuery("SELECT u.name, u.age FROM User u WHERE u.UId = :UId");
        query8.setParameter("UId", 1);
        List<Object[]> results = query.list();
        for (Object[] result : results) {
            String id = (String) result[0];
            String name = (String) result[1];
            String age = (String) result[2];
            System.out.println("UId: " + id + " name: " + name + "age: "+age);
        }

                /* --------------------------------------------------------------------------------*/

        Query query9 = session.createQuery("select u.UId ,u.name, u.age from User u");
        results = query9.list();
        for (Object[] result : results) {
            String id = (String) result[0];
            String name = (String) result[1];
            String age = (String) result[2];
            System.out.println("user id: " + id + ", Name: " + name +"age: " +age);
        }

                /* --------------------------------------------------------------------------------*/


                /* join*/
        Query query10 = session.createQuery("SELECT p.id, p.brand , p.price FROM Phone p INNER JOIN p.user u WHERE u.UId= :id");
        query10.setParameter("id", 1);
        results = query.list();
        for (Object[] result : results) {
            String id = (String) result[0];
            String brand = (String) result[1];
            String price = (String) result[2];
            System.out.println(id + " " + brand );
        }
        transaction.commit();
        session.close();


    }
}