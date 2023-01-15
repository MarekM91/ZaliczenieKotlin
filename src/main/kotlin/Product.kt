/**
 * @author Michal Marek
 */
class Product(val name: String,
              val description: String,
              var price: Int,
              var quantity: Int) {

    override fun toString(): String {
        return "Product(name='$name', description='$description', price=$price, quantity=$quantity)"
    }
}