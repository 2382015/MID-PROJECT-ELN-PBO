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

public class ManajemenTokoBuku {
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

    public static void updateBookInfo() {
        System.out.println("Pembaruan Informasi Buku");
        String title = input("Masukkan judul buku yang ingin diperbarui");
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.author = input("Penulis Baru");
                book.category = input("Kategori Baru");
                book.supplier = input("Pemasok Baru");
                book.expiryDate = input("Tanggal Kadaluarsa Baru");
                book.condition = input("Kondisi Baru");
                System.out.println("Informasi buku diperbarui.");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public static void removeBook() {
        System.out.println("Penghapusan Buku");
        String title = input("Masukkan judul buku yang ingin dihapus");
        books.removeIf(book -> book.title.equalsIgnoreCase(title));
        System.out.println("Buku berhasil dihapus.");
    }

    public static void searchAndSortBooks() {
        System.out.println("Pencarian dan Penyortiran Buku");
        String keyword = input("Masukkan kata kunci untuk pencarian (judul/penulis)");
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase()) ||
                    book.author.toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        searchResults.sort((b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
        for (Book book : searchResults) {
            System.out.println(book);
        }
    }
