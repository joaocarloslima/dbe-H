package br.com.fiap.loja.desconto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class DescontoPorValor extends Desconto {

	public DescontoPorValor(Desconto proximo) {
		super(proximo);
	}

	@Override
	protected BigDecimal aplicarDesconto(Pedido pedido) {
		return pedido.getValor().multiply( new BigDecimal(0.1));
	}

	@Override
	protected boolean deveAplicar(Pedido pedido) {
		return pedido.getValor().compareTo(new BigDecimal(500)) > 0;
	}

}
