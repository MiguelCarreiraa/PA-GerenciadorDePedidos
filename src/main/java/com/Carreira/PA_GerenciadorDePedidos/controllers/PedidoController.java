package com.Carreira.PA_GerenciadorDePedidos.controllers;

import com.Carreira.PA_GerenciadorDePedidos.models.PedidoModel;
import com.Carreira.PA_GerenciadorDePedidos.servicies.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAllPedido(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel novo = pedidoService.criarPedido(pedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorId(@PathVariable Long id){
        Optional<PedidoModel> pedido = pedidoService.buscarPorId(id);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable Long id,
                                                       @RequestBody PedidoModel pedidoModel){
        Optional<PedidoModel> existente = pedidoService.buscarPorId(id);

        if (existente.isPresent()) {
            PedidoModel atualizado = pedidoService.atualizar(id, pedidoModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        Optional<PedidoModel> existente = pedidoService.buscarPorId(id);

        if (existente.isPresent()) {
            pedidoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
