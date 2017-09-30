package meng.keddit.features.news

import meng.keddit.api.RestAPI
import meng.keddit.commons.RedditNewsItem
import rx.Observable

/**
 * Created by meng on 2017/9/25.
 */
class NewsManager(private val api:RestAPI = RestAPI()) {
    fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}