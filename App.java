import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String password = "1234";
        String username = "mrsluggan";

        Scanner scanner = new Scanner(System.in);
        int saldo = 800;
        String val;
        String alternativ = "\n 1: Se saldo på ditt konto \n 2: Sätta in pengar\n 3: Ta ut pengar \n 4: Avsluta\n Skriv in siffran för det valet du vill göra, klicka sedan enter: \n";
        boolean mainRunning = true;
        Boolean running = true;

        while (mainRunning) {

            System.out.print("Hej! Skriv ditt användarnamn: ");
            String usernameInput = scanner.next().toLowerCase();
            System.out.print("Hej! Skriv ditt lösenord: ");
            String passwordInput = scanner.next();

            if (username.equals(usernameInput) && passwordInput.equals(password)) {
                System.out.println("Välkommen tillbaka! " + username);
                running = true;
                while (running) {
                    System.out.print(alternativ);
                    val = scanner.next();
                    switch (val) {
                        case "1":
                            // Se saldo
                            seSaldo(saldo);
                            break;
                        case "2":
                            // Sätt in pengar
                            saldo = sättInPengar(saldo, scanner);
                            break;
                        case "3":
                            // Sätt in pengar
                            saldo = taUtPengar(saldo, scanner);
                            break;
                        case "4":
                            // Avsluta
                            running = false;
                            System.out.println("Program avslutas!");
                            break;
                        default:
                            System.out.println("Ogiltigt val. Försök igen.");
                            break;
                    }
                }
            } else {

                System.out.println("Felaktigt användarnamn eller lösenord, försök igen");

            }

            System.out.println("Vill du logga igen? ja eller nej: ");
            if (scanner.next().equals("nej")){
                mainRunning = false;
            }else if (scanner.equals("ja")){
                break;
            }else{


            }
        }
        
        scanner.close();
    }

    public static void seSaldo(int saldo) {
        System.out.println("Du har: " + saldo + "kr");
    }

    public static int sättInPengar(int saldo, Scanner scanner) {
        System.out.print("Hur mycket vill du sätta in?: ");

        if (scanner.hasNextInt()) {
            int insättning = scanner.nextInt();

            if (insättning >= 0) {
                saldo += insättning;
                System.out.println("Du har lagt till: " + insättning + " kr\n");
            } else {
                System.out.println("Du kan inte sätta in negativa belopp.");
            }

        } else {
            System.out.println("Ogiltig inmatning, försök igen.\n");
            scanner.next();
        }

        return saldo;
    }

    public static int taUtPengar(int saldo, Scanner scanner) {

        System.out.print("Hur mycket vill du ta ut?: ");

        if (scanner.hasNextInt()) {
            int utdrag = scanner.nextInt();

            if (utdrag > saldo) {
                System.out.println("Du har för lite pengar");
            } else if (utdrag < 0) {
                System.out.println("Vänligen skriv ett hur mycket du vill ta ut: ");
            } else {
                System.out.println("Du har tagit ut: " + utdrag + "kr ");
                saldo -= utdrag;

            }

        }

        return saldo;
    }

}
