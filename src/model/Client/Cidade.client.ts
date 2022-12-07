import axios, { AxiosInstance } from "axios"
import { Cidade } from "../Class/Cidade"

export class CidadeClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http://localhost:8080/api/cidade",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Cidade> {
        try {
            return (await this.axiosClient.get<Cidade>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findByEstado(id: number): Promise<Cidade[]> {
        try {
            return (await this.axiosClient.get<Cidade[]>(`/estado/ ${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Cidade[]> {
        try {
            return (await this.axiosClient.get<Cidade[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(cidade: Cidade): Promise<void> {
        try {
            return (await this.axiosClient.post(``, cidade)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(cidade: Cidade): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${cidade.id}`, cidade)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(cidade: Cidade): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${cidade.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

