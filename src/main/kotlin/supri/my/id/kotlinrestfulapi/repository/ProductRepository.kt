package supri.my.id.kotlinrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import supri.my.id.kotlinrestfulapi.entity.Product

interface ProductRepository :JpaRepository<Product, String>{

}