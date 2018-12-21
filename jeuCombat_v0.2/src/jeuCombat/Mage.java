package jeuCombat;

public class Mage extends Personnage{
	
	private double puissanceMagique;
	
	public Mage(String unNom) {
		super(100, unNom, 1);
		this.puissanceMagique = 25;
	}
	
	public Mage(double uneForceMagique, double pV, String unNom, double uneChanceCritique) {
		super(pV, unNom, uneChanceCritique);
		this.puissanceMagique = uneForceMagique;
	}

	public double getPuissanceMagique() {
		return this.puissanceMagique;
	}
	
	public void seSoigner(double uneForceMagique) {
		this.setPointsDeVie(this.getPointsDeVie() + (this.getPuissanceMagique() * 0.3));
	}
	
	public void attaque(Personnage attaqué ) {
		if(attaqué.getPointsDeVie()- this.getPuissanceMagique() <= 0) 
		{
			attaqué.setPointsDeVie(0);
		}
		else {
			attaqué.setPointsDeVie(attaqué.getPointsDeVie() - this.getPuissanceMagique());
		}
	}
	
	public String toString() {
		String description = "Classe du personnage : Mage" +"\n";
		description += super.toString();
		description += "Puissance magique: " + puissanceMagique +"\n\n";
		
		return description;
	}

}
