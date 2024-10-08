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

    public double getSaldo() {
        return saldo;
    }

    public double getCredito() {
        return credito;
    }
   
    public double getFatura() {
        return fatura;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public Cartao(String nomeTitular,double saldoConta,int numeroCartao,double rendaMensal){
        this.titular = nomeTitular.toUpperCase();
        this.saldo = saldoConta;
        this.numeroCartao = numeroCartao;
        this.rendaMensal = rendaMensal;
        this.credito = rendaMensal;        
        this.extrato = new ArrayList<>();
    }

    public void inserirExtrato(Extrato extrato){
        this.extrato.add(extrato);
    }

    public void mostrarExtrato(){
        System.out.println(extrato);
    }

    public void sacarPagar(double sacar){
        this.saldo -= sacar;
    }

    public void credito(double preco){
        this.credito -= preco;
        this.fatura += preco;
    }

    public void depositar(double deposito){
        this.saldo += deposito;
    }

    public boolean pagarFatura(boolean exito){
        if (this.getSaldo() >= this.getFatura()) {
            System.out.println(this.getSaldo());
            this.saldo -= this.getFatura();

            this.fatura = 0;
            System.out.println(this.getSaldo());
            exito = true;
            System.out.println("exito "+exito);
            return exito;
        }else{
            exito = false;
            return exito;
        }
    }

    @Override
    public String toString() {
        return "Titular: "+this.titular+"\n"+
            "Saldo: "+this.saldo+"\n"+
            "Numero do Cartão: "+this.numeroCartao+"\n"+
            "Renda Mensal: "+this.rendaMensal+"\n"+
            "Credito: "+this.credito+"\n"+
            "Fatura: "+this.fatura+"\n";
    }
}
