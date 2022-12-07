import axios, { AxiosInstance } from "axios"
import { Usuario } from "../Class/Usuario"

export class UsuarioClient {

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: "http://localhost:8080/api/usuario",
            headers: {
                'Content-type': 'application/json'
            }
        })
    }

    public async findById(id: number): Promise<Usuario> {
        try {
            return (await this.axiosClient.get<Usuario>(`/${id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async findAll(): Promise<Usuario[]> {
        try {
            return (await this.axiosClient.get<Usuario[]>(``)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

    public async cadastrar(usuario: Usuario): Promise<void> {
        try {
            return (await this.axiosClient.post(``, Usuario)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }


    }
    public async atualizar(usuario: Usuario): Promise<void> {
        try {
            return (await this.axiosClient.put(`/${usuario.id}`, usuario)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }



    public async excluir(usuario: Usuario): Promise<void> {
        try {
            return (await this.axiosClient.delete(`/${usuario.id}`)).data

        } catch (error: any) {
            return Promise.reject(error.response)
        }
    }

}

