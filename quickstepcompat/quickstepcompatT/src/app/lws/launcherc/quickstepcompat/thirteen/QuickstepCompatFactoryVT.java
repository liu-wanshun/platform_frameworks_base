package app.lws.launcherc.quickstepcompat.thirteen;

import androidx.annotation.NonNull;

import app.lws.launcherc.quickstepcompat.ActivityManagerCompat;
import app.lws.launcherc.quickstepcompat.twelve.QuickstepCompatFactoryVS;

public class QuickstepCompatFactoryVT extends QuickstepCompatFactoryVS {

    @NonNull
    @Override
    public ActivityManagerCompat getActivityManagerCompat() {
        return new ActivityManagerCompatVT();
    }
}
