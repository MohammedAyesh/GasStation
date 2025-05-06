import java.util.Scanner;
import java.util.Date;
public class FuelPumping {
    String fuelType;
    double usedGallons;
    double usedGallonsRegular;
    double usedGallonsDiesel;
    public String fuelPump() {
        double price = promptUser();
        double gallons = promptUserGallons();
        usedGallons += gallons;
        Date date = new Date();
        return  "Fuel Receipt\n\n" +
                     "Fuel Type: " + fuelType + "\n" +
                     "Price Per Gallon: $" + price + "\n" +
                     "Gallons of Fuel: " + gallons + "\n" +
                     "Total Price: $" + (price*gallons) + "\n" +
                     "Date: " + date;
    }
    public double getGallons() {return usedGallons;}
    public String getType() {return fuelType;}
    private  double promptUser() {
        Scanner input = new Scanner(System.in);
        int inp;
        do {
            System.out.print("is Fuel type Regular, Premium, or Diesel, Type 0 for Regular, 1 for Premium, 2 for Diesel: ");
            inp = input.nextInt();
        } while (inp < 0 || inp > 2);
        if (inp == 0) {
            fuelType = "regular";

            return 3.45;
        }
        else if (inp == 1) {
            fuelType = "premium";
            return 4.00;
        }
        fuelType = "diesel";
        return 3.89;
    }
    private  double promptUserGallons() {
        Scanner input = new Scanner(System.in);
        int inp;
        do {
            System.out.print("How many Gallons do you want to fill up? ");
            inp = input.nextInt();
        } while (inp <= 0);
        return inp;
    }
}
