
public class ex4Array {
	
	// POINT D'ENTRÉE DU PROGRAMME 
	public static void main(String[] args) {
		System.out.println("=== Exercice 4 : Les Tableaux ===");
		
		System.out.println("=== Bloc 1 : Test des calculs ===");
		double[] testNotes = {10, 15, 8, 12, 5.75};
		
		System.out.println(findMin(testNotes));
		System.out.println(findMax(testNotes));
		System.out.print(calculateAverage(testNotes));
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

}
