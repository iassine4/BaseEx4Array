import java.util.Scanner;


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
		
		System.out.print("Combien d'élèves souhaitez-vous saisir ? ");
		int nomber = scan.nextInt();
		scan.nextLine(); //pour vider Le buffer
		
		String[] lastNames = new String[nomber];
		String[] firstNames = new String[nomber];
		double[][] studentsNotes = new double[nomber][];
		
		for (int i = 0; i < nomber; i++) {
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
		for (int i = 0; i < nomber; i++) {
			double average = calculateAverage(studentsNotes[i]);
			System.out.printf("%s %s - Moyenne : %.2f\n", firstNames[i], lastNames[i], average);
		}
		
		scan.close();
	}
}
