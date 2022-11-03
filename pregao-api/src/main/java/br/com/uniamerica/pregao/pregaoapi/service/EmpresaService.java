package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> findByAtivoTrue() {
        return this.empresaRepository.findByAtivoTrue();
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
