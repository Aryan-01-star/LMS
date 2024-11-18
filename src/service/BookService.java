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

    /**
     * Retrieves all books from the database.
     * @return List of all books or null if an error occurs.
     */
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

    /**
     * Searches for books by title or author.
     * @param query Search query for title or author.
     * @return List of matching books or null if an error occurs.
     */
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

    /**
     * Adds a new book to the database.
     * @param book Book to add.
     * @return true if the operation is successful, false otherwise.
     */
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

    /**
     * Updates an existing book in the database.
     * @param book Book to update.
     * @return true if the operation is successful, false otherwise.
     */
    public boolean updateBook(Book book) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.error("Error updating book: ", e);
            return false;
        }
    }

    /**
     * Deletes a book from the database.
     * @param bookId ID of the book to delete.
     * @return true if the operation is successful, false otherwise.
     */
    public boolean deleteBook(int bookId) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                session.delete(book);
                session.getTransaction().commit();
                return true;
            } else {
                logger.warn("Book not found with ID: " + bookId);
                return false;
            }
        } catch (Exception e) {
            logger.error("Error deleting book: ", e);
            return false;
        }
    }

    /**
     * Closes the SessionFactory.
     */
    public static void closeFactory() {
        if (factory != null) {
            factory.close();
        }
    }
}
