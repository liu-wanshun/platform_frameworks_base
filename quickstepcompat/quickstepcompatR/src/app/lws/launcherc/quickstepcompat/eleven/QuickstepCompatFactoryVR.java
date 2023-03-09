package app.lws.launcherc.quickstepcompat.eleven;

import android.app.ActivityManager;
import android.app.TaskInfo;
import android.app.WindowConfiguration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.AppTransitionAnimationSpec;
import android.view.RemoteAnimationTarget;
import android.view.SurfaceControl;

import androidx.annotation.NonNull;

import app.lws.launcherc.quickstepcompat.ActivityManagerCompat;
import app.lws.launcherc.quickstepcompat.ActivityOptionsCompat;
import app.lws.launcherc.quickstepcompat.QuickstepCompatFactory;
import app.lws.launcherc.quickstepcompat.TaskInfoCompat;

public class QuickstepCompatFactoryVR extends QuickstepCompatFactory {

    @NonNull
    @Override
    public ActivityManagerCompat getActivityManagerCompat() {
        return new ActivityManagerCompatVR();
    }

    @NonNull
    @Override
    public ActivityOptionsCompat getActivityOptionsCompat() {
        return new ActivityOptionsCompatVR();
    }

    @Override
    public AppTransitionAnimationSpec createAppTransitionAnimationSpec(int taskId, Bitmap buffer, Rect rect) {
        return new AppTransitionAnimationSpec(taskId,
                buffer != null ? buffer.createGraphicBufferHandle() : null, rect);
    }

    @Override
    public RemoteAnimationTarget createRemoteAnimationTarget(int taskId, int mode, SurfaceControl leash, boolean isTranslucent, Rect clipRect, Rect contentInsets, int prefixOrderIndex, Point position, Rect localBounds, Rect screenSpaceBounds, WindowConfiguration windowConfig, boolean isNotInRecents, SurfaceControl startLeash, Rect startBounds, ActivityManager.RunningTaskInfo taskInfo, boolean allowEnterPip, int windowType) {
        return new RemoteAnimationTarget(
                taskId, mode, leash, isTranslucent, clipRect, contentInsets,
                prefixOrderIndex, position, localBounds, screenSpaceBounds, windowConfig,
                isNotInRecents, startLeash, startBounds
        );
    }

    @Override
    public TaskInfoCompat getTaskInfoCompat(TaskInfo taskInfo) {
        return new TaskInfoCompatVR(taskInfo);
    }
}
