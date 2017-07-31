package meng.keddit.commons

/**
 * Created by meng on 2017/7/31.
 */

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)
