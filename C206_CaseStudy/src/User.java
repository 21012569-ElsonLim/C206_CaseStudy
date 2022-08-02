
public class User {

	private String Name;
	private String Role;
	private String Email;
	private String Password;
	private String Status;

	public User(String name, String role, String email, String password, String status) {
		this.Name = name;
		this.Role = role;
		this.Email = email;
		this.Password = password;
		this.Status = status;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
