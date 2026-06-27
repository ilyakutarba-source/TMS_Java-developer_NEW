package HomeWork30.task4;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class BuilderDemo {
    public static void main(String[] args) {
        Computer gamingComputer = Computer.builder()
                .processor("Intel Core i7")
                .ram(32)
                .storage(1000)
                .videoCard("NVIDIA RTX 4070")
                .operatingSystem("Windows 11")
                .build();

        Computer officeComputer = Computer.builder()
                .processor("Intel Core i5")
                .ram(16)
                .storage(512)
                .operatingSystem("Ubuntu")
                .build();

        System.out.println(gamingComputer);
        System.out.println(officeComputer);
    }
}

@Getter
@Builder
@ToString
class Computer {
    private final String processor;
    private final int ram;
    private final int storage;
    @Builder.Default
    private final String videoCard = "Integrated graphics";
    @Builder.Default
    private final String operatingSystem = "No OS";
}
