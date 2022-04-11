package supri.my.id.kotlinrestfulapi.service

import supri.my.id.kotlinrestfulapi.model.CreateProductRequest
import supri.my.id.kotlinrestfulapi.model.ListProductRequest
import supri.my.id.kotlinrestfulapi.model.ProductResponse
import supri.my.id.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id:String) :ProductResponse

    fun update(id:String,updateProductRequest: UpdateProductRequest ):ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest):List<ProductResponse>
}