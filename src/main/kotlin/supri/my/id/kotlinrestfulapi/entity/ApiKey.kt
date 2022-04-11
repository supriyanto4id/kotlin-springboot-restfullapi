package supri.my.id.kotlinrestfulapi.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name ="api_key")
data class ApiKey(
    @Id
    val id: String
)
