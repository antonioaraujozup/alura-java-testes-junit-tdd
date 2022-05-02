package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        System.out.println("INÍCIO");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Antonio Eloy", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("FIM");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("ANTES DE TODOS");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("DEPOIS DE TODOS");
    }

    @Test
    public void reajusteDeveriaSerIgualATresPorCentoQuandoDesempenhoFuncionarioIgualADesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerIgualAQuinzePorCentoQuandoDesempenhoFuncionarioIgualABom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerIgualAVintePorCentoQuandoDesempenhoFuncionarioIgualAOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
