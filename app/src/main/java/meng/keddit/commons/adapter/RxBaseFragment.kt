package meng.keddit.commons.adapter

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by meng on 2017/9/25.
 */
open class RxBaseFragment : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}