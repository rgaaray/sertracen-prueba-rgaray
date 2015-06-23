package sv.com.sertracen.prueba.rgaray.model.entity.cat;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import sv.com.sertracen.prueba.rgaray.model.BaseEntities;


@Entity
@Table(name="CAT_ESQUELA")
@XmlRootElement
@AttributeOverride(name = "id", column = @Column(name = "CAT_ESQ_ID"))
public class CatEsquela extends BaseEntities<Long> {

	
	private static final long serialVersionUID = 201404120102L;
	
	@Column(name = "CAT_ESQ_DESCRIPTION")
	private String catEsquelaDescription;

	@Column(name = "CAT_ESQ_CODE")
	private String catEsquelaCode;

	@Column(name = "CAT_ESQ_VALUE_CANCEL")
	private BigDecimal catEsquelaValueToCancel;
	
	@Column(name = "CAT_ESQ_CONFISCATION")
	private String catEsquelaConfiscation;
	
	@Column(name = "CAT_ESQ_DOCUMENT")
	private String catEsquelaDocument;
	
	@Column(name = "CAT_ESQ_ACTIVE")
	private boolean catEsquelaActive;

	
	public CatEsquela() {
	}

	public CatEsquela(String catEsquelaDescription, String catEsquelaCode, BigDecimal catEsquelaValueToCancel,
			String catEsquelaConfiscation, String catEsquelaDocument, boolean catEsquelaActive) {
		super();
		this.catEsquelaDescription = catEsquelaDescription;
		this.catEsquelaCode = catEsquelaCode;
		this.catEsquelaValueToCancel = catEsquelaValueToCancel;
		this.catEsquelaConfiscation = catEsquelaConfiscation;
		this.catEsquelaDocument = catEsquelaDocument;
		this.catEsquelaActive = catEsquelaActive;
	}
	

	public String getCatEsquelaDescription() {
		return catEsquelaDescription;
	}

	public void setCatEsquelaDescription(String catEsquelaDescription) {
		this.catEsquelaDescription = catEsquelaDescription;
	}

	public String getCatEsquelaCode() {
		return catEsquelaCode;
	}

	public void setCatEsquelaCode(String catEsquelaCode) {
		this.catEsquelaCode = catEsquelaCode;
	}

	public BigDecimal getCatEsquelaValueToCancel() {
		return catEsquelaValueToCancel;
	}

	public void setCatEsquelaValueToCancel(BigDecimal catEsquelaValueToCancel) {
		this.catEsquelaValueToCancel = catEsquelaValueToCancel;
	}

	public boolean isCatEsquelaActive() {
		return catEsquelaActive;
	}

	public void setCatEsquelaActive(boolean catEsquelaActive) {
		this.catEsquelaActive = catEsquelaActive;
	}

	public String getCatEsquelaConfiscation() {
		return catEsquelaConfiscation;
	}

	public void setCatEsquelaConfiscation(String catEsquelaConfiscation) {
		this.catEsquelaConfiscation = catEsquelaConfiscation;
	}

	public String getCatEsquelaDocument() {
		return catEsquelaDocument;
	}

	public void setCatEsquelaDocument(String catEsquelaDocument) {
		this.catEsquelaDocument = catEsquelaDocument;
	}
	
}
