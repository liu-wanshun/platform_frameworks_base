package app.lws.launcherc.quickstepcompat

import android.os.Build
import app.lws.launcherc.quickstepcompat.eleven.QuickstepCompatFactoryVR
import app.lws.launcherc.quickstepcompat.ten.QuickstepCompatFactoryVQ
import app.lws.launcherc.quickstepcompat.thirteen.QuickstepCompatFactoryVT
import app.lws.launcherc.quickstepcompat.twelve.QuickstepCompatFactoryVS

object QuickstepCompat {
    @JvmField
    val ATLEAST_R: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R

    @JvmField
    val ATLEAST_S: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    @JvmField
    val ATLEAST_T: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU


    @JvmStatic
    val factory: QuickstepCompatFactory = if (ATLEAST_T) {
        QuickstepCompatFactoryVT()
    } else if (ATLEAST_S) {
        QuickstepCompatFactoryVS()
    } else if (ATLEAST_R) {
        QuickstepCompatFactoryVR()
    } else {
        QuickstepCompatFactoryVQ()
    }

    @JvmStatic
    val activityManagerCompat: ActivityManagerCompat = factory.activityManagerCompat

    @JvmStatic
    val activityOptionsCompat = factory.activityOptionsCompat
}