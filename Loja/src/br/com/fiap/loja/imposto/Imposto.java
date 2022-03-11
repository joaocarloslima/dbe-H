package br.com.fiap.loja.imposto;
import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public abstract class Imposto {
	
	protected Imposto outroImposto;
	
	public Imposto(Imposto outroImposto) {
		super();
		this.outroImposto = outroImposto;
	}

	abstract BigDecimal calcular (Pedido pedido);

}
