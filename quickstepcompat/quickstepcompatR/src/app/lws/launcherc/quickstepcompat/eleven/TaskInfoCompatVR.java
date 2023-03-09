package app.lws.launcherc.quickstepcompat.eleven;

import android.app.TaskInfo;

import app.lws.launcherc.quickstepcompat.TaskInfoCompat;

public class TaskInfoCompatVR implements TaskInfoCompat {

    private final TaskInfo taskInfo;

    public TaskInfoCompatVR(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    @Override
    public boolean supportsSplitScreenMultiWindow() {
        return taskInfo.supportsSplitScreenMultiWindow;
    }
}
