import config.config;
import java.util.Scanner;

public class main {
    
    public static void viewStaff() {
        String votersQuery = "SELECT * FROM staff";
        String[] votersHeaders = {"ID", "First Name", "Last Name", "Email", "Role"};
        String[] votersColumns = {"staff_ID", "first_name", "last_name", "email", "role"};
        config con = new config();
        con.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
    public static void main(String[] args) {
        
        config con = new config();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== STAFF MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    // Add staff
                    System.out.print("Enter First Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();

                    String insertSQL = "INSERT INTO staff(first_name, last_name, email, password, role) VALUES(?,?,?,?,?)";
                    con.addRecord(insertSQL, fname, lname, email, pass, role);
                    break;

                case 2:
                    
                    viewStaff();
                    
                    break;

                case 3:
                    viewStaff();
                    
                    System.out.print("Enter ID to update: ");
                    int s_id = sc.nextInt();
                    
                    System.out.print("Enter New First Name: ");
                    String nfname = sc.next();
                    System.out.print("Enter New Last Name: ");
                    String nlname = sc.next();
                    System.out.print("Enter New Email: ");
                    String nemail = sc.next();
                    System.out.print("Enter New Password: ");
                    String npass = sc.next();
                    System.out.print("Enter New Role: ");
                    String nrole = sc.next();
                    
                    String qry = "UPDATE staff SET first_name = ?, last_name = ?, email = ?, password = ?, role = ? WHERE staff_id = ?";
                    con.updateRecord(qry, nfname, nlname, nemail, npass, nrole, s_id);
                    
                    viewStaff();
                    break;

                case 4:
                    viewStaff();
                    
                    System.out.print("Enter ID to delete: ");
                    int del_id = sc.nextInt();
                    
                    String deleteSQL = "DELETE FROM staff WHERE staff_ID = ?";
                    con.deleteRecord(deleteSQL, del_id);
                    
                    viewStaff();
                    
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
