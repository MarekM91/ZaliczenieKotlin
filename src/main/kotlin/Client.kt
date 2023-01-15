/**
 * @author Michal Marek
 */
class Client(val surname: String,
             var wallet: Int,
             val boughtProducts: MutableList<Product>) {
    override fun toString(): String {
        return "$surname"
    }
}
