package xen.retrofitlesson

import retrofit2.http.GET

interface ProductApi {
    @GET("products/1") //здесь описываем запрос-ссылку, который хотим реализовать
    // указывает только часть ссылки, потому что базовая часть будет содержаться в ретрофите

    suspend fun getProductById(): Product
}