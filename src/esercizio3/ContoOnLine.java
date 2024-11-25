package esercizio3;

import esercizio2.ConsumiAuto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ContoOnLine extends ContoCorrente {
    private static double maxPrelievo;

    private final static Logger LOGGER = LoggerFactory.getLogger(ContoOnLine.class);

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + getTitolare() +
                " - Saldo: " + restituisciSaldo() +
                " - Num movimenti: " + getnMovimenti() +
                " - Massimo movimenti: " + getMaxMovimenti() +
                " - Massimo prelievo possibile: " + maxPrelievo);
    }

    public void preleva(double x) {

        try {
            verificaSaldo(x);
            super.preleva(x);


        } catch (BancaException e) {
            LOGGER.error(e.getMessage());
            System.out.println("Errore: " + e.getMessage());
        }


    }


    private static void verificaSaldo(double saldo) {
        if (saldo > maxPrelievo) {
            throw new BancaException("Prelievo non disponibile");
        }

    }

}
