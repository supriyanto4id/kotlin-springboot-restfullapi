package supri.my.id.kotlinrestfulapi.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import supri.my.id.kotlinrestfulapi.entity.ApiKey
import supri.my.id.kotlinrestfulapi.repository.ApiKeyRepository

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository): ApplicationRunner {

    val apiKey ="SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val entity =ApiKey(id=apiKey)
            apiKeyRepository.save(entity)
        }
    }
}