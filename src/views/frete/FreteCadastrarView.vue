<template>
    <div>

        <div class="colums">
            <div class="colum">
                Cadastrar
            </div>
        </div>

        <div class="Inpts">


            <input class="input" type="text" placeholder="Cidade Origem" />

            <input class="input" type="text" placeholder="Cidade Destino" />

            <div class="select">
                <select>
                    <option v-for="item in produtoList" :key="item.id"> {{ item.nome }}</option>
                </select>

            </div>


        </div>

        <!-- <input class="input" type="text" v-model="frete.produto.id" placeholder="Produto" />

        <input class="input" type="text" v-model="frete.caminhao.id" placeholder="Caminhão" />

        <input class="input" type="text" v-model="frete.motorista.id" placeholder="Motorista" />

        <input class="input" type="text" v-model="frete.precoTonelada" placeholder="Preço por Tonelada" />
 -->




        <div class="Buttons">
            <button @click="onClickCadastrar()">Cadastrar</button>
        </div>





    </div>




</template>

<script lang="ts">


import { Component, Vue } from 'vue-property-decorator'
import { FreteClient } from '@/model/Client/Frete.client'
import { Frete } from '@/model/Class/Frete'
// import { Route } from 'vue-router'
import { Produto } from '@/model/Class/Produto'
import { ProdutoClient } from '@/model/Client/Produto.client'


@Component

export default class FreteCadastrarView extends Vue {

    private freteClient: FreteClient = new FreteClient()
    private produtoClient: ProdutoClient = new ProdutoClient()


    public frete: Frete = new Frete()
    public produtoList: Produto[] = []

    public mounted(): void {
        this.selectProdutoList();
    }

    public onClickCadastrar(): void {


        this.freteClient.cadastrar(this.frete).then(
            success => {
                console.log('Registro cadastrado com sucesso!')
                this.frete = new Frete();

            }, error => {
                console.log(error)
            }
        )

    }

    private selectProdutoList(): void {
        this.produtoClient.findAll().then(
            success => this.produtoList = success,
            error => console.log(error)
        )

    }
}
</script>



<style>
.Inpts {
    text-align: justify;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    gap: 25px;

}


.input {
    height: 30px;

    width: 15%;
    text-align: justify;

}

.Buttons {
    display: flex;
    justify-content: center;
    gap: 10px;
    margin-top: 20px;
}

button {
    height: 25px;
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