package br.com.fiap.loja.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.fiap.loja.desconto.CalculcadoraDeDesconto;
import br.com.fiap.loja.situacao.Pedido;

class CalculcadoraDeDescontoTest {

	@Test
	void deveRetorarZeroCasoNenhumDescontoSejaAplicado() {
		Pedido pedido = new Pedido(new BigDecimal(100), 2);
		CalculcadoraDeDesconto calculcadoraDeDesconto = new CalculcadoraDeDesconto();
		BigDecimal desconto = calculcadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("0.00"), desconto);
	}
	
	@Test
	void deveRetornarDescontoParaPedidosCaros() {
		Pedido pedido = new Pedido(new BigDecimal(1000), 2);
		CalculcadoraDeDesconto calculcadoraDeDesconto = new CalculcadoraDeDesconto();
		BigDecimal desconto = calculcadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("100.00"), desconto);
	}
	
	@Test
	void deveRetornarDescontoParaPedidosGrandes() {
		Pedido pedido = new Pedido(new BigDecimal(100), 50);
		CalculcadoraDeDesconto calculcadoraDeDesconto = new CalculcadoraDeDesconto();
		BigDecimal desconto = calculcadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("5.00"), desconto);
	}
	

}
