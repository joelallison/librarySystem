package library.userTypes;

import library.Book;
import library.Main;
import library.User;
import library.basicUtil;

import java.util.ArrayList;
import java.util.Locale;

public class Borrower extends library.User{

    private ArrayList<Book> Books;

    public Borrower(String username, String password, int accessLevel) {
        super(username, password, accessLevel);
    }

    public void menu() {
        boolean running = true;
        System.out.println("Options --> { Add book(s) [a], Edit a book's information [e], Take out a book [t], Return a book [r], List the library [l], Quit the program [q] }\n");
        String choice = basicUtil.getInput().toLowerCase(Locale.ROOT);
        switch (choice) {
            case "b":
                Main.addBooks();
                break;
            case "e":
                Main.findBook();
                Main.editBook(new Book());
                break;
            case "l":
                Main.listLib();
                break;
            case "q":
                running = false;
                break;
        }
    }

    public void addBook(Book book){ this.Books.add(book); }

    public ArrayList<Book> getBooks() { return Books; }
}
