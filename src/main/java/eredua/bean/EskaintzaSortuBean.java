package eredua.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessLogic.BLFacade;
import exceptions.MustBeLaterThanTodayException;
import exceptions.ParamNullException;
import exceptions.SaleAlreadyExistException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

@Named("EskaintzaSortu")
@ViewScoped
public class EskaintzaSortuBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5561807963708209230L;

	private String tituloa; 
	private String deskripzioa;
	private float prezioa;
	private EgoeraMota egoera;
	private Date data;
	private String emaila;
	private File argazkia;
	private static List<EgoeraMota> egoerak =new ArrayList<EgoeraMota>();
	private BLFacade facadeBL=FacadeBean.getBusinessLogic(); 
	private Part uploadedFile;
	
	public EskaintzaSortuBean() {

	}
	
		
	
	
	public String getTituloa() {
		return tituloa;
	}
	public void setTituloa(String tituloa) {
		this.tituloa = tituloa;
	}
	public String getDeskripzioa() {
		return deskripzioa;
	}
	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}
	public float getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}
	public EgoeraMota getEgoera() {

		    return egoera;
		}
	
	public  void setEgoera(EgoeraMota egoera) {
		this.egoera = egoera;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEmaila() {
		return emaila;
	}
	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}
	public File getIrudia() {
		return argazkia;
	}
	public  void setIrudia(File argazkia) {
		this.argazkia = argazkia;
	}
	public BLFacade facadeBL() {
		return facadeBL;
	}
	public void setDbfacadeBL(BLFacade facadeBL) {
		this.facadeBL = facadeBL;
	}
	public List<EgoeraMota> getEgoerak() {
		egoerak = new ArrayList<EgoeraMota>(); 
		egoerak.add(new EgoeraMota(0, "Berria")); 
		egoerak.add(new EgoeraMota(1, "Oso ona"));
		egoerak.add(new EgoeraMota(2, "Egokia")); 
		egoerak.add(new EgoeraMota(3, "Oso zaharra")); 
		return egoerak; 
	}
	public void setEgoerak(List<EgoeraMota> egoerak) {
		EskaintzaSortuBean.egoerak = egoerak;
	}
	public void argazkiaKudeatu() throws IOException{

		    String fileName = uploadedFile.getSubmittedFileName();

		    File file = new File(
		        "C:/temp/" + fileName
		    );

		    Files.copy(
		        uploadedFile.getInputStream(),
		        file.toPath(),
		        StandardCopyOption.REPLACE_EXISTING
		    );
		    argazkia = file;
		    
		
	}
	public void gorde() {
		try{
			facadeBL.createSale(tituloa, deskripzioa, egoera.getKodea(), prezioa, data, "user@gmail.com", argazkia);
			FacesContext.getCurrentInstance().addMessage(null,  
			new FacesMessage("Eskaintza sortuta")); 
		}catch (MustBeLaterThanTodayException e1) {
			FacesContext.getCurrentInstance().addMessage(null,  
			new FacesMessage("Data gaur baino lehenagokoa da")); 
		}catch (ParamNullException e2) {
			FacesContext.getCurrentInstance().addMessage(null,  
			new FacesMessage("Datuak falta dira"));
		}catch (SaleAlreadyExistException e3) {
			FacesContext.getCurrentInstance().addMessage(null,  
			new FacesMessage("Eskaintza hori jada sortua dago"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,  
			new FacesMessage("Eskaintza ezin da sortu"));
		}
		
	}
	public File getArgazkia() {
		return argazkia;
	}
	public void setArgazkia(File argazkia) {
		this.argazkia = argazkia;
	}
	public Part getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static EgoeraMota getObject(String mota) { 
		for (EgoeraMota m: egoerak){ 
		if (mota.equals(m.getErabMota()))  
		return m;} 
		return null; } 
}
