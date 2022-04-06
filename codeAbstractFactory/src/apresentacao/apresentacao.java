package apresentacao;

public class apresentacao {

    private static Application configureApplication() {
        WindowsGUI windowsGUI = new WindowsGUI();
        LinuxGUI linuxGUI = new LinuxGUI();

        Application applicationWindows = new Application(windowsGUI);
        Application applicationLinux = new Application(linuxGUI);

        return applicationWindows;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }


}


class Application {
    final Menu menu;
    final ScrollBar scrollBar;

    Application(GUIFactory guiFactory) {
        menu = guiFactory.createMenu();
        scrollBar = guiFactory.createScrollBar();
    }

    public void paint() {
        menu.paint();
        scrollBar.paint();
    }
}


interface GUIFactory {
    Menu createMenu();

    ScrollBar createScrollBar();
}


interface Menu {
    void paint();
}


interface ScrollBar {
    void paint();
}

class WindowsMenu implements Menu {
    @Override
    public void paint() {
        System.out.println("Menu do Windows criado");
    }
}

class LinuxMenu implements Menu {
    @Override
    public void paint() {
        System.out.println("Menu do Linux criado");
    }
}

class WindowsScrollBar implements ScrollBar {
    @Override
    public void paint() {
        System.out.println("ScrollBar do Windows criada");
    }
}

class LinuxScrollBar implements ScrollBar {
    @Override
    public void paint() {
        System.out.println("ScrollBar do Linux criada");
    }
}

class WindowsGUI implements GUIFactory {
    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
}

class LinuxGUI implements GUIFactory {
    @Override
    public Menu createMenu() {
        return new LinuxMenu();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new LinuxScrollBar();
    }
}
