package ocp.testCode;

public class DVD {
	private String tite;
	private String acteur;
	private long prix;
	
	public DVD(String tite, String acteur, long prix) {
		super();
		this.tite = tite;
		this.acteur = acteur;
		this.prix = prix;
	
	}
	public String getTite() {
		return tite;
	}
	public void setTite(String tite) {
		this.tite = tite;
	}
	public String getActeur() {
		return acteur;
	}
	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "DVD [tite=" + tite + ", acteur=" + acteur + ", prix=" + prix + "]";
	} 
	
}
