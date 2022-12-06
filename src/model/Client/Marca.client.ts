import axios, { AxiosInstance } from "axios"
import { Marca } from "../Class/Marca"

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

    public async findById(id: number): Promise<Marca> {
        try {
            return (await this.axiosClient.get<Marca>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Marca[]> {
        try {
            return (await this.axiosClient.get<Marca[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(marca: Marca): Promise<void> {
        try {
            return (await this.axiosClient.post(``, Marca)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(marca: Marca): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${marca.id}`, marca)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(marca: Marca): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${marca.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

