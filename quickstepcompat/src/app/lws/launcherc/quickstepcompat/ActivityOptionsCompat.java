package app.lws.launcherc.quickstepcompat;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Handler;

abstract public class ActivityOptionsCompat {
    public abstract ActivityOptions makeCustomAnimation(Context context, int enterResId,
                                                        int exitResId, final Runnable callback, final Handler callbackHandler);
}
