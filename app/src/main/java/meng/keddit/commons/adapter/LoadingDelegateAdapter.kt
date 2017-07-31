package meng.keddit.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import meng.keddit.R
import meng.keddit.commons.extensions.inflate

/**
 * Created by meng on 2017/7/31.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}