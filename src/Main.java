import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Titular do cartão: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o Saldo da conta: ");
        double saldo = scanner.nextDouble();

        System.out.println("Digite o numero do cartão: ");
        int numeroCartao = scanner.nextInt();

        System.out.println("Digite a renda Mensal: ");
        double rendaMensal = scanner.nextDouble();
        
        Cartao conta = new Cartao(nome, saldo, numeroCartao, rendaMensal);


        conta.mostrarInfo();

        System.out.println("""
                *********************************
                1- Sacar dinheiro

                2- Comprar itens

                3- Depositar dinheiro

                4- Pagar Fatura

                5- Checar valor da Fatura
                *********************************
                """);


                int decisao = scanner.nextInt();

                switch (decisao) {
                    case 1:
                        System.out.println("Digite o valor que deseja sacar: ");
                        conta.sacar(scanner.nextDouble());
                        break;
                      
                    case 2:
                        System.out.println("""
                                Sapato: 300 reais

                                camisa: 420

                                computador: 2500
                                """);

                        break;

                    case 3:
                    System.out.println("Digite o valor do deposito: ");
                        conta.depositar(scanner.nextDouble());
                        break;

                    case 4:
                        
                        break;

                    case 5:
                        
                        break;
                
                    default:
                        break;
                }
        }
    }
