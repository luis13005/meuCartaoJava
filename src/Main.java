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
        
        boolean erro = false;

        Cartao conta = new Cartao(nome, saldo, numeroCartao, rendaMensal);


            int decisao = 0;

                while (decisao != 7) {
                                System.out.println("""

                            *********************************
                            1- Sacar dinheiro

                            2- Comprar itens

                            3- Depositar dinheiro

                            4- Checar valor da Fatura

                            5- Pagar Fatura

                            6- Extrato

                            7- Encerrar
                            *********************************
                            """);
                    decisao = scanner.nextInt();
                    switch (decisao) {
                        case 1:
                            System.out.println("Digite o valor que deseja sacar: ");
                            double saque = scanner.nextDouble();

                            
                            
                            erro = conta.sacar(saque,erro);

                            if (erro==false) {
                                // conta
                                System.out.println(conta.toString()); 
                            }else{
                                System.out.println("Saque falhou");
                            }
                          
                            break;
                          
                        case 2:
                            System.out.println("Qual o produto: ");
                            
                            String produto = "";
                            while(produto.isEmpty()){
                                produto = scanner.nextLine();
                            }

                            System.out.println("Digite o valor: ");
                            double preco = scanner.nextDouble();
                           

                            System.out.println("Digite a forma de pagamento \n 1- Credito \n 2- Debito");
                            int opcao = scanner.nextInt();

                            
                            if (opcao == 1) {
                                conta.credito(preco);
                            }else if (opcao == 2) {
                                
                                erro = conta.compra(preco,erro);
                            }else{
                                System.out.println("Opção inválida");
                            }

                            if (erro==false) {
                                System.out.println(conta.toString()); 
                            }else{
                                System.out.println("Compra falhou");
                            }
        
                            break;
    
                        case 3:
                        System.out.println("Digite o valor do deposito: ");
                            conta.depositar(scanner.nextDouble());
                            System.out.println(conta.toString());
                            break;
    
                        case 4:
                            System.out.println(conta.getFatura()); 
                            break;

                            case 5:
                        System.out.printf("%.2f R$ Deseja pagar a fatura?\n 1-SIM\n 2-Não ",conta.getFatura());
                            int fatura = scanner.nextInt();
                            if (fatura == 1) {
                                boolean exito = false;
                                exito = conta.pagarFatura(exito);
                                    System.out.println("Saida exito "+exito);
                                if (exito == true) {
                                    System.out.printf("Fatura paga com sucesso saldo atual: %.2f R$",conta.getSaldo());
                                }else{
                                    System.out.printf("Pagamento falhou saldo atual: %.2f R$",conta.getSaldo());
                                }
                            }
                            break;
                            
                            case 6:

                                conta.mostrarExtrato();
                            break;

                        default:
                            break;
                    }
                }
        }
    }
