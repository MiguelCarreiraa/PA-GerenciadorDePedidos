package com.Carreira.PA_GerenciadorDePedidos.controllers;

import com.Carreira.PA_GerenciadorDePedidos.models.PedidoModel;
import com.Carreira.PA_GerenciadorDePedidos.servicies.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoModel> findAll(){
        return pedidoService.findAll();
    }

    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedidoModel){
        return pedidoService.criarPedido(pedidoModel);
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoModel atualizarPedido(@PathVariable long id,@RequestBody PedidoModel pedidoModel ){
        return  pedidoService.atualizar(id,pedidoModel);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletar(id);
    }
}
