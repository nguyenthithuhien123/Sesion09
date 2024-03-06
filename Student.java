package ra.entity;

import ra.itf.IStudent;

import java.util.Scanner;

public class Student implements IStudent {

    private String studentId;
    private String studentName;
    private int age;
    private float diemToan;
    private float diemLy;       //: float – điểm lý
   private float diemHoa;        // : float – điểm hóa
     private float diemTB;      //: float – điểm trung bình
    private boolean status;      //: Boolean – Trạng thái sinh viên

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float diemToan, float diemLy, float diemHoa, boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public float getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }

    public float getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(Scanner scanner) {
        System.out.println("Mời nhập  mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.println("Mời nhập tên sinh viên: ");
        this.studentName = scanner.nextLine();
        System.out.println("Mời nhập tuổi sinh viên: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập điểm toán: ");
        this.diemToan = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời nhập điểm lý");
        this.diemLy = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời nhập điểm hóa");
        this.diemHoa = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời bạn nhập trạng thái sinh  viên true: đang học hoặc false: thôi học");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
    public float getDiemTB() {
        return this.diemTB = (getDiemToan()+getDiemLy()+getDiemHoa())/3;
    }
    public String xetDiem(){
        if (getDiemTB()>=MARK_PASS){
            return "pass";
        }else return "fall";
    }

    @Override
    public void displayData() {
        System.out.printf("Tên học sinh: %s - MSV: %s - Tuổi sinh viên: %d - Điểm toán: %f - Điểm lý: %f - Điểm hóa: %f - Điểm trung bình:%f - Trạng thái: %s - Tình trạng qua môn: %s\n",
                this.studentName,this.studentId,this.age,this.diemToan,this.diemLy,this.diemHoa,getDiemTB(),this.status?"Đang học":"Thôi học",xetDiem());
    }

}
