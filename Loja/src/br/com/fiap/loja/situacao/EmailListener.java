package br.com.fiap.loja.situacao;

public class EmailListener implements SituacaoListener {

	@Override
	public void update(Pedido pedido) {
		System.out.println("Enviando e-mail do pedido " 
					+ pedido + " com a situacao " 
					+ pedido.getSituacao()
					+ pedido.getValor()
					);
	}

}
