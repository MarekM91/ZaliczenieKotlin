/**
 * @author Michal Marek
 */
class Client(val surname: String,
             var wallet: Int,
             val boughtProducts: MutableList<Product>,
             var totalIncome: Int) {

    fun buyProduct(product: Product){
        if (wallet >= product.price)
        {
            boughtProducts.add(product)
        }
    }
}
