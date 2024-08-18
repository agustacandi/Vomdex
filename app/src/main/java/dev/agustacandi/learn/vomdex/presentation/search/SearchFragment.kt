package dev.agustacandi.learn.vomdex.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.utils.Helper
import dev.agustacandi.learn.core.utils.ext.gone
import dev.agustacandi.learn.core.utils.ext.show
import dev.agustacandi.learn.vomdex.base.BaseFragment
import dev.agustacandi.learn.vomdex.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            searchBar.setOnClickListener {
                searchView.show()
            }
            searchView.editText.setOnEditorActionListener { _, _, _ ->
                val query = searchView.text.toString()
                searchView.hide()
                searchBar.setText(query)
                if (query.isNotBlank() || query.isNotBlank()) {
                    searchViewModel.searchMovie(query)
                }
                false
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        searchViewModel.searchResult.observe(viewLifecycleOwner) { searchResult ->
            if (searchResult != null) {
                binding.apply {
                    when (searchResult) {
                        is RemoteResponse.Loading -> {
                            showShimmer(true)
                        }
                        is RemoteResponse.Success -> {
                            showShimmer(false)
                            val movieListAdapter = MovieListAdapter()
                            movieListAdapter.submitList(searchResult.data)
                            rvSearchResult.apply {
                                adapter = movieListAdapter
                                layoutManager = LinearLayoutManager(requireActivity())
                            }
                        }
                        is RemoteResponse.Error -> {
                            showShimmer(false)
                            Helper.showToast(requireActivity(), searchResult.errorMessage)
                        }
                        is RemoteResponse.Empty -> {
                            showShimmer(false)
                            Helper.showToast(requireActivity(), "Data is empty")
                        }
                    }
                }
            }
        }
    }

    private fun showShimmer(state:Boolean) {
        binding.apply {
            if (state) {
                shimmerSearchResult.root.show()
            } else {
                shimmerSearchResult.root.gone()
            }
        }
    }

}