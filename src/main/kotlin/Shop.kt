/**
 * @author Michal Marek
 */
class Shop(val name: String,
           val productList: MutableList<Product>,
           val clientList: MutableList<Client>,
           var totalIncome: Int) {

    fun buyProduct(product: Product){
        totalIncome += product.price
        --product.quantity
    }

    fun addProduct(product: Product) {
        productList.toMutableList().add(product)
    }

    fun removeProduct(product: Product){
        productList.toMutableList().remove(product)
    }

    fun register(){}

    fun login(){}
}