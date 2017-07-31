@file:JvmName("ExtensionsUtils") // name used in java code, without this line, you have to use ExtensionsKt

package meng.keddit.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by meng on 2017/7/31.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
