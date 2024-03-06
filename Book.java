package imp;

import ra.IBook;

import java.util.Scanner;

public class Book implements IBook {
   private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String author;
    private  String descriptions;

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String author, String descriptions) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.descriptions = descriptions;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập id sách: ");
        bookId = scanner.nextLine();
        System.out.println("Nhập tên sách:  ");
        bookName = scanner.nextLine();
        System.out.println("Nhập giá nhập vào: ");
        importPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập giá bán: ");
        exportPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập tác giả sách: ");
        author = scanner.nextLine();
        System.out.println("Nhập mô tả sách: ");
        descriptions= scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("Book Name %s\tBookId %s\timportPrice %f\texportPrice %f\tauthor %S\tdescriptions %S\n",
                bookName,bookId,importPrice,exportPrice,author,descriptions);
    }
}
