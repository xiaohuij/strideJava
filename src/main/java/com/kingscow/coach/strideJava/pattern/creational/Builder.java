package com.kingscow.coach.strideJava.pattern.creational;

//Builder pattern is used to create a complex object using simple objects.
//It creates the bigger object step by step from small and simple object.

import sun.applet.Main;

class Menu {
    Menu() {
        System.out.println("creating menu");
    }
}

class ToolBar {
    ToolBar() {
        System.out.println("creating toolbar");
    }
}

class MainWindow {
    MainWindow() {
        System.out.println("creating main window");
    }
    Menu menu;
    ToolBar toolBar;
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
        System.out.println("setting menu to main window");
    }
    public ToolBar getToolBar() {
        return toolBar;
    }
    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
        System.out.println("setting toolbar to main window");
    }
}

class WindowBuilder{
    public static MainWindow createWindow(){
        MainWindow window = new MainWindow();
        Menu menu = new Menu();
        ToolBar toolBar = new ToolBar();
        window.setMenu(menu);
        window.setToolBar(toolBar);
        return window;
    }
}

public class Builder {
    public static void main(String[] args) {
        MainWindow object = WindowBuilder.createWindow();
    }

}
