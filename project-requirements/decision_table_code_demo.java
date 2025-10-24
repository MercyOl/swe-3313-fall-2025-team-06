import java.util.Scanner;

public class decision_table_code_demo {
    public static Scanner input;

    public static void main(String[] args) {
        //initialize Scanner
        input = new Scanner(System.in);
        int option;


        if(IsRegistered()) {
            if (IsAdmin()) {
                System.out.println("User has logged in as administrator.\n");
                int cart = 0;
                
                while(true){
                    System.out.print("\nSelect an action:\n1. Promote user to admin\n" +
                            "2. Run sales report\n" +
                            "3. View and manage inventory\n" +
                            "4. Add to cart\n" +
                            "5. View cart\n" +
                            "6. Checkout\n" +
                            "7. Logout\n" +
                            "\n\nOption: ");
    
                    option = Integer.parseInt(input.nextLine());
                        
                    if(option == 7){
                        System.out.println("Logging out...");
                        break;
                    }else{
                        switch(option){
                            case 1:
                                System.out.println("Promoting another user to administrator.");
                                break;
                            case 2:
                                System.out.println("Running sales report.");
                                break;
                            case 3:
                                System.out.println("Displaying inventory.");
                                break;
                            case 4:
                                cart++;
                                System.out.println("Cart now has " + cart + " items");
                                break;
                            case 5:
                                System.out.println("Cart has " + cart + " items");
                                break;
                            case 6:
                                if (cart > 0) {
                                    System.out.println("Checked out " + cart + " items. Displaying receipt.");
                                    cart = 0;
                                } else {
                                    System.out.println("Cart is empty!");
                                }
                                break;
                            }
                        }
                    }
            }else{
                System.out.println("User has logged in as standard user.\n");
                int cart = 0;
                while(true) {
                    System.out.print("\nSelect an action:\n1. Add to cart\n" +
                            "2. View cart\n" +
                            "3. Checkout\n" +
                            "4. Logout\n" +
                            "\nOption: ");

                    option = Integer.parseInt(input.nextLine());

                    if(option == 4){
                        System.out.println("Logging out...");
                        break;
                    }else {
                        switch (option) {
                            case 1:
                                cart++;
                                System.out.println("Cart now has " + cart + " items");
                                break;
                            case 2:
                                System.out.println("Cart has " + cart + " items");
                                break;
                            case 3:
                                if (cart > 0) {
                                    System.out.println("Checked out " + cart + " items. Displaying receipt.");
                                    cart = 0;
                                } else {
                                    System.out.println("Cart is empty!");
                                }
                                break;
                        }
                    }
                }
            }
        }else{
            System.out.print("\nSelect an action:\n1. Register\n\nOption: ");
            option = Integer.parseInt(input.nextLine());
            if(option != 1){
                System.out.println("Invalid option.");
            }else{
                System.out.println("User is now registered.");
            }
        }
    }

    public static boolean IsAdmin(){
        System.out.print("Is the user an administrator? (y/n): ");
        String response = input.nextLine();
        if(response.equalsIgnoreCase("y")){
            System.out.println("User is an admin.");
            return true;
        }
        System.out.println("User is NOT an admin.");
        return false;

    }

    public static boolean IsRegistered(){
        System.out.print("Is the user registered? (y/n): ");
        String response = input.nextLine();
        if(response.equalsIgnoreCase("y")){
            System.out.println("User is registered.");
            return true;
        }
        System.out.println("User is NOT registered");
        return false;

    }
}
