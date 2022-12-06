<template>
    <div class="Fundos">
        <div class="colums">
            <div class="colum">
                LISTA DE FRETES
            </div>
        </div>

        <div class="colums">

            <table style="margin: 0 auto" class="tabela">
                <thead>
                    <tr>
                        <th>Data </th>
                        <th>Cidade Origem </th>
                        <th>Cidade Destino </th>

                        <th>Caminhão Placa </th>
                        <th>Produto </th>
                        <th>Observação </th>
                        <th>Situacao </th>
                        <th>Status Frete </th>
                    </tr>
                </thead>

                <tbody>
                    <!--//armazena na variavel a quantidade de itens,
                        percorrendo item a item. Key pra identificar a keyu-->


                    <tr v-for="item in freteList" :key="item.id">

                        <th>{{ item.cadastrado }}</th>


                        <th>{{ item.cidadeOrigem.nome }}</th>
                        <th>{{ item.cidadeDesino.nome }}</th>

                        <th>{{ item.caminhao.placa }}</th>

                        <th>{{ item.produto.nome }}</th>
                        <th>{{ item.observacao }}</th>
                        <th>
                            <span v-if="item.ativo" class="tag in-success">Ativo</span>
                            <span v-if="!item.ativo" class="tag in-danger">Inativo</span>
                        </th>



                        <th>

                            <span v-if="(item.statusFrete === 'em_transporte')" class="tag is-info">Em carga</span>
                            <span v-if="(item.statusFrete === 'carga')" class="tag is-info">Em carga</span>
                            <span v-if="(item.statusFrete === 'interrompido')"
                                class="tag is-warning">Interrompido</span>
                            <span v-if="(item.statusFrete === 'descarga')" class="tag is-primary">Descarga</span>
                            <span v-if="(item.statusFrete === 'interrompido')"
                                class="tag is-success">Interrompido</span>
                            <span v-if="(item.statusFrete === 'faturado')" class="tag is-danger">Faturado</span>


                        </th>








                    </tr>
                </tbody>

            </table>

            <a href="/cadastrar-frete"><button>Cadastrar</button></a>

        </div>
    </div>
</template>

<script lang="ts">

import { Component, Vue } from 'vue-property-decorator'
import { Frete } from '@/model/Class/Frete'
import { FreteClient } from '@/model/Client/Frete.client'


@Component
export default class FreteListView extends Vue {

    private freteClient: FreteClient = new FreteClient()
    public freteList: Frete[] = []

    public mounted(): void {
        this.listarFretes()
    }

    // private async listarFretes() {
    //     this.freteList = await this.freteClient.findAll();
    // }

    private listarFretes(): void {
        this.freteClient.findAll().then(
            success => {
                this.freteList = success
            }, error => {
                console.log(error)
            }
        )

    }

}

</script>

<style>
.tabela {
    border: 3px solid black;
    border-radius: 25px;
}

.Fundos {
    background: rgba(250, 243, 243, 0.747);
    width: 100%;
    height: 100vh;

}

table tr th {
    padding: 10px 30px;
}

button {
    margin-left: 43%;
    margin-top: 5%;

    height: 30px;
    border-radius: 5%;
    width: 10%;
    color: black;
    font-weight: bold;
    border: 2px solid rgb(59, 59, 167);
}

button:hover {
    background-color: rgb(59, 59, 167);
    /* border: none; */
    border-radius: 5%;
    color: white;
    font-weight: bold;
    transition: 0.5s;
}
</style>