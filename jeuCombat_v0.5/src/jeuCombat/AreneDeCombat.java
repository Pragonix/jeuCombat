package jeuCombat;

import java.util.ArrayList;

import java.util.Scanner;

public class AreneDeCombat {
	
	private ArrayList<Personnage> lesJoueurs = new ArrayList<>();
	private ArrayList<Personnage> lesJoueursMorts = new ArrayList<>();
	
	
	public AreneDeCombat(ArrayList<Personnage> listJoueurs) {
		this.lesJoueurs = listJoueurs;
	}

	public void debutPartie() {
		Scanner scan = new Scanner(System.in);

		ArrayList<Personnage> autreJoueurs = new ArrayList<>();
		
		while(continueDePartie()) {
 
			for(int numJoueurEnAction = 0; numJoueurEnAction < lesJoueurs.size(); numJoueurEnAction++){
				int choixVictime = 0;
				System.out.println("\n-----------------------------------------------------\n");
				System.out.println("C'est au tour de " + lesJoueurs.get(numJoueurEnAction).getNom() + ", il te reste " + lesJoueurs.get(numJoueurEnAction).getPointsDeVie() + "PV");
				System.out.println(lesJoueurs.get(numJoueurEnAction).getNom() + " qui veux-tu maraver ?\n");
						
				//Creation d'un tableau contenant UNIQUEMENT les autres joueurs;
				autreJoueurs.clear();
				for(int numJoueurs = 0; numJoueurs < lesJoueurs.size(); numJoueurs++ ) {
					if(numJoueurEnAction != numJoueurs) {
						autreJoueurs.add(lesJoueurs.get(numJoueurs));	
					}
				}
				
				//Liste les autre joueur à attaquer
				System.out.println("Les joueur(s) vivant(s) : ");
				for(int numAutreJoueur = 0; numAutreJoueur < autreJoueurs.size(); numAutreJoueur++){
						System.out.println((numAutreJoueur + 1) + " " + autreJoueurs.get(numAutreJoueur).getNom() + " | PV = " + autreJoueurs.get(numAutreJoueur).getPointsDeVie());
				}
				System.out.println("\nLes joueur(s) mort(s) : ");
				if (lesJoueursMorts.size() > 0) {
					for(int numJoueurMorts = 0; numJoueurMorts < lesJoueursMorts.size(); numJoueurMorts++){
						System.out.println((numJoueurMorts + 1) + " " + lesJoueursMorts.get(numJoueurMorts).getNom());
					}
				}else {
					System.out.println("Aucun joueur n'est mort..");
				}
				
				boolean saisieOk = true;
				
				do{
					choixVictime = scan.nextInt();
					
					if(choixVictime > 0 && choixVictime < (autreJoueurs.size() + 1)) {
						saisieOk = false;
					}else {
						System.out.println("ERREUR : Choisissez une victime existante !");
					}
					
				}while(saisieOk);	
				
				autreJoueurs.get(choixVictime-1).recevoirAttaque(lesJoueurs.get(numJoueurEnAction).lancerAttaque());
				
				if(autreJoueurs.get(choixVictime - 1).getPointsDeVie() == 0) {
					enterrerJoueur(lesJoueurs, lesJoueursMorts, autreJoueurs, (choixVictime - 1));
				}
			}		
		}
		scan.close();
		System.out.println(afficheClassement(lesJoueurs, lesJoueursMorts));
		System.out.println("La partie est fini !");
	}
	
	public boolean continueDePartie() {
		int compteurSurvivants = this.lesJoueurs.size();
		for(int x = 0 ; x < this.lesJoueurs.size(); x ++){
			if(this.lesJoueurs.get(x).getPointsDeVie() <= 0){
				compteurSurvivants--;
			}
		}
		if(compteurSurvivants < 2) {
			return false;
		}
	return true;
	}
	
	public void enterrerJoueur(ArrayList<Personnage> lesJoueurs, ArrayList<Personnage> lesMorts, ArrayList<Personnage> lesAutresJoueurs, int idJoueurMort) {
		lesMorts.add(lesAutresJoueurs.get(idJoueurMort));
		lesJoueurs.remove(lesAutresJoueurs.get(idJoueurMort));

	}
	
	public String afficheClassement(ArrayList<Personnage> lesJoueurs, ArrayList<Personnage> lesMorts) {
		String classement = "Le n°1 est : " + lesJoueurs.get(0).getNom() + ".\n";
		
		int numClassement = 2;
		for(int unIdJoueurMort = lesMorts.size(); unIdJoueurMort > 0; unIdJoueurMort-- ) {		
			classement += "Le n°" + (numClassement) + " est : " + lesMorts.get(unIdJoueurMort - 1).getNom() + ".\n";
			numClassement++;
		}
		return classement;
	}
	

}
