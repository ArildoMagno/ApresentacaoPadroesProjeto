// INTERFACE GRAFICA PARA WINDOWS E LINUX
// INTEFACE: button, scrollbar

package apresentacao_exemplo;

public class ApresentacaoExemplo {

    public static void main(String[] args) {
        GUIFactory guiFactoryWindows = new WindowsGUI();
        GUIFactory guiFactoryLinux = new LinuxGUI();

        Cliente cliente = new Cliente(guiFactoryLinux);
        cliente.execute();
    }

}


class Cliente {
    Button button;
    ScrollBar scrollBar;

    Cliente(GUIFactory guiFactory) {
        button = guiFactory.createButton();
        scrollBar = guiFactory.createScrollBar();
    }

    void execute() {
        button.paint();
        scrollBar.paint();
    }
}


interface Button {
    void paint();
}

interface ScrollBar {
    void paint();
}

interface GUIFactory {
    Button createButton();

    ScrollBar createScrollBar();
}


class WindowsGUI implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
}

class LinuxGUI implements GUIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new LinuxScrollBar();
    }
}


// Implements = implementa os metodo
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Ola eu sou o botao do Windows");
    }
}

class LinuxButton implements Button {
    @Override
    public void paint() {
        System.out.println("Ola eu sou o botao do Linux");
    }
}

class WindowsScrollBar implements ScrollBar {
    @Override
    public void paint() {
        System.out.println("Ola eu sou o ScrollBar do Windows");
    }
}

class LinuxScrollBar implements ScrollBar {

    @Override
    public void paint() {
        System.out.println("Ola eu sou o ScrollBar do Linux");
    }
}
