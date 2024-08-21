package dev.agustacandi.learn.vomdex.presentation.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.movie.model.DetailMovie
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.core.utils.Helper
import dev.agustacandi.learn.core.utils.ext.getYear
import dev.agustacandi.learn.core.utils.ext.gone
import dev.agustacandi.learn.core.utils.ext.roundedNumber
import dev.agustacandi.learn.core.utils.ext.show
import dev.agustacandi.learn.vomdex.R
import dev.agustacandi.learn.vomdex.base.BaseFragment
import dev.agustacandi.learn.vomdex.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val detailViewModel: DetailViewModel by viewModel()
    private var movieId: String? = null
    private var detailMovie: DetailMovie? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)

    override fun initIntent() {
        movieId = arguments?.getString(ConstVal.KEY_MOVIE_ID)
    }

    override fun initAction() {
        binding.apply {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun initProcess() {
        detailViewModel.apply {
            getCast(movieId ?: "")
            getDetailMovie(movieId ?: "")
            checkFavorite(movieId ?: "")
        }
    }

    override fun initObservers() {
        detailViewModel.detailMovieResult.observe(viewLifecycleOwner) { detailMovieResult ->
            if (detailMovieResult != null) {
                binding.apply {
                    when(detailMovieResult) {
                        is RemoteResponse.Loading -> {
                            shimmerDetail.root.show()
                            starIcon.gone()
                            calendarIcon.gone()
                            genreIcon.gone()
                        }
                        is RemoteResponse.Success -> {
                            shimmerDetail.root.gone()
                            starIcon.show()
                            calendarIcon.show()
                            genreIcon.show()
                            detailMovie = detailMovieResult.data
                            detailMoviePoster.load("${ConstVal.IMAGE_URL}/w300${detailMovieResult.data.posterPath}") {
                                placeholder(ColorDrawable(Color.LTGRAY))
                            }
                            detailMovieName.text = detailMovieResult.data.title
                            aboutMovie.text = detailMovieResult.data.overview
                            popularity.text = detailMovieResult.data.voteAverage?.roundedNumber()
                            release.text = detailMovieResult.data.releaseDate?.getYear()
                            genre.text = detailMovieResult.data.genres?.get(0)?.name
                        }
                        is RemoteResponse.Empty -> {
                            shimmerDetail.root.gone()
                            Helper.showToast(requireActivity(), "Empty")
                        }
                        is RemoteResponse.Error -> {
                            shimmerDetail.root.gone()
                            Helper.showToast(requireActivity(), detailMovieResult.errorMessage)
                        }
                    }
                }
            }
        }

        detailViewModel.castResult.observe(viewLifecycleOwner) { castResult ->
            if (castResult != null) {
                binding.apply {
                    when(castResult) {
                        is RemoteResponse.Loading -> {
                            shimmerCast.root.show()
                        }
                        is RemoteResponse.Success -> {
                            shimmerCast.root.gone()
                            val cast = castResult.data
                            val castAdapter = CastAdapter()
                            castAdapter.submitList(cast)
                            castRv.apply {
                                adapter = castAdapter
                                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                            }

                        }
                        is RemoteResponse.Empty -> {
                            shimmerCast.root.gone()
                            Helper.showToast(requireActivity(), "Empty")
                        }
                        is RemoteResponse.Error -> {
                            shimmerCast.root.gone()
                            Helper.showToast(requireActivity(), castResult.errorMessage)
                        }
                    }
                }
            }
        }

        detailViewModel.isFavorite.observe(viewLifecycleOwner) { isFavorite ->
            binding.favoriteButton.apply {
                if (isFavorite) {
                    setImageResource(R.drawable.baseline_favorite_24)
                } else {
                    setImageResource(R.drawable.baseline_favorite_border_24)
                }
                setOnClickListener { buttonFavAction(isFavorite) }
            }
        }
    }

    private fun buttonFavAction(isFavorite: Boolean) {
        if (isFavorite) {
            detailViewModel.removeFavorite(movieId ?: "")
        } else {
            val movie = Movie(
                id = detailMovie?.id ?: 0,
                overview = detailMovie?.overview ?: "",
                title = detailMovie?.title ?: "",
                posterPath = detailMovie?.posterPath ?: "",
                backdropPath = detailMovie?.backdropPath ?: "",
                releaseDate = detailMovie?.releaseDate ?: "",
                voteAverage = detailMovie?.voteAverage ?: 0.0,
                popularity = detailMovie?.popularity ?: 0.0,
                voteCount = detailMovie?.voteCount ?: 0,
                adult = detailMovie?.adult ?: false,
                originalLanguage = detailMovie?.originalLanguage ?: "",
                originalTitle = detailMovie?.originalTitle ?: "",
                video = detailMovie?.video ?: false,
            )
            detailViewModel.addFavorite(movie)
        }
    }

}