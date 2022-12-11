package br.com.uniamerica.pregao.pregaoapi.entity;

public enum StatusDemanda {
    ABERTO("aberto"),
    ATENDIDO("atendido"),
    ENCERRADO("encerrado"),
    EXCLUIDO("excluido");

    private String statusDemanda;

    public String getStatusDemanda(){
        return this.statusDemanda;
    }

    StatusDemanda(String statusDemanda){
        this.statusDemanda = statusDemanda;
    }
}
