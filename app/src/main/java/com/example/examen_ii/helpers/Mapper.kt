import com.example.examen_ii.data.ApiAddress
import com.example.examen_ii.data.ApiCompany
import com.example.examen_ii.data.ApiGeo
import com.example.examen_ii.data.ApiUser
import com.example.examen_ii.entity.UserEntity

fun List<UserEntity>.toApiUsers(): List<ApiUser> {
    return this.map { userEntity ->
        ApiUser(
            id = userEntity.id,
            name = userEntity.name,
            username = userEntity.username,
            email = userEntity.email,
            address = ApiAddress(
                city = userEntity.address.city,
                street = userEntity.address.street,
                suite = userEntity.address.suite,
                zipcode = userEntity.address.zipcode,
                geo = ApiGeo(
                    lat = userEntity.address.geo.lat,
                    lng = userEntity.address.geo.lng
                )
            ),
            company = ApiCompany(
                name = userEntity.company.name,
                catchPhrase = userEntity.company.catchPhrase,
                bs = userEntity.company.bs
            )
        )
    }
}