package HomeWork29;

import java.util.List;

public class SolidExamples {
    public static void main(String[] args) {
        System.out.println("SRP: " + new OrderPrinter().print(new Order("Notebook", 2, 1500)));
        System.out.println("OCP: " + new PriceCalculator().calculate(1000, new RegularDiscount()));
        System.out.println("LSP: " + new BirdInfo().describe(new Sparrow()));
        System.out.println("ISP: " + new SimplePrinter().print("Homework"));
        System.out.println("DIP: " + new NotificationService(new EmailSender()).notifyUser("SOLID examples are ready"));
    }

    /*
     * SRP - Single Responsibility Principle.
     * У класса должна быть одна причина для изменения.
     * Order хранит данные заказа, а OrderPrinter отвечает только за вывод.
     */
    static class Order {
        private final String productName;
        private final int count;
        private final int price;

        Order(String productName, int count, int price) {
            this.productName = productName;
            this.count = count;
            this.price = price;
        }

        int getTotalPrice() {
            return count * price;
        }

        String getProductName() {
            return productName;
        }
    }

    static class OrderPrinter {
        String print(Order order) {
            return order.getProductName() + ", total price: " + order.getTotalPrice();
        }
    }

    /*
     * OCP - Open/Closed Principle.
     * Код открыт для расширения, но закрыт для изменения.
     * Для новой скидки достаточно добавить новый класс Discount, PriceCalculator менять не нужно.
     */
    interface Discount {
        double apply(double price);
    }

    static class RegularDiscount implements Discount {
        @Override
        public double apply(double price) {
            return price * 0.9;
        }
    }

    static class PriceCalculator {
        double calculate(double price, Discount discount) {
            return discount.apply(price);
        }
    }

    /*
     * LSP - Liskov Substitution Principle.
     * Наследника можно использовать вместо базового типа без поломки логики.
     * Sparrow корректно работает везде, где ожидается Bird.
     */
    interface Bird {
        String getName();
    }

    static class Sparrow implements Bird {
        @Override
        public String getName() {
            return "Sparrow";
        }
    }

    static class BirdInfo {
        String describe(Bird bird) {
            return "This is a " + bird.getName();
        }
    }

    /*
     * ISP - Interface Segregation Principle.
     * Лучше несколько маленьких интерфейсов, чем один большой.
     * SimplePrinter реализует только печать и не обязан знать про сканирование.
     */
    interface Printable {
        String print(String text);
    }

    interface Scannable {
        String scan(List<String> pages);
    }

    static class SimplePrinter implements Printable {
        @Override
        public String print(String text) {
            return "Printed: " + text;
        }
    }

    /*
     * DIP - Dependency Inversion Principle.
     * Высокоуровневый класс зависит от абстракции MessageSender, а не от конкретной почты.
     */
    interface MessageSender {
        String send(String message);
    }

    static class EmailSender implements MessageSender {
        @Override
        public String send(String message) {
            return "Email sent: " + message;
        }
    }

    static class NotificationService {
        private final MessageSender sender;

        NotificationService(MessageSender sender) {
            this.sender = sender;
        }

        String notifyUser(String message) {
            return sender.send(message);
        }
    }
}
