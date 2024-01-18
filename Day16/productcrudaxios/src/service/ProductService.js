import axios from 'axios';
let baseUrl="http://localhost:9090/SpringRESTWebService/product/"
class ProductService{
    getAllproducts(){
       return axios.get(baseUrl+"products")
    }
    getById(pid){
        return axios.get(baseUrl+"products/"+pid)
    }
    addProduct(prod){
        return axios.post(baseUrl+"products/"+prod.pid,prod)
    }
    updateProduct(prod){
        return axios.put(baseUrl+"products/"+prod.pid,prod)
    }
    deleteProduct(pid){
        return axios.delete(baseUrl+"products/"+pid);
    }
}

export default new ProductService();