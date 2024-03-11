package xen.retrofitlesson

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{id}") //здесь описываем запрос-ссылку, который хотим реализовать
    // указывает только часть ссылки, потому что базовая часть будет содержаться в ретрофите

    suspend fun getProductById(@Path("id") id: Int): Product
}