package sv.com.sertracen.prueba.rgaray.model.entity.sec;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sv.com.sertracen.prueba.rgaray.model.BaseEntities;


@Entity
@Table(name="SEC_USER")
@AttributeOverride(name = "id", column = @Column(name = "SEC_USE_ID"))
public class SecUser extends BaseEntities<Long> {

	
	private static final long serialVersionUID = 201404140102L;
	
	@Column(name = "SEC_USE_NAME")
	private String secUserName;

	@Column(name = "SEC_USE_USERNAME")
	private String secUserUsername;

	@Column(name = "SEC_USE_PASSWORD")
	private String secUserPassword;

	@Column(name = "SEC_USE_ROLE")
	private String secUserRole;

	
	public SecUser() {
	}

	public SecUser(String secUserName, String secUserUsername, String secUserPassword, String secUserRole) {
		super();
		this.secUserName = secUserName;
		this.secUserUsername = secUserUsername;
		this.secUserPassword = secUserPassword;
		this.secUserRole = secUserRole;
	}

	
	public String getSecUserName() {
		return secUserName;
	}

	public void setSecUserName(String secUserName) {
		this.secUserName = secUserName;
	}

	public String getSecUserUsername() {
		return secUserUsername;
	}

	public void setSecUserUsername(String secUserUsername) {
		this.secUserUsername = secUserUsername;
	}

	public String getSecUserPassword() {
		return secUserPassword;
	}

	public void setSecUserPassword(String secUserPassword) {
		this.secUserPassword = secUserPassword;
	}

	public String getSecUserRole() {
		return secUserRole;
	}

	public void setSecUserRole(String secUserRole) {
		this.secUserRole = secUserRole;
	}


}
