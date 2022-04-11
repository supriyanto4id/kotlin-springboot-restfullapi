package supri.my.id.kotlinrestfulapi.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import supri.my.id.kotlinrestfulapi.model.CreateProductRequest
import supri.my.id.kotlinrestfulapi.model.ProductResponse
import org.springframework.stereotype.Service
import supri.my.id.kotlinrestfulapi.entity.Product
import supri.my.id.kotlinrestfulapi.error.NotFoundException
import supri.my.id.kotlinrestfulapi.model.ListProductRequest
import supri.my.id.kotlinrestfulapi.model.UpdateProductRequest
import supri.my.id.kotlinrestfulapi.repository.ProductRepository
import supri.my.id.kotlinrestfulapi.service.ProductService
import supri.my.id.kotlinrestfulapi.validation.ValidationUtil
import java.util.Date
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validation :ValidationUtil
    ) :ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {

        validation.validate(createProductRequest)

        val product = Product(
            id =createProductRequest.id!!,
            name=createProductRequest.name!!,
            price =createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
      val product =  findProductByIdOrThrowNotFound(id)
           return convertProductToProductResponse(product)

    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)


            validation.validate(updateProductRequest)
            product.apply {
                name = updateProductRequest.name!!
                price = updateProductRequest.price!!
                quantity = updateProductRequest.quantity!!
                updatedAt = Date()
            }
            productRepository.save(product)

            return convertProductToProductResponse(product)

    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
      val page = productRepository.findAll(PageRequest.of(listProductRequest.page,listProductRequest.size))
        val product: List<Product> = page.get().collect(Collectors.toList())
        return product.map{convertProductToProductResponse(it)}
    }

    private  fun findProductByIdOrThrowNotFound(id: String):Product{
        val product = productRepository.findByIdOrNull(id)
        if (product==null){
            throw NotFoundException()
        }else{
            return product
        }
    }
    private fun convertProductToProductResponse(product: Product): ProductResponse{
        return ProductResponse(
            id =product.id!!,
            name =product.name!!,
            price =  product.price!!,
            quantity = product.quantity!!,
            createdAt = product.createdAt!!,
            updatedAt = product.updatedAt
        )
    }

}