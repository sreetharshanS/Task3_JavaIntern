import java.util.*;

//Book class
class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String toString() {
        return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User class
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Library class
class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book \"" + b.title + "\" issued to " + user.name);
                return;
            }
        }
        System.out.println("Book not available!");
    }

    void returnBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book \"" + b.title + "\" returned by " + user.name);
                return;
            }
        }
        System.out.println("Invalid return request!");
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

     
        library.addBook(new Book(1, "Physics"));
        library.addBook(new Book(2, "Dynamic Lecture"));
        library.addBook(new Book(3, "Psychology Of Money"));

        
        User user1 = new User(101, "Alice");

        library.showBooks();
        library.issueBook(2, user1);
        library.showBooks();
        library.returnBook(2, user1);
        library.showBooks();
    }
}

