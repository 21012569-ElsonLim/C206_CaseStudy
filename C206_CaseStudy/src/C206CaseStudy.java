import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206CaseStudy {
  
 
  
  private static final ArrayList<Quotation> QuotationList= new  ArrayList<Quotation>();
  private static final ArrayList<Quotation> requestedQuotationList = new ArrayList<Quotation>();
  private static final ArrayList<Package> PackageList = new ArrayList<Package>();
  
  
  public static void main(String[] args) {
    LocalDate p1 = LocalDate.parse("2015-10-03");
    LocalDate p2 = LocalDate.parse("2012-01-12");
    LocalDate p3 = LocalDate.parse("2010-05-12");
    QuotationList.add(new Quotation("Q101","QU1","Kitchen","Shiny and clean ","Loki",p1, 359.90) );
    QuotationList.add(new Quotation("Q102","QU2","Bedroom","Big and tidy ","Harry",p2,500.00) );
    QuotationList.add(new Quotation("Q103","QU3","Bedroom","Bright ","Louis",p3,450.00));
    
    LocalDate p4 = LocalDate.parse("2016-11-20");
    LocalDate p5 = LocalDate.parse("2016-02-13");
    LocalDate p6 = LocalDate.parse("2016-06-16");
    requestedQuotationList.add(new Quotation("HDB",100.25,"James",91234567,"James@gmail.com",1000.10,p4,2,0,"",false));
    requestedQuotationList.add(new Quotation("Private",200.25,"Jacob",98765432,"Jacob@hotmail.com",200.20,p5,1,1,"",true));
    requestedQuotationList.add(new Quotation("Landed",300.25,"Cody",91827364,"Cody@yahoo.com",300.30,p6,0,2,"",true));
    
    LocalDate e1 = LocalDate.parse("2015-10-07"); //End Date
    LocalDate e2 = LocalDate.parse("2012-01-18");
    LocalDate e3 = LocalDate.parse("2010-05-19");
    PackageList.add(new Package("P101", "Shiny Kitchen", p1, e1, 400));
    PackageList.add(new Package("P102", "Small BedRoom", p2, e2, 500));
    PackageList.add(new Package("P103", "Big Bedroom", p3, e3, 600));
    
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
 double d1=QuotationList.get(x).getTotal_Quotation_amt();
 String Quotationamt=Double.toString(d1);
   LocalDate x1=QuotationList.get(x).getEarliest_Start_Date();
   String updatedDate=x1.toString();
      output1 += String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n", QuotationList.get(x).getRequest_ID(),
          QuotationList.get(x).getQuotation_ID(), 
          QuotationList.get(x).getRenovation_Category(),QuotationList.get(x).getDescription(),QuotationList.get(x).getDesi_Name()
          ,updatedDate,Quotationamt);
    }
    return output1;
  }
  
  public static String retrieveAllRequestedQuotation(ArrayList<Quotation> requestedQuotationList) {
	  String output = "";  
	  for (Quotation i : requestedQuotationList) {
	    	 String propertyType = i.getPropertyType();
	    	 String areaSize = Double.toString(i.getAreaType());    	
	    	 String requestorName = i.getrequestorName();    	 
	    	 String customerContactNum = i.getcustomerContactNum() + "";    	
	    	 String customerEmail = i.getCustomerEmail();    	 
	    	 String budget = i.getbudget() + "";
	    	 String targetCompletionDate = i.getTargetCompletionDate() + "";
	    	 String roomToRenovate = i.getRoomToRenovate() + "";
	    	 String toiletToRenovate = i.getToiletToRenovate() + "";
	    	 String renovationStyle = i.getRenovationStyle();
	    	 String urgentRequest = i.getUrgentRequest() + "";
	    	 output += String.format("%-20s %-20s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n",
	    			propertyType,areaSize,requestorName,customerContactNum,customerEmail,budget,
	    			targetCompletionDate,roomToRenovate,toiletToRenovate,renovationStyle,urgentRequest);
	    }
	    return output;
	  } // Done by Jun Cheng
  
  public static void viewAllQuotation(ArrayList<Quotation>QuotationList) {
    C206CaseStudy.setHeader("Quotation List");
    String output = String.format("%-10s %-30s %-10s %-35s %-20s %-15s %-20s\n", "REQUESTID", "QUOTATION",
        "RENOVATIONCATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
    
     output += retrieveAllQuotation(QuotationList);
    System.out.println(output);
  } // Done by Elson

  
  
  
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
  
  
  
  
  
  public static void addRequestQuotation(ArrayList<Quotation> requestedQuotationList, Quotation x) {
	  
	  requestedQuotationList.add(x);
	  
  } // Done by Jun Cheng #1
  
  public static void viewAllRequestedQuotation(ArrayList<Quotation> requestedQuotationList) {
	  C206CaseStudy.setHeader("Requested Quotation List");
	    String output = String.format("%-10s %-30s %-10s %-35s %-20s %-15s %-20s\n", "REQUESTID", "QUOTATION",
	        "RENOVATIONCATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
	    
	     output += retrieveAllQuotation(requestedQuotationList);
	    System.out.println(output);
  } // Done by Jun Cheng #2
  
  public static void doDeleteRequestedQuotation(ArrayList<Quotation> requestedQuotationList, String RequestorName) {
	  for(Quotation i : requestedQuotationList) {
	      if(i.getrequestorName().equalsIgnoreCase(RequestorName)){    
	    	  String propertyType = i.getPropertyType();
	    	  double areaSize = i.getAreaType();    	
	    	  String requestorName = i.getrequestorName();    	 
	    	  int customerContactNum = i.getcustomerContactNum();    	
	    	  String customerEmail = i.getCustomerEmail();    	 
	    	  double budget = i.getbudget();
	    	  LocalDate targetCompletionDate = i.getTargetCompletionDate();
	    	  int roomToRenovate = i.getRoomToRenovate();
	    	  int toiletToRenovate = i.getToiletToRenovate();
	    	  String renovationStyle = i.getRenovationStyle();
	    	  boolean urgentRequest = i.getUrgentRequest();
	    	  Quotation removing = new Quotation(propertyType,areaSize,requestorName,customerContactNum,customerEmail,budget,targetCompletionDate,roomToRenovate,toiletToRenovate,renovationStyle,urgentRequest);
	    	  requestedQuotationList.remove(removing);
	      }
	    }
  } // Done by Jun Cheng #3

  public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation x) {

    QuotationList.add(x);
  } // Done by Elson

  public static void doDeleteQuotation(ArrayList<Quotation> QuotationList, String QuotationID) {
	String RID="";
	String OID="";
	String Category="";
	String description="";
	String Designer_name="";
	LocalDate date1=null;
	double quotationAmt=0.0;
        
  for(int q = 1;q <=QuotationList.size();q++) {
      if(QuotationList.get(q).getQuotation_ID().equalsIgnoreCase(QuotationID)){    
    	  RID= QuotationList.get(q).getRequest_ID();    	
    	   OID= QuotationList.get(q).getQuotation_ID();    	
    	  Category= QuotationList.get(q).getRenovation_Category();    	 
    	 description= QuotationList.get(q).getDescription();    	
    	 Designer_name= QuotationList.get(q).getDesi_Name();    	 
    	   date1= QuotationList.get(q).getEarliest_Start_Date();
    	 quotationAmt= QuotationList.get(q).getTotal_Quotation_amt();
      }
    }
  Quotation a = new Quotation(RID, OID, Category, description, Designer_name, date1, quotationAmt);
  QuotationList.remove(a);

  } // Done by Elson
  
  public static Package inputPackage() {
	  String ID = Helper.readString("Enter ID > ");
	  String des = Helper.readString("Enter description > ");
	  String startDate = Helper.readString("Enter start date (yyyy-mm-dd) > ");
	  LocalDate startDate1 = LocalDate.parse(startDate);
	  String endDate = Helper.readString("Enter end date (yyyy-mm-dd) > ");
	  LocalDate endDate1 = LocalDate.parse(endDate);
	  double amt = Helper.readDouble("Enter package amount >");
	  
	  Package P = new Package(ID, des, startDate1, endDate1, amt);
	  return P;
  }
  
  public static void addPackage(ArrayList<Package> PackageList, Package P) {
	  PackageList.add(P);
  }
  
  public static String retrieveAllPackage(ArrayList<Package> PackageList) {
	  String output = "";
	  for (Package P : PackageList) {
		  String ID = P.getPackageCode() + "";
		  String des = P.getPackageDes() + "";
		  String startDate = P.getStartDate() + "";
		  String endDate = P.getEndDate() + "";
		  double amt = P.getPackageAmount();
		  output += String.format("%-10s %-30s %-10s %-10s %-20.2f\n", ID, des, startDate, endDate, amt);
		  
	  }
	  return output;
  }
  
  public static void viewAllPackage(ArrayList<Package> PackageList) {
	  C206CaseStudy.setHeader("PACKAGE LIST");
	  String output = String.format("%-10s %-30s %-10s %-20s", "ID", "DESCRIPTION", "START DATE", "END DATE",
			  "PACKAGE AMOUNT");
	  output += retrieveAllPackage(PackageList);
	  System.out.println(output);
  }
  
  public static void deletePackage(ArrayList<Package> PackageList, String packageCode) {
		String ID = "";
		String des = "";
		LocalDate startDate1 = null;
		LocalDate endDate1 = null;
		double amt = 0.0;
	        
	  for(int i = 1; i <=PackageList.size(); i++) {
	      if(PackageList.get(i).getPackageCode().equalsIgnoreCase(ID)){    
	    	  ID = PackageList.get(i).getPackageCode();    	   	  	 
	    	 des = PackageList.get(i).getPackageDes();    	 
	    	   startDate1 = PackageList.get(i).getStartDate();
	    	   endDate1 = PackageList.get(i).getEndDate();
	    	 amt = PackageList.get(i).getPackageAmount();
	      }
	  }
	  Package p = new Package(ID, des, startDate1, endDate1, amt);
	  PackageList.remove(p);
  }
}