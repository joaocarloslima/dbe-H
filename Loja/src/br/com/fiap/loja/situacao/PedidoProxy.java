package br.com.fiap.loja.situacao;

import java.math.BigDecimal;

public class PedidoProxy extends Pedido{

	private Pedido pedido;
	private BigDecimal valor;

	public PedidoProxy(Pedido pedido) {
		super(pedido.getValor());
		this.pedido = pedido;
	}
	
	@Override
	public BigDecimal getValor() {
		if (valor == null) {
			valor = pedido.getValor();
		}
		return valor;
	}

}
