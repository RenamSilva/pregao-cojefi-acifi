import axios, { AxiosInstance } from "axios"
import { Despesas } from "../Class/Despesas"

export class DespesasClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http//:localhost:8080/api/despesas",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Despesas> {
        try {
            return (await this.axiosClient.get<Despesas>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Despesas[]> {
        try {
            return (await this.axiosClient.get<Despesas[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(despesas: Despesas): Promise<void> {
        try {
            return (await this.axiosClient.post(``, despesas)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(despesas: Despesas): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${despesas.id}`, despesas)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(despesas: Despesas): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${despesas.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

