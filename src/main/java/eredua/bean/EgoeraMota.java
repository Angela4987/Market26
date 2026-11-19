package eredua.bean;

public class EgoeraMota {
	 public String egoeraMota; 
	 public int kodea; 
	 
	 public EgoeraMota(int kodea, String egoeraMota){ 
	  this.egoeraMota=egoeraMota; 
	  this.kodea=kodea; 
	 } 
	 public String getErabMota() { 
	  return egoeraMota; 
	 } 
	 public void setErabMota(String erabMota) { 
	  this.egoeraMota = erabMota; 
	 } 
	 public int getKodea() { 
	  return kodea; 
	 } 
	 public void setKodea(int kodea) { 
	  this.kodea = kodea; 
	 } 
	 public String toString(){ 
	  return egoeraMota; 
	 }
	 @Override 
	 public int hashCode() { 
		 final int prime = 31; 
		 int result = 1; 
		 result = prime * result + kodea; 
		 return result; } 
	 @Override 
	 public boolean equals(Object obj) { 
		 if (this == obj) 
		 return true; 
		 if (obj == null) 
		 return false; 
		 if (getClass() != obj.getClass()) 
		 return false; 
		 EgoeraMota other = (EgoeraMota) obj; 
		 if (kodea != other.kodea) 
		 return false; 
		 return true; } 
	 } 
