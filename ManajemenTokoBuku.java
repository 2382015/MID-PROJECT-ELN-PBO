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

    public static void reportStock() {
    System.out.println("Laporan Stok Buku");
    for (Book book : books) {
        System.out.println(book);
    }
}

public static void reduceBookStock() {
    System.out.println("Pengurangan Stok Buku");
    String title = input("Masukkan judul buku yang ingin dikurangi stoknya");
    int amount = Integer.parseInt(input("Jumlah yang ingin dikurangi"));
    for (Book book : books) {
        if (book.title.equalsIgnoreCase(title)) {
            book.stock -= amount;
            System.out.println("Stok buku berhasil dikurangi.");
            return;
        }
    }
    System.out.println("Buku tidak ditemukan.");
}

public static void lowStockNotification() {
    System.out.println("Notifikasi Stok Rendah");
    for (Book book : books) {
        if (book.stock < 5) {
            System.out.println("Stok buku " + book.title + " rendah: " + book.stock + " unit tersisa.");
        }
    }
}

public static void trackTransactionHistory() {
    // Placeholder for tracking transaction history.
    System.out.println("Pelacakan Riwayat Transaksi belum diimplementasikan.");
}
