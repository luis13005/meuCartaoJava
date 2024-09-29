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
        List compraList = new ArrayList<Extrato>();
        

        Cartao conta = new Cartao(nome, saldo, numeroCartao, rendaMensal);


            int decisao = 0;

                while (decisao != 6) {
                                System.out.println("""
                            *********************************
                            1- Sacar dinheiro

                            2- Comprar itens

                            3- Depositar dinheiro

                            4- Pagar Fatura

                            5- Checar valor da Fatura

                            6- Encerrar
                            *********************************
                            """);
                    decisao = scanner.nextInt();
                    switch (decisao) {
                        case 1:
                            System.out.println("Digite o valor que deseja sacar: ");
                            double saque = scanner.nextDouble();

                            conta.sacarPagar(saque);

                            Extrato extrato = new Extrato("Saque",saque);
                            System.out.println("Termina de criar o EXTRATO OBJETO");
                            conta.inserirExtrato(extrato);
                            System.out.println("Começa a mostrar o Extrato");
                            conta.mostrarExtrato();
                            System.out.println(conta.toString()); 
                            break;
                          
                        case 2:
                            System.out.println("Qual o produto: ");
                            String produto = scanner.next();

                            System.out.println("Digite o valor: ");
                            double preco = scanner.nextDouble();
                            System.out.println("Digite a forma de pagamento \n 1- Credito \n 2- Debito");
                            int opcao = scanner.nextInt();
                            if (opcao == 1) {
                                conta.credito(preco);
                            }else if (opcao == 2) {
                                conta.sacarPagar(preco);
                            }else{
                                System.out.println("Opção inválida");
                            }
                            Extrato compra = new Extrato(produto, preco);
                            conta.inserirExtrato(compra);
                            conta.mostrarExtrato();
                            System.out.println(conta.toString()); 
                            break;
    
                        case 3:
                        System.out.println("Digite o valor do deposito: ");
                            conta.depositar(scanner.nextDouble());
                            System.out.println(conta.toString());
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
    }
