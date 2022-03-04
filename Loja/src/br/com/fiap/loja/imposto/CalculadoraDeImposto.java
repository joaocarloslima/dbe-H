package br.com.fiap.loja.imposto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class CalculadoraDeImposto {
	
	private Imposto imposto;
	
	public BigDecimal calcular(Pedido pedido){
		return imposto.calcular(pedido);
	}
	
	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

}
