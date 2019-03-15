package uk.co.spltech.secume.ui.home.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.reactivex.subjects.PublishSubject
import uk.co.spltech.secume.R
import uk.co.spltech.secume.model.Article


class HomeAdapter() : RecyclerView.Adapter<HomeViewHolder>() {
    val onClickSubject = PublishSubject.create<String>()
    var newsList = ArrayList<Article>()
        set(value) {
            if (value != field) {
                field = value
                notifyDataSetChanged()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val news = newsList[position]
        holder.let {
            with(holder) {
                newsTitle.text = news?.title
                Picasso.get().load(news?.image).into(newsImage)
            }
        }
    }

    override fun getItemCount(): Int = newsList.size
}

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val newsTitle = view.findViewById<TextView>(R.id.txtTitle)
    val newsImage = view.findViewById<ImageView>(R.id.imgBanner)
}

