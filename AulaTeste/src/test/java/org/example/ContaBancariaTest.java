package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    ContaBancaria conta = new ContaBancaria("1234-5", "José");

    @Test
    void depositarTrueTest(){
        assertTrue(conta.depositar(100));
    }

    @Test
    void depositarFalseTest(){
        assertFalse(conta.depositar(-100));
    }

    @Test
    void sacarTrueTest(){
        conta.depositar(100);
        assertTrue(conta.sacar(50));
    }

    @Test
    void sacarFalseTest(){
        conta.depositar(100);
        assertFalse(conta.sacar(-50));
        assertFalse(conta.sacar(150));
    }

    @Test
    void transferirTrueTest(){
        ContaBancaria contaDestino = new ContaBancaria("1234-6", "Maria");
        conta.depositar(100);
        assertTrue(conta.transferir(contaDestino, 50));
        assertEquals(50, conta.getSaldo());
        assertEquals(50, contaDestino.getSaldo());
    }

    @Test
    void transferirFalseTest(){
        ContaBancaria contaDestino = new ContaBancaria("1234-6", "Maria");
        conta.depositar(100);
        assertFalse(conta.transferir(contaDestino, -50));
        assertFalse(conta.transferir(contaDestino, 150));
        assertEquals(100, conta.getSaldo());
        assertEquals(0, contaDestino.getSaldo());
    }

}
