import java.util.*;

public class lms{

    static class Book {
        int bookId;
        String title, author;
        boolean isAvailable;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public void displayBookInfo() {
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
            System.out.println();
        }

        public boolean borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }
            return false;
        }

        public void returnBook() {
            isAvailable = true;
        }
    }

    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: " + book.title);
        }

        public void removeBook(int bookId) {
            for (Iterator<Book> it = books.iterator(); it.hasNext(); ) {
                Book book = it.next();
                if (book.bookId == bookId) {
                    it.remove();
                    System.out.println("Book removed: " + book.title);
                    return;
                }
            }
            System.out.println("Book with ID " + bookId + " not found.");
        }

        public void listAvailableBooks() {
            boolean found = false;
            System.out.println("Available Books:");
            for (Book book : books) {
                if (book.isAvailable) {
                    book.displayBookInfo();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No books available.");
            }
        }

        public Book findBookById(int bookId) {
            for (Book book : books) {
                if (book.bookId == bookId) {
                    return book;
                }
            }
            return null;
        }
    }

    static class Student {
        int studentId;
        String name;
        ArrayList<Book> borrowedBooks = new ArrayList<>();

        public Student(int studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }

        public void borrowBook(Book book) {
            if (book.isAvailable && borrowedBooks.size() < 3) {
                borrowedBooks.add(book);
                book.borrowBook();
                System.out.println(name + " borrowed: " + book.title);
            } else if (!book.isAvailable) {
                System.out.println("The book \"" + book.title + "\" is not available.");
            } else {
                System.out.println("Borrowing limit reached. You cannot borrow more than 3 books.");
            }
        }

        public void returnBook(Book book) {
            if (borrowedBooks.contains(book)) {
                borrowedBooks.remove(book);
                book.returnBook();
                System.out.println(name + " returned: " + book.title);
            } else {
                System.out.println("This book is not in your borrowed list.");
            }
        }

        public void displayBorrowedBooks() {
            if (borrowedBooks.isEmpty()) {
                System.out.println(name + " has not borrowed any books.");
            } else {
                System.out.println(name + "'s Borrowed Books:");
                for (Book book : borrowedBooks) {
                    book.displayBookInfo();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.addBook(new Book(1, "Data Mining", "Sharma Sir"));
        library.addBook(new Book(2, "Data Structures", "Bhaskaran Sir"));
        library.addBook(new Book(3, "Java Lab Manual", "Pranav Bro"));

        Student student = new Student(224212, "Saiganesh");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List Available Books");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Borrow Book by ID");
            System.out.println("5. Return Book by ID");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.listAvailableBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;

                case 3:
                    System.out.print("Enter Book ID to remove: 📕");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    break;

                case 4:
                    System.out.print("Enter the ID of the book to borrow: 📘");
                    int borrowId = sc.nextInt();
                    Book bookToBorrow = library.findBookById(borrowId);
                    if (bookToBorrow != null) {
                        student.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the ID of the book to return: 📗");
                    int returnId = sc.nextInt();
                    Book bookToReturn = library.findBookById(returnId);
                    if (bookToReturn != null) {
                        student.returnBook(bookToReturn);
                    } else {
                        System.out.println("🚫Book not found.");
                    }
                    break;

                case 6:
                    student.displayBorrowedBooks();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye👋!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
