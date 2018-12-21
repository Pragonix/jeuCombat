package jeuCombat;

public class Assassin extends Personnage{
	private double force;
	
	public Assassin(String unNom) {
		super(unNom, 75, 1);
		this.force = 20;
	}
	
	public Assassin(String unNom, double pV, double uneForce, double uneChanceCritique) {
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
		String description = "Classe du personnage : Assassin" +"\n";
		description += super.toString();
		description += "Force physique : " + force +"\n\n";
		
		return description;
	}
	
}
