package ec.edu.uteq.bancoaustro.controller;

import ec.edu.uteq.bancoaustro.service.ConsultaDistribuidaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CuentaController {

    private final ConsultaDistribuidaService service;

    public CuentaController(ConsultaDistribuidaService service) {
        this.service = service;
    }

    @GetMapping("/saldo/{numero}")
    public Map<String, Object> consultarSaldo(@PathVariable String numero) {
        return service.consultarSaldo(numero);
    }

    @GetMapping("/clientes")
    public List<Map<String, Object>> listarClientes() {
        return service.listarTodosLosClientes();
    }
}