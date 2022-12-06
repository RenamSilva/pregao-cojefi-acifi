import { Cor } from "./Enum/Cor"
import { AbstractEntity } from "./AbstractEntity"

import { Modelo } from "./Modelo"

export class Caminhao extends AbstractEntity {

    placa!: string
    modelo!: Modelo
    cor!: Cor
    ano!: number
    observacao!: string



}