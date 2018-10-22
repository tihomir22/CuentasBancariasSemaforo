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

     
            if (this.getName().equalsIgnoreCase("Bankia")) {
            	
            	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("BANKIA  INGRESA 200 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
				this.cuenta.ingresar(200.0);
                System.out.println("RESULTADO INGRESO DE 200 " + this.cuenta.getSaldo());
                System.out.println("BANKIA  SACA 100 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
				this.cuenta.sacar(100.0);
                System.out.println("RESULTADO SACADA DE 100 " + this.cuenta.getSaldo());
           

            } else if (this.getName().equalsIgnoreCase("CajaMadrid")) {
            	
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("CAJA MADRID INGRESA 500 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
				this.cuenta.ingresar(500.0);
                System.out.println("RESULTADO INGRESO DE 500 " + this.cuenta.getSaldo());
                System.out.println("CAJA MADRID SACA 200 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
				this.cuenta.sacar(200.0);			
                System.out.println("RESULTADO SACADA DE 200 " + this.cuenta.getSaldo());
              

            } else if (this.getName().equalsIgnoreCase("Bancaja")) {
            
            	try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("BANCAJA  INGRESA 100 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
                this.cuenta.ingresar(100.0);
                System.out.println("RESULTADO INGRESO DE 100 " + this.cuenta.getSaldo());
                System.out.println("BANCAJA  SACA 800 A " + this.cuenta.getTitular() + "CON SALDO " + this.cuenta.getSaldo());
				this.cuenta.sacar(800.0);
                System.out.println("RESULTADO SACADA DE 200 " + this.cuenta.getSaldo());
              
            }

        
    }

}
