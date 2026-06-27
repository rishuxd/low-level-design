package managers;

import adapters.AudioInterface;
import enums.DeviceType;
import factories.DeviceFactory;

public class DeviceManger {
    private AudioInterface device;

    private static class Holder {
        private final static DeviceManger INSTANCE = new DeviceManger();
    }

    public static DeviceManger getInstance() {
        return Holder.INSTANCE;
    }

    public void connect(DeviceType dt) {
        device = DeviceFactory.create(dt);
    }

    public AudioInterface getDevice() {
        return device;
    }
}
