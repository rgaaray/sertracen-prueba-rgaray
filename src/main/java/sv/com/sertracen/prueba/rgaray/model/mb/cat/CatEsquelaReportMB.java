package sv.com.sertracen.prueba.rgaray.model.mb.cat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import sv.com.sertracen.prueba.rgaray.model.BaseBeans;
import sv.com.sertracen.prueba.rgaray.model.entity.cat.CatEsquela;
import sv.com.sertracen.prueba.rgaray.model.repository.cat.CatEsquelaRepo;

@SuppressWarnings("deprecation")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "catEsquelaReportMB")
public class CatEsquelaReportMB extends BaseBeans {
	
	private static final long serialVersionUID = 2043585512198067764L;

	private List<CatEsquela> catEsquelaList;

    @Inject
	private CatEsquelaRepo catEsquelaRepo;
    
    JasperPrint jasperPrint;
    
    public List<CatEsquela> getCatEsquelaList() {
    	catEsquelaList = this.catEsquelaRepo.findAll();
        return catEsquelaList;
    }

    public void setCatEsquelaList(List<CatEsquela> catEsquelaList) {
        this.catEsquelaList = catEsquelaList;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() throws JRException{
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(getCatEsquelaList());
        jasperPrint=JasperFillManager.fillReport(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/reports/reportEsquelas.jasper"), new HashMap(),beanCollectionDataSource);
//        jasperPrint=JasperFillManager.fillReport("C:\\Users\\rag4\\Desktop\\reportEsquelas.jasper", new HashMap(),beanCollectionDataSource);
    }
    
   public void PDF(ActionEvent actionEvent) throws JRException, IOException{
       init();
       
       HttpServletResponse httpServletResponse;httpServletResponse = (HttpServletResponse)  FacesContext.getCurrentInstance().getExternalContext().getResponse();
       httpServletResponse.setContentType("application/pdf");
       httpServletResponse.addHeader("Content-disposition", "inline;filename=testReport.pdf");
//       httpServletResponse.addHeader("Content-disposition", "attachment;filename=testReport.pdf");
       ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);

       FacesContext.getCurrentInstance().responseComplete();
       FacesContext.getCurrentInstance().renderResponse();
   }
	public void DOCX(ActionEvent actionEvent) throws JRException, IOException{
        init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.docx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRDocxExporter docxExporter=new JRDocxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       
       FacesContext.getCurrentInstance().responseComplete();
       FacesContext.getCurrentInstance().renderResponse();
   }
    
	public void XLSX(ActionEvent actionEvent) throws JRException, IOException{
        init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.xlsx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRXlsxExporter docxExporter=new JRXlsxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
       
       FacesContext.getCurrentInstance().responseComplete();
       FacesContext.getCurrentInstance().renderResponse();
   }
    
	public void ODT(ActionEvent actionEvent) throws JRException, IOException{
       init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.odt");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JROdtExporter docxExporter=new JROdtExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
   }
      
	public void PPT(ActionEvent actionEvent) throws JRException, IOException{
       init();
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pptx");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JRPptxExporter docxExporter=new JRPptxExporter();
       docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
       docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
       docxExporter.exportReport();
   }
    
}
