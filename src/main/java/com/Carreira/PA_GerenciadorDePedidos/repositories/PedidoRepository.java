package com.Carreira.PA_GerenciadorDePedidos.repositories;

import com.Carreira.PA_GerenciadorDePedidos.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
