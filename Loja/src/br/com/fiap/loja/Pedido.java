package br.com.fiap.loja;

import java.math.BigDecimal;

public class Pedido { 
	
	private BigDecimal valor;
	private int totalDeItens;
	
	public Pedido(BigDecimal valor) {
		super();
		this.valor = valor;
	}
	
	public Pedido(BigDecimal valor, int totalDeItens) {
		super();
		this.valor = valor;
		this.totalDeItens = totalDeItens;
	}
	
	public int getTotalDeItens() {
		return totalDeItens;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
