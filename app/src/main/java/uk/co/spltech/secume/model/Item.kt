package uk.co.spltech.secume.model

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("articles")
    val articles: ArrayList<Article> = arrayListOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)

data class Article(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("content")
    val content: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val image: String = ""
)

data class Source(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)