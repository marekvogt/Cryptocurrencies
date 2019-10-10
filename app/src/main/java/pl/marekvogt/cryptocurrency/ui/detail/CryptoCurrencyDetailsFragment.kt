package pl.marekvogt.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_currency_details.*
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyDetailsBinding
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyListBinding
import pl.marekvogt.cryptocurrency.ui.common.autoCleared
import pl.marekvogt.cryptocurrency.ui.common.extension.getSerializable
import pl.marekvogt.cryptocurrency.ui.common.extension.nonNull
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject


private const val ARG_CURRENCY_VIEW_ENTITY = "arg-currency-view-entity"
private const val ARG_TRANSITION_NAME = "arg-transition-name"

class CryptoCurrencyDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CryptoCurrencyDetailsViewModel by viewModels { viewModelFactory }

    private var binding by autoCleared<FragmentCurrencyDetailsBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_details, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currencyRateViewEntity = arguments?.getSerializable<CryptoCurrencyRateViewEntity>(ARG_CURRENCY_VIEW_ENTITY)
        val currencyIconDrawable = currencyRateViewEntity?.iconRes?.let { iconRes -> context?.getDrawable(iconRes) }

        imgCurrencyIcon.setImageDrawable(currencyIconDrawable)
        imgCurrencyIcon.transitionName = arguments?.getString(ARG_TRANSITION_NAME)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        currencyRateViewEntity?.let { setupViewModel(it) }
    }

    private fun setupViewModel(viewEntity: CryptoCurrencyRateViewEntity) {
        viewModel.getViewState(viewEntity).nonNull().observe(this) { labelValues ->
            binding.labelValues = labelValues
        }
    }

    companion object {
        fun createExtras(
            cryptoCurrencyRateViewEntity: CryptoCurrencyRateViewEntity,
            currencyIconTransitionName: String
        ) = bundleOf(
            ARG_CURRENCY_VIEW_ENTITY to cryptoCurrencyRateViewEntity,
            ARG_TRANSITION_NAME to currencyIconTransitionName
        )
    }
}