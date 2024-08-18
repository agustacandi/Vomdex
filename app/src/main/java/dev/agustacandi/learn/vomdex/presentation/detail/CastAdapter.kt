package dev.agustacandi.learn.vomdex.presentation.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.agustacandi.learn.core.domain.credits.model.Cast
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.vomdex.databinding.ItemCastBinding

class CastAdapter : ListAdapter<Cast, CastAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemCastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cast: Cast) {
            with(binding) {
                castImage.load("${ConstVal.IMAGE_URL}/w200${cast.profilePath}") {
                    placeholder(ColorDrawable(Color.LTGRAY))
                }
                originalName.text = cast.originalName
                name.text = cast.character
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = ItemCastBinding.inflate(from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cast = getItem(position)
        holder.bind(cast)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Cast>() {
            override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
                return oldItem == newItem
            }
        }
    }
}