package br.com.fiap.loja.situacao;

import java.math.BigDecimal;

public class TestaProxy {
	public static void main(String[] args) {
		Pedido pedido = 
				new PedidoProxy(	
					new Pedido(new BigDecimal(100))
				);
		
		pedido.getManager().inscrever(new EmailListener());
		pedido.getManager().inscrever(new LogListener());
		
		
		System.out.println(pedido.getValor());
		
		pedido.cancelar();
		pedido.reabrir();
		pedido.pagar();
		pedido.entregar();
		
	}
}
