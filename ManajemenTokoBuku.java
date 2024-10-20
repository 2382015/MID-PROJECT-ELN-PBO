import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int stock;
    String category;
    String supplier;
    String expiryDate; // if applicable
    String condition; // "Good", "Damaged", etc.

    public Book(String title, String author, int stock, String category, String supplier, String expiryDate, String condition) {
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.category = category;
        this.supplier = supplier;
        this.expiryDate = expiryDate;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Stock: " + stock + ", Category: " + category
                + ", Supplier: " + supplier + ", Expiry: " + expiryDate + ", Condition: " + condition;
    }
}

public class BookManagementSystem {
    public static ArrayList<Book> books = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void registerBook() {
        System.out.println("Pendaftaran Buku Baru");
        String title = input("Judul Buku");
        String author = input("Penulis Buku");
        int stock = Integer.parseInt(input("Stok Buku"));
        String category = input("Kategori Buku");
        String supplier = input("Pemasok Buku");
        String expiryDate = input("Tanggal Kadaluarsa (opsional)");
        String condition = input("Kondisi Buku (baik/rusak)");

        books.add(new Book(title, author, stock, category, supplier, expiryDate, condition));
        System.out.println("Buku berhasil ditambahkan.");
    }
