package FactoryDevices;

public class FactoryDevices {

    public static IDevices make(String type){
        IDevices device;
        switch (type){
            case "android":
                device = new Android();
                break;
            default:
                device = new Android();
                break;

        }
        return device;
    }
}
