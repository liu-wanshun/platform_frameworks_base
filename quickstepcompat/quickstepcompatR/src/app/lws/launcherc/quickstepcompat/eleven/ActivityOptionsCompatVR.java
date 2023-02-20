package app.lws.launcherc.quickstepcompat.eleven;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Handler;

import app.lws.launcherc.quickstepcompat.ActivityOptionsCompat;

public class ActivityOptionsCompatVR extends ActivityOptionsCompat {
    @Override
    public ActivityOptions makeCustomAnimation(Context context, int enterResId, int exitResId, Runnable callback, Handler callbackHandler) {
        return ActivityOptions.makeCustomAnimation(context, enterResId, exitResId,
                callbackHandler,
                new ActivityOptions.OnAnimationStartedListener() {
                    @Override
                    public void onAnimationStarted() {
                        if (callback != null) {
                            callbackHandler.post(callback);
                        }
                    }
                }, null /* finishedListener */);
    }
}
