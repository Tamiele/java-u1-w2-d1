package esercizio3;

public class MainContoCorrente {
    public static void main(String[] args) {

        ContoCorrente contoUno = new ContoCorrente("Mario", 50);
        contoUno.preleva(60);
        System.out.println(contoUno.restituisciSaldo());
    }
}
