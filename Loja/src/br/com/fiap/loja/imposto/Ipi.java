package br.com.fiap.loja.imposto;

import java.math.BigDecimal;

import br.com.fiap.loja.Pedido;

public class Ipi implements Imposto{

	@Override
	public BigDecimal calcular(Pedido pedido) {
		return BigDecimal.ONE;
	}

}
