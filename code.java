package digitalibery;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String isbn;  // unique identifier for a book
    private String title;
    private String author;
    private int availableCopies;

    public Book(String isbn, String title, String author, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String isbn, String title, String author, int availableCopies) {
        Book book = new Book(isbn, title, author, availableCopies);
        books.put(isbn, book);
        System.out.println("Book added successfully.");
    }

    public void deleteBook(String isbn) {
        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void modifyBook(String isbn, int newAvailableCopies) {
        if (books.containsKey(isbn)) {
            Book book = books.get(isbn);
            book.setAvailableCopies(newAvailableCopies);
            System.out.println("Book modified successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books.values()) {
            System.out.println("ISBN: " + book.getIsbn() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Available Copies: " + book.getAvailableCopies());
        }
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book\n2. Delete Book\n3. Modify Book\n4. Display Books\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.next();
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter available copies: ");
                    int availableCopies = scanner.nextInt();
                    library.addBook(isbn, title, author, availableCopies);
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to delete: ");
                    String deleteIsbn = scanner.next();
                    library.deleteBook(deleteIsbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to modify: ");
                    String modifyIsbn = scanner.next();
                    System.out.print("Enter new available copies: ");
                    int newAvailableCopies = scanner.nextInt();
                    library.modifyBook(modifyIsbn, newAvailableCopies);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting the library management system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
