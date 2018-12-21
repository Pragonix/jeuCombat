package jeuCombat;

public class Guerrier extends Personnage{
	
	private double force;
	
	public Guerrier(String unNom) {
		super(120, unNom, 1);
		this.force = 30;
	}
	
	public Guerrier(double uneForce, double pV, String unNom, double uneChanceCritique) {
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
