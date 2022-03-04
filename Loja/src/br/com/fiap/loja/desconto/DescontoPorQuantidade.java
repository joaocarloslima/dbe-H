package br.com.fiap.loja.desconto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class DescontoPorQuantidade extends Desconto {

	public DescontoPorQuantidade(Desconto proximo) {
		super(proximo);
	}

	@Override
	protected BigDecimal aplicarDesconto(Pedido pedido) {
		return pedido.getValor().multiply( new BigDecimal(0.05));
	}

	@Override
	protected boolean deveAplicar(Pedido pedido) {
		return pedido.getTotalDeItens() > 10;
	}

}
