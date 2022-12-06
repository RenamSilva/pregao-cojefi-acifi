import { AbstractEntity } from "./AbstractEntity"
import { Frete } from "./Frete"
import { TipoDespesa } from "./TipoDespesa"
import { Usuario } from "./Usuario"

export class Despesas extends AbstractEntity {

    valor!: number
    data!: Date
    frete!: Frete
    tipodespesa!: TipoDespesa
    usuario!: Usuario

}