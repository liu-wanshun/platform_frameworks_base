package com.android.systemui.shared.system

import java.lang.reflect.Method
import java.lang.reflect.Modifier

/**
 * add by liuwanshun
 */
object ThreadHook {

    @Volatile
    private var preHandler: Any? = this // uninitialized marker

    // Reflectively lookup pre-handler.
    private fun preHandler(): Method? {
        val current = preHandler
        if (current !== this) return current as Method?
        val declared = try {
            Thread::class.java.getDeclaredMethod("getUncaughtExceptionPreHandler").takeIf {
                Modifier.isPublic(it.modifiers) && Modifier.isStatic(it.modifiers)
            }
        } catch (e: Throwable) {
            null /* not found */
        }
        preHandler = declared
        return declared
    }


    fun getUncaughtExceptionPreHandler(): Thread.UncaughtExceptionHandler? {
        return preHandler()?.invoke(null) as? Thread.UncaughtExceptionHandler
    }


    @Volatile
    private var sSetUncaughtExceptionPreHandler: Any? = this // uninitialized marker

    // Reflectively set pre-handler.
    private fun setPreHandler(): Method? {
        val current = sSetUncaughtExceptionPreHandler
        if (current !== this) return current as Method?
        val declared = try {
            val getDeclaredMethod = Class::class.java.getDeclaredMethod(
                "getDeclaredMethod",
                String::class.java,
                Array::class.java
            )
            getDeclaredMethod.invoke(
                Thread::class.java, "setUncaughtExceptionPreHandler", arrayOf<Class<*>>(
                    Thread.UncaughtExceptionHandler::class.java
                )
            ) as Method
        } catch (e: Throwable) {
            null /* not found */
        }
        sSetUncaughtExceptionPreHandler = declared
        return declared
    }


    fun setUncaughtExceptionPreHandler(handler: Thread.UncaughtExceptionHandler) {
        setPreHandler()?.invoke(null, handler)
    }
}