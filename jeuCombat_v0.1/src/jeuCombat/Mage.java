package jeuCombat;

public class Mage extends Personnage{
	
	private double forceMagique;
	
	public Mage(String unNom) {
		super(100, unNom, 1);
		this.forceMagique = 25;
	}
	
	public Mage(double uneForceMagique, double pV, String unNom, double uneChanceCritique) {
		super(pV, unNom, uneChanceCritique);
		this.forceMagique = uneForceMagique;
	}

	public double getForceMagique() {
		return this.forceMagique;
	}
	
	public void seSoigner(double uneForceMagique) {
		this.setPointsDeVie(this.getPointsDeVie() + (this.getForceMagique() * 0.3));
	}
	
	public void attaque(Personnage attaqué ) {
		if(attaqué.getPointsDeVie()- this.getForceMagique() <= 0) 
		{
			attaqué.setPointsDeVie(0);
		}
		else {
			attaqué.setPointsDeVie(attaqué.getPointsDeVie() - this.getForceMagique());
		}
	}
	
	public String toString() {
		String description = "Classe du personnage : " + this.getClass().getName() +"\n";
		description += "Nom de combattant : " + nom + "\n";
		description += "Points de vie : " + pointsDeVie +"\n";
		description += "Force magique: " + forceMagique +"\n\n";
		
		return description;
	}

}
