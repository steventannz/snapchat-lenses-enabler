package gigaicon.lensesenabler;

import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SnapchatLensesEnabler implements IXposedHookLoadPackage {

    private static final String TAG = SnapchatLensesEnabler.class.getSimpleName();

    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals("com.snapchat.android"))
            return;

        try {
            Field model = Build.class.getField("MODEL");
            model.setAccessible(true);
            model.set(null, "LG-H810");
        } catch (Throwable e) {
            Log.d(TAG, "Failed to set build values");
        }
    }
}
