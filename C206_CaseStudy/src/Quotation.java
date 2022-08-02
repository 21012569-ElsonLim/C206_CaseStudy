import java.time.LocalDate;

public class Quotation {
	
	private String RequestID;
	private String QuotationID;
	private String renovationCategory;
	private String DesiName;
	private String Description;
	private LocalDate earliestStartDate;
	private double TotalQuotationamt;
	
	private String propertyType;
	private double areaSize;
	private String requestorName;
	private int customerContactNum;
	private String customerEmail;
	private double budget;
	private LocalDate targetCompletionDate;
	private int roomToRenovate;
	private int toiletToRenovate;
	private String renovationStyle;
	private boolean urgentRequest;

	public Quotation(String RequestID, String QuotationID, String renovationCategory, String Description,
			String DesiName, LocalDate earliestStartDate, double TotalQuotationamt) {
		this.RequestID = RequestID;
		this.QuotationID = QuotationID;
		this.renovationCategory = renovationCategory;
		this.DesiName = DesiName;
		this.Description=Description;
		this.earliestStartDate = earliestStartDate;
		this.TotalQuotationamt = TotalQuotationamt;
	}
	
	public Quotation(String propertyType, double areaSize, String requestorName, int customerContactNum,
			String customerEmail, double budget, LocalDate targetCompletionDate, int roomToRenovate,
			int toiletToRenovate, String renovationStyle, boolean urgentRequest) {
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestorName = requestorName;
		this.customerContactNum = customerContactNum;
		this.customerEmail = customerEmail;
		this.budget = budget;
		this.targetCompletionDate = targetCompletionDate;
		this.roomToRenovate = roomToRenovate;
		this.toiletToRenovate = toiletToRenovate;
		this.renovationStyle = renovationStyle;
		this.urgentRequest = urgentRequest;
	}

	
	public String getRequest_ID() {
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

	public LocalDate getEarliest_Start_Date() {
		return earliestStartDate;
	}

	public double getTotal_Quotation_amt() {
		return TotalQuotationamt;
	}

	
	
	public String getPropertyType() {
		return propertyType;
	}
	
	public double getAreaType() {
		return areaSize;
	}
	
	public String getrequestorName() {
		return requestorName;
	}
	
	public int getcustomerContactNum() {
		return customerContactNum;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public double getbudget() {
		return budget;
	}
	
	public LocalDate getTargetCompletionDate() {
		return targetCompletionDate;
	}
	
	public int getRoomToRenovate() {
		return roomToRenovate;
	}
	
	public int getToiletToRenovate() {
		return toiletToRenovate;
	}
	public String getRenovationStyle() {
		return renovationStyle;
	}
	
	public boolean getUrgentRequest() {
		return urgentRequest;
	}
}
