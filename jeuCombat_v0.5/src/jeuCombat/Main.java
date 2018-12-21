package jeuCombat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****************************************\n"
						 + "* FIGHT SIMULATOR TURBO 7 FATAL EDITION *\n"
						 + "*****************************************\n");
		
		
		System.out.println("                    *\n"
						 + "                   * *\n"
						 + "                  *   *\n"
						 + "                 *  |  *\n"
						 + "                *   |   *\n"
						 + "               *    |    *\n"
						 + "              *           *\n"
						 + "             *      @      *\n"
						 + "            *               *\n"
						 + "           * * * * * * * * * *\n"
						 + "   Jeu en cours de développement v.0.5"
						 + "\n\n");
		
		System.out.print("Indiquez le nombre de joueur : ");
		
		int nbJoueurs = scan.nextInt();
		
		ArrayList<Personnage> lesJoueurs = new ArrayList<>();
		
		
		AreneDeCombat arene;
		
		
		
		for(int i = 0; i < nbJoueurs; i++) {
			System.out.println("Joueur N°" + (i+1));
			System.out.println("Choisissez un nom pour votre combattant");
			String nomCombattant = scan.next();
			do{
				System.out.println("Choisissez la classe de " + nomCombattant + "\n"
						+ "1 : Guerrier \n"
						+ "2 : Assassin \n"
						+ "3 : Mage");
				int choixType = scan.nextInt();
				
				switch(choixType) {
					case 1 : 
						lesJoueurs.add(new Guerrier(nomCombattant));
						break;
						
					case 2 : 
						lesJoueurs.add(new Assassin(nomCombattant));
						break;
						
					case 3 : 
						lesJoueurs.add(new Mage(nomCombattant));
						break;
					default :
						System.out.println("Choix incorrect");
						break;
				}
			}while(lesJoueurs.size() <= i);
		}
		arene = new AreneDeCombat(lesJoueurs);
		arene.debutPartie();
		scan.close();
	}
}
