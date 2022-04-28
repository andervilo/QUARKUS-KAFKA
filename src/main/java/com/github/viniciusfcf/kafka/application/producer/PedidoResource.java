package com.github.viniciusfcf.kafka.application.producer;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.viniciusfcf.kafka.application.Pedido;

@Path("/pedido")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoResource {
	
	@Inject
	private PedidoProducer pedidoProducer;
	
	@POST
	@Path("/unico")
	public Response send(Pedido pedido) {
		pedidoProducer.sendPedidoUnico(pedido);
		return Response.accepted().build();
	}
	
	@Path("/lista")
	@POST	
	public Response send(List<Pedido> pedidos) {
		pedidoProducer.sendListaPedidos(pedidos);
		return Response.accepted().build();
	}

}
