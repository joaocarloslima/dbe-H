package br.com.fiap.loja.imposto;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public class Iss extends Imposto{

	public Iss(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal calcular(Pedido pedido) {
		
		 BigDecimal valorDoImposto = pedido.getValor().multiply(new BigDecimal(0.1)); 
		 BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		 
		 if(outroImposto != null) {
			 valorDoOutroImposto = outroImposto.calcular(pedido);
		 }
		 
		 return valorDoImposto.add(valorDoOutroImposto); 
	}

}
