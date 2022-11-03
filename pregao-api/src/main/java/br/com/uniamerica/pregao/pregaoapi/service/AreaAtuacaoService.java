package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.AreaAtuacao;
import br.com.uniamerica.pregao.pregaoapi.repository.AreaAtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaAtuacaoService {
    @Autowired
    private AreaAtuacaoRepository areaAtuacaoRepository;

    public List<AreaAtuacao> findByAtivoTrue() {
        return this.areaAtuacaoRepository.findByAtivoTrue();
    }

    public AreaAtuacao findById(Long id) {
        return this.areaAtuacaoRepository.findById(id).orElse(new AreaAtuacao());
    }

    public AreaAtuacao save(AreaAtuacao areaAtuacao) {
        return this.areaAtuacaoRepository.save(areaAtuacao);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(Long id, AreaAtuacao areaAtuacao) {
        this.areaAtuacaoRepository.update(id, areaAtuacao.getNome());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void setAtivoFalse(Long id) {
        this.areaAtuacaoRepository.setAtivoFalse(id);
    }
}
