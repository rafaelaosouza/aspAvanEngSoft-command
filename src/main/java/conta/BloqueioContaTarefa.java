package conta;

public class BloqueioContaTarefa implements Tarefa {

    private Conta conta;

    public BloqueioContaTarefa(Conta conta) {
        this.conta = conta;
    }

    public void executar() {
        this.conta.bloquearConta();
    }

    public void cancelar() {
        this.conta.desbloquearConta();
    }
}
