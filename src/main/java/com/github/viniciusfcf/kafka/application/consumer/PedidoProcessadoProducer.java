package com.github.viniciusfcf.kafka.application.consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.viniciusfcf.kafka.application.Pedido;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

@ApplicationScoped
public class PedidoProcessadoProducer {
	
	@Inject
	@Channel("pedido-processado-out")
	private Emitter<Pedido> emitter;

	public void send(Pedido pedido) {
		System.out.println("***********************ENVIANDO PEDIDO PROCESSADO PARA o KAFKA***********************");
		System.out.println(pedido);
		System.out.println("**************************************************************************************");
		emitter.send(pedido);
	}
}
