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
  
  private ArrayList<Quotation> QuotationList;
  @Before
  public void setUp() throws Exception {
    LocalDate p1 = LocalDate.parse("2015-10-03");
    LocalDate p2 = LocalDate.parse("2012-01-12");
    LocalDate p3 = LocalDate.parse("2010-05-12");
    Q1= new Quotation("Q101","QU1","Kitchen","Shiny and clean ","Loki",p1,359.90);
    Q2= new Quotation("Q102","QU2","Bedroom","Big and tidy ","Harry",p2,500.00);
    Q3= new Quotation("Q103","QU3","Bedroom","Bright ","Louis",p3,450.00);
    
    
    QuotationList =new ArrayList<Quotation>();
  }

  
//  @After
//  public void tearDown() throws Exception {
//  }

  
//  public void () {
//    //fail("Not yet implemented"); 
////    assertTrue("C206_CaseStudy_SampleTest ",true);
//  }
  
  
//=======================Add Quotation Items ===========================================================
  @Test
  public void testAddQuotation() {
    
    assertNotNull("Test if there is valid Camcorder arraylist to add to", QuotationList);
    
    //Given an empty list, after adding 1 item, the size of the list is 1
    C206CaseStudy.addQuotation(QuotationList, Q1);    
    assertEquals("Test if that Camcorder arraylist size is 1?", 1, QuotationList.size());
    
    //The item just added is as same as the first item of the list
    assertSame("Test that Camcorder is added same as 1st item of the list?", Q1, QuotationList.get(0));
    
    //Add another item. test The size of the list is 2?
    C206CaseStudy.addQuotation(QuotationList, Q2);
    C206CaseStudy.addQuotation(QuotationList, Q3);
    assertEquals("Test that Camcorder arraylist size is 3?", 3, QuotationList.size());
    assertSame("Test that Camcorder is added same as 3rd item of the list?", Q3, QuotationList.get(2));
    }
    
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
      assertEquals("Test if that Quotation arraylist size is 2?", 2, QuotationList.size());
      

      allQuotation= C206CaseStudy.retrieveAllQuotation(QuotationList);

      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20.2f\n","Q101","QU1","Kitchen","Shiny and clean ","Loki","03-10-2015",359.90);
      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20.2f\n","Q102","QU2","Bedroom","Big and tidy ","Harry","12-01-2012",500.00);
      testOutput += String.format("%-10s %-30s %-10s %-10s %-20s %-20s %-20.2f\n","Q103","QU3","Bedroom","Bright ","Louis","12-05-2010",450.00);
      assertEquals("Check that ViewAllQuotationlist", testOutput, allQuotation);//
      
    }


    @Test
    public void testDeleteQuotation() {
      assertNotNull("Test if there is Quotation arraylist to add to", QuotationList);
      
      C206CaseStudy.addQuotation(QuotationList,Q1);
      
      Boolean deleted=C206CaseStudy.doDeleteQuotation(QuotationList, null);
    }
    
    
}