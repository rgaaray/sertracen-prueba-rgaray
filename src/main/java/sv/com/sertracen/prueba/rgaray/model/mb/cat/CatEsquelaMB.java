package sv.com.sertracen.prueba.rgaray.model.mb.cat;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import sv.com.sertracen.prueba.rgaray.model.BaseBeans;
import sv.com.sertracen.prueba.rgaray.model.entity.cat.CatEsquela;
import sv.com.sertracen.prueba.rgaray.model.repository.cat.CatEsquelaRepo;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "catEsquelaMB")
public class CatEsquelaMB extends BaseBeans {

	private static final long serialVersionUID = 201404221641L;

	private static final Logger logger = Logger.getLogger(CatEsquelaMB.class);

	@Inject
	private CatEsquelaRepo catEsquelaRepo;

	private List<CatEsquela> catEsquelaList;

	private CatEsquela selectedCatEsquela;

	private Long id;

	public CatEsquelaMB() {
	}

	public void onLoad() {
		this.catEsquelaList = this.catEsquelaRepo.findAll();
	}

	public List<CatEsquela> getCatEsquelaList() {
		return this.catEsquelaList;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void delete() {
		if (this.selectedCatEsquela != null) {
			this.catEsquelaRepo.delete(this.selectedCatEsquela.getId());
		}
	}

	public void selectCatEsquela(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedCatEsquela = (CatEsquela) evt.getObject();
			} else {
				this.selectedCatEsquela = null;
			}
		} catch (Exception e) {
			this.selectedCatEsquela = null;

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectCatEsquela() {
		this.selectedCatEsquela = null;
	}

	public CatEsquela getSelectedCatEsquela() {
		return this.selectedCatEsquela;
	}

	public void setSelectedCatEsquela(CatEsquela selectedCatEsquela) {
		this.selectedCatEsquela = selectedCatEsquela;
	}

}
