package br.com.fiap.loja.test;

import java.math.BigDecimal;

import br.com.fiap.loja.situacao.EmailListener;
import br.com.fiap.loja.situacao.LogListener;
import br.com.fiap.loja.situacao.Pedido;

public class TestaSituacao {
	
	public static void main(String[] args) {
		
		Pedido pedido = new Pedido(new BigDecimal(100));
		pedido.getManager().inscrever(new EmailListener());
		pedido.getManager().inscrever(new LogListener());
		
		pedido.abrirChamado();
		
		
		pedido.cancelar();
		pedido.reabrir();
		pedido.pagar();
		pedido.entregar();
		
		pedido.abrirChamado();
		
	}

}
