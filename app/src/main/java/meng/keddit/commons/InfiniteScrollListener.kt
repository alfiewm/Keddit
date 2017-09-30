package meng.keddit.commons

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by meng on 2017/9/30.
 */
class InfiniteScrollListener(
        val func: ()->Unit,
        val layoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    private var previewTotal = 0
    private var loading = true
    private var visibleThreshold = 2
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            visibleItemCount = recyclerView.childCount
            totalItemCount = layoutManager.itemCount
            firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

            if (loading) {
                if (totalItemCount > previewTotal) {
                    loading = false
                    previewTotal = totalItemCount
                }
            }
            if (!loading && (totalItemCount - firstVisibleItem - visibleItemCount) <= visibleThreshold) {
                Log.i("InfiniteScrollListener", "End reached")
                func()
                loading = true
            }
        }
    }
}
