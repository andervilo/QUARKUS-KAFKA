package com.github.viniciusfcf.kafka.application.consumer;

import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.github.viniciusfcf.kafka.application.Pedido;
import com.github.viniciusfcf.kafka.application.TipoCliente;

@ApplicationScoped
public class ProcessaPedidoConsummer {

	@Inject
	private PedidoProcessadoProducer pedidoProcessadoProducer;
	
	private final static Double VINTE_POR_CENTO = 0.2;
	private final static Double QUINZE_POR_CENTO = 0.15;
	private final static Double DEZ_POR_CENTO = 0.10;

	@Incoming("pedido-create-in")
	public void receive(Pedido pedido) {
		System.out.println("***********************RECEBENDO PEDIDO***********************");
		System.out.println(pedido);
		System.out.println("**************************************************************");
		processar(pedido);

		pedidoProcessadoProducer.send(pedido);
	}

	private void processar(Pedido pedido) {
		if (pedido.getTipoCliente().equals(TipoCliente.A))
			calculaDesconto(pedido, VINTE_POR_CENTO);
		if (pedido.getTipoCliente().equals(TipoCliente.B))
			calculaDesconto(pedido, QUINZE_POR_CENTO);
		if (pedido.getTipoCliente().equals(TipoCliente.C))
			calculaDesconto(pedido, DEZ_POR_CENTO);
	}

	private void calculaDesconto(Pedido pedido, Double valorDesconto) {
		pedido.setValorDesconto(pedido.getValor().multiply(BigDecimal.valueOf(valorDesconto)));
		pedido.setValorFinal(pedido.getValor().subtract(pedido.getValorDesconto()));
	}

}
