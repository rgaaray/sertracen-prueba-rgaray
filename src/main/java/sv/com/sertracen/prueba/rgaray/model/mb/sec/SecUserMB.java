package sv.com.sertracen.prueba.rgaray.model.mb.sec;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import sv.com.sertracen.prueba.rgaray.model.BaseBeans;
import sv.com.sertracen.prueba.rgaray.model.entity.sec.SecUser;
import sv.com.sertracen.prueba.rgaray.model.repository.sec.SecUserRepo;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "secUserMB")
public class SecUserMB extends BaseBeans {

	private static final long serialVersionUID = 201404221641L;

	private static final Logger logger = Logger.getLogger(SecUserMB.class);

	@Inject
	private SecUserRepo secUserRepo;

	private List<SecUser> secUserList;

	private SecUser selectedSecUser;

	private Long id;

	public SecUserMB() {
	}

	public void onLoad() {
		this.secUserList = this.secUserRepo.findAll();
	}

	public List<SecUser> getSecUserList() {
		return this.secUserList;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void delete() {
		if (this.selectedSecUser != null) {
			this.secUserRepo.delete(this.selectedSecUser.getId());
		}
	}

	public void selectSecUser(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedSecUser = (SecUser) evt.getObject();
			} else {
				this.selectedSecUser = null;
			}
		} catch (Exception e) {
			this.selectedSecUser = null;

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectSecUser() {
		this.selectedSecUser = null;
	}

	public SecUser getSelectedSecUser() {
		return this.selectedSecUser;
	}

	public void setSelectedSecUser(SecUser selectedSecUser) {
		this.selectedSecUser = selectedSecUser;
	}

}
