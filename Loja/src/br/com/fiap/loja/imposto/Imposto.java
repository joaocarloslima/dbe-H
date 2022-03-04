package br.com.fiap.loja.imposto;
import java.math.BigDecimal;

import br.com.fiap.loja.situacao.Pedido;

public interface Imposto {
	
	BigDecimal calcular (Pedido pedido);

}
