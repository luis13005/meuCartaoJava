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

    private void inserirExtrato(String chave,double valor){
        Extrato extrato = new Extrato(chave, valor);
        this.extrato.add(extrato);
    }

    public void mostrarExtrato(){
                 
                    System.out.println("*************Extrato*************\n"+this.extrato+ "\n" + //
                                                "*************Extrato*************\n");
    }

    public boolean sacar(double sacar,boolean erro){
        if (sacar <= this.saldo) {
            this.saldo -= sacar;
            erro = false;

            String chave = "Saque";
            this.inserirExtrato(chave, sacar);

            return erro;
        }else{
            erro = true;
            return erro;
        }
    }

    public boolean compra(double sacar,boolean erro){
        if (sacar <= this.saldo) {
            this.saldo -= sacar;
            String chave = "Compra Debito";
            this.inserirExtrato(chave, sacar);
            erro = false;
            return erro;
        }else{
            erro = true;
            return erro;
        }
    }

    public void credito(double preco){
        this.credito -= preco;
        this.fatura += preco;
        String chave = "Compra Credito";
            this.inserirExtrato(chave, preco);
    }

    public void depositar(double deposito){
        this.saldo += deposito;
        
        String chave = "Deposito";
        this.inserirExtrato(chave, deposito);
    }

    public boolean pagarFatura(boolean exito){
        if (this.getSaldo() >= this.getFatura()) {
            System.out.println(this.getSaldo());
            this.saldo -= this.getFatura();

            exito = true;
            
            String chave = "Pagamento da Fatura";
            this.inserirExtrato(chave, this.getFatura());

            this.fatura = 0;
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
