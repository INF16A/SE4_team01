package Task_I06;

import Task_I06.Product.Product;
import Task_I06.ShoppingCartStatus.IShoppingCartStatus;
import Task_I06.ShoppingCartStatus.OpenShoppingCartStatus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCart implements Iterable<Product> {
    private Map<Product, Integer> positions;
    private IShoppingCartStatus status;

    public ShoppingCart() {
        this.status = new OpenShoppingCartStatus();
        this.positions = new HashMap<>();
    }

    @Override
    public Iterator<Product> iterator() {
        return new ShoppingCartIterator(this);
    }

    public void AddProduct(Product p) {
        if (status.isClosed()) {
            System.out.println("Can't add a product to a closed cart");
            return;
        }
        if (positions.containsKey(p)) {
            positions.put(p, positions.get(p) + 1);
        } else {
            positions.put(p, 1);
        }
    }

    public boolean isClosed() {
        return this.status.isClosed();
    }

    public boolean isPaid() {
        return this.status.isPaid();
    }

    public void pay() {
        this.status = this.status.pay(this);
    }

    public void close() {
        this.status = this.status.close(this);
    }

    public class ShoppingCartIterator implements Iterator<Product> {
        private ShoppingCart cart;
        private Iterator<Map.Entry<Product, Integer>> iterator;

        private Product currentProduct;
        private int index;

        public ShoppingCartIterator(ShoppingCart cart) {
            this.cart = cart;
            this.index = 0;
            resetIterator();
        }

        private void resetIterator() {
            Set<Map.Entry<Product, Integer>> entrySet = cart.positions.entrySet();
            iterator = entrySet.iterator();
        }

        @Override
        public boolean hasNext() {
            return index > 1 || iterator.hasNext();//*/
        }

        @Override
        public Product next() {
            if (index > 1) {
                index--;
                return currentProduct;
            }
            if (!iterator.hasNext()) {
                throw new RuntimeException("NextElement does not exist");
            }
            Map.Entry<Product, Integer> entry = iterator.next();
            index = entry.getValue();
            currentProduct = entry.getKey();
            return currentProduct;
        }
    }


}
