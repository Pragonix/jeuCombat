package jeuCombat;

public class Assassin extends Personnage{
	private double force;
	
	public Assassin(String unNom) {
		super(75, unNom, 1);
		this.force = 20;
	}
	
	public Assassin(double uneForce, double pV, String unNom, double uneChanceCritique) {
		super(pV, unNom, uneChanceCritique);
		this.force = uneForce;
	}

	public double getForce() {
		return this.force;
	}
	
	public void attaque(Personnage attaqué ) {
		if(attaqué.getPointsDeVie()- this.getForce() <= 0) 
		{
			attaqué.setPointsDeVie(0);
		}
		else {
			attaqué.setPointsDeVie(attaqué.getPointsDeVie() - this.getForce());
		}
	}
	
	public String toString() {
		String description = "Classe du personnage : " + this.getClass().getName() +"\n";
		description += "Nom de combattant : " + nom + "\n";
		description += "Points de vie : " + pointsDeVie +"\n";
		description += "Force : " + force +"\n\n";
		
		return description;
	}
	
}
