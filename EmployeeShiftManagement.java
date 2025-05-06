package GasStation;
import java.util.Scanner;

public class EmployeeShiftManagement {
    public String EmployeeShiftManagements() {
        int res = promptUserIdNumber();
        int total = promptUserShiftHours();
        return "The total earnings for User " + res + " is $" + total;
    }
    private  int promptUserIdNumber() {
        Scanner input = new Scanner(System.in);
        int inp;
        do {
            System.out.print("Please Enter your Employee ID Number ");
            inp = input.nextInt();
        } while (inp < 10000 || inp > 99999);
        return inp;
    }
    private  int promptUserShiftHours() {
        Scanner input = new Scanner(System.in);
        int inp;
        int tips;
        do {
            System.out.print("Please Enter your Shift Hours: ");
            inp = input.nextInt();
        } while (inp < 0);
        do {
            System.out.print("Please Enter your Cash tips: ");
            tips = input.nextInt();
        } while (tips < 0);
        if (tips > 40) tips /= 2;
        inp = (inp * 18) + tips;
        return inp;
    }
}
