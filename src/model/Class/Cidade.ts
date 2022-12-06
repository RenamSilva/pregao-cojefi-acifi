import { Estado } from "./Estado"
import { AbstractEntity } from "./AbstractEntity"


export class Cidade extends AbstractEntity {

    nome!: string
    estado!: Estado

}   