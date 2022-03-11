package br.com.fiap.loja.situacao;

public class LogListener implements SituacaoListener {

	@Override
	public void update(Pedido pedido) {
		System.out.println("LOG: mudan�a de estado " 
					+ pedido.getSituacao() 
					+ pedido.getValor());		
	}

}
