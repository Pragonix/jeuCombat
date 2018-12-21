package jeuCombat;

public abstract class Personnage {
	protected double pointsDeVie;
	protected String nom;
	protected double chanceCritique;
	
	public Personnage(double pV, String unNom, double uneChanceCritique) {
		this.pointsDeVie = pV;
		this.nom = unNom;
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

	public abstract void attaque(Personnage attaqué);
	
}
