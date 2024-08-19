package dev.agustacandi.learn.favorite.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.agustacandi.learn.favorite.databinding.ActivityFavoriteBinding
import dev.agustacandi.learn.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private val loadFeature by lazy { loadKoinModules(favoriteModule) }
    private fun inject() = loadFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inject()

        binding.apply {
            backButton.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }

            removeAllFavoriteBtn.setOnClickListener {
                favoriteViewModel.removeAllFavorite()
            }
        }

        favoriteViewModel.getFavoriteMovie()

        favoriteViewModel.favorite.observe(this) {
            val movieAdapter = FavoriteAdapter { id ->
                favoriteViewModel.removeFavorite(id)
            }
            movieAdapter.submitList(it)
            binding.rvFavorite.apply {
                adapter = movieAdapter
                layoutManager = LinearLayoutManager(this@FavoriteActivity)
            }

        }
    }
}