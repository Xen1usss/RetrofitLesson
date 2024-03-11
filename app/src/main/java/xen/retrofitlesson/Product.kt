package xen.retrofitlesson

data class Product( //подключенный конвектор сам преобразует джейсон с сайта в котлин дата класс
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
