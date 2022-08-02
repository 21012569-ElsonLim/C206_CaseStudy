import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206CaseStudy {
  
  private Quotation Q1;
  private Quotation Q2;
  private Quotation Q3;
  
  private static final ArrayList<Quotation> QuotationList= new  ArrayList<Quotation>();
  private static final ArrayList<Quotation> requestedQuotationList = new ArrayList<Quotation>();

  
  
  public static void main(String[] args) {
    LocalDate p1 = LocalDate.parse("2015-10-03");
    LocalDate p2 = LocalDate.parse("2012-01-12");
    LocalDate p3 = LocalDate.parse("2010-05-12");
    QuotationList.add(new Quotation("Q101","QU1","Kitchen","Shiny and clean ","Loki",p1, 359.90) );
    QuotationList.add(new Quotation("Q102","QU2","Bedroom","Big and tidy ","Harry",p2,500.00) );
    QuotationList.add(new Quotation("Q103","QU3","Bedroom","Bright ","Louis",p3,450.00));
    
    int logonChoice = -1;
    while (logonChoice != 3) {
      logon_menu();
      logonChoice = Helper.readInt("Choice > ");
      if (logonChoice == 1) {
        String correctCustomerUsername = ""; //Related to Jasrene's topic
        String correctCustomerPassword = ""; //Related to Jasrene's topic
        String enteredUsername = ""; //Related to Jasrene's topic
        String enteredPassword = ""; //Related to Jasrene's topic
        
        while (correctCustomerUsername.equals(enteredUsername) && correctCustomerPassword.equals(enteredPassword)) {
          int customerChoice = -1;
          while (customerChoice != 4) {
            customer_menu();
            customerChoice = Helper.readInt("Choice > ");
            if (customerChoice == 1) {
              
            } else if (customerChoice == 2) {
              
            } else if (customerChoice == 3) {
              
            } else if (customerChoice == 4) {
              System.out.println("Logging Out");
            } else {
              System.out.println("Invalid Option");
            }
          }
        }
        
      } else if (logonChoice == 2) { // THIS IS UNDONE - Jun Cheng
        String correctStaffUsername = ""; //Related to Jasrene's topic
        String correctStaffPassword = ""; //Related to Jasrene's topic
        String enteredUsername = ""; //Related to Jasrene's topic
        String enteredPassword = ""; //Related to Jasrene's topic
        enteredUsername = Helper.readString("Username > ");
        enteredPassword = Helper.readString("Password > ");
        while (correctStaffUsername.equals(enteredUsername) && correctStaffPassword.equals(enteredPassword)) {
          int StaffChoice = -1;
          while (StaffChoice != 6) {
            staff_menu();
            StaffChoice = Helper.readInt("Choice > ");
            if (StaffChoice == 1) {
              
            } else if (StaffChoice == 2) {
              
            } else if (StaffChoice == 3) {
              
            } else if (StaffChoice == 4) {
              
            } else if (StaffChoice == 5) {
              
            } else if (StaffChoice == 6) {
              System.out.println("Logging Out");
            } else {
              System.out.println("Invalid Option");
            }
          }
        }
        
      } else if (logonChoice == 3){
        System.out.println("Thank you for using Renovation ACE!");
      } else {
        System.out.println("Invalid Option");
      }
    }
  }
  
  
  
  public static void customer_menu() {
    C206CaseStudy.setHeader("C206 Centre Customer Page");
    System.out.println("1. Visitor Account Registration");
    System.out.println("2. Request to Quotation");
    System.out.println("3. Manage Appointment");
    System.out.println("4. Log Out");
  }
  
  public static void staff_menu() {
    C206CaseStudy.setHeader("C206 Centre Administrator Page");
    System.out.println("1. Manage Customer");
    System.out.println("2. Manage Package");
    System.out.println("3. Manage Request Quotation");
    System.out.println("4. Manage Quotation");
    System.out.println("5. Manage Appointment");
    System.out.println("6. Log Out");
  }
  
  public static void logon_menu() {
    C206CaseStudy.setHeader("Log In Page");
    System.out.println("1. Customers");
    System.out.println("2. Admin/Designer");
    System.out.println("3. Quit");
  }
  
  
  
  public static void setHeader(String Header) {
    Helper.line(80, "=");
    System.out.println(Header);
    Helper.line(80, "=");
  }

  
  
  
  
  
  
  




  public static String retrieveAllQuotation(ArrayList<Quotation> QuotationList) {
    // TODO Auto-generated method stub
    String output1 = "";

  
    for (int x = 0; x < QuotationList.size(); x++) {

      output1 += String.format("%-10s %-30s %-10s %-10s %-20.2f\n", QuotationList.get(x).getRequest_ID1(),
          QuotationList.get(x).getQuotation_ID(), 
          QuotationList.get(x).getRenovation_Category(),QuotationList.get(x).getDesi_Name(),QuotationList.get(x).getDescription()
          ,QuotationList.get(x).getEarliest_Start_Date(),QuotationList.get(x).getTotal_Quotation_amt());
    }
    return output1;
  }
  public static void viewAllQuotation(ArrayList<Quotation>QuotationList) {
    C206CaseStudy.setHeader("Quotation List");
    String output = String.format("%-10s %-30s %-10s %-35s %-20s %-15s %-20s\n", "REQUESTID", "QUOTATION",
        "RENOVATIONCATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
    
     output += retrieveAllQuotation(QuotationList);
    System.out.println(output);
  }

  
  
  
  public static Quotation inputQuotation() {
    String RequestID = Helper.readString("Enter asset tag > ");
    String QuotationID = Helper.readString("Enter Quotation ID > ");
    String renovationCat = Helper.readString("Enter renovationCat > ");
    String desiName = Helper.readString("Enter Designer name  > ");
    String Description = Helper.readString("Enter description > ");
    String earliestStartDate = Helper.readString("Enter earliest Start Date > ");
    double TotalQuotationamt = Helper.readDouble("Enter Total Amount  > ");
  
    DateTimeFormatter x= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date=LocalDate.parse(earliestStartDate, x);

    Quotation Q3= new Quotation(RequestID, QuotationID, renovationCat,desiName,Description,date,TotalQuotationamt);
    return Q3;
  }
  
  
  
  
  
  public static void requestQuotation(ArrayList<Quotation> requestedQuotationList, Quotation x) {
	  
	  requestedQuotationList.add(x);
  } // Done by Jun Cheng
  
  public static void viewAlRequestedQuotation(ArrayList<Quotation> requestedQuotationList) {
	  C206CaseStudy.setHeader("Requested Quotation List");
	    String output = String.format("%-10s %-30s %-10s %-35s %-20s %-15s %-20s\n", "REQUESTID", "QUOTATION",
	        "RENOVATIONCATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
	    
	     output += retrieveAllQuotation(requestedQuotationList);
	    System.out.println(output);
  } // Done by Jun Cheng
  
//  public static void doDeleteRequestedQuotation(ArrayList<Quotation> requestedQuotationList,String ) {
//	  
//  }
  
  
  public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation x) {

    QuotationList.add(x);
  } // Done by Elson
  
  

  
//  public static boolean doDeleteQuotation(ArrayList<Quotation> QuotationList, String QuotationID) {
//    
//    boolean delete=false;
//    
//  for(int q = 1;q <=QuotationList.size();q++) {
//      if(QuotationList.get(q).getQuotation_ID().equalsIgnoreCase(QuotationID)&&(QuotationList!=null)){
////        QuotationList.get(q)
//      }
//    }
//  return delete;
//  } // Done by Elson
  
  public static void addPackage(ArrayList<Package> PackageList, Package P) {
	  PackageList.add(P);
  }
}