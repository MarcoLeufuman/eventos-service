package cl.agencia.eventos.service;

import cl.agencia.eventos.model.Evento;
import cl.agencia.eventos.repository.EventoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<Evento> listar() {
        return repository.findAll();
    }

    public Optional<Evento> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Evento crear(Evento evento) {
        evento.setId(null);
        return repository.save(evento);
    }

    public Optional<Evento> actualizar(String id, Evento datos) {
        return repository.findById(id).map(existente -> {
            datos.setId(id);
            return repository.save(datos);
        });
    }

    public boolean eliminar(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
