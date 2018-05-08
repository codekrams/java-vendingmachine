
package getraenkeautomat;
import java.util.Scanner;

public class Getraenkeautomat {
    public static void main(String[] args) {
        Scanner usereingabe = new Scanner(System.in);
        System.out.println("In diesem Getränkeautomaten ist Platz für 5 Getränkesorten.");
        String [] getraenke = new String [5];
        double [] preise = new double [5];
        double [] wechselgeld = {0.05, 0.10,0.20,0.50,1.00,2.00};
        
        for (int i=0; i<5; i++){
            System.out.println("Bitte nenne die " + (i+1) + " Getraenkemarke:");
            String dose = usereingabe.next();                        
            getraenke[i]=dose;

            System.out.println("Wie teuer ist eine Dose?");
            double dosenpreis = usereingabe.nextDouble();
            preise[i]=dosenpreis;
        }
        System.out.println("Vielen Dank, der Automat wechselt jetzt in den Betriebsmodus.");
        System.out.println("Willkommen, die folgenden Getränke stehen zur Auswahl:");
        
        for(int j=0; j<5;j++){
            System.out.print("Auswahl "+ (j+1) + ": " + getraenke[j] + " " + preise[j] + " Euro");
            System.out.println();
        }
        System.out.println("Bitte wählen Sie das gewünschte Getränk mithilfe der Auswahlnummer aus:");
        int auswahl = usereingabe.nextInt();
        
        System.out.println("Sie haben " + getraenke[(auswahl-1)] + " ausgewählt.");
        System.out.println("Bitte werfen Sie " + preise[(auswahl-1)] + " Euro ein.");
        System.out.println("Der Automat nimmt nur die folgenden Münzen an(in Euro): 0,05-0,10-0,20-0,50-1,00-2,00");
        
        double betrag = preise[(auswahl-1)];
        double summe = 0;
        
        
        do {
            System.out.println("Bitte werfen Sie eine Münze ein: ");
            double einwurf = usereingabe.nextDouble();
            if (einwurf>2.00 || einwurf ==0 ) {
            System.out.println("Bitte überprüfen Sie ihre Münzen. Der Automat nimmt nur die genannten Münzen an.");
                    }
                for (int k=0; k<wechselgeld.length; k++){
                if (wechselgeld[k] == einwurf) {
                summe = summe +einwurf;
                    }
                
                }
        } while (summe<betrag);
        
        double wgeld = summe-(preise[(auswahl-1)]);
        System.out.println("Bitte entnehmen Sie ihre Dose " + getraenke[(auswahl-1)] + " und ihr Wechselgeld in Höhe von " + wgeld + " Euro.");
    }
}
