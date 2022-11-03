package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Contato;
import br.com.uniamerica.pregao.pregaoapi.entity.TipoContato;
import br.com.uniamerica.pregao.pregaoapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EmpresaService empresaService;

    public List<Contato> listAll(){
        return this.contatoRepository.findByAtivoTrue();
    }

    public Optional<Contato> getById(Long id){return this.contatoRepository.findByIdAtivoTrue(id);}

    public Contato inserir (Contato contato){
        return this.contatoRepository.save(contato);
    }

    public void atualizar (Long id, Contato contato) throws Exception {
        Contato contato1 = this.getById(id).orElse(null);

        if(contato1 == null){
            throw new Exception("contato não encontrada");
        } else {
            contato1.setValor(contato.getValor());
            contato1.setTipo(contato.getTipo());
            this.contatoRepository.save(contato1);
        }

    }

    public void atualizarContato (Long id, TipoContato tipoContato) throws Exception{
        Contato contato1 = this.getById(id).orElse(null);

        if(contato1 == null){
            throw new Exception("contato não encontrada");
        } else {
            contato1.setTipo(tipoContato);

            this.contatoRepository.save(contato1);
        }

    }


}


