package br.com.airline.passagem.adapter.out.persistence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import br.com.airline.passagem.adapter.out.persistence.entity.FormaPagamentoEntity;
import br.com.airline.passagem.adapter.out.persistence.entity.PagamentoEntity;
import br.com.airline.passagem.adapter.out.persistence.entity.PassagemEntity;
import br.com.airline.passagem.adapter.out.persistence.entity.UsuarioEntity;
import br.com.airline.passagem.adapter.out.persistence.entity.config.DatabaseSequence;
import br.com.airline.passagem.adapter.out.persistence.repository.PassagemRepository;
import br.com.airline.passagem.core.application.port.out.PassagemPersistencePort;
import br.com.airline.passagem.core.domain.FormaPagamento;
import br.com.airline.passagem.core.domain.Usuario;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Log4j2
public class PassagemPersistence implements PassagemPersistencePort {

  private final PassagemRepository passagemRepository;
  private final MongoOperations mongoOperations;


  public void comprar(Usuario usuario, FormaPagamento formaPagamento, String valor) {
    log.info("Gravar no banco de dados\n " + usuario.toString() + "\n" + formaPagamento.toString());

    UsuarioEntity usuarioEntity = new UsuarioEntity();
    usuarioEntity.setCpf(usuario.getCpf());
    usuarioEntity.setNome(usuario.getNome());

    FormaPagamentoEntity formaPagamentoEntity = new FormaPagamentoEntity();
    formaPagamentoEntity.setDescricao(formaPagamento.getDescricao());

    PagamentoEntity pagamentoEntity = new PagamentoEntity();
    pagamentoEntity.setUsuario(usuarioEntity);
    pagamentoEntity.setFormaPagamento(formaPagamentoEntity);
    pagamentoEntity.setValor(new BigDecimal(valor));

    PassagemEntity passagemEntity = new PassagemEntity();
    passagemEntity.setId(generateSequence(PassagemEntity.SEQUENCE_NAME));
    passagemEntity.setPagamento(pagamentoEntity);

    passagemRepository.save(passagemEntity);
  }

  public long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        DatabaseSequence.class);

    return !Objects.isNull(counter) ? counter.getSeq() : 1;
  }
}
