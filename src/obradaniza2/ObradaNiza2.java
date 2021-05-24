package obradaniza2;

/**
 *
 * @author: Dejan Smiljić; e-mail: dej4n.s@gmail.com
 *
 */

/* Kod predstavlja doradu assignment-a: 
        "Koriscenje naredbi za kontrolu toka u obradi niza."
   Modul 04 : Kontrola toka, petlje i grananje
   Kurs: Core Java Programming
   IT Akademija 2019.
   Dorade su naznacene i opisane u sklopu komentara unutar koda.
 */

 /*   Zadatak:
       
       "Dat je sledeći niz: int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87}.
        
        Potrebno je napraviti dva niza, jedan za smeštanje pozitivnih, a drugi za smeštanje negativnih 
        elemenata niza array i potrebnu logiku koja će obaviti izvlačenje odgovarajućih elemenata u 
        odgovarajući niz. Elemente jednake nuli ne treba ubacivati u rezultujuće nizove.
        Drugim rečima, potrebno je iz niza array, koji je dat, izvući sve pozitivne elemente i smestiti u
        zaseban niz i izvući sve negativne elemente i smestiti u zaseban niz.
        Takođe je potrebno odrediti i broj duplikata u nizu array. U tom slučaju, treba brojati i 
        elemente koji su jednaki nuli. Pri tome, ne treba ispisivati koliko puta se ponavlja svaki 
        element niza, već prebrojati i ispisati samo one elelemente koji se ponavljaju i koliko puta.
        Naravno, potrebno je da napisana funkcionalnost bude primenljiva na bilo koji 
        niz celobrojnih vrednosti, ne samo na ovaj konkretan primer."
 */
import java.util.Arrays;// Program koristi metod "toString"

public class ObradaNiza2 {

    public static void main(String[] args) {

        int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};

        int pozitivan = 0;// Vrijednost varijable odredjuje velicinu niza pozitivnih brojeva
        int negativan = 0;// Vrijednost varijable odredjuje velicinu niza negativnih brojeva
        /* Nakon dorade zadatka, ove dvije varijable ce se koristiti kao indeks elementa niza pozitivnih
           i niza negativnih brojeva pri njihovom popunjavanju odgovarajucim vrijednostima. */

        int duplikat = 0;
        int brojDuplikata = 0;
        int brojPonavljanja = 0;

        System.out.print("\nDat je niz brojeva:\n\n\t");
        System.out.print(Arrays.toString(array));
        System.out.println("\n");

        for (int i = 0; i < array.length; i++)//Odredjivanje velicine nizova...
        {
            if (array[i] > 0) {
                pozitivan += 1;
            } else // *DORADA: if i else/if umjesto 2 if uslovna izraza
            if (array[i] < 0) {
                negativan++;
            }

        }

        int[] arrayPozitivnih = new int[pozitivan]; // Deklaracija niza pozitivnih brojeva
        int[] arrayNegativnih = new int[negativan];// Deklaracija niza negativnih brojeva

        pozitivan = 0;// Resetovanje vrijednosti varijabli...
        negativan = 0;// ... Koriste se kao indeks elementa niza pozitivnih tj. niza negativnih brojeva.

        /*  **DORADA: Kopiranje pozitivnih i negativnih brojeva iz datog niza u odgovarajuce nizove
                      se vrsi u jednoj FOR petlji. Prethodno se vrsilo kroz dvije posebne FOR petlje.*/
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                arrayPozitivnih[pozitivan++] = array[i];
            } else if (array[i] < 0) {
                arrayNegativnih[negativan++] = array[i];
            }

        }

        if (pozitivan > 0) {
            System.out.print("\nSvi pozitivni brojevi koje sadrzi dati niz:\n\n\t");
            System.out.println(Arrays.toString(arrayPozitivnih));
        } else {
            System.out.println("\nDati niz ne sadrzi pozitivne brojeve.");
        }

        if (negativan > 0) {
            System.out.print("\n\nSvi negativni brojevi koje sadrzi dati niz:\n\n\t");
            System.out.println(Arrays.toString(arrayNegativnih));
        } else {
            System.out.println("\nDati niz ne sadrzi negativne brojeve.");
        }
        // sledeca petlja trazi vrijednosti koje se ponavljaju u nizu
        boolean vecPostoji = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (i == 0) {
                        brojDuplikata++;
                        break;
                    }
                    if (i > 0) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (array[i] == array[k]) {
                                vecPostoji = true;
                                break;
                            } else {
                                vecPostoji = false;
                            }
                        }
                        if (vecPostoji == false) {
                            brojDuplikata++;
                            break;
                        } else {
                            break;
                        }
                    }

                }

            }
        }

        System.out.printf("\n\nBroj duplikata u datom nizu: %d\n", brojDuplikata);

        System.out.print("Brojevi koji se ponavljaju su: ");

        // Sledeca petlja ispisuje na izlaz vrijednosti koje se ponavljaju
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    brojPonavljanja++;
                }
            }

            if (brojPonavljanja == 1) {
                System.out.printf("%d, ", array[i]);
            }

            brojPonavljanja = 0;
        }

        System.out.println();

        // Sledeca petlja ispisuje na izlaz broj-duplikat i koliko puta se taj broj ponavlja u nizu
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (i == 0) {
                        duplikat = array[i];
                        brojPonavljanja++;

                    }
                    if (i > 0) {

                        for (int k = i - 1; k >= 0; k--) {
                            if (array[i] == array[k]) {
                                vecPostoji = true;
                                break;
                            } else {
                                vecPostoji = false;
                            }
                        }
                        if (vecPostoji == false) {
                            duplikat = array[i];
                            brojPonavljanja++;

                        } else {
                            break;
                        }
                    }

                }
            }

            if (brojPonavljanja >= 1) {
                System.out.printf("\nBroj %d se ponavlja %d puta", duplikat, brojPonavljanja);
            }

            brojPonavljanja = 0;
        }

        System.out.println("\n\n...");
    }

}
