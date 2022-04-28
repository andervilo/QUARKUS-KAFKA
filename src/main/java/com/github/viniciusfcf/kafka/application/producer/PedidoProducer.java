package com.github.viniciusfcf.kafka.application.producer;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.viniciusfcf.kafka.application.Pedido;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;


@ApplicationScoped
public class PedidoProducer {
	
	@Inject
	@Channel("pedido-create-out")
	private Emitter<Pedido> emitter;
	
	public void sendPedidoUnico(Pedido pedido) {
		UUID id = UUID.randomUUID();
		pedido.setId(id);
		
		System.out.println("***********************CRIANDO PEDIDO***********************");
		System.out.println(pedido);
		System.out.println("************************************************************");
		
		emitter.send(pedido);
	}
	
	public void sendListaPedidos(List<Pedido> pedidos) {
		System.out.println("***********************CRIANDO LISTA DE PEDIDOS NO KAFIKA***********************");
		for (Pedido pedido : pedidos) {
			UUID id = UUID.randomUUID();
			pedido.setId(id);			
			System.out.println(pedido);
			emitter.send(pedido);
		}
		System.out.println("****************************************************************************");
	}
}
