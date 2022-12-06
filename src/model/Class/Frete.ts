import { StatusFrete } from "./Enum/StatusFrete"
import { AbstractEntity } from "./AbstractEntity"
import { Caminhao } from "@/model/Class/Caminhao"
import { Cidade } from "@/model/Class/Cidade"
import { Produto } from "@/model/Class/Produto"
import { Usuario } from "@/model/Class/Usuario"

export class Frete extends AbstractEntity {

    quilometragemIni!: number
    quilometragemFim!: number
    totalBrutoRecebidoNota!: number
    totalLiquidoRecebido!: number
    pesoInicial!: number
    pesoFinal!: number
    pesoFinalTransportado!: number
    precoTonelada!: number
    observacao!: string

    produto!: Produto
    motorista!: Usuario
    cidadeOrigem!: Cidade
    cidadeDesino!: Cidade
    caminhao!: Caminhao
    statusFrete!: StatusFrete


}