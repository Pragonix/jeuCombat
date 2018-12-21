package jeuCombat;

public class Mage extends Personnage{
	
	private double puissanceMagique;
	
	public Mage(String unNom) {
		super(unNom, 100, 1);
		this.puissanceMagique = 125;
	}
	
	public Mage(String unNom, double pV, double uneForceMagique, double uneChanceCritique) {
		super(unNom, pV, uneChanceCritique);
		this.puissanceMagique = uneForceMagique;
	}

	public double getPuissanceMagique() {
		return this.puissanceMagique;
	}
	
	public void seSoigner(double uneForceMagique) {
		this.setPointsDeVie(this.getPointsDeVie() + (this.getPuissanceMagique() * 0.3));
	}
	public double lancerAttaque() {
		//futur methode d'attaque
		return this.puissanceMagique;
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
		String description = "Classe du personnage : Mage" +"\n";
		description += super.toString();
		description += "Puissance magique: " + puissanceMagique +"\n\n";
		
		return description;
	}

}
