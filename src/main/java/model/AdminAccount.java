package model;
// default package
// Generated Apr 27, 2021, 3:04:25 PM by Hibernate Tools 5.4.27.Final

/**
 * AdminAccount generated by hbm2java
 */
public class AdminAccount implements java.io.Serializable {

	private String nameAccount;
	private String passwordAdmin;
	private String firstName;
	private String lastName;

	public AdminAccount() {
	}

	public AdminAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public AdminAccount(String nameAccount, String passwordAdmin, String firstName, String lastName) {
		this.nameAccount = nameAccount;
		this.passwordAdmin = passwordAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getNameAccount() {
		return this.nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public String getPasswordAdmin() {
		return this.passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
