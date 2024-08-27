package DEV.SILLAS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------- bem vindos a nossa agencia --------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("*************selecione uma operacao que deseja realizar*************");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("     opcao 1 - criar conta  ");
        System.out.println("     opcao 2 - depositar    ");
        System.out.println("     opcao 3 - sacar");
        System.out.println("     opcao 4 - transferir");
        System.out.println("     opcao 5 - listar");
        System.out.println("     opcao 6 - sair");

        int operacao = input.nextInt();

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarcontas();
                break;
            case 6:
                System.out.println("flw e nois, obrigado por usar nossa agencia");
                System.exit(0);

            default:
                System.out.println("opcao invalida");
                operacoes();
                break;
        }
    }

    public static void criarConta(){
        System.out.println("\nnome: ");
        String nome = input.next();

        System.out.println("\ncpf: ");
        String cpf = input.next();

        System.out.println("\nemail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("sua conta doi criada com sucesso");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("NUMERO DA CONTA ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("qual o valor que deseja depositar? ");
            double valordeposito = input.nextDouble();
            conta.depositar(valordeposito);
            System.out.println("valor depositado com sucesso!");
        }else {
            System.out.println("conta nao foi encontrada!");
        }
        operacoes();
    }

    public static void sacar(){
        System.out.println("NUMERO DA CONTA ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("qual o valor que deseja sacar? ");
            double valorsaque = input.nextDouble();
            conta.sacar(valorsaque);
            // System.out.println("valor sacado com sucesso!");
        }else {
            System.out.println("conta nao foi encontrada!");
        }
        operacoes();
    }

    public static void transferir(){
        System.out.println("NUMERO DA CONTA DO REMETENTE ");
        int numerocontaremetente = input.nextInt();

        Conta contaremetente = encontrarConta(numerocontaremetente);

        if(contaremetente != null) {
            System.out.println("numero da conta do destinatario ");
            int numerocontadestinatario = input.nextInt();

            Conta contadestinatario = encontrarConta(numerocontadestinatario);

            if(contadestinatario != null) {
                System.out.println("valor da transferencia: ");
                double valor = input.nextDouble();

                contaremetente.transferencia(contadestinatario, valor);
            }else{
                System.out.println("a conta para deposito nao foi encontrada");
            }
        }else{
            System.out.println("conta para transferencia nao encontrada");
        }
        operacoes();
    }

    public static void listarcontas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("nao ha contas cadastradas");
        }
        operacoes();
    }
}
