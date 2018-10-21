/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariaconsemaforo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class CajeroBanco extends Thread {

    private CuentaBancaria cuenta;
    private String nombreCajero;

    public CajeroBanco(CuentaBancaria cuenta, String nombreCajero) {
        this.cuenta = cuenta;
        this.setName(nombreCajero);

    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    @Override
    public String toString() {
        return "CajeroBanco{" + "cuenta=" + cuenta + ", nombreCajero=" + nombreCajero + '}';
    }

    @Override
    public void run() {
        System.out.println(this.cuenta.getSemaforo());
        if (this.cuenta.getSemaforo() > 0) {
            if (this.getName().equalsIgnoreCase("Bankia")) {

                this.cuenta.setSemaforo(this.cuenta.getSemaforo() - 1);

                System.out.println("BANKIA  INGRESA 200 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.ingresar(200.0);
                System.out.println("RESULTADO INGRESO DE 200 " + this.cuenta.getSaldo());
                System.out.println("BANKIA  SACA 100 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.sacar(100.0);
                System.out.println("RESULTADO SACADA DE 100 " + this.cuenta.getSaldo());
                this.cuenta.setSemaforo(this.cuenta.getSemaforo() + 1);

            } else if (this.getName().equalsIgnoreCase("CajaMadrid")) {

                this.cuenta.setSemaforo(this.cuenta.getSemaforo() - 1);

                System.out.println("CAJA MADRID INGRESA 500 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.ingresar(500.0);
                System.out.println("RESULTADO INGRESO DE 500 " + this.cuenta.getSaldo());
                System.out.println("CAJA MADRID SACA 200 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.sacar(200.0);
                System.out.println("RESULTADO SACADA DE 200 " + this.cuenta.getSaldo());
                this.cuenta.setSemaforo(this.cuenta.getSemaforo() + 1);

            } else if (this.getName().equalsIgnoreCase("Bancaja")) {

                this.cuenta.setSemaforo(this.cuenta.getSemaforo() - 1);

                System.out.println("BANCAJA  INGRESA 100 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.ingresar(100.0);
                System.out.println("RESULTADO INGRESO DE 100 " + this.cuenta.getSaldo());
                System.out.println("BANCAJA  SACA 800 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.sacar(800.0);
                System.out.println("RESULTADO SACADA DE 200 " + this.cuenta.getSaldo());
                this.cuenta.setSemaforo(this.cuenta.getSemaforo() + 1);

            }

        }else{
            try {
                this.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CajeroBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
