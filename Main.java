import java.util.*;

// Case class
class Case {
    private String caseNumber;
    private String clientName;
    private String caseDetails;

    public Case(String caseNumber, String clientName, String caseDetails) {
        this.caseNumber = caseNumber;
        this.clientName = clientName;
        this.caseDetails = caseDetails;
    }

    public String getCaseNumber() { return caseNumber; }
    public String getClientName() { return clientName; }
    public String getCaseDetails() { return caseDetails; }

    public String toString() {
        return "Case No: " + caseNumber + ", Client: " + clientName + ", Details: " + caseDetails;
    }
}

// CaseManager class
class CaseManager {
    private List<Case> cases = new ArrayList<>();

    public void addCase(Case c) {
        cases.add(c);
        System.out.println("Case added successfully.");
    }

    public void listCases() {
        for (Case c : cases) {
            System.out.println(c);
        }
    }

    public void searchCase(String caseNumber) {
        for (Case c : cases) {
            if (c.getCaseNumber().equalsIgnoreCase(caseNumber)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Case not found.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CaseManager manager = new CaseManager();

        while (true) {
            System.out.println("\n1. Add Case\n2. List All Cases\n3. Search Case\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter case number: ");
                    String num = sc.nextLine();
                    System.out.print("Enter client name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter case details: ");
                    String details = sc.nextLine();
                    manager.addCase(new Case(num, name, details));
                    break;
                case 2:
                    manager.listCases();
                    break;
                case 3:
                    System.out.print("Enter case number to search: ");
                    String searchNum = sc.nextLine();
                    manager.searchCase(searchNum);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}