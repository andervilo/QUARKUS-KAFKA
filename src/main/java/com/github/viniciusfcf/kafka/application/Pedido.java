package com.github.viniciusfcf.kafka.application;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 7993717522484880202L;

	private UUID id;

	private BigDecimal valor;

	private BigDecimal valorFinal;

	private BigDecimal valorDesconto;

	private TipoCliente tipoCliente;

	public Pedido() {
	}

	public Pedido(UUID id, BigDecimal valor, BigDecimal valorDesconto, BigDecimal valorFinal, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.valorDesconto = valorDesconto;
		this.valorFinal = valorFinal;
		this.tipoCliente = tipoCliente;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valor=" + valor + ", valorFinal=" + valorFinal + ", valorDesconto="
				+ valorDesconto + ", tipoCliente=" + tipoCliente + "]";
	}

}
