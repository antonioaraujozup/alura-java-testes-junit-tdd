package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioAcimaDe10000() {
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Antonio Eloy", LocalDate.now(), new BigDecimal("25000"));

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(funcionario));
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaFuncionarioComSalarioIgualA5000() {
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Antonio Eloy", LocalDate.now(), new BigDecimal("5000"));

        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaFuncionarioComSalarioIgualA10000() {
        BonusService service = new BonusService();
        Funcionario funcionario = new Funcionario("Antonio Eloy", LocalDate.now(), new BigDecimal("10000"));

        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
