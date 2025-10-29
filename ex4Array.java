import java.util.Scanner;
import java.util.Arrays;

public class ex4Array {
	
	// POINT D'ENTRÉE DU PROGRAMME 
	public static void main(String[] args) {
		System.out.println("=== Exercice 4 : Les Tableaux ===");
		
		System.out.println("=== Bloc 1 : Test des calculs ===");
		double[] testNotes = {10, 15, 8, 12, 5.75};
		
		System.out.println(findMin(testNotes));
		System.out.println(findMax(testNotes));
		System.out.print(calculateAverage(testNotes));
		inputStudents();
		}
	
	// Calcule la moyenne d'un tableau de notes
	static double calculateAverage(double[] notes) {
        if (notes == null || notes.length == 0) return 0;
        double sum = 0;
        for (double n : notes) sum += n;
        return sum / notes.length;
    }
	
	// Retourne la note la plus petite
	static double findMin(double[] notes) {
		if(notes == null || notes.length == 0) return 0;
		double min = notes[0];
		for(double n : notes) if(n < min) min = n;
		return min;
	}
	
	// Retourne la note la plus grande
	static double findMax(double[] notes) {
		if(notes == null || notes.length == 0)return 0;
		double max = notes[0];
		for(double n : notes) if(n > max) max = n;
		return max;
	}

	static void inputStudents() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n Combien d'élèves souhaitez-vous saisir ? ");
		int nomberStud = scan.nextInt();
		scan.nextLine(); //pour vider Le buffer
		
		String[] lastNames = new String[nomberStud];
		String[] firstNames = new String[nomberStud];
		double[][] studentsNotes = new double[nomberStud][];
		
		for (int i = 0; i < nomberStud; i++) {
			System.out.println("--Eleve" + ( i + 1 ) + "---");
			System.out.print("Nom : ");
			lastNames[i] = scan.nextLine();
			System.out.print("Prenom : ");
			firstNames[i] = scan.nextLine();
			
			System.out.print("Combien de notes pour cet élève ? ");
			int nbNotes = scan.nextInt();
			double[ ] notes = new double[nbNotes];
			
			for (int j = 0; j < nbNotes; j++) {
	            System.out.print("Note " + (j + 1) + " : ");
	            notes[j] = scan.nextDouble();
	        }
			scan.nextLine(); // vider buffer
			studentsNotes[i] = notes; // les notes entrer par l'utilisateur/éléve
		}
		
		System.out.println("\n=== Récapitulatif ===");
		for (int i = 0; i < nomberStud; i++) {
			double average = calculateAverage(studentsNotes[i]);
			System.out.printf("%s %s - Moyenne : %.2f\n", firstNames[i], lastNames[i], average);
		}
		sortAndDisplayFirstNames(firstNames);
		
		System.out.print("\nRechercher un élève par nom : ");
		String searchStud = scan.nextLine();
		
		boolean found = false;
		
		for ( int i = 0; i < nomberStud; i++) {
			if (lastNames[i].equalsIgnoreCase(searchStud)) { // equalsIgnoreCase()méthode compare deux chaînes, en ignorant les différences entre les minuscules et les majuscules
				found = true;
				System.out.println("\nÉlève trouvé : " + firstNames[i] + " " + lastNames[i]);
				System.out.print("Notes : ");
				
				System.out.printf("\nMoyenne : %.2f\n", calculateAverage(studentsNotes[i]));
			}
		}
		if (!found) {
		    System.out.println("Aucun élève trouvé avec ce nom.");
		}	
		
		scan.close();
	}
	static void sortAndDisplayFirstNames(String[] firstNames) {
		System.out.println("\n--- Tri des prénoms ---");
		
		String[] copy = Arrays.copyOf(firstNames, firstNames.length);
	    Arrays.sort(copy);
	    
	    System.out.println("Ordre croissant :");
	    for (String lastName : copy) System.out.print(lastName + " ");
	    System.out.println();

	    System.out.println("Ordre décroissant :");
	    for (int i = copy.length - 1; i >= 0; i--) System.out.print(copy[i] + " ");
	    System.out.println();

	}

}
