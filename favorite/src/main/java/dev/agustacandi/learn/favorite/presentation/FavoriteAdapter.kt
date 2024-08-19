package dev.agustacandi.learn.favorite.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.core.utils.ext.getYear
import dev.agustacandi.learn.core.utils.ext.roundedNumber
import dev.agustacandi.learn.favorite.databinding.ItemFavoriteBinding

class FavoriteAdapter(private val removeAction: (id: Int) -> Unit) : ListAdapter<Movie, FavoriteAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemFavoriteBinding, private val removeAction: (id: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                movieListPoster.load("${ConstVal.IMAGE_URL}/w200${movie.posterPath}") {
                    placeholder(ColorDrawable(Color.LTGRAY))
                }
                movieListTitle.text = movie.title
                voteValue.text = movie.voteAverage?.roundedNumber()
                date.text = movie.releaseDate?.getYear()
                removeFavoriteButton.setOnClickListener {
                    removeAction(movie.id ?: 0)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemFavoriteBinding.inflate(from(parent.context), parent, false)
        return MyViewHolder(binding, removeAction)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}