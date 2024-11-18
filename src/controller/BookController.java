package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class BookController {

    // Inner class to represent a Book
    public static class Book {
        private int id;
        private String title;
        private String author;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + "]";
        }
    }

    private List<Book> books;
    private int nextId;

    public BookController() {
        this.books = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Create a new book.
     * @param title Title of the book.
     * @param author Author of the book.
     */
    public void createBook(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.add(book);
        JOptionPane.showMessageDialog(null, "Book added: " + book);
    }

    /**
     * List all books.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books available.");
        } else {
            StringBuilder bookList = new StringBuilder("Books:\n");
            for (Book book : books) {
                bookList.append(book).append("\n");
            }
            JOptionPane.showMessageDialog(null, bookList.toString());
        }
    }

    /**
     * Update a book by its ID.
     * @param id ID of the book to update.
     * @param newTitle New title for the book.
     * @param newAuthor New author for the book.
     */
    public void updateBook(int id, String newTitle, String newAuthor) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getId() == id).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            JOptionPane.showMessageDialog(null, "Book updated: " + book);
        } else {
            JOptionPane.showMessageDialog(null, "Book not found with ID: " + id);
        }
    }

    /**
     * Delete a book by its ID.
     * @param id ID of the book to delete.
     */
    public void deleteBook(int id) {
        if (books.removeIf(b -> b.getId() == id)) {
            JOptionPane.showMessageDialog(null, "Book with ID " + id + " deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Book not found with ID: " + id);
        }
    }

    // Main method for testing the controller
    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.createBook("The Catcher in the Rye", "J.D. Salinger");
        controller.createBook("To Kill a Mockingbird", "Harper Lee");
        controller.listBooks();
        controller.updateBook(1, "The Catcher in the Rye", "Jerome David Salinger");
        controller.listBooks();
        controller.deleteBook(2);
        controller.listBooks();
    }
}
