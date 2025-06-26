import java.util.*;
public class LibraryManagementSystem {
    static class Book {
        int id;
        String title;
        boolean isIssued;
        Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.isIssued = false;
        }
        void issueBook() {
            isIssued = true;
        }
        void returnBook() {
            isIssued = false;
        }
        public String toString() {
            return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
        }
    }
    static class User {
        int userId;
        String name;
        User(int userId, String name) {
            this.userId = userId;
            this.name = name;
        }
        public String toString() {
            return userId + " - " + name;
        }
    }
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        books.add(new Book(1, "I Too Had a Love Story"));
        books.add(new Book(2, "Can Love Happen Twice?\n" + "\n"));
        users.add(new User(101, "Ravinder Singh"));
        boolean running = true;
        while (running) {
            System.out.println("\n LIBRARY MENU");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    boolean foundIssue = false;
                    for (Book book : books) {
                        if (book.id == issueId && !book.isIssued) {
                            book.issueBook();
                            System.out.println("Book issued successfully.");
                            foundIssue = true;
                            break;
                        }
                    }
                    if (!foundIssue) System.out.println("Book not available or already issued.");
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    boolean foundReturn = false;
                    for (Book book : books) {
                        if (book.id == returnId && book.isIssued) {
                            book.returnBook();
                            System.out.println("Book returned successfully.");
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) System.out.println("Invalid book return attempt.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
