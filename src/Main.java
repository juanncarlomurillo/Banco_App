public class Main {
    public static void main(String[] args) {
        try {
            BancoApp cuenta1 = new BancoApp(500);
            BancoApp cuenta2 = new BancoApp(300);

            cuenta1.depositar(200);
            cuenta1.retirar(100);
            cuenta1.transferir(cuenta2, 200);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class BancoApp {
    private double saldo;

    public BancoApp(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.saldo = saldoInicial;
    }

    public void retirar(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo actual: " + saldo);
    }

    public void depositar(double monto) throws IllegalArgumentException {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto a depositar no puede ser negativo.");
        }
        saldo += monto;
        System.out.println("Depósito exitoso. Saldo actual: " + saldo);
    }

    public void transferir(BancoApp otraCuenta, double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Saldo insuficiente para realizar la transferencia.");
        }
        retirar(monto);
        otraCuenta.depositar(monto);
        System.out.println("Transferencia exitosa.");
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.