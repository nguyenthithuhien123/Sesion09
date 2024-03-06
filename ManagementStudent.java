package ra.run;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementStudent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();

        do {
            System.out.println("""
                    ********************************MENU***************************
                         1.	Nhập thông tin n sinh viên
                         2.	Tính điểm trung bình sinh viên
                         3.	Xét điểm qua cho sinh viên
                         4.	Hiển thị thông tin sinh viên
                         5.	Thoát
                    """);
            System.out.println("Mời bạn chọn: ");
            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose){
                case 1:
                    System.out.println("Mời bạn nhập số thông tin cần thêm: ");
                  int studentNumber = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < studentNumber; i++) {
                        Student student = new Student();
                        System.out.println("Mời bạn nhập thông tin sinh viên: "+(i+1));
                        student.inputData(scanner);
                       students.add(student);
                    }

                    break;
                case 2:
                    for (Student tb: students){
                        System.out.println("Điểm trung bình của học sinh "+tb.getStudentName()+" là: "+tb.getDiemTB());
                    }
                    break;
                case 3:
                    for (Student xd: students){
                        System.out.println("Hoc sinh "+xd.getStudentName()+" là: "+xd.xetDiem());
                    }
                    break;
                case 4:
                    for (Student show : students){
                        show.displayData();
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Mời bạn nhập lại từ 1-5");
            }
        }while (true);
    }
}
