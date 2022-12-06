import axios, { AxiosInstance } from "axios"
import { Frete } from "../Class/Frete"



export class FreteClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http://localhost:8080/api/frete",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Frete> {
        try {
            return (await this.axiosClient.get<Frete>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Frete[]> {
        try {
            return (await this.axiosClient.get<Frete[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(frete: Frete): Promise<void> {
        try {
            return (await this.axiosClient.post(``, frete)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(frete: Frete): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${frete.id}`, frete)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(frete: Frete): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${frete.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

