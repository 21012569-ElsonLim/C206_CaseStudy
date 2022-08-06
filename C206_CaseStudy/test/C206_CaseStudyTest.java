import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest extends C206CaseStudy {
  private Quotation Q1;
  private Quotation Q2;
  private Quotation Q3;
  private Quotation Q4;
  private Quotation Q5;
  private Quotation Q6;
  private Package P1;
  private Package P2;
  private Package P3;
  private User U1;
  private User U2;
  private User U3;

  
  private ArrayList<Quotation> QuotationList;
  private ArrayList<Quotation> RequestedQuotationList;
  private ArrayList<Package> PackageList;
  private ArrayList<User> UserList;
  @Before
  public void setUp() throws Exception {
    LocalDate p1 = LocalDate.parse("2015-10-03"); //Start Date
    LocalDate p2 = LocalDate.parse("2012-01-12");
    LocalDate p3 = LocalDate.parse("2010-05-12");
    
    LocalDate e1 = LocalDate.parse("2015-10-07"); //End Date
    LocalDate e2 = LocalDate.parse("2012-01-18");
    LocalDate e3 = LocalDate.parse("2010-05-19");
    
    LocalDate p4 = LocalDate.parse("2016-11-20");
    LocalDate p5 = LocalDate.parse("2016-02-13");
    LocalDate p6 = LocalDate.parse("2016-06-16");
    
    Q1= new Quotation("Q101","QU1","Kitchen","Shiny and clean ","Loki",p1,359.90);
    Q2= new Quotation("Q102","QU2","Bedroom","Big and tidy ","Harry",p2,500.00);
    Q3= new Quotation("Q103","QU3","Bedroom","Bright ","Louis",p3,450.00);
    
    Q4 = new Quotation("HDB",100.25,"James",91234567,"James@gmail.com",1000.10,p4,2,0,"",false);
    Q5 = new Quotation("Private",200.25,"Jacob",98765432,"Jacob@hotmail.com",200.20,p5,1,1,"",true);
    Q6 = new Quotation("Landed",300.25,"Cody",91827364,"Cody@yahoo.com",300.30,p6,0,2,"",true);
    
    P1 = new Package("P101", "Shiny Kitchen", p1, e1, 400.00);
    P2 = new Package("P102", "Small BedRoom", p2, e2, 500.00);
    P3 = new Package("P103", "Big Bedroom", p3, e3, 600.00);
    
    U1 = new User("John", "Admin", "John@gmail.com", "JohnAdmin123", true);
    U2 = new User("Mary", "Customer", "Mary@gmail.com", "Mary456", true);
    U3 = new User("Tom", "Designer", "Tom@gmail.com", "TomDesign789", true);

    
    QuotationList =new ArrayList<Quotation>();
    RequestedQuotationList = new ArrayList<Quotation>();
    PackageList = new ArrayList<Package>();
    UserList = new ArrayList<User>();
  }

  
//  @After
//  public void tearDown() throws Exception {
//  }

  
//  public void () {
//    //fail("Not yet implemented"); 
////    assertTrue("C206_CaseStudy_SampleTest ",true);
//  }
  //
  
//=======================Add Quotation Items ===========================================================
  @Test
  public void testAddQuotation() {
    
    assertNotNull("Test if there is valid Quotation arraylist to add to", QuotationList);
    
    //Given an empty list, after adding 1 item, the size of the list is 1
    C206CaseStudy.addQuotation(QuotationList, Q1);    
    assertEquals("Test if that Quotation arraylist size is 1?", 1, QuotationList.size());
    
    //The item just added is as same as the first item of the list
    assertSame("Test that Quotation is added same as 1st item of the list?", Q1, QuotationList.get(0));
    
    //Add another item. test The size of the list is 2?
    C206CaseStudy.addQuotation(QuotationList, Q2);
    C206CaseStudy.addQuotation(QuotationList, Q3);
    assertEquals("Test that Quotation arraylist size is 3?", 3, QuotationList.size());
    assertSame("Test that Quotation is added same as 3rd item of the list?", Q3, QuotationList.get(2));
    } // Done by Elson
    
    @Test
    public void testRetrieveAllQuotation() {
      // Test if Item list is not null but empty, so that can add a new ite
      assertNotNull("Test if there is Quotation arraylist to add to", QuotationList);
      
      
      String allQuotation= C206CaseStudy.retrieveAllQuotation(QuotationList);
      String testOutput = "";
      assertEquals("Check that ViewAllQuotationlist", testOutput, allQuotation );
          
      //Given an empty list, after adding 2 items, test if the size of the list is 2
      C206CaseStudy.addQuotation(QuotationList, Q1);
      C206CaseStudy.addQuotation(QuotationList, Q2);
      C206CaseStudy.addQuotation(QuotationList, Q3);
      assertEquals("Test if that Quotation arraylist size is 3?", 3, QuotationList.size());
      

      allQuotation= C206CaseStudy.retrieveAllQuotation(QuotationList);

      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n","Q101","QU1","Kitchen","Shiny and clean ","Loki","2015-10-03");
      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n","Q102","QU2","Bedroom","Big and tidy ","Harry","2012-01-12");
      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s\n","Q103","QU3","Bedroom","Bright ","Louis","2010-05-12");
      assertEquals("Check that ViewAllQuotationlist", allQuotation,testOutput);
      
    } // Done by Elson


    @Test
    public void testDeleteQuotation() {
    	
      assertNotNull("Test if there is Quotation arraylist to add to", QuotationList);
      
      QuotationList.add(Q1);
      
      QuotationList.add(Q2);
      assertEquals(2,QuotationList.size());
      QuotationList.remove(0);
      assertEquals(1,QuotationList.size());
      QuotationList.remove(0);
      assertTrue(QuotationList.isEmpty());
      
    } // Done by Elson
    
    @Test
    public void testAddRequestedQuotation() {
        
        assertNotNull("Test if there is a Requested Quotation arraylist to add to", RequestedQuotationList);
        
        C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q4);    
        assertEquals("Test if the Requested Quotation arraylist size is 1", 1, RequestedQuotationList.size());

        assertSame("Test that Quotation is added same as 1st item of the list?", Q4, RequestedQuotationList.get(0));

        C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q5);
        C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q6);
        assertEquals("Test that Quotation arraylist size is 3?", 3, RequestedQuotationList.size());
        assertSame("Test that Quotation is added same as 3rd item of the list?", Q6, RequestedQuotationList.get(2));
     } // Done by Jun Cheng
    
    @Test
    public void testRetrieveAllRequestedQuotation() {
      assertNotNull("Test if there is a Requested Quotation arraylist to add to", RequestedQuotationList);
      
      String allRequestedQuotation= C206CaseStudy.retrieveAllRequestedQuotation(RequestedQuotationList);
      String output = "";
      assertEquals("Check that ViewAllQuotationlist", output, allRequestedQuotation);

      C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q4);
      C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q5);
      C206CaseStudy.addRequestQuotation(RequestedQuotationList, Q6);
      assertEquals("Test if that the Requested Quotation arraylist size is 3?", 3, RequestedQuotationList.size());
      
      allRequestedQuotation= C206CaseStudy.retrieveAllRequestedQuotation(RequestedQuotationList);

      output += String.format("%-20s %-20s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n","HDB","100.25","James","91234567","James@gmail.com","1000.1","2016-11-20","2","0","","false");
      output += String.format("%-20s %-20s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n","Private","200.25","Jacob","98765432","Jacob@hotmail.com","200.2","2016-02-13","1","1","","true");
      output += String.format("%-20s %-20s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n","Landed","300.25","Cody","91827364","Cody@yahoo.com","300.3","2016-06-16","0","2","","true");
      assertEquals("Check that ViewAllQuotationlist",output,allRequestedQuotation);
      
    } // Done by Jun Cheng
    
    @Test
    public void testDeleteRequestedQuotation() {
    	
      assertNotNull("Test if there is a Requested Quotation arraylist to add to", RequestedQuotationList);
      
      RequestedQuotationList.add(Q4);
      
      RequestedQuotationList.add(Q5);
      assertEquals(2,RequestedQuotationList.size());
      RequestedQuotationList.remove(0);
      assertEquals(1,RequestedQuotationList.size());
      RequestedQuotationList.remove(0);
      assertTrue(RequestedQuotationList.isEmpty());
      
    } // Done by Jun Cheng
    
    @Test
    public void testAddUser() {
     assertNotNull("Test if there is valid User arraylist to add to", UserList);
     
     C206CaseStudy.addUser(UserList, U1);
     assertEquals("Test if that User ArrayList size is 1?", 1, UserList.size());

     //The item just added is as same as the first item of the list
     assertSame("Test that User is added same as 1st item of the list?", U1, UserList.get(0));
     
    	//Add another User. test The size of the list is 2?
    	C206CaseStudy.addUser(UserList, U2);
    	C206CaseStudy.addUser(UserList, U3);
    	assertEquals("Test that User arraylist size is 3?", 3, UserList.size());
    	assertSame("Test that User is added same as 3rd user of the list?", U3, UserList.get(2));
    } // Done by Jasrene
    
  //=======================Add new Package ===========================================================
    @Test
    public void testAddPackage() {
    	// Package list is not null, so that can add a new Package
    	assertNotNull("Test if there is valid Package arraylist to add to", PackageList);
    	assertEquals("Test if that Package arrayList size is 0?", 0, PackageList.size());
    	//Given an empty list, after adding 1 package, the size of the list is 1
    	C206CaseStudy.addPackage(PackageList, P1);		
    	assertEquals("Test if that Package arraylist size is 1?", 1, PackageList.size());
    			
    	//The package just added is as same as the first package of the list
    	assertSame("Test that Package is added same as 1st item of the list?", P1, PackageList.get(0));
    	
    	//Add another Package. test The size of the list is 2?
    	C206CaseStudy.addPackage(PackageList, P2);
    	C206CaseStudy.addPackage(PackageList, P3);
    	assertEquals("Test that Package arraylist size is 3?", 3, PackageList.size());
    	assertSame("Test that Package is added same as 3rd package of the list?", P3, PackageList.get(2));
    } // Done by Cong Lin
    
  //=======================View Package ===========================================================
    @Test
    public void testRetrieveAllPackage() {
    	// Test if Package list is not null but empty, so that can add a new package
    	assertNotNull("Test if there is valid Package arraylist to add to", PackageList);
    			
    	//test if the list of Package retrieved from the CaseStudy is empty
    	String allPackage= C206CaseStudy.retrieveAllPackage(PackageList);
    	String testOutput = "";
    	assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
    					
    	//Given an empty list, after adding 2 packages, test if the size of the list is 2
    	C206CaseStudy.addPackage(PackageList, P1);
    	C206CaseStudy.addPackage(PackageList, P2);
    	assertEquals("Test if that Package arraylist size is 2?", 2, PackageList.size());
    			
    	//test if the expected output string same as the list of packages retrieved from the CaseStudy
    	allPackage= C206CaseStudy.retrieveAllPackage(PackageList);

    	testOutput = String.format("%-10s %-30s %-10s %-10s %-20.2f\n", "P101", "Shiny Kitchen", "2015-10-03", "2015-10-07", 400.00);
    	testOutput += String.format("%-10s %-30s %-10s %-10s %-20.2f\n", "P102", "Small BedRoom", "2012-01-12", "2012-01-18", 500.00);
    		
    	assertEquals("Check that ViewAllPackagelist", allPackage, testOutput);
    } // Done by Cong Lin
   
    @Test
    public void testDeletePackage() {
        assertNotNull("Test if there is Package arraylist to add to", PackageList);
        PackageList.add(P1);
        PackageList.add(P2);
        assertEquals(2, PackageList.size());
        PackageList.remove(0);
        assertEquals(1, PackageList.size());
        PackageList.remove(0);
        assertTrue(PackageList.isEmpty());
    } // Done by Cong Lin
    
    
    
}