package jeuCombat;

import java.util.Scanner;

public class AreneDeCombat {
	private int tourDeJeu;
	private Personnage joueur1;
	private Personnage joueur2;
	
	public AreneDeCombat(Personnage j1, Personnage j2) {
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.tourDeJeu = 0;
	}

	public void debutPartie() {
		Scanner scan = new Scanner(System.in);
		System.out.println("j1 pv = " + joueur1.getPointsDeVie());
		System.out.println("j2 pv = " + joueur2.getPointsDeVie());
		
		while(joueur1.getPointsDeVie() > 0 && joueur2.getPointsDeVie() > 0) {
			if(tourDeJeu == 0)
			{
				System.out.println(joueur1.getNom() + " attaque " + joueur2.getNom());
				joueur1.attaque(joueur2);
				System.out.println("j1 pv = " + joueur1.getPointsDeVie());
				System.out.println("j2 pv = " + joueur2.getPointsDeVie());
				tourDeJeu++;
			}
				
			if(tourDeJeu == 1)
			{
				System.out.println(joueur2.getNom() + " attaque " + joueur1.getNom());
				joueur2.attaque(joueur1);
				System.out.println("j1 pv = " + joueur1.getPointsDeVie());
				System.out.println("j2 pv = " + joueur2.getPointsDeVie());
				tourDeJeu++;
			}
			else tourDeJeu = 0 ;
						
		}
	}
}
