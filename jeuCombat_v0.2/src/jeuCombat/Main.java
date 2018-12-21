package jeuCombat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Personnage[] lesJoueurs = {null,null};
		AreneDeCombat arene;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++) {
			System.out.println("Joueur N°" + (i+1));
			System.out.println("Choisissez un nom pour votre combattant");
			String nomCombattant = scan.next();
			while(lesJoueurs[i] == null) {
				System.out.println("Choisissez la classe de " + nomCombattant + "\n"
						+ "1 : Guerrier \n"
						+ "2 : Assassin \n"
						+ "3 : Mage");
				int choixType = scan.nextInt();
				
				switch(choixType) {
					case 1 : 
						lesJoueurs[i] = new Guerrier(nomCombattant);
						break;
						
					case 2 : 
						lesJoueurs[i] = new Assassin(nomCombattant);
						break;
						
					case 3 : 
						lesJoueurs[i] = new Mage(nomCombattant);
						break;
					default :
						System.out.println("Choix incorrect");
						break;
				}
			}
			//System.out.println(lesJoueurs[i].toString());
		}
		arene = new AreneDeCombat(lesJoueurs);
		arene.debutPartie();
	}
}
