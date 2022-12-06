import axios, { AxiosInstance } from "axios";
import { Produto } from "@/model/Class/Produto";

export class ProdutoClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http//:localhost:8080/api/produto",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Produto> {
        try {
            return (await this.axiosClient.get<Produto>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Produto[]> {
        try {
            return (await this.axiosClient.get<Produto[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(produto: Produto): Promise<void> {
        try {
            return (await this.axiosClient.post(``, Produto)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(produto: Produto): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${produto.id}`, produto)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(produto: Produto): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${produto.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

