import java.time.LocalDate;
	
public class Package {
	
	private String packageCode;
	private String packageDes;
	private LocalDate startDate;
	private LocalDate endDate;
	private double packageAmount;
	
	public Package(String packageCode, String packageDes, LocalDate startDate, LocalDate endDate, double packageAmount) {
		this.packageCode = packageCode;
		this.packageDes = packageDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.packageAmount = packageAmount;
	}

	
	public String getPackageCode() {
		return packageCode;
	}
	
	public String getPackageDes() {
		return packageDes;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public double getPackageAmount() {
		return packageAmount;
	}

}
