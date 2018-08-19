import java.util.Scanner;

public class GUI {
    private static final java.lang.Object System = ;

    public static void startGUI() {
        System.out.println("Witamy");
        System.out.println("Podaj dane samochodu:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Marka: ");
        String brand = scanner.nextLine();

        System.out.println("Model: ");
        String model = scanner.nextLine();

        System.out.println("Cena: ");
        String price = scanner.nextLine();

        try {
            validatePrice(price);
            Car car = new Car(model, brand, Double.parseDouble(price));
            Repository.addCar(car);
        } catch (ParsePriceException e){
            System.out.println(e.getMessage());
        }
    }

    private static void validatePrice(String price) throws ParsePriceException{
        String pattern = "[0-9]+([\\.]{1}[0-9]{2})?";
        if(!price.matches(pattern)) {
            throw new ParsePriceException();
        }
    }
    public static void login(){
        System.out.println("Witamy!");
        System.out.println("Podaj login:");
        Scanner scanner = new Scanner(System.in);

        String login = scanner.nextLine();

        System.out.println("Podaj hasło:");
        String password = scanner.nextLine();

        boolean authFlag = Repository.authenticateUser(login, password);

        if(authFlag) {
            menu();
        } else {
            System.exit(0);
        }
    }
    public static void menu() {
        System.out.println("1.Exit");
        System.out.println("");
        System.out.println("Podaj wybor");

        Scanner scanner = new Scanner(System.in);
        String choosen = scanner.nextLine();

        switch (choosen) {
            case "1":
                System.exit(0);
                break;
        }
    }
}
