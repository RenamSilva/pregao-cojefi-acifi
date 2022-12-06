import axios, { AxiosInstance } from "axios"
import { Caminhao } from "../Class/Caminhao"

export class CaminhaoClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http//:localhost:8080/api/caminhao",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Caminhao> {
        try {
            return (await this.axiosClient.get<Caminhao>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Caminhao[]> {
        try {
            return (await this.axiosClient.get<Caminhao[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(caminhao: Caminhao): Promise<void> {
        try {
            return (await this.axiosClient.post(``, caminhao)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(caminhao: Caminhao): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${caminhao.id}`, caminhao)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(caminhao: Caminhao): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${caminhao.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

