package conta;

public class Conta {

    private int agencia;
    private int numero;
    private String situacao;

    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void bloquearConta() {
        this.situacao = "Conta bloqueada";
    }

    public void desbloquearConta() {
        this.situacao = "Conta desbloqueada";
    }
}
