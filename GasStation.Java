package GasStation;

import java.util.Scanner;
import java.util.Date;
class GasStation {
    
    final static double defaultGallonsRegular = 300;
    final static double defaultGallonsPremium = 300;
    final static double defaultGallonsDiesel = 300;
    static double currentGallonsRegular = defaultGallonsRegular;
    static double currentGallonsPremium = defaultGallonsPremium;
    static double currentGallonsDiesel = defaultGallonsDiesel;
    static double usedGallonsPremium = 0;
    static double usedGallonsRegular = 0;
    static double usedGallonsDiesel = 0;
    static int minimium = 100;
    public static void main(String[] args) {
        Date date = new Date();
        int inp = -1;
        while (inp != 10) {
        inp = promptUser();
        String result = "";
        if (inp == 2) {
            EmployeeShiftManagement emp = new EmployeeShiftManagement();
            result = emp.EmployeeShiftManagements();
            System.out.println("\n" + result);
        }
        else if (inp == 1) {
            FuelPumping cus = new FuelPumping();
            result = cus.fuelPump(currentGallonsRegular, currentGallonsPremium, currentGallonsDiesel);
            System.out.println("\n" + result);
            String fuelType = cus.getType();
            double gallons = cus.getGallons();
            switch (fuelType) {
                case "regular": usedGallonsRegular += gallons;currentGallonsRegular -= gallons;break;
                case "premium": usedGallonsPremium+= gallons;currentGallonsPremium -= gallons;break;
                case "diesel": usedGallonsDiesel+= gallons;currentGallonsDiesel-= gallons;
            }
        } else {
            promptManager();
            managerPrompts(getFuelType());
                
            String inventoryDisplay = "CURRENT FUEL INVENTORIES\n\n" +
                      "Premium Fuel:\n" +
                      "   Used: " + usedGallonsPremium + " gallons\n" +
                      "   Remaining: " + (getTankCapacity("premium")) + " gallons\n\n" +
                      "Regular Fuel:\n" +
                      "   Used: " + usedGallonsRegular + " gallons\n" +
                      "   Remaining: " + (getTankCapacity("regular")) + " gallons\n\n" +
                      "Diesel Fuel:\n" +
                      "   Used: " + usedGallonsDiesel + " gallons\n" +
                      "   Remaining: " + (getTankCapacity("diesel")) + " gallons\n\n" +
                      "Minimum Inventory Level: " + minimium + " gallons\n" +
                      "Last Updated: " +date;

                      System.out.println(inventoryDisplay);
            
        }
    }
    }
    private static double getTankCapacity(String fuelType) {
        switch (fuelType) {
            case "regular": return currentGallonsRegular;
            case "premium": return currentGallonsPremium;
            case "diesel":  return currentGallonsDiesel;
        }
        return 300;
    }
    private static int promptUser() {
        Scanner input = new Scanner(System.in);
        int inp;
        do {
            System.out.print("Are you a customer or an Employee, Type 1 for Customer or 2 for Employee: ");
            inp = input.nextInt();
           // System.out.println(inp);
        } while (inp != 1 && inp != 2 && inp != 312);
        return inp;
    }
    private static int promptManager() {
        Scanner input = new Scanner(System.in);
        int inp;
        do {
            System.out.println("Hello Manager! Please input your ID: ");
            inp = input.nextInt();
        } while (inp < 10000 || inp >= 100000);
        return inp;
    }
    private static String managerPrompts(String fuelType) {
        switch (fuelType) {
            case "regular": if (getTankCapacity("regular") <= minimium) displayAlert(fuelType);break;
            case "premium": if (getTankCapacity("premium") <= minimium) displayAlert(fuelType);break;
            case "diesel":if (getTankCapacity("diesel") <= minimium) displayAlert(fuelType);break;
        }
        return fuelType;
    }
    private static void displayAlert(String fuelType) {
        Date date = new Date();
        System.out.println(fuelType + " fuel type is low!");
        String purchaseOrder = "PURCHASE ORDER\n" +
                      "Standard Quantity Required: " +  (defaultGallonsRegular) + " gallons\n" +
                      "Fuel Type: " +  fuelType + "\n" +
                      "Date: " + date; 
        System.out.println(purchaseOrder);
        switch (fuelType) {
            case "regular": currentGallonsRegular += defaultGallonsRegular;break;
            case "premium": currentGallonsPremium += defaultGallonsPremium;break;
            case "diesel": currentGallonsDiesel += defaultGallonsDiesel;
        }
    }
    private  static String getFuelType() {
        Scanner input = new Scanner(System.in);
        int inp;
        String fuelType;
        do {
            System.out.print("is Fuel type Regular, Premium, or Diesel, Type 0 for Regular, 1 for Premium, 2 for Diesel: ");
            inp = input.nextInt();
        } while (inp < 0 || inp > 2);
        if (inp == 0) {
            fuelType = "regular";
        }
        else if (inp == 1) {
            fuelType = "premium";
        } else {
        fuelType = "diesel";
        }
        return fuelType;
    }
    
}