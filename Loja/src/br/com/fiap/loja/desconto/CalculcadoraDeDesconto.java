package br.com.fiap.loja.desconto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class CalculcadoraDeDesconto {
	
	public BigDecimal calcular(Pedido pedido){
		
		Desconto cadeiaDeDesconto = 
				new DescontoPorValor(
				new DescontoPorQuantidade(
				new SemDesconto()
		));
		
		return cadeiaDeDesconto.calcular(pedido);
		
	}

}
