<template>

    <div class="colums">

        <!-- <div class="colums">
            <div class="colum">
                Cadastrar Frete
            </div>
        </div> -->

        <div class="titulo"> Cadastrar frete</div>
        <div class="paidetodas">

            <div class="Inpts">
                <!-- part1 -->
                <div class="Anaju">
                    <div class="OrdenandoCadastro">



                        <div class="ordenaorigemdestino">
                            <div class="Origem">
                                <div class="select is-fullwidith">
                                    <select>
                                        <option selected hidden="true">Estado Origem</option>
                                        <option v-for="item in estadoList" :key="item.id"
                                            @click="estadoSelecionado(item.id)">
                                            {{
                                                    item.nome
                                            }}
                                        </option>
                                    </select>




                                </div>



                                <div class="select is-fullwidith">
                                    <select>
                                        <option selected hidden="true">Cidade Origem</option>
                                        <option v-for="item in cidadesList" :key="item.id"> {{ item.nome }}</option>
                                    </select>

                                </div>

                            </div>


                            <div class="Destino">
                                <div class="select is-fullwidith">
                                    <select>
                                        <option selected hidden="true">Estado Destino</option>
                                        <option v-for="item in estadoList" :key="item.id"
                                            @click="estadoSelecionado(item.id)">
                                            {{
                                                    item.nome
                                            }}
                                        </option>
                                    </select>

                                </div>

                                <div class="select is-fullwidith">
                                    <select>
                                        <option selected hidden="true">Cidade Destino</option>
                                        <option v-for="item in cidadesList" :key="item.id"> {{ item.nome }}</option>
                                    </select>

                                </div>

                            </div>
                        </div>


                        <div class="ordenaoutroselementos">


                            <div class="OrdenandoCadastro1">
                                <div class="ordenandosete">
                                    <div class="elementos1">

                                        <div class="select is-fullwidith">
                                            <select>
                                                <option selected hidden="true">Selecione um Produto </option>
                                                <option v-for="item in produtoList" :key="item.id"> {{ item.nome }}
                                                </option>
                                            </select>

                                        </div>

                                        <div class="select is-fullwidith">
                                            <select>
                                                <option selected hidden="true">Selecione um Motorista</option>
                                                <option v-for="item in usuarioList" :key="item.id"> {{ item.nome }}
                                                </option>
                                            </select>
                                        </div>


                                    </div>

                                    <div class="elementos2">

                                        <div class="select is-fullwidith">
                                            <select>
                                                <option selected hidden="true">Selecione um Caminhao</option>
                                                <option v-for="item in caminhaoList" :key="item.id"> {{ item.placa }}
                                                </option>
                                            </select>
                                        </div>

                                        <input class="input" type="number" v-model="frete.precoTonelada"
                                            placeholder="Preço por Tonelada" />


                                    </div>
                                </div>

                            </div>




                        </div>



                    </div>
                </div>



            </div>


        </div>
        <div class="classeButoes">
            <div class="Buttons">
                <button @click="onClickCadastrar()">Cadastrar</button>
            </div>


            <div class="Buttons">
                <a href="/frete"><button>Voltar</button></a>
            </div>

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
import { CidadeClient } from '@/model/Client/Cidade.client'
import { Cidade } from '@/model/Class/Cidade'
import { EstadoClient } from '@/model/Client/Estado.client'
import { Estado } from '@/model/Class/Estado'
import { Caminhao } from '@/model/Class/Caminhao'
import { CaminhaoClient } from '@/model/Client/Caminhao.client'
import { UsuarioClient } from '@/model/Client/Usuario.client'
import { Usuario } from '@/model/Class/Usuario'




@Component

export default class FreteCadastrarView extends Vue {

    private freteClient: FreteClient = new FreteClient()
    private produtoClient: ProdutoClient = new ProdutoClient()
    private cidadeClient: CidadeClient = new CidadeClient()
    private estadoClient: EstadoClient = new EstadoClient()
    private caminhaoClient: CaminhaoClient = new CaminhaoClient()
    private usuarioClient: UsuarioClient = new UsuarioClient()

    public frete: Frete = new Frete()
    public produtoList: Produto[] = []
    public cidadesList: Cidade[] = []
    public estadoList: Estado[] = []
    public caminhaoList: Caminhao[] = []
    public usuarioList: Usuario[] = []


    public mounted(): void {
        this.selectProdutoList();
        this.selectEstadoList();
        this.selectCaminhaoList();
        this.selectUsuarioList();
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

    private selectEstadoList(): void {
        this.estadoClient.findAll().then(
            success => this.estadoList = success,
            error => console.log(error)
        )
    }

    private selectCidadeList(id: number): void {
        this.cidadeClient.findByEstado(id).then(
            success => this.cidadesList = success,
            error => console.log(error)
        )

        console.log(this.cidadesList)
    }

    private selectCaminhaoList(): void {
        this.caminhaoClient.findAll().then(
            success => this.caminhaoList = success,
            error => console.log(error)
        )
    }

    private selectUsuarioList(): void {
        this.usuarioClient.findAll().then(
            success => this.usuarioList = success,
            error => console.log(error)
        )
    }

    public estadoSelecionado(id: number): void {
        if (id == null) {
            return
        }




    }


}
</script>



<style>
.classeButoes {
    position: absolute;
    margin-left: 40%;
    margin-top: 20%;
}

.titulo {
    position: absolute;
    margin-left: 43%;
    margin-top: -28%;

    font-family: Arial, Helvetica, sans-serif;
    font-size: 25px;
}

.Anaju {
    display: flex;
    flex-direction: row;
}

.elementos2 {
    display: flex;
    gap: 25px;
}

.elementos1 {
    display: flex;
    gap: 25px;
    /* flex-direction: row; */
}

.ordenandosete {
    display: flex;
    gap: 25px;
    flex-direction: column;
}

.ordenaoutroselementos {
    display: flex;
    flex-direction: column;
    gap: 25px;
}

.ordenaorigemdestino {
    display: flex;
    flex-direction: column;
    gap: 25px;
}

.Destino {
    display: flex;
    gap: 25px;

}

.Origem {
    display: flex;
    gap: 25px;
}

.paidetodas {

    display: flex;
    flex-direction: row;

    justify-content: center;
    align-items: center;

    height: 450px;
    border-radius: 25px;
    width: 80%;
    margin-left: 12%;

    background-color: rgba(178, 236, 176, 0.842);
}

.colums {
    display: flex;
    flex-direction: row;
    gap: 5%;

    align-items: center;


}

.OrdenandoCadastro1 {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;

    gap: 5%;
}



.OrdenandoCadastro {
    display: flex;
    flex-direction: row;
    /* flex-wrap: wrap; */

    gap: 5%;
    justify-content: center;
    align-items: center;
}

.classeButoes {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 5%;
}

.Inpts {
    text-align: justify;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center
        /* gap: 10% */
}


.input {
    height: 40px;

    width: 100%;
    text-align: justify;

    margin-left: -15px;



}

.Buttons {
    display: flex;
    justify-content: center;
    gap: 10px;
    margin-top: 20px;
}

button {
    height: 40px;
    border-radius: 5%;
    width: 150px;
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