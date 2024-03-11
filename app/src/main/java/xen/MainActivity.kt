package xen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xen.retrofitlesson.ProductApi
import xen.retrofitlesson.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tv)
        val b = findViewById<Button>(R.id.button)

        val retrofit = Retrofit.Builder() // инициализация библиотеки ретрофит
            .baseUrl("https://dummyjson.com") //базовая ссылка
            .addConverterFactory(GsonConverterFactory.create())
            .build() //create special converter for using json converting
        // преобразвывает data class в json и наоборот
        val productApi =
            retrofit.create(ProductApi::class.java) // создаем инстанцию апи по подобию интерфейса, которую сможем запускать

        b.setOnClickListener {// с помощью второстепенного потока получаем продукт и отображаем в тв
            CoroutineScope(Dispatchers.IO).launch {
                val product =
                    productApi.getProductById(3) // при запуске правой части запустится интерфейс, возьмет один продукт и запишет его в пер. продукт
                runOnUiThread { // получение доступа к текст вью делается через основной поток, этот код помогает это сделать
                    // обновление текст вью
                    tv.text = product.title
                }
            } // запускаем корутину, второстепенный поток
        }

       // productApi.getProductById() // выдача продукта // это тормозит все процессы в основном потоке, поэтому используем корутины
    }
}