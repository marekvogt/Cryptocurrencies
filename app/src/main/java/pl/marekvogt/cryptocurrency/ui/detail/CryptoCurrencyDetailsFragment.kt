package pl.marekvogt.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_currency_details.*
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyDetailsBinding
import pl.marekvogt.cryptocurrency.ui.common.autoCleared
import pl.marekvogt.cryptocurrency.ui.common.extension.navArgs
import pl.marekvogt.cryptocurrency.ui.common.extension.nonNull
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject

class CryptoCurrencyDetailsFragment @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : DaggerFragment() {

    private val viewModel: CryptoCurrencyDetailsViewModel by viewModels { viewModelFactory }

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
        val currencyIconDrawable = context?.getDrawable(currencyRateViewEntity.iconRes)

        imgCurrencyIcon.setImageDrawable(currencyIconDrawable)
        imgCurrencyIcon.transitionName = detailsArgs.transitionName
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