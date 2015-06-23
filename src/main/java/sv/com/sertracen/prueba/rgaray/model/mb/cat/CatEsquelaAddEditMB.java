package sv.com.sertracen.prueba.rgaray.model.mb.cat;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import sv.com.sertracen.prueba.rgaray.model.BaseBeans;
import sv.com.sertracen.prueba.rgaray.model.entity.cat.CatEsquela;
import sv.com.sertracen.prueba.rgaray.model.repository.cat.CatEsquelaRepo;


@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "catEsquelaAddEditMB")
public class CatEsquelaAddEditMB extends BaseBeans {

	private static final long serialVersionUID = 201311132355L;

	@Inject
	private CatEsquelaRepo catEsquelaRepo;

	@Inject
	private CatEsquelaMB catEsquelaMB;

	@Inject
	private FacesContext context;

	private CatEsquela catEsquela;

	private String title;

	public CatEsquelaAddEditMB() {
		this.catEsquela = new CatEsquela();
	}

	public CatEsquela getCatEsquela() {
		return this.catEsquela;
	}

	public void setCatEsquela(CatEsquela catEsquela) {
		this.catEsquela = catEsquela;
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "catEsquela_add");
	}

	public void update() {
		this.catEsquela = this.catEsquelaMB.getSelectedCatEsquela();
		this.title = this.getResourceProperty("labels", "catEsquela_update");
	}

	public void cancel() {
		this.catEsquelaMB.unselectCatEsquela();
	}

	public void save() {
		if (this.catEsquela != null) {
			if (this.catEsquela.getId() == null) {
				// Add
				this.catEsquelaRepo.save(this.catEsquela);
			} else {
				// Update
				this.catEsquelaRepo.save(this.catEsquela);
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
