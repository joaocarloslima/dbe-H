package br.com.fiap.loja.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.fiap.loja.Pedido;
import br.com.fiap.loja.desconto.CalculcadoraDeDesconto;

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
		
		assertEquals(new BigDecimal("100.00"), desconto.setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	void deveRetornarDescontoParaPedidosGrandes() {
		Pedido pedido = new Pedido(new BigDecimal(100), 50);
		CalculcadoraDeDesconto calculcadoraDeDesconto = new CalculcadoraDeDesconto();
		BigDecimal desconto = calculcadoraDeDesconto.calcular(pedido);
		
		assertEquals(new BigDecimal("5.00"), desconto);
	}
	

}
