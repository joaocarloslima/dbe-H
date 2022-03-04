package br.com.fiap.loja.situacao;

import java.util.ArrayList;
import java.util.List;

public class EventManager { 
	
	private List<SituacaoListener> listeners = new ArrayList<SituacaoListener>() ;
	
	public void inscrever(SituacaoListener listener) {
		listeners.add(listener);
	}
	
	public void desinscrever(SituacaoListener listener) {
		listeners.remove(listener);
	}
	
	public void notificar(Pedido pedido) {
		listeners.forEach(listerner -> listerner.update(pedido));
	}

}
