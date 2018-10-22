/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancariaconsemaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author sportak
 */
public class CuentaBancaria {

    private String titular;
    private Double saldo;
    private int semaforo=1;

    

    public CuentaBancaria(String titular, Double saldo) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		
	}
    public CuentaBancaria() {}

	public void ingresar(Double pasta) {
		sendWait();
        
        double actual = this.getSaldo();
        this.setSaldo(actual + pasta);
        
        sendSignal();
    }

    public void sacar(Double pasta) {
    	sendWait();
        
        double actual = this.getSaldo();
        this.setSaldo(actual - pasta);
        
        sendSignal();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(int semaforo) {
		this.semaforo = semaforo;
	}
	
	public void sendWait() {
		while(this.getSemaforo()<=0) {
			System.out.println(".");
		}
		this.setSemaforo(0);
	}
	
	public void sendSignal() {
		this.setSemaforo(1);
		
	}
	
	@Override
    public String toString() {
        return "CuentaBacaria{" + "titular=" + titular + ", saldo=" + saldo + '}';
    }

}
