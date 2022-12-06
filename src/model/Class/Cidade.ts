import { Estado } from "../Enum/Estado"
import { AbstractEntity } from "./AbstractEntity"


export class Cidade extends AbstractEntity {

    nome!: string
    estado!: Estado

}   