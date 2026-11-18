package cl.agencia.eventos.repository;

import cl.agencia.eventos.model.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepository extends MongoRepository<Evento, String> {
}