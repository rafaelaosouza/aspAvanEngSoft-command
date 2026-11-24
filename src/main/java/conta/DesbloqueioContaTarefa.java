package conta;

public class DesbloqueioContaTarefa implements Tarefa {

    private Conta conta;

    public DesbloqueioContaTarefa(Conta conta) {
        this.conta = conta;
    }

    public void executar() {
        this.conta.desbloquearConta();
    }

    public void cancelar() {
        this.conta.bloquearConta();
    }
}
