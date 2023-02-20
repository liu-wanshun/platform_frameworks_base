package app.lws.launcherc.quickstepcompat;

import android.app.ActivityManager;
import android.app.WindowConfiguration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.AppTransitionAnimationSpec;
import android.view.RemoteAnimationTarget;
import android.view.SurfaceControl;

import androidx.annotation.NonNull;

public abstract class QuickstepCompatFactory {

    @NonNull
    public abstract ActivityManagerCompat getActivityManagerCompat();

    @NonNull
    public abstract ActivityOptionsCompat getActivityOptionsCompat();

    public abstract AppTransitionAnimationSpec createAppTransitionAnimationSpec(int taskId, Bitmap buffer, Rect rect);

    public abstract RemoteAnimationTarget createRemoteAnimationTarget(int taskId, int mode, SurfaceControl leash, boolean isTranslucent,
                                                                      Rect clipRect, Rect contentInsets, int prefixOrderIndex, Point position,
                                                                      Rect localBounds, Rect screenSpaceBounds,
                                                                      WindowConfiguration windowConfig, boolean isNotInRecents,
                                                                      SurfaceControl startLeash, Rect startBounds,
                                                                      ActivityManager.RunningTaskInfo taskInfo, boolean allowEnterPip,
                                                                      int windowType);
}
