package com.ublox.BLE;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.ublox.BLE.activities.MainActivity;
import com.ublox.BLE.utils.UBloxDevice;

import static com.ublox.BLE.ConstantsForTests.DEVICE_ADDRESS;

public class MainWithBluetoothTestRule extends ActivityTestRule<MainActivity> {

    public MainWithBluetoothTestRule() {
        super(MainActivity.class);
    }

    @Override
    public Intent getActivityIntent() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        BluetoothManager manager = (BluetoothManager) context
            .getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter adapter = manager.getAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(DEVICE_ADDRESS);
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_DEVICE, new MockDevice());
        return intent;
    }
}
