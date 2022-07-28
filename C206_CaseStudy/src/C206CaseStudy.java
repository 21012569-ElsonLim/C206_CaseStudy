import java.util.ArrayList;

public class C206CaseStudy {
	
	private Quotation Q1;
	private Quotation Q2;
	private Quotation Q3;
	
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Quotation> QuotationList= new  ArrayList<Quotation>();
		QuotationList.add(new Quotation("Q101","QU1","Kitchen","Shiny and clean ","Loki","03-10-2015",359.90) );
		QuotationList.add(new Quotation("Q102","QU2","Bedroom","Big and tidy ","Harry","12-01-2012",500.00) );
		QuotationList.add(new Quotation("Q103","QU3","Bedroom","Bright ","Louis","12-05-2010",450.00));
	}
	
	
	
	public static void menu() {
		C206CaseStudy.setHeader("C206 Centre App");
		System.out.println("1.Account");
		System.out.println("2.Package");
		System.out.println("3.Request Quotation");
		System.out.println("4.Manage Quotation");
		
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

			output1 += String.format("%-10s %-30s %-10s %-10s %-20s\n", QuotationList.get(x).getRequest_ID1(),
					QuotationList.get(x).getQuotation_ID(), 
					QuotationList.get(x).getRenovation_Category(),QuotationList.get(x).getDesi_Name(),QuotationList.get(x).getDescription()
					,QuotationList.get(x).getEarliest_Start_Date(),QuotationList.get(x).getTotal_Quotation_amt().);
		}
		return output1;
	}
	public static void viewAllChromebook(ArrayList<Quotation>QuotationList) {
		C206CaseStudy.setHeader("Quotation List");
		String output = String.format("%-10s %-30s %-10s %-35s %-20s %-15s %-20s\n", "REQUESTID", "QUOTATION",
				"RENOVATIONCATEGORY", "DESCRIPTION","DESIGNER NAME ","EARLIEST START DATE ","TOTAL QUOTATION AMOUNT ");
		
		 output += retrieveAllQuotation(QuotationList);
		System.out.println(output);
	}

	
	
	
	public static Quotation inputQuotation() {
		String RequestID = Helper.readString("Enter asset tag > ");
		String QuotationID = Helper.readString("Enter description > ");
		String renovationCat = Helper.readString("Enter description > ");
		String desiName = Helper.readString("Enter description > ");
		String Description = Helper.readString("Enter description > ");
		String earliestStartDate = Helper.readString("Enter description > ");
		double TotalQuotationamt = Helper.readDouble("Enter description > ");
	

		Quotation Q3= new Quotation(RequestID, QuotationID, renovationCat,desiName,Description,earliestStartDate,TotalQuotationamt);
		return cc;
	}
	
	
	
	
	
	
	
	
	
	public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation x) {

		QuotationList.add(x);
	}
}
