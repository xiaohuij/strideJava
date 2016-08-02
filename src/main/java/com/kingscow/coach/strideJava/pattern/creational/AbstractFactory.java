package com.kingscow.coach.strideJava.pattern.creational;

//Abstract Factory patterns, also called as Factory of factories, have a factory which creates
// other factories.
//When using Abstract Factory pattern, we first use super factory to create factory, then use the created
// factory to create objects.

abstract class AbstractFactoryClass {
    abstract Printer getPrinter(String type);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactoryClass {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        return null;
    }
}
class PrinterFactory extends AbstractFactoryClass {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("paper")){
            return new PaperPrinter();
        } else if(type.equalsIgnoreCase("web")){
            return new WebPrinter();
        } else if(type.equalsIgnoreCase("Screen")){
            return new ScreenPrinter();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactoryClass getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("Printer")){
            return new PrinterFactory();
        }
        return null;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        AbstractFactoryClass shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();


        AbstractFactoryClass printerFactory = FactoryProducer.getFactory("printer");
        Printer printer1 = printerFactory.getPrinter("Paper");
        printer1.print();
        Printer printer2 = printerFactory.getPrinter("Web");
        printer2.print();
        Printer printer3 = printerFactory.getPrinter("Screen");
        printer3.print();
    }
}
