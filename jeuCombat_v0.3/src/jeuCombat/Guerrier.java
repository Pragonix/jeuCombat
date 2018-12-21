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
		String description = "Classe du personnage : Guerrier" +"\n";
		description += super.toString();
		description += "Force physique : " + force +"\n\n";
		
		return description;
	}
}
