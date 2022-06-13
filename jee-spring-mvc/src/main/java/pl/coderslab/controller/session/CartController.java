package pl.coderslab.controller.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CartController {

    private Cart cart;
    private ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

/*    @RequestMapping("/addtocart")
    @ResponseBody
    public String addToCart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }*/

    @GetMapping("/addtocart")
    @ResponseBody
    public String addToCart(@RequestParam("id") long id, @RequestParam("quantity") int quantity) {
        if(cart.hasProductWithId(id)) {
            cart.updateQuantity(id, quantity);
            return "quantityUpdated";
        }
        Product product = productDao.getProductById(id);
        CartItem cartItem = new CartItem(quantity, product);
        cart.addToCart(cartItem);
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String showCart() {
        StringBuilder sb = new StringBuilder();
        sb.append("W koszyku jest: ")
                .append(cart.getCartItems().size())
                .append(" pozycji. \n");
        sb.append("W koszyku jest: ")
                .append(cart.totalQuantity())
                .append(" produktów. \n");
        sb.append("Wartosc koszyka to: ")
                .append(cart.totalAmount())
                .append(" .\n");

        return sb.toString();
    }

}
