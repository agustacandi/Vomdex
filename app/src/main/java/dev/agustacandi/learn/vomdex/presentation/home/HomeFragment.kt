package dev.agustacandi.learn.vomdex.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.utils.Helper
import dev.agustacandi.learn.core.utils.ext.gone
import dev.agustacandi.learn.core.utils.ext.show
import dev.agustacandi.learn.vomdex.base.BaseFragment
import dev.agustacandi.learn.vomdex.databinding.FragmentHomeBinding
import dev.agustacandi.learn.vomdex.databinding.ShimmerMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initAction() {
        binding.favoriteButton.setOnClickListener {
            try {
                moveToFavoriteActivity()
            } catch (e: Exception) {
                Helper.showToast(requireActivity(), "Module not found")
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        homeViewModel.nowPlaying.observe(viewLifecycleOwner) { nowPlaying ->
            if (nowPlaying != null) {
                binding.apply {
                    when (nowPlaying) {
                        is RemoteResponse.Loading -> {
                            showShimmer(true, shimmerNowPlaying, rvNowPlaying)
                        }
                        is RemoteResponse.Success -> {
                            showShimmer(false, shimmerNowPlaying, rvNowPlaying)

                            val movieAdapter = MovieAdapter()
                            movieAdapter.submitList(nowPlaying.data)
                            rvNowPlaying.apply {
                                adapter = movieAdapter
                                layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
                            }
                        }
                        is RemoteResponse.Error -> {
                            showShimmer(false, shimmerNowPlaying, rvNowPlaying)
                            Helper.showToast(requireActivity(), nowPlaying.errorMessage)
                        }
                        is RemoteResponse.Empty -> {
                            showShimmer(false, shimmerNowPlaying, rvNowPlaying)
                            Helper.showToast(requireActivity(), "Data is empty")
                        }
                    }
                }
            }
        }

        homeViewModel.popular.observe(viewLifecycleOwner) { popular ->
            if (popular != null) {
                binding.apply {
                    when (popular) {
                        is RemoteResponse.Loading -> {
                            showShimmer(true, shimmerPopular, rvPopular)
                        }
                        is RemoteResponse.Success -> {
                            showShimmer(false, shimmerPopular, rvPopular)
                            val movieAdapter = MovieAdapter()
                            movieAdapter.submitList(popular.data)
                            rvPopular.apply {
                                adapter = movieAdapter
                                layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
                            }
                        }
                        is RemoteResponse.Error -> {
                            showShimmer(false, shimmerPopular, rvPopular)
                            Helper.showToast(requireActivity(), popular.errorMessage)
                        }
                        is RemoteResponse.Empty -> {
                            showShimmer(false, shimmerPopular, rvPopular)
                            Helper.showToast(requireActivity(), "Data is empty")
                        }
                    }
                }
            }
        }

        homeViewModel.topRated.observe(viewLifecycleOwner) { topRated ->
            if (topRated != null) {
                binding.apply {
                    when (topRated) {
                        is RemoteResponse.Loading -> {
                            showShimmer(true, shimmerTopRated, rvTopRated)
                        }
                        is RemoteResponse.Success -> {
                            showShimmer(false, shimmerTopRated, rvTopRated)

                            val movieAdapter = MovieAdapter()
                            movieAdapter.submitList(topRated.data)
                            rvTopRated.apply {
                                adapter = movieAdapter
                                layoutManager = LinearLayoutManager(
                                    requireActivity(),
                                    LinearLayoutManager.HORIZONTAL,
                                    false
                                )
                            }
                        }
                        is RemoteResponse.Error -> {
                            showShimmer(false, shimmerTopRated, rvTopRated)
                            Helper.showToast(requireActivity(), topRated.errorMessage)
                        }
                        is RemoteResponse.Empty -> {
                            showShimmer(false, shimmerTopRated, rvTopRated)
                            Helper.showToast(requireActivity(), "Data is empty")
                        }
                    }
                }
            }
        }

        homeViewModel.upcoming.observe(viewLifecycleOwner) { upcoming ->
            if (upcoming != null) {
                binding.apply {
                    when (upcoming) {
                        is RemoteResponse.Loading -> {
                            showShimmer(true, shimmerUpcoming, rvUpcoming)
                        }
                        is RemoteResponse.Success -> {
                            showShimmer(false, shimmerUpcoming, rvUpcoming)

                            val movieAdapter = MovieAdapter()
                            movieAdapter.submitList(upcoming.data)
                            rvUpcoming.apply {
                                adapter = movieAdapter
                                layoutManager = LinearLayoutManager(
                                    requireActivity(),
                                    LinearLayoutManager.HORIZONTAL,
                                    false
                                )
                            }
                        }
                        is RemoteResponse.Error -> {
                            showShimmer(false, shimmerUpcoming, rvUpcoming)
                            Helper.showToast(requireActivity(), upcoming.errorMessage)
                        }
                        is RemoteResponse.Empty -> {
                            showShimmer(false, shimmerUpcoming, rvUpcoming)
                            Helper.showToast(requireActivity(), "Data is empty")
                        }
                    }
                }
            }
        }
    }

    private fun showShimmer(state: Boolean, shimmerView: ShimmerMovieBinding, recyclerView: RecyclerView) {
            if (state) {
                shimmerView.root.show()
                recyclerView.gone()
            } else {
                shimmerView.root.gone()
                recyclerView.show()
            }
    }

    private fun moveToFavoriteActivity() {
        startActivity(Intent(requireActivity(), Class.forName("dev.agustacandi.learn.favorite.presentation.FavoriteActivity")))
    }

}