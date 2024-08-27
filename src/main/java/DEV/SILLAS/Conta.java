package DEV.SILLAS;

import utilitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas +=1;


    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toSTRING() {
        return "\nsaldo: " +
                "\nnumero da conta: " + this.getNumeroConta() +
                "\nnome: " + this.pessoa.getNome()+
                "\ncpf: " + this.pessoa.getCpf() +
                "\nemail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }
    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            //this.saldo = this.getSaldo() + valor;
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }
    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }
    public void transferencia(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            //this.saldo = this.getSaldo() - valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência");
        }

    }

}

