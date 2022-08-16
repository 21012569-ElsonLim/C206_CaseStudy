import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206CaseStudy {
  
 
  
  private static final ArrayList<Quotation> QuotationList= new  ArrayList<Quotation>();
  private static final ArrayList<Quotation> requestedQuotationList = new ArrayList<Quotation>();
  private static final ArrayList<Package> PackageList = new ArrayList<Package>();
  private static final ArrayList<User> UserList = new ArrayList<User>(); 
  
  
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
    
    UserList.add(new User("John", "Admin", "John@gmail.com", "JohnAdmin123", true));
	UserList.add(new User("Mary", "Customer", "Mary@gmail.com", "Mary456", true));
	UserList.add(new User("Harry", "Designer", "Harry@gmail.com", "HarryDesign789", true));    
	
    int logonChoice = -1;
    int customerChoice = -1;
    int StaffChoice = -1;
    
    while (logonChoice != 3) {
      logon_menu();
      logonChoice = Helper.readInt("Choice > ");
      if (logonChoice == 1) {
        String enteredUsername = "";
        String enteredPassword = "";
        for (User i : UserList) {
        	enteredUsername = Helper.readString("Enter Username > ");
        	enteredPassword = Helper.readString("Enter Password > ");
        if (i.getName().equals(enteredUsername) && i.getPassword().equals(enteredPassword) && i.getRole().equalsIgnoreCase("Customer")) {
        	
        	while (customerChoice != 3) {
        		customer_menu();
        		customerChoice = Helper.readInt("Choice > ");
        		if (customerChoice == 1) {
        			addUser(UserList,inputUser());
        		} else if (customerChoice == 2) {
        			addRequestQuotation(requestedQuotationList,inputRequestQuotation());
        		} else if (customerChoice == 3) {
        			System.out.println("Logging Out");
        		} else {
        			System.out.println("Invalid Option");
        			}
        		}
        	customerChoice = -1;
        	break;
        	} else {
        		System.out.println("Invalid Username or Password, please try again.");
        	}
        }
        
      	} else if (logonChoice == 2) {
        String enteredUsername = "";
        String enteredPassword = "";
        boolean checker = false;
        while (checker == false) {
        	enteredUsername = Helper.readString("Username > ");
        	enteredPassword = Helper.readString("Password > ");
        	for (User x : UserList) {
            	if (x.getName().equals(enteredUsername) && x.getPassword().equals(enteredPassword) && (x.getRole().equalsIgnoreCase("Admin") || x.getRole().equalsIgnoreCase("Designer"))) {
            		checker = true;
            		break;
            	}
            }
        }
        
        while (StaffChoice != 5 && checker == true) {
        	staff_menu();
        	StaffChoice = Helper.readInt("Choice > ");
        	if (StaffChoice == 1) {
        		int manageCustomer = -1;
        		while (manageCustomer != 3) {
        			manageCustomerMenu();
        			manageCustomer = Helper.readInt("Choice > ");
        			if (manageCustomer == 1) {
      						viewAllUser(UserList);
     				} else if (manageCustomer == 2) {
      						addUser(UserList,inputUser());
        			} else if (manageCustomer == 3) {
        				System.out.println("Going Back");
        			}else {
        				System.out.println("Invalid Option");
        			}
        		}	
        	} else if (StaffChoice == 2) {
        				int managePackage = -1;
        				while (managePackage != 3) {
        					managePackageMenu();
        					managePackage = Helper.readInt("Choice > ");
        					if (managePackage == 1) {
        						viewAllPackage(PackageList);
        					} else if (managePackage == 2) {
        						addPackage(PackageList,inputPackage());
        					} else if (managePackage == 3) {
        						String code = Helper.readString("Enter Code > ");
        						deletePackage(PackageList,code);
        					} else if (managePackage == 4) {
        						System.out.println("Going Back");
        					}else {
        						System.out.println("Invalid Option");
        					}
        				}
        			} else if (StaffChoice == 3) {
        				int manageRequestedQuotation = -1;
                    	while (manageRequestedQuotation != 4) {
                    		manageRequestQuotationMenu();
                    		manageRequestedQuotation = Helper.readInt("Choice > ");
                    		if (manageRequestedQuotation == 1) {
                    			System.out.println("1. HDB");
                    			System.out.println("2. Private");
                    			System.out.println("3. Landed");
                    			int question = Helper.readInt("Property Type > ");
                    			String choice = "";
                    			if (question == 1) {
                    				choice = "HDB";
                    			} else if (question == 2) {
                    				choice = "Private";
                    			} else if (question == 3) {
                    				choice = "Landed";
                    			} else {
                    				System.out.println("Invalid Option");
                    			}
                    			viewAllRequestedQuotation(requestedQuotationList,choice);
                    		} else if (manageRequestedQuotation == 2) {
                    			addRequestQuotation(requestedQuotationList,inputRequestQuotation());
                    		} else if (manageRequestedQuotation == 3) {
                    			String customerName = Helper.readString("Enter customer name > ");
                    			doDeleteRequestedQuotation(requestedQuotationList,customerName);
                    		}  else if (manageRequestedQuotation == 4) {
                    			System.out.println("Going Back");
                    		} else {
                    			System.out.println("Invalid Option");
                    		}
                    	}
        			} else if (StaffChoice == 4) {
        				int manageQuotation = -1;
                    	while (manageQuotation != 4) {
                    		manageQuotationMenu();
                    		manageQuotation = Helper.readInt("Choice > ");
                    		if (manageQuotation == 1) {
                    			viewAllQuotation(QuotationList);
                    		} else if (manageQuotation == 2) {
                    			addQuotation(QuotationList,inputQuotation());
                    		} else if (manageQuotation == 3) {
                    			String quotationId = Helper.readString("Enter quotation ID > ");
                    			doDeleteQuotation(QuotationList,quotationId);
                    		} else if (manageQuotation == 4) {
                    			System.out.println("Going Back");
                    		} else {
                    			System.out.println("Invalid Option");
                    		}
                    	}
        			} else if (StaffChoice == 5) {
        				System.out.println("Logging Out");
        			} else {
        				System.out.println("Invalid Option");
        			}
        		}

        		StaffChoice = -1;
        		break;
        
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
	  System.out.println("3. Log Out");
  }
  
  public static void staff_menu() {
	  C206CaseStudy.setHeader("C206 Centre Staff Page");
	  System.out.println("1. Manage Customer");
	  System.out.println("2. Manage Package");
	  System.out.println("3. Manage Request Quotation");
	  System.out.println("4. Manage Quotation");
	  System.out.println("5. Log Out");
  }
  
  public static void manageQuotationMenu() {
	  C206CaseStudy.setHeader("Manage Quotation");
	  System.out.println("1. View Quotation");
	  System.out.println("2. Add Quotation");
	  System.out.println("3. Delete Quotation");
	  System.out.println("4. Exit");
  }
  
  public static void manageRequestQuotationMenu() {
	  C206CaseStudy.setHeader("Manage Request Quotation");
	  System.out.println("1. View Request Quotation");
	  System.out.println("2. Add Request Quotation");
	  System.out.println("3. Delete Request Quotation");
	  System.out.println("4. Exit");
  }
  
  public static void manageCustomerMenu() {
	  C206CaseStudy.setHeader("Manage Customer");
	  System.out.println("1. View All User");
	  System.out.println("2. Add User");
	  System.out.println("3. Exit");
  }
  
  public static void managePackageMenu() {
	  C206CaseStudy.setHeader("Manage Package");
	  System.out.println("1. View All Package");
	  System.out.println("2. Add New Package");
	  System.out.println("3. Delete Package");
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
	  String output1 = "";

	  for (int x = 0; x < QuotationList.size(); x++) {
		  double d1=QuotationList.get(x).getTotal_Quotation_amt();
		  String Quotationamt=Double.toString(d1);
		  LocalDate x1=QuotationList.get(x).getEarliest_Start_Date();
		 
		  output1 += String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s\n", QuotationList.get(x).getRequest_ID(),
          QuotationList.get(x).getQuotation_ID(), 
          QuotationList.get(x).getRenovation_Category(),QuotationList.get(x).getDescription(),QuotationList.get(x).getDesi_Name()
          ,x1,Quotationamt);
	  }
	  return output1;
  } // Done by Elson
  
  public static void viewAllQuotation(ArrayList<Quotation>QuotationList) {
	  C206CaseStudy.setHeader("Quotation List");
	  String output = String.format("%-30s %-30s %-30s %-30s %-30s %-30s %-30s\n", "REQUESTID", "QUOTATION ID",
	  "RENOVATION CATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
    
      output += retrieveAllQuotation(QuotationList);
      System.out.println(output);
  } // Done by Elson
  
  public static Quotation inputQuotation() {
	  String RequestID = Helper.readString("Enter request id> ");
	  String QuotationID = Helper.readString("Enter Quotation ID > ");//ask use for input of new quotation id 
	  String renovationCat = Helper.readString("Enter renovationCat > ");
	  renovationCat.toUpperCase();
	  String desiName = Helper.readString("Enter Designer name  > ");
	  String Description = Helper.readString("Enter description > ");
	  String earliestStartDate = Helper.readString("Enter earliest Start Date > ");
	  double TotalQuotationamt = Helper.readDouble("Enter Total Amount  > ");
  
	  DateTimeFormatter x= DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	  LocalDate date=LocalDate.parse(earliestStartDate, x);//formatting the string ealiestStartdate into a LocalDate object

 	  Quotation Q3= new Quotation(RequestID, QuotationID, renovationCat,desiName,Description,date,TotalQuotationamt);//create a quotation object
 	  return Q3;
  } // Done by Elson
  
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
        
	  for(int q = 0;q <QuotationList.size();q++) {
		  if(QuotationList.get(q).getQuotation_ID().equalsIgnoreCase(QuotationID)){    //if the quotation id input is the same as the quotation id in the quotation list 
			  RID= QuotationList.get(q).getRequest_ID();    	
			  OID= QuotationList.get(q).getQuotation_ID();    	
			  Category= QuotationList.get(q).getRenovation_Category();    	 
			  description= QuotationList.get(q).getDescription();    	
			  Designer_name= QuotationList.get(q).getDesi_Name();    	 
			  date1= QuotationList.get(q).getEarliest_Start_Date();
			 
			  quotationAmt= QuotationList.get(q).getTotal_Quotation_amt();
			  System.out.println("REQUEST ID:"+RID);
			  System.out.println("QUOTATION ID:"+OID);
			  System.out.println("CATEGORY:"+Category);
			  System.out.println("DESCRIPTION:"+description);
			  System.out.println("DESIGNER: "+Designer_name);
			  System.out.println("EARLIEST START DATE: "+date1);
			  System.out.println("QUOTATION AMOUNT: "+quotationAmt);
			  
			  QuotationList.remove(q);//remove the quotation

		  }
		  
	  }
	 
  } // Done by Elson
  
  public static String retrieveAllRequestedQuotation(ArrayList<Quotation> requestedQuotationList, String choice) {
	   String output = "";
		  for (Quotation i : requestedQuotationList) {
			  if (i.getPropertyType().equalsIgnoreCase(choice)) {
			  	String propertyType = i.getPropertyType();
		    	 String areaSize = Double.toString(i.getAreaSize());    	
		    	 String requestorName = i.getrequestorName();    	 
		    	 String customerContactNum = i.getcustomerContactNum() + "";    	
		    	 String customerEmail = i.getCustomerEmail();    	 
		    	 String budget = i.getbudget() + "";
		    	 String targetCompletionDate = i.getTargetCompletionDate() + "";
		    	 String roomToRenovate = i.getRoomToRenovate() + "";
		    	 String toiletToRenovate = i.getToiletToRenovate() + "";
		    	 String renovationStyle = i.getRenovationStyle();
		    	 String urgentRequest = i.getUrgentRequest() + "";
		    	 output += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s"
		    	 		+ " %-20s %-20s %-20s %-20s\n",
		    			propertyType,areaSize,requestorName,customerContactNum,customerEmail,budget,
		    			targetCompletionDate,roomToRenovate,toiletToRenovate,renovationStyle,urgentRequest);
		  	}
		  }
	    return output;
	  } // Done by Jun Cheng
  
  public static void viewAllRequestedQuotation(ArrayList<Quotation> requestedQuotationList, String choice) {
	  C206CaseStudy.setHeader("Requested Quotation List");
	    String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s" +
 	    		 "%-20s %-20s %-20s %-20s\n", "PROPERTY TYPE", "AREA SIZE",
	        "REQUESTOR NAME", "CONTACT NUMBER","EMAIL","BUDGET","TARGET DATE","ROOMS",
	        "TOILETS","STYLE","URGENT");
	    if (retrieveAllRequestedQuotation(requestedQuotationList,choice).length() > 0) {
	     output += retrieveAllRequestedQuotation(requestedQuotationList,choice);
	    } else {
	    	System.out.println("No Data found");
	    }
	    System.out.println(output);
  } // Done by Jun Cheng
  
  public static Quotation inputRequestQuotation() {
	  boolean validation = true;
	  String propertyType = Helper.readString("Enter property type > ");
	  double areaSize = Helper.readDouble("Enter area size > ");
	  String requestorName = Helper.readString("Enter your name > ");
	  int customerContactNum = Helper.readInt("Enter your mobile number > ");
	  String customerEmail = Helper.readString("Enter your email > ");
	  double budget = Helper.readDouble("Enter your budget > ");
	  boolean checker = false;
	  LocalDate targetCompletionDate = null;
	  while (checker == false) {
	  	String questiontargetCompletionDate = Helper.readString("Enter completion date > ");
	  	String format = "\\d{4}[-]\\d{2}[-]\\d{2}";
	  	if (questiontargetCompletionDate.matches(format)) {
		  	targetCompletionDate = LocalDate.parse(questiontargetCompletionDate);
		  	validation = true;
		  	checker = true;
	  	} else {
		  	System.out.println("Wrong Format");
	  	}
  	}
  
	  int roomToRenovate = Helper.readInt("Enter amount of rooms > ");
	  int toiletToRenovate = Helper.readInt("Enter amount of toilets > ");
	  String renovationStyle = Helper.readString("Enter renovation style (optional) > ");
	  String questionurgentRequest = Helper.readString("Urgent (Y/N)> ");
	  Boolean urgentRequest = null;
	  if (questionurgentRequest.equalsIgnoreCase("Y")) {
		  urgentRequest = true;
	  } else if (questionurgentRequest.equalsIgnoreCase("N")) {
		  urgentRequest = false;
	  }
	  if (propertyType.length() == 0 || areaSize <= 0 || requestorName.length() == 0 ||
	      customerContactNum <= 0 || customerEmail.length() == 0 || budget <= 0 ||
	      targetCompletionDate == null || roomToRenovate < 0 || toiletToRenovate < 0 || 
	      urgentRequest == null) {
		  validation = false;
	  } // To check if mandatory fields are not left blank 
	
	  Quotation requesting = null;
	  if (validation == true) {
	  requesting = new Quotation(propertyType,areaSize,requestorName,
	  customerContactNum,customerEmail,budget,targetCompletionDate,roomToRenovate,
	  toiletToRenovate,renovationStyle,urgentRequest);
	  } else {
		  System.out.println("Mandatory fields are not filled in.");
	  }
	  return requesting;
  } // Done by Jun Cheng
  
  public static void addRequestQuotation(ArrayList<Quotation> requestedQuotationList, Quotation x) {
	  if (x != null) {
		  requestedQuotationList.add(x);
		  System.out.println("Successfully Requested");
	  } else {
		  System.out.println("Failed to Add Request");
	  }
	  
  } // Done by Jun Cheng

  public static void doDeleteRequestedQuotation(ArrayList<Quotation> requestedQuotationList, String RequestorName) {
	  boolean checker = false;
	  for(int i = 0; i < requestedQuotationList.size(); i++) {
		  checker = true;
	      if(requestedQuotationList.get(i).getrequestorName().equalsIgnoreCase(RequestorName)){
	    	  System.out.println("Property Type: " + requestedQuotationList.get(i).getPropertyType());
	    	  System.out.println("Area Size: " + requestedQuotationList.get(i).getAreaSize());
	    	  System.out.println("Name: " + requestedQuotationList.get(i).getrequestorName());
	    	  System.out.println("Contact Number: " + requestedQuotationList.get(i).getcustomerContactNum());
	    	  System.out.println("Email: " + requestedQuotationList.get(i).getCustomerEmail());
	    	  System.out.println("Budget: " + requestedQuotationList.get(i).getbudget());
	    	  System.out.println("By: " + requestedQuotationList.get(i).getTargetCompletionDate());
	    	  System.out.println("Rooms: " + requestedQuotationList.get(i).getRoomToRenovate());
	    	  System.out.println("Toilets: " + requestedQuotationList.get(i).getToiletToRenovate());
	    	  System.out.println("Style: " + requestedQuotationList.get(i).getRenovationStyle());
	    	  System.out.println("Urgent: " + requestedQuotationList.get(i).getUrgentRequest());
	    	  String question = Helper.readString("Are you sure (Y/N)> ");
			  if (question.equalsIgnoreCase("y")) {
				  requestedQuotationList.remove(i);
				  System.out.println("Delete Successful");
			  } else if (question.equalsIgnoreCase("n")) {
				  System.out.println("Delete Failed");
			  } else {
				 System.out.println("Enter either 'Y' or 'N', Delete failed.");
			  }
	      } else if (checker == false){
	    	  System.out.println("There is no such data found.");
	      }
	  }
	  
  } // Done by Jun Cheng
  
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
  } // Done by Cong Lin
  
  public static void addPackage(ArrayList<Package> PackageList, Package P) {
	  PackageList.add(P);
  } // Done by Cong Lin
  
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
  } // Done by Cong Lin
  
  public static void viewAllPackage(ArrayList<Package> PackageList) {
	  C206CaseStudy.setHeader("PACKAGE LIST");
	  String output = String.format("%-10s %-30s %-10s %-20s", "ID", "DESCRIPTION", "START DATE", "END DATE",
			  "PACKAGE AMOUNT");
	  output += retrieveAllPackage(PackageList);
	  System.out.println(output);
  } // Done by Cong Lin
  
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
  } // Done by Cong Lin
  
  public static User inputUser() {
		String Name = Helper.readString("Enter Name > ");
		String Role = Helper.readString("Enter Role > ");
		String Email = Helper.readString("Enter Email > ");
		String Password = Helper.readString("Enter Password ");
		boolean Status = true;

		User U = new User(Name, Role, Email, Password, Status);
		return U;
	} // Done by Jasrene
  
  public static void addUser(ArrayList<User> UserList, User U) {
		UserList.add(U);
	} // Done by Jasrene
  
  public static String retrieveAllUser(ArrayList<User> UserList) {
		String output = "";
		for (int i = 0; i < UserList.size(); i++) {
			output += String.format("%-10s %-30s %-10s %-20b\n", UserList.get(i).getName(), UserList.get(i).getRole(), UserList.get(i).getEmail(), UserList.get(i).getStatus());
		}
		return output;
	} // Done by Jasrene
  
  public static void viewAllUser(ArrayList<User> UserList) {
		C206CaseStudy.setHeader("User LIST");
		String output = String.format("%-10s %-30s %-10s %-20s\n", "NAME", "ROLE", "EMAIL", "STATUS");
		output += retrieveAllUser(UserList);
		System.out.println(output);
	} // Done by Jasrene

}
