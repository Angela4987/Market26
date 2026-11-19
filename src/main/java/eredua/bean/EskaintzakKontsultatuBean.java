package eredua.bean;
import java.io.Serializable;
import java.util.List;

import businessLogic.BLFacade;
import domain.Sale;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("EskaintzakKontsultatu")
@ViewScoped
public class EskaintzakKontsultatuBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BLFacade facadeBL=FacadeBean.getBusinessLogic();
	private String desc;
	private List<Sale> eskaintzak;
	
	public BLFacade getFacadeBL() {
		return facadeBL;
	}

	public void setFacadeBL(BLFacade facadeBL) {
		this.facadeBL = facadeBL;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void  eskaintzakLortu() {
	    System.out.println("HE ENTRADO");
	    System.out.println("DESC = " + desc);
		setEskaintzak(facadeBL.getSales(desc));
		 System.out.println("ESKAINTZAK = " + eskaintzak);
		    System.out.println("SIZE = " +
		        (eskaintzak == null ? "NULL" : eskaintzak.size()));
		}
		
	

	public List<Sale> getEskaintzak() {
		return eskaintzak;
	}

	public void setEskaintzak(List<Sale> eskaintzak) {
		this.eskaintzak = eskaintzak;
	}

}
