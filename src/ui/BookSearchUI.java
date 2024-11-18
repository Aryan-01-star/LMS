package ui;

import javax.swing.*;
import java.awt.event.*;
import service.BookService;
import model.Book;
import java.util.List;

public class BookSearchUI extends JPanel {
    private JTextField searchField;
    private JList<Book> resultsList;
    private BookService bookService;

    public BookSearchUI() {
        this.bookService = new BookService();
        setupUI();
    }

    private void setupUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel searchLabel = new JLabel("Search Books:");
        add(searchLabel);

        searchField = new JTextField(20);
        searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String query = searchField.getText();
                updateResults(query);
            }
        });
        add(searchField);

        resultsList = new JList<>();
        add(new JScrollPane(resultsList));
    }

    private void updateResults(String query) {
        List<Book> results = bookService.searchBooks(query);
        resultsList.setListData(results.toArray(new Book[0]));
    }
}
