package jeuCombat;

public abstract class Personnage {
	private double pointsDeVie;
	private String nom;
	private double chanceCritique;
	
	public Personnage(String unNom, double pV, double uneChanceCritique) {
		this.nom = unNom;
		this.pointsDeVie = pV;
		this.chanceCritique = uneChanceCritique;
	}
	
	public double getPointsDeVie() {
		return pointsDeVie;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getChanceCritique() {
		return chanceCritique;
	}
	
	
	public void setPointsDeVie(double pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	
	public abstract double lancerAttaque();
	
	public abstract void recevoirAttaque (double degatsBrute);
	
	
	
	
	public String toString() {
		String description = "Nom de combattant : " + nom + "\n";
		description += "Points de vie : " + pointsDeVie +"\n";
		return description;
	}
}
