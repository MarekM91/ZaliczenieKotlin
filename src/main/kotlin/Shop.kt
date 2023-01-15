/**
 * @author Michal Marek
 */
class Shop(val name: String,
           val productList: MutableList<Product>,
           val clientList: MutableList<Client>,
           var totalIncome: Int = 0) {

    constructor(name: String): this(name, mutableListOf(), mutableListOf())

    fun buyProduct(product: Product, client: Client){
        totalIncome += product.price
        --product.quantity
        client.boughtProducts.add(product)
    }

    fun addProduct(product: Product) {
        productList.add(product)
    }

    fun removeProduct(product: Product){
        productList.remove(product)
    }

    fun register(client: Client){
        clientList.add(client)
    }
}