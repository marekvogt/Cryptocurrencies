package pl.marekvogt.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.transition.TransitionInflater
import dagger.hilt.android.AndroidEntryPoint
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyDetailsBinding
import pl.marekvogt.cryptocurrency.ui.common.autoCleared
import pl.marekvogt.cryptocurrency.ui.common.extension.navArgs
import pl.marekvogt.cryptocurrency.ui.common.extension.nonNull
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject

@AndroidEntryPoint
class CryptoCurrencyDetailsFragment @Inject constructor() : Fragment() {

    private val viewModel: CryptoCurrencyDetailsViewModel by viewModels()

    private val detailsArgs by navArgs<CryptoCurrencyDetailsFragmentArgs>()
    private var binding by autoCleared<FragmentCurrencyDetailsBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_details, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currencyRateViewEntity = detailsArgs.currencyRateViewEntity
        val currencyIconDrawable = ContextCompat.getDrawable(requireContext(), currencyRateViewEntity.iconRes)

        binding.imgCurrencyIcon.setImageDrawable(currencyIconDrawable)
        binding.imgCurrencyIcon.transitionName = detailsArgs.transitionName
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        setupViewModel(currencyRateViewEntity)
    }

    private fun setupViewModel(viewEntity: CryptoCurrencyRateViewEntity) {
        viewModel.setupCurrencyDetails(viewEntity)

        viewModel.viewState.nonNull().observe(this) { labelValues ->
            binding.labelValues = labelValues
        }
    }
}