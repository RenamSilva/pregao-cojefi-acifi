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
                        <!-- <th>Observação </th> -->
                        <th>Situacao </th>
                        <th>Status Frete </th>
                        <th>Ações </th>
                    </tr>
                </thead>

                <tbody>
                    <!--//armazena na variavel a quantidade de itens,
                        percorrendo item a item. Key pra identificar a keyu-->


                    <tr v-for="item in freteList" :key="item.id">

                        <th>{{ item.cadastrado }}</th>


                        <th>{{ item.cidadeOrigem.nome }}</th>
                        <th>{{ item.cidadeDestino.nome }}</th>

                        <th>{{ item.caminhao.placa }}</th>

                        <th>{{ item.produto.nome }}</th>
                        <!-- <th>{{ item.observacao }}</th> -->
                        <th>
                            <span v-if="item.ativo" class="tag is-success">Ativo</span>
                            <span v-if="!item.ativo" class="tag is-danger">Inativo</span>
                        </th>



                        <th>
                            <span v-if="(item.statusFrete === 'em_transporte')" class="tag is-link">Em transporte</span>
                            <span v-if="(item.statusFrete === 'carga')" class="tag is-info">Em carga</span>
                            <span v-if="(item.statusFrete === 'interrompido')"
                                class="tag is-warning">Interrompido</span>
                            <span v-if="(item.statusFrete === 'descarga')" class="tag is-dark">Descarga</span>
                            <span v-if="(item.statusFrete === 'faturado')" class="tag is-success">Faturado</span>
                            <span v-if="(item.statusFrete === 'cancelado')" class="tag is-danger">Cancelado</span>
                        </th>

                        <th>

                            <div class="acoes" v-if="(item.statusFrete === 'carga')">
                                <button class="button is-small is-default is-primary is-outlined">T</button>
                                <button class="button is-small is-default is-link is-outlined">I</button>
                                <button class="button is-small is-default is-danger is-outlined">C</button>
                            </div>

                            <div class="acoes" v-if="(item.statusFrete === 'em_transporte')">
                                <button class="button is-small is-default is-link is-outlined">I</button>
                                <button class="button is-small is-default is-dark is-outlined">D</button>
                            </div>

                            <div class="acoes" v-if="(item.statusFrete === 'interrompido')">
                                <button class="button is-small is- is-info is-outlined">CR</button>
                                <button class="button is-small is-default is-link is-outlined">T</button>
                                <button class="button is-small is-default is-danger is-outlined">C</button>
                            </div>

                            <div class="acoes" v-if="(item.statusFrete === 'cancelado')">
                                <button class="button is-small is-default is-info is-outlined">CR</button>
                                <button class="button is-small is-default is-link is-outlined">I</button>
                            </div>

                            <div class="acoes" v-if="(item.statusFrete === 'descarga')">
                                <button class="button is-small is-default is-success is-outlined">F</button>
                            </div>



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
.colum {
    display: flex;
    justify-content: center;

    font-family: Arial, Helvetica, sans-serif;
    font-size: 25px;
}

.tabela {
    border: 3px solid black;
    border-radius: 25px;
}

th {
    border: 1px solid black
}

.Fundos {
    background: rgba(250, 243, 243, 0.747);
    width: 100%;
    height: 800vh;

}

table tr th {
    padding: 10px 30px;
}

button {
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

.acoes {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

.alinhaacoes {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>