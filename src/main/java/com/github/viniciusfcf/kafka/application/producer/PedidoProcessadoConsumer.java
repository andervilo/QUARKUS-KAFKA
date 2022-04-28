package com.github.viniciusfcf.kafka.application.producer;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.github.viniciusfcf.kafka.application.Pedido;

@ApplicationScoped
public class PedidoProcessadoConsumer {
	
	@Incoming("pedido-processado-in")
	public void receive(Pedido pedido) {
		System.out.println("***********************RECEBENDO PEDIDO PROCESSADO DO KAFKA***********************");
		System.out.println(pedido);
		System.out.println("**********************************************************************************");
	}

}
