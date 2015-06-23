package sv.com.sertracen.prueba.rgaray.model.mb.sec;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import sv.com.sertracen.prueba.rgaray.model.BaseBeans;
import sv.com.sertracen.prueba.rgaray.model.entity.sec.SecUser;
import sv.com.sertracen.prueba.rgaray.model.repository.sec.SecUserRepo;


@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "secUserAddEditMB")
public class SecUserAddEditMB extends BaseBeans {

	private static final long serialVersionUID = 201311132355L;

	@Inject
	private SecUserRepo secUserRepo;

	@Inject
	private SecUserMB secUserMB;

	@Inject
	private FacesContext context;

	private SecUser secUser;

	private String title;

	public SecUserAddEditMB() {
		this.secUser = new SecUser();
	}

	public SecUser getSecUser() {
		return this.secUser;
	}

	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "secUser_add");
	}

	public void update() {
		this.secUser = this.secUserMB.getSelectedSecUser();
		this.title = this.getResourceProperty("labels", "secUser_update");
	}

	public void cancel() {
		this.secUserMB.unselectSecUser();
	}

	public void save() {
		if (this.secUser != null) {
			if (this.secUser.getId() == null) {
				// Add
				this.secUserRepo.save(this.secUser);
			} else {
				// Update
				this.secUserRepo.save(this.secUser);
			}
		}
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}

}
