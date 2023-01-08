package emlakcepte.dto.model.response;

import emlakcepte.model.enums.UserType;

import java.time.LocalDateTime;

public class UserResponse {
	private String name;
	private String email;
	private UserType type;

	private LocalDateTime packageExpireDate;

	public LocalDateTime getPackageExpireDate() {
		return packageExpireDate;
	}

	public void setPackageExpireDate(LocalDateTime packageExpireDate) {
		this.packageExpireDate = packageExpireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserResponse [name=" + name + ", email=" + email + ", type=" + type + "]";
	}

}
