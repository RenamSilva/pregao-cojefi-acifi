import axios, { AxiosInstance } from "axios"
import { Modelo } from "../Class/Modelo"

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

    public async findById(id: number): Promise<Modelo> {
        try {
            return (await this.axiosClient.get<Modelo>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Modelo[]> {
        try {
            return (await this.axiosClient.get<Modelo[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(modelo: Modelo): Promise<void> {
        try {
            return (await this.axiosClient.post(``, Modelo)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(modelo: Modelo): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${modelo.id}`, modelo)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(modelo: Modelo): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${modelo.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

