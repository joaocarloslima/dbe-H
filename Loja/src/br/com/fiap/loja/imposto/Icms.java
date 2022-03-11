package br.com.fiap.loja.imposto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class Icms extends Imposto{

	public Icms(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal calcular(Pedido pedido) {
		
		 BigDecimal valorDoImposto = pedido.getValor().multiply(new BigDecimal(0.05)); 
		 BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		 
		 if(outroImposto != null) {
			 valorDoOutroImposto = outroImposto.calcular(pedido);
		 }
		 
		 return valorDoImposto.add(valorDoOutroImposto);
	}

}
