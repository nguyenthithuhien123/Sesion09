package run;

import imp.Book;

import java.util.*;

public class BookRun {
    public static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    ======================== MENU ========================
                    1\tNhập thông tin sách
                    2\tHiển thị thông tin sách
                    3\tCập nhật thông tin sách theo mã sách
                    4\tXóa sách theo mã sách
                    5\tSắp xếp sách theo giá bán tăng dần
                    6\tThống kê sách theo khoảng giá (a-b) nhập từ bàn phím)
                    7\tTìm kiếm sách theo tên tác giả
                    8\tThoát
                    """);
            System.out.println("Mời bạn chọn: ");
            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1:
                    System.out.println("Mời bạn nhập số sách cần thêm: ");
                    int bookOfNumber = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < bookOfNumber; i++) {
                        Book book = new Book();
                        book.inputData(scanner);
                        books.add(book);
                    }
                    break;
                case 2:
                    for (Book b : books) {
                        b.displayData();
                    }
                    break;
                case 3:
                    System.out.println("Nhập Mã sách cần cập nhật: ");
                    String upDateBookId = scanner.nextLine();
                    if (bookById(upDateBookId) >= 0) {
                        books.get(bookById(upDateBookId)).inputData(scanner);
                    } else {
                        System.out.println("Book Id không tồn tại");
                    }
                    break;
                case 4:
                    System.out.println("Nhập Mã sách cần xóa: ");
                    String deleteBookId = scanner.nextLine();
                    if (bookById(deleteBookId) >= 0) {
                        books.remove(bookById(deleteBookId));
                    } else {
                        System.out.println("Book Id không tồn tại");
                    }
                    break;
                case 5:
                    sapXep();
                    for (Book b : books) {
                        b.displayData();
                    }
                    break;
                case 6:
                    System.out.println("Nhập khoảng giá cần tìm p1,p2 ");
                    System.out.println("Nhập giá p1 ");
                    float p1 = Float.parseFloat(scanner.nextLine());
                    System.out.println("Nhập giá p2: ");
                    float p2 = Float.parseFloat(scanner.nextLine());
                    int count = 0;
                    for (Book p : books) {
                        if (p.getExportPrice() >= p1 && p.getExportPrice() <= p2) {
                            p.displayData();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không có sách nào có khoảng giá trên");
                    }
                    break;
                case 7:
                    System.out.println("Nhâp tên tác giả cần tìm kiếm:");
                    String inputFinedAuthor = scanner.nextLine();

                    if (bookByAuthor(inputFinedAuthor) >= 0) {
                        books.get(bookByAuthor(inputFinedAuthor)).displayData();
                    } else {
                        System.out.println("Tác giả không tồn tại!");
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Mời bạn chọn từ 1-8");
            }
        } while (true);
    }

    public static int bookById(String inputBook) {
        for (int i = 0; i < books.size(); i++) {
            if (inputBook.equalsIgnoreCase(books.get(i).getBookId())) {
                return i;
            } else return -1;
        }
        return -1;
    }

    public static int bookByAuthor(String inputBookAuthor) {
        for (int i = 0; i < books.size(); i++) {
            if (inputBookAuthor.equalsIgnoreCase(books.get(i).getAuthor())) {
                return i;
            } else return -1;
        }
        return -1;
    }

    /**
     * void BubbleSort(int a[], int n){
     * int temp; // biến tạm temp
     * for (int i = 0; i < n; i++){
     * for (int j = 0; j < n; j++){
     * if (a[i] > a[j]){
     * temp = a[i];
     * a[i] = a[j];
     * a[j] = temp;
     * }
     * }
     * }
     * }
     */
    public static void sapXep() {//List<Book>books ngoài class thì truyền vào
        Book temp;
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size(); j++) {
                if (books.get(i).getExportPrice() > books.get(j).getExportPrice()) {
                    temp = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, temp);
                }
            }
        }
    }

}
