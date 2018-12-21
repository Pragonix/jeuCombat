package jeuCombat;

import java.util.Scanner;

public class AreneDeCombat {
	private int tourDeJeu;
	private Personnage[] lesJoueurs;
	
	public AreneDeCombat(Personnage[] listJoueurs) {
		this.lesJoueurs = listJoueurs;
		this.tourDeJeu = 0;
	}

	public void debutPartie() {
		Scanner scan = new Scanner(System.in);
		Personnage[] autreJoueurs = new Personnage[lesJoueurs.length - 1];
		
		while(continueDePartie()) {

			for(int numJoueurEnAction = 0; numJoueurEnAction < lesJoueurs.length; numJoueurEnAction++){
				int choixVictime = 0;
				System.out.println("PV " + lesJoueurs[numJoueurEnAction].getNom() + " = " + lesJoueurs[numJoueurEnAction].getPointsDeVie());
				System.out.println(lesJoueurs[numJoueurEnAction].getNom() + " qui souhaitez-vous maraver ? ");
						
				//Creation d'un tableau contenant UNIQUEMENT les autres joueurs;
				int indAutreJoueur = 0;
				for(int numJoueurs = 0; numJoueurs < lesJoueurs.length; numJoueurs++ ) {
					if(numJoueurEnAction != numJoueurs) {
						autreJoueurs[indAutreJoueur] = lesJoueurs[numJoueurs];	
						indAutreJoueur++;
					}
				}
				
				//Liste les autre joueur à attaquer
				for(int numAutreJoueur = 0; numAutreJoueur < autreJoueurs.length; numAutreJoueur++){
						System.out.println((numAutreJoueur + 1) + " " + autreJoueurs[numAutreJoueur].getNom());
				}
				
				boolean saisieOk = true;
				
				do{
					choixVictime = scan.nextInt();
					
					if(choixVictime > 0 && choixVictime < (autreJoueurs.length + 1)) {
						saisieOk = false;
					}else {
						System.out.println("Choisissez une victime existante");
					}
					
				}while(saisieOk);	
				
				lesJoueurs[numJoueurEnAction].attaque(autreJoueurs[choixVictime - 1]);
				
				/*Condition pour un joueur mort 
				 * if(this.lesJoueurs[].getPointsDeVie() <= 0){
					System.out.println(this.lesJoueurs[x]);
				}*/
				
			}		
		}
		scan.close();
		System.out.println("La partie est fini !");
		
	}
	
	public boolean continueDePartie() {
		int compteurSurvivants = this.lesJoueurs.length;
		for(int x = 0 ; x < this.lesJoueurs.length; x ++){
			if(this.lesJoueurs[x].getPointsDeVie() <= 0){
				compteurSurvivants--;
			}
		}
		if(compteurSurvivants < 2) {
			return false;
		}
	return true;
	}
}
