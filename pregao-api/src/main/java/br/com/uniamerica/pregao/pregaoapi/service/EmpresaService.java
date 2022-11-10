package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.AreaAtuacao;
import br.com.uniamerica.pregao.pregaoapi.entity.Contato;
import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private void filterNotActiveClasses(Empresa empresa) {
        Set<AreaAtuacao> activeAreasAtuacao = empresa.getAreasAtuacao().stream().filter(areaAtuacao -> areaAtuacao.isAtivo()).collect(Collectors.toSet());
        List<Contato> activeContatos = empresa.getContatos().stream().filter(contato -> contato.isAtivo()).collect(Collectors.toList());
        List<Demanda> activeDemandas = empresa.getDemandas().stream().filter(demanda -> demanda.isAtivo()).collect(Collectors.toList());

        empresa.setAreasAtuacao(activeAreasAtuacao);
        empresa.setContatos(activeContatos);
        empresa.setDemandas(activeDemandas);
    }

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa findByIdAndAtivoTrue(Long id) {
        Empresa empresa = this.empresaRepository.findById(id).orElse(new Empresa());
        filterNotActiveClasses(empresa);

        return empresa;
    }

    public List<Empresa> findByAtivoTrueAndContatoAtivoTrue() {
        final List<Empresa> empresas = this.empresaRepository.findByAtivoTrue();
        empresas.forEach(empresa -> filterNotActiveClasses(empresa));

        return empresas;
    }

    public Empresa findById(Long id) {
        return this.empresaRepository.findById(id).orElse(new Empresa());
    }

    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(Long id, Empresa empresa) {
        this.empresaRepository.update(id, empresa.getNome());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void setAtivoFalse(Long id) {
        this.empresaRepository.setAtivoFalse(id);
    }
}
