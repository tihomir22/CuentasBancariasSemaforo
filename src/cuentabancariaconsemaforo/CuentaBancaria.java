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
public class CuentaBancaria {

    private String titular;
    private Double saldo;
    private int semaforo;

    public CuentaBancaria(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.semaforo=1;
    }

    public void ingresar(Double pasta) {
        double actual = this.getSaldo();
        this.setSaldo(actual + pasta);
    }

    public void sacar(Double pasta) {
        double actual = this.getSaldo();
        this.setSaldo(actual - pasta);
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
    

    @Override
    public String toString() {
        return "CuentaBacaria{" + "titular=" + titular + ", saldo=" + saldo + '}';
    }

}
