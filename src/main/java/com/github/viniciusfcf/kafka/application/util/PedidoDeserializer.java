package com.github.viniciusfcf.kafka.application.util;

import com.github.viniciusfcf.kafka.application.Pedido;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class PedidoDeserializer extends ObjectMapperDeserializer<Pedido>{

	public PedidoDeserializer() {
		super(Pedido.class);
	}

}
