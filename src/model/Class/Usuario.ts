import { Grupo } from "./Enum/Grupo"
import { AbstractEntity } from "./AbstractEntity"


export class Usuario extends AbstractEntity {

    porGanho!: number
    login!: string
    senha!: string
    nome!: string
    cpf!: string
    telefone!: string
    dataNascimento!: Date
    endereco!: string
    observacao!: string
    grupo!: Grupo
}