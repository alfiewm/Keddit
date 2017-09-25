package meng.keddit.features.news

import meng.keddit.commons.RedditNewsItem
import rx.Observable

/**
 * Created by meng on 2017/9/25.
 */
class NewsManager() {
    fun getNews(): Observable<MutableList<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val news = mutableListOf<RedditNewsItem>()
            for (i in 0..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title$i",
                        i, // number of comments
                        System.currentTimeMillis() / 1000 - i * 2000, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}