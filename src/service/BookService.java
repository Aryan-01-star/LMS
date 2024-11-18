package service;

import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Book.class)
            .buildSessionFactory();

    public List<Book> getAllBooks() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            List<Book> books = session.createQuery("from Book", Book.class).getResultList();
            session.getTransaction().commit();
            return books;
        } catch (Exception e) {
            logger.error("Error fetching all books: ", e);
            return null;
        }
    }

    public List<Book> searchBooks(String query) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            List<Book> books = session.createQuery("from Book b where b.title like :query or b.author like :query", Book.class)
                    .setParameter("query", "%" + query + "%")
                    .getResultList();
            session.getTransaction().commit();
            return books;
        } catch (Exception e) {
            logger.error("Error searching books: ", e);
            return null;
        }
    }

    public boolean addBook(Book book) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.error("Error adding book: ", e);
            return false;
        }
    }

    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
