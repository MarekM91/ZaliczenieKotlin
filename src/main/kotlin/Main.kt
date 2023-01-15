import java.util.Scanner

fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)
    println("Witaj w sklepie spożywczym Marek!")

    val shop = Shop("Shop")

    val product1 = Product("Mleko", "3,2%", 5, 50)
    val product2 = Product("Masło", "Osełka góralksa", 10, 100)
    val product3 = Product("Pepsi", "Napój gazowany 2l", 8, 20)
    val product4 = Product("Monster", "Napój energetyczny", 6, 20)
    val product5 = Product("Big Milk", "Lód na patyku", 2, 200)
    shop.addProduct(product1)
    shop.addProduct(product2)
    shop.addProduct(product3)
    shop.addProduct(product4)
    shop.addProduct(product5)
    val client1 = Client("Marek", 500, mutableListOf())
    val client2 = Client("Ogarek", 600, mutableListOf())
    val client3 = Client("Kowalski", 700, mutableListOf())
    shop.register(client1)
    shop.register(client2)
    shop.register(client3)

    while(true) {
        println("1 - Dodaj produkt")
        println("2 - Usuń produkt")
        println("3 - Lista produktów")
        println("4 - Zakupy")
        println("0 - Zakończ działanie")

        when(reader.nextInt())
        {
            1 -> {
                println("Dodaj produkt")
                println("Podaj nazwę:")
                val name = reader.next()
                println("Podaj opis:")
                val description = reader.next()
                println("Podaj cenę:")
                val price = reader.nextInt()
                println("Podaj ilość")
                val quantity = reader.nextInt()
                val product = Product(name, description, price, quantity)
                shop.addProduct(product)
                println("Dodano produkt $name")
            }
            2 -> {
                println("Usuń produkt")
                println("Wybierz produkt do usunięcia:")
                for((index, product) in shop.productList.withIndex())
                {
                    println("${index + 1}: $product")
                }
                val productIndex = reader.nextInt() - 1
                val product = shop.productList[productIndex]
                shop.removeProduct(product)
                println("Usunięto produkt $product")
            }
            3 -> {
                println("Lista produktów")
                for ((index, product) in shop.productList.withIndex())
                {
                    println("${index + 1}. $product")
                }
            }
            4 -> {
                println("Zakupy")
                println("Wybierz klienta")
                for((index, client) in shop.clientList.withIndex())
                {
                    println("${index + 1}: $client")
                }
                val clientIndex = reader.nextInt()
                val client = shop.clientList[clientIndex]

                println("Wybrano klienta ${client.surname}")

                println("Wybierz produkt:")
                for((index, product) in shop.productList.withIndex())
                {
                    println("${index + 1}: $product")
                }
                val productIndex = reader.nextInt() - 1
                val product = shop.productList[productIndex]
                println("Wybrano produkt $product")

                println("Wybierz ilość:")
                var quantity = reader.nextInt()

                if (quantity <= product.quantity)
                {
                    if (client.wallet > (product.price * quantity))
                    {
                        while (quantity > 0)
                        {
                            shop.buyProduct(shop.productList[productIndex], client)
                            quantity--
                        }
                    }
                    else
                    {
                        println("Brak wystarczających środków")
                    }
                    println("Dziękujemy za zakup")
                }
                else
                {
                    println("Nie ma tyle na stanie, wybierz mniejszą ilość.")
                }
            }
            0 ->
            {
                println("Dziękujemy za skorzystanie z naszych usług!")
                break
            }
        }
    }
}