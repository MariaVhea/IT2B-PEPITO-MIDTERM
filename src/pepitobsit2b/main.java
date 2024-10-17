package pepitobsit2b;

import java.util.Scanner;

public class main {

    
public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
        String resp;
        do{

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
     System.out.print("Enter Action: ");
            int action = sc.nextInt();
            main test = new main();
            switch(action){
                case 1:
                    test.addAttendance();
                break;
                case 2:
                    test.viewAttendance();
                break;
                case 3:
                    test.viewAttendance();
                    test.updateAttendance();
                break;
                case 4:
                    test.viewAttendance();
                    test.deleteAttendance();
                    test.viewAttendance();
                break;
                case 5:
                    System.out.println("Exiting");
                    break;
                 default:
                    System.out.println("Action Error!");
            }
            
            System.out.print("Continue?  ");
            resp = sc.next();

        }while(resp.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");

    }
    
    public void addAttendance(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
       
        System.out.print("Date: ");
        String cdate = sc.nextLine();
        System.out.print("Status: ");
        String cstatus = sc.nextLine();
        System.out.print("Remarks: ");
        String cremarks = sc.nextLine();

        String sql = "INSERT INTO tbl_student ( c_date, c_status, c_remarks) VALUES ( ?, ?, ?)";

      
        conf.addRecord(sql, cdate, cstatus, cremarks);
    }
    
    private void viewAttendance() {
        
        String qry = "SELECT * FROM tbl_student";
        String[] hdrs = {"Attendance ID", "Date", "Status", "Remarks"};
        String[] clms = {"attendance_id", "c_date", "c_status", "c_remarks"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }
    
    private void updateAttendance(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        
       
        System.out.print("Enter new date: ");
        String cdate = sc.next();
        System.out.print("Enter new status: ");
        String cstatus = sc.next();
        System.out.print("Enter new remarks: ");
        String cremarks = sc.next();
        
        String qry = "UPDATE tbl_student SET c_date = ?, c_status = ?, c_remarks = ? WHERE attendance_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, cdate, cstatus, cremarks, id);
        
    }
    
    private void deleteAttendance(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_student WHERE attendance_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    
    }
    
    
}
