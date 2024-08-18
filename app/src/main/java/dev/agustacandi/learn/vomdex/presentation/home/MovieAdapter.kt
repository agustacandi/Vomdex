package dev.agustacandi.learn.vomdex.presentation.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.vomdex.databinding.ItemMovieBinding

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                moviePoster.load("${ConstVal.IMAGE_URL}/w200${movie.posterPath}") {
                    placeholder(ColorDrawable(Color.LTGRAY))
                }
                root.setOnClickListener { view ->
                    val navigateToDetailArticle = HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie.id.toString())
                    view.findNavController().navigate(navigateToDetailArticle)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemMovieBinding.inflate(from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
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