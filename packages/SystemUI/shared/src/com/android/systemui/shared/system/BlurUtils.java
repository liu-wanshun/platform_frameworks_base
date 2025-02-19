/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.systemui.shared.system;

import static android.view.CrossWindowBlurListeners.CROSS_WINDOW_BLUR_SUPPORTED;

import android.app.ActivityManager;
import android.os.SystemProperties;

import app.lws.launcherc.quickstepcompat.QuickstepCompat;

public abstract class BlurUtils {

    /**
     * If this device can render blurs.
     *
     * @return {@code true} when supported.
     */
    public static boolean supportsBlursOnWindows() {
        if (!QuickstepCompat.ATLEAST_S) return false;
        return CROSS_WINDOW_BLUR_SUPPORTED && ActivityManager.isHighEndGfx()
                && !SystemProperties.getBoolean("persist.sysui.disableBlur", false);
    }
}
