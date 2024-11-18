package model;

/**
 * Represents a book with attributes such as ID, title, author, and availability status.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    // Constructor
    public Book() {
        // Default constructor
    }

    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Validates if the book has a valid title and author.
     * @return true if both title and author are non-null and non-empty; false otherwise.
     */
    public boolean isValidBook() {
        return title != null && !title.trim().isEmpty() && author != null && !author.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }

    // Main method for testing the Book class
    public static void main(String[] args) {
        Book book = new Book(1, "1984", "George Orwell", true);

        System.out.println("Book Details:");
        System.out.println(book);

        System.out.println("\nIs valid book: " + book.isValidBook());

        // Test invalid book case
        Book invalidBook = new Book(2, "", "", false);
        System.out.println("\nInvalid Book Details:");
        System.out.println(invalidBook);

        System.out.println("\nIs valid book: " + invalidBook.isValidBook());
    }
}
