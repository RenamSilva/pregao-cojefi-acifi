import { StatusFrete } from "../Enum/StatusFrete"
import { AbstractEntity } from "./AbstractEntity"
import { Caminhao } from "./Caminhao"
import { Cidade } from "./Cidade"
import { Produto } from "./Produto"
import { Usuario } from "./Usuario"

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