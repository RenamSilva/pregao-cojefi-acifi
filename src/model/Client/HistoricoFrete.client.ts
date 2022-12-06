import axios, { AxiosInstance } from "axios"
import { HistoricoFrete } from "../Class/HistoricoFrete"

export class DespesasClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http//:localhost:8080/api/frete",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<HistoricoFrete> {
        try {
            return (await this.axiosClient.get<HistoricoFrete>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<HistoricoFrete[]> {
        try {
            return (await this.axiosClient.get<HistoricoFrete[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(historicoFrete: HistoricoFrete): Promise<void> {
        try {
            return (await this.axiosClient.post(``, HistoricoFrete)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(historicoFrete: HistoricoFrete): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${historicoFrete.id}`, historicoFrete)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(historicoFrete: HistoricoFrete): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${historicoFrete.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

