public class Mutantes {
    public static void main(String[] args) {
        buscarMutante(); // Llamada a subprograma
    }

    // caracteres validos A,T,C,G
    public static void buscarMutante() {
        String[] dna = { // Es mutante
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        String[] dna2 = { // No es mutante
                "AGCTAA",
                "CTAGAG",
                "GTAGGT",
                "TGGGAT",
                "TCCCTA",
                "CGCGCG"
        };
        String[] dna3 = { // No es mutante, no tiene cadenas de adn validas (controlar con excepcion?)
                "BBBHJI",
                "aaaccc",
                "TATGCC",
                "CCCTAA",
                "GGGTAA",
                "AAATCC"
        };
        String[] dna4 = { // Es mutante
                "AAtAAA",
                "CCAAGA",
                "GAAaCA",
                "AGAAAG",
                "CCCCTA",
                "TCACTG"
        };
        String[] dna5 = { // Es mutante(Mismo que dna pero con minusculas)
                "ATgCGA",
                "CAGTGC",
                "TtATGT",
                "AGaaGG",
                "CcCcTA",
                "TCACTG"
        };
        String[] dna6 = { // Mutante (diagonal paralela a la principal; mirar A)
                "GACTCG",
                "CGAGCT",
                "GCTATC",
                "TCGGAT",
                "GTTTTA",
                "AATAGC"
        };
        String[] dna7 = { // Mutante (por la diag inversa; mirar la c penultima columna)
                "GACTCG",
                "CGAcCT",
                "GCCATC",
                "TCGGAT",
                "GCTTTA",
                "AATAGC"
        };

        msj(dna, 1); // Es mutante
        msj(dna2, 2); // No es mutante
        msj(dna3, 3); // No es mutante, no tiene cadenas de adn validas
        msj(dna4, 4); // Es mutante
        msj(dna5, 5); // Es mutante(Mismo que dna pero con minusculas)
        msj(dna6, 6); // Es mutante
        msj(dna7, 7); // Es mutante
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
        int count = 0; // Contador de secuencias mutantes
        dna = convertirMayusc(dna);

        // Verificar horizontal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    count++;
                }
            }
        }

        // Verificar vertical
        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < n; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    count++;
                }
            }
        }

        // Verificar diagonales principales
        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    count++;
                }
            }
        }

        // Verificar diagonales inversa
        for (int i = 0; i < n - 3; i++) {
            for (int j = n - 1; j >= 3; j--) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j - 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                    count++;
                }
            }
        }
        // Si se encuentran al menos dos secuencias mutantes, retorna true
        return count >= 2;
    }

    public static void msj(String[] dna, int i) {
        System.out.print(i + ": ");
        if (isMutant(dna)) {
            System.out.println("Encontre un mutancito");
        } else {
            System.out.println("No es mutante :c");
        }
    }

    public static String[] convertirMayusc(String[] dna) {
        String[] dnaMayusc = new String[dna.length];

        for (int i = 0; i < dna.length; i++) {
            StringBuilder fMayusc = new StringBuilder();
            for (int j = 0; j < dna.length; j++) {
                char caracter = dna[i].charAt(j);
                char charMayusc = Character.toUpperCase(caracter);
                fMayusc.append(charMayusc);
            }
            dnaMayusc[i] = fMayusc.toString();
        }
        return dnaMayusc;
    }
}