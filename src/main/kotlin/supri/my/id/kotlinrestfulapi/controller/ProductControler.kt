package supri.my.id.kotlinrestfulapi.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import supri.my.id.kotlinrestfulapi.model.*
import supri.my.id.kotlinrestfulapi.service.ProductService

@RestController
class ProductControler (val productService: ProductService){

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebRespon<ProductResponse>{
        val productResponse = productService.create(body)
        return WebRespon(
            code = 200,
            status ="OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct")id:String): WebRespon<ProductResponse>{
        val productResponse =productService.get(id)
        return WebRespon(
            code = 200,
            status ="OK",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("idProduct") id:String,
                      @RequestBody updateProductRequest: UpdateProductRequest): WebRespon<ProductResponse>{
        val productResponse=productService.update(id,updateProductRequest)

        return WebRespon(
            code = 200,
            status ="OK",
            data = productResponse
        )

    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun delete(@PathVariable("idProduct") id: String):WebRespon<String>{
        productService.delete(id)
        return WebRespon(
            code = 200,
            status ="OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/products/"],
        produces = ["application/json"]
    )
    fun listProduct(@RequestParam(value ="size", defaultValue = "10") size: Int,
                    @RequestParam(value ="page", defaultValue = "0") page:Int): WebRespon<List<ProductResponse>>{
        val request = ListProductRequest(page = page, size =size)
        val response =productService.list(request)

        return WebRespon(
            code = 200,
            status ="OK",
            data = response
        )
    }
}