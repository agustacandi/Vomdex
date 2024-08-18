package dev.agustacandi.learn.vomdex.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.vomdex.R
import dev.agustacandi.learn.vomdex.base.BaseFragment
import dev.agustacandi.learn.vomdex.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        lifecycleScope.launch {
            delay(ConstVal.SPLASH_SCREEN_DURATION)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

}