package lab11.src.ex1;

public class Phone {
    // atributes
    private String model;
    private String processor;
    private double price;
    private String storage;
    private String camera;

    // contructor
    public Phone(String model, String processor, double price, String storage, String camera) {
        this.model = model;
        this.processor = processor;
        this.price = price;
        this.storage = storage;
        this.camera = camera;
    }

    // getters
    public String getModel() {
        return model;
    }
    public String getProcessor() {
        return processor;
    }
    public double getPrice() {
        return price;
    }
    public String getStorage() {
        return storage;
    }
    public String getCamera() {
        return camera;
    }
    
    // setters
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public void setCamera(String camera) {
        this.camera = camera;
    }
    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Phone " + model + "; " + processor + "; " + price + "; " + storage + "; " + camera;
    }
}
