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
        boolean removed = books.removeIf(book -> book.title.equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Buku berhasil dihapus.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
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
                if (book.stock >= amount) {
                    book.stock -= amount;
                    System.out.println("Stok buku berhasil dikurangi.");
                } else {
                    System.out.println("Stok tidak mencukupi untuk dikurangi.");
                }
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
        // Implementasi pelacakan riwayat transaksi
        System.out.println("Pelacakan Riwayat Transaksi");
        System.out.println("Masukkan detail transaksi (belum diimplementasikan): ");
        String transactionDetails = input("Detail Transaksi");
        // Simpan atau proses detail transaksi sesuai kebutuhan.
        System.out.println("Detail transaksi diterima: " + transactionDetails);
    }
public static void manageSuppliers() {
        // Implementasi manajemen pemasok buku
        System.out.println("Manajemen Pemasok Buku");
        String supplierName = input("Masukkan nama pemasok");
        String supplierDetails = input("Masukkan detail pemasok");
        // Simpan atau proses detail pemasok sesuai kebutuhan.
        System.out.println("Pemasok " + supplierName + " dengan detail: " + supplierDetails + " telah ditambahkan.");
    }

    public static void forecastDemand() {
        // Implementasi forecasting permintaan buku
        System.out.println("Forecasting Permintaan Buku");
        String bookTitle = input("Masukkan judul buku untuk forecasting");
        String demandForecast = input("Masukkan perkiraan permintaan (misalnya: tinggi, sedang, rendah)");
        // Simpan atau proses perkiraan permintaan sesuai kebutuhan.
        System.out.println("Permintaan untuk buku " + bookTitle + " diperkirakan: " + demandForecast);
    }

    public static void expiredOrDamagedBookWarning() {
        System.out.println("Peringatan Buku Kadaluarsa atau Rusak");
        for (Book book : books) {
            if (book.condition.equalsIgnoreCase("rusak") || !book.expiryDate.isEmpty()) {
                System.out.println("Peringatan: Buku " + book.title + " dalam kondisi rusak atau kadaluarsa.");
            }
        }
    }

    public static void manageCategories() {
        // Implementasi manajemen kategori buku
        System.out.println("Manajemen Kategori Buku");
        String categoryName = input("Masukkan nama kategori");
        String categoryDetails = input("Masukkan detail kategori");
        // Simpan atau proses detail kategori sesuai kebutuhan.
        System.out.println("Kategori " + categoryName + " dengan detail: " + categoryDetails + " telah ditambahkan.");
    }

    public static String input(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n--- Menu Manajemen Buku ---");
            System.out.println("1. Pendaftaran Buku Baru");
            System.out.println("2. Pengurangan Stok Buku");
            System.out.println("3. Pembaruan Informasi Buku");
            System.out.println("4. Pencarian dan Penyortiran Buku");
            System.out.println("5. Laporan Stok Buku");
            System.out.println("6. Penghapusan Buku");
            System.out.println("7. Notifikasi Stok Rendah");
            System.out.println("8. Pelacakan Riwayat Transaksi");
            System.out.println("9. Manajemen Pemasok Buku");
            System.out.println("10. Forecasting Permintaan Buku");
            System.out.println("11. Peringatan Buku Kadaluarsa atau Rusak");
            System.out.println("12. Manajemen Kategori Buku");
            System.out.println("13. Keluar");

            String selectedMenu = input("Pilih menu");

            switch (selectedMenu) {
                case "1":
                    registerBook();
                    break;
                case "2":
                    reduceBookStock();
                    break;
                case "3":
                    updateBookInfo();
                    break;
                case "4":
                    searchAndSortBooks();
                    break;
                case "5":
                    reportStock();
                    break;
                case "6":
                    removeBook();
                    break;
                case "7":
                    lowStockNotification();
                    break;
                case "8":
                    trackTransactionHistory();
                    break;
                case "9":
                    manageSuppliers();
                    break;
                case "10":
                    forecastDemand();
                    break;
                case "11":
                    expiredOrDamagedBookWarning();
                    break;
                case "12":
                    manageCategories();
                    break;
                case "13":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar.");
            }
        }
    }
}
