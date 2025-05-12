class BancaException extends Exception {
    public BancaException(String message) {
        super(message);
    }
}

class ContoCorrente {
    protected String titolare;
    protected int nMovimenti;
    protected final int maxMovimenti = 50;
    protected double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if (nMovimenti >= maxMovimenti) {
            saldo -= 0.50;
        }
        saldo -= x;
        nMovimenti++;

        if (saldo < 0) {
            throw new BancaException("Il conto è in rosso.");
        }
    }

    public double restituisciSaldo() {
        return saldo;
    }
}
