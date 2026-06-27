package HomeWork30.task2;

import lombok.Getter;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();

        createRoom(modernFactory);
        createRoom(victorianFactory);
    }

    private static void createRoom(FurnitureFactory factory) {
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();

        System.out.println(chair.getStyle());
        System.out.println(sofa.getStyle());
    }
}

interface Chair {
    String getStyle();
}

interface Sofa {
    String getStyle();
}

interface FurnitureFactory {
    Chair createChair();

    Sofa createSofa();
}

@Getter
class ModernChair implements Chair {
    private final String style = "Modern chair";
}

@Getter
class ModernSofa implements Sofa {
    private final String style = "Modern sofa";
}

@Getter
class VictorianChair implements Chair {
    private final String style = "Victorian chair";
}

@Getter
class VictorianSofa implements Sofa {
    private final String style = "Victorian sofa";
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
