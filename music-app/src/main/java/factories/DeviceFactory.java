package factories;

import adapters.AudioInterface;
import adapters.BluetoothAdapter;
import adapters.WiredAdapter;
import apis.BluetoothAPI;
import apis.WiredAPI;
import enums.DeviceType;

public class DeviceFactory {
    public static AudioInterface create(DeviceType dt){
        switch (dt) {
            case BLUETOOTH:
                return new BluetoothAdapter(new BluetoothAPI());
            
            case WIRED:
                return new WiredAdapter(new WiredAPI());

            default:
                throw new IllegalStateException("No such device found!");
        }
    }
}
