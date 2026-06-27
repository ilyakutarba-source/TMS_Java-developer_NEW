package HomeWork30.task3;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Dialog windowsDialog = new WindowsDialog();
        Dialog webDialog = new WebDialog();

        windowsDialog.render();
        webDialog.render();
    }
}

interface Button {
    void click();
}

abstract class Dialog {
    public void render() {
        Button button = createButton();
        button.click();
    }

    protected abstract Button createButton();
}

class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}

class HtmlButton implements Button {
    @Override
    public void click() {
        System.out.println("HTML button clicked");
    }
}

class WindowsDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {
    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
