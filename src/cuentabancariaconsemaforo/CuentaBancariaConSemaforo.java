/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariaconsemaforo;

/**
 *
 * @author sportak
 */
public class CuentaBancariaConSemaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb = new CuentaBancaria("Tihomir Stoychev", 5000.00);

        CajeroBanco cba = new CajeroBanco(cb, "Bankia");
        CajeroBanco cba2 = new CajeroBanco(cb, "Bancaja");
        CajeroBanco cba3 = new CajeroBanco(cb, "CajaMadrid");

        cba.start();
        cba.join();
        cba2.start();
        cba2.join();
        cba3.start();
        cba3.join();

    }

}
