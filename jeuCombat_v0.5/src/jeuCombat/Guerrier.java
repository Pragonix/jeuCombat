package jeuCombat;

public class Guerrier extends Personnage{
	
	private double force;
	
	public Guerrier(String unNom) {
		super(unNom, 120, 1);
		this.force = 130;
	}
	
	public Guerrier( String unNom, double pV, double uneForce, double uneChanceCritique) {
		super(unNom, pV, uneChanceCritique);
		this.force = uneForce;
	}

	public double getForce() {
		return this.force;
	}
	
	
	public double lancerAttaque() {
		//futur methode d'attaque
		return this.force;
	}

	
	public void recevoirAttaque (double degatsBrut) {
		if(this.getPointsDeVie() - degatsBrut <= 0) 
		{
			this.setPointsDeVie(0);
		}
		else {
			this.setPointsDeVie(this.getPointsDeVie() - degatsBrut);
		}
	}
	
	
	public String toString() {
		String description = "Classe du personnage : Guerrier" +"\n";
		description += super.toString();
		description += "Force physique : " + force +"\n\n";
		
		return description;
	}
}
