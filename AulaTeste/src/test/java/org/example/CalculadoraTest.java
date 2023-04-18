package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
  
    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testAdicao() {
        assertEquals(8, calculadora.adicionar(3, 5));
        assertEquals(2, calculadora.adicionar(-3, 5));
        assertEquals(7.3, calculadora.adicionar(3.2, 4.1), 0.001);
    }

    @Test
    public void testSubtracao() {
        assertEquals(2, calculadora.subtrair(5, 3));
        assertEquals(-8, calculadora.subtrair(-3, 5));
        assertEquals(0.9, calculadora.subtrair(4.1, 3.2), 0.001);
    }

    @Test
    public void testMultiplicacao() {
        assertEquals(15, calculadora.multiplicar(3, 5));
        assertEquals(-15, calculadora.multiplicar(-3, 5));
        assertEquals(13.12, calculadora.multiplicar(3.2, 4.1), 0.001);
    }

    @Test
    public void testDivisao() {
        assertEquals(3, calculadora.dividir(6, 2));
        assertEquals(-3, calculadora.dividir(-6, 2));
        assertEquals(2, calculadora.dividir(4.4, 2.2), 0.001);
        assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(6, 0));
    }
}
