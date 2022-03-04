package br.com.fiap.loja.test;

import java.math.BigDecimal;

import br.com.fiap.loja.imposto.CalculadoraDeImposto;
import br.com.fiap.loja.imposto.Icms;
import br.com.fiap.loja.imposto.Ipi;
import br.com.fiap.loja.imposto.Iss;
import br.com.fiap.loja.situacao.Pedido;

public class TestaImposto {
	
	public static void main(String[] args) {
		Pedido pedido = new Pedido(new BigDecimal(100));
		CalculadoraDeImposto calculadoraDeImposto = new CalculadoraDeImposto();
		
		calculadoraDeImposto.setImposto(new Iss());
		BigDecimal imposto = calculadoraDeImposto.calcular(pedido);
		System.out.println(imposto);
		
		calculadoraDeImposto.setImposto(new Icms());
		imposto = calculadoraDeImposto.calcular(pedido);
		System.out.println(imposto);
		
		calculadoraDeImposto.setImposto(new Ipi());
		imposto = calculadoraDeImposto.calcular(pedido);
		System.out.println(imposto);
		
	}

}
