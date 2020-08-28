package ru.lantsev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lantsev.entity.Product;
import ru.lantsev.entity.User;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        // CRUD
        Session session = factory.getCurrentSession() ;
        session.beginTransaction() ;
        /*
        написать тестовое консольное приложение, которое позволит посмотреть,
        какие товары покупал клиент,
         */

        //Смотрим какие товары покупал клиент 1

        User user1 = session.get(User.class , 1) ;
        System.out.println(user1);
        user1.getProducts().forEach(System.out::println);

        System.out.println();

        //Смотрим какие товары покупал клиент 2
        User user2 = session.get(User.class , 2) ;
        System.out.println(user2);
        user2.getProducts().forEach(System.out::println);

        /*
        какие клиенты купили определенный товар,
         */

        System.out.println();

        //Смотрим продукт 1
        Product product1 = session.get(Product.class, 1) ;
        System.out.println(product1);
        product1.getUsers().forEach(System.out::println);

        System.out.println();

        //Смотрим продукт 2
        Product product2 = session.get(Product.class, 2) ;
        System.out.println(product2);
        product2.getUsers().forEach(System.out::println);

        /*
        предоставит возможность удалять из базы товары/покупателей.
         */
        //Удаляем продукт 5
        Product productDel = session.get(Product.class, 5) ;
        session.delete(productDel);

        //Удаляем пользователя 5
        User user = session.get(User.class, 5) ;
        session.delete(user);

        session.getTransaction().commit();

    }
}
