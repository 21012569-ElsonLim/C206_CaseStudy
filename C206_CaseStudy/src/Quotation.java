import java.util.ArrayList;
import java.util.Date;

public class Quotation {

	private  String RequestID;
	private String QuotationID;
	private String renovationCategory;
	private String DesiName;
	private String Description;
	private String earliestStartDate;
	private double TotalQuotationamt;
	


	public Quotation(String RequestID, String QuotationID, String renovationCategory, String Description,
			String DesiName, String earliestStartDate, double TotalQuotationamt) {
		// TODO Auto-generated constructor stub\
		this.RequestID = RequestID;
		this.QuotationID = QuotationID;
		this.renovationCategory = renovationCategory;
		this.DesiName = DesiName;
		this.Description=Description;
		this.earliestStartDate = earliestStartDate;
		this.TotalQuotationamt = TotalQuotationamt;
	}

	
	public String getRequest_ID1() {
		return RequestID;
	}

	public String getQuotation_ID() {
		return QuotationID;
	}

	public String getRenovation_Category() {
		return renovationCategory;
	}

	public String getDesi_Name() {
		return DesiName;
	}
	
	public String getDescription() {
		return Description;
	}

	public String getEarliest_Start_Date() {
		return earliestStartDate;
	}

	public double getTotal_Quotation_amt() {
		return TotalQuotationamt;
	}


	


}
