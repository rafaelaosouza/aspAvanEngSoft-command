package conta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GerenteTest {

    Gerente gerente;
    Conta conta;

    @BeforeEach
    void setUp() {
        gerente = new Gerente();
        conta = new Conta(1234, 56789);
    }

    @Test
    void deveBloquearConta() {
        Tarefa bloqueioConta = new BloqueioContaTarefa(conta);
        gerente.executarTarefa(bloqueioConta);

        assertEquals("Conta bloqueada", conta.getSituacao());
    }

    @Test
    void deveDesbloquearConta() {
        Tarefa desbloqueioConta = new DesbloqueioContaTarefa(conta);
        gerente.executarTarefa(desbloqueioConta);

        assertEquals("Conta desbloqueada", conta.getSituacao());
    }

    @Test
    void deveCancelarDesbloqueioConta() {
        Tarefa bloqueioConta = new BloqueioContaTarefa(conta);
        Tarefa desbloqueioConta = new DesbloqueioContaTarefa(conta);

        gerente.executarTarefa(bloqueioConta);
        gerente.executarTarefa(desbloqueioConta);

        gerente.cancelarUltimaTarefa();

        assertEquals("Conta bloqueada", conta.getSituacao());
    }

    @Test
    void deveCancelarDuasTarefasEmSequencia() {
        gerente.executarTarefa(new DesbloqueioContaTarefa(conta));
        gerente.executarTarefa(new BloqueioContaTarefa(conta));
        gerente.executarTarefa(new DesbloqueioContaTarefa(conta));

        gerente.cancelarUltimaTarefa();
        gerente.cancelarUltimaTarefa();

        assertEquals("Conta desbloqueada", conta.getSituacao());
    }

    @Test
    void naoDeveAlterarContaAoCancelarSemTarefas() {
        gerente.cancelarUltimaTarefa();

        assertNull(conta.getSituacao());
    }

}
