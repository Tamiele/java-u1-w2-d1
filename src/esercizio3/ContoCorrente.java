package esercizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(ContoCorrente.class);

    public String getTitolare() {
        return titolare;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }

    public double restituisciSaldo() {
        return saldo;
    }

    public int getMaxMovimenti() {
        return maxMovimenti;
    }

    public void preleva(double x) {
        try {
            if (nMovimenti < maxMovimenti)
                saldo = saldo - x;
            else
                saldo = saldo - x - 0.50;
            verificaSaldo(saldo);
            nMovimenti++;

        } catch (BancaException e) {
            LOGGER.error(e.getMessage());
            System.out.println("Errore: " + e.getMessage());

        }
    }

    private static void verificaSaldo(double saldo) {
        if (saldo <= 0) {
            throw new BancaException("Conto in rosso");
        }

    }


}
