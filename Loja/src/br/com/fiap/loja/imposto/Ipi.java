package br.com.fiap.loja.imposto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class Ipi extends Imposto{

	public Ipi(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal calcular(Pedido pedido) {
		
		 BigDecimal valorDoImposto = BigDecimal.ONE;
		 BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		 
		 if(outroImposto != null) {
			 valorDoOutroImposto = outroImposto.calcular(pedido);
		 }
		 
		 return valorDoImposto.add(valorDoOutroImposto);	}

}
