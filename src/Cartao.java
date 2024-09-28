import java.util.ArrayList;
import java.util.List;

public class Cartao {

    private String titular;
    private double saldo;
    private double credito;
    private double fatura;
    private int numeroCartao;
    private double rendaMensal;
    private List<Extrato> extrato; 

    public Cartao(String nomeTitular,double saldoConta,int numeroCartao,double rendaMensal){
        this.titular = nomeTitular.toUpperCase();
        this.saldo = saldoConta;
        this.numeroCartao = numeroCartao;
        this.rendaMensal = rendaMensal;
        this.credito = rendaMensal;        
        this.extrato = new ArrayList<>();
    }

    public void mostrarInfo(){
        System.out.printf("""
                Titular: %s

                Saldo: %.2f

                Numero do Cartão: %d

                Renda Mensal: %.2f

                Credito: %.2f

                Fatura: %.2f
                """,this.titular,this.saldo,this.numeroCartao,this.rendaMensal,this.credito,this.fatura);
    }

    public void sacar(double sacar){
        this.saldo -= sacar;
    }

    public void depositar(double deposito){
        this.saldo += deposito;
    }
}
