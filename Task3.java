import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void addCopy() {
        copies++;
    }

    public void removeCopy() {
        if (copies > 0) {
            copies--;
        }
    }
}

class Library {
    private Book[] books;
    private int totalBooks;

    public Library(int capacity) {
        books = new Book[capacity];
        totalBooks = 0;
    }

    public void addBook(String title, String author, int copies) {
        if (totalBooks < books.length) {
            books[totalBooks] = new Book(title, author, copies);
            totalBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(int index) {
        if (index >= 0 && index < totalBooks) {
            for (int i = index; i < totalBooks - 1; i++) {
                books[i] = books[i + 1];
            }
            books[totalBooks - 1] = null;
            totalBooks--;
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (int i =0; i < totalBooks; i++) {
            System.out.println(i+1+". "+ books[i].getTitle() + " by " + books[i].getAuthor() + " (" + books[i].getCopies() + " copies)");
        }
    }

    public int searchBook(String title) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public Book getBook(int index) {
        if (index >= 0 && index < totalBooks) {
            return books[index];
        }
        return null;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Library library = new Library(10);
        Scanner scanner = new Scanner(System.in);

        // Adding some initial books
        library.addBook("Java", "Harry", 5);
        library.addBook("Frontend", "Hayathi", 3);
        library.addBook("Database management", "Hermione", 7);

        while (true) {
            System.out.println("==========***==========");
            System.out.print("\nMenu:\n");
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Check Number of Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Add a Book (Admin)");
            System.out.println("5. Remove a Book (Admin)");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.println("Total number of books in the library: " + library.getTotalBooks());
                    break;
                case 3:
                    System.out.print("Enter the title of the book to search: ");
                    scanner.nextLine(); // Consume newline
                    String searchTitle = scanner.nextLine();
                    int searchResult = library.searchBook(searchTitle);
                    if (searchResult != -1) {
                        Book book = library.getBook(searchResult);
                        System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getCopies() + " copies)");
                    } else {
                        System.out.println("Book not found in the library.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    scanner.nextLine(); // Consume newline
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int newCopies = scanner.nextInt();
                    library.addBook(newTitle, newAuthor, newCopies);
                    break;
                case 5:
                    System.out.print("Enter the index of the book to remove: ");
                    int removeIndex = scanner.nextInt();
                    library.removeBook(removeIndex+1);
                    break;
                case 6:
                    System.out.println("Exiting the Library Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    
}
