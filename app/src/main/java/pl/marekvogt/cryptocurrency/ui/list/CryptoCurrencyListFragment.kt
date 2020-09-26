package pl.marekvogt.cryptocurrency.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.marekvogt.cryptocurrency.R
import javax.inject.Inject
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyListBinding
import pl.marekvogt.cryptocurrency.ui.common.autoCleared
import pl.marekvogt.cryptocurrency.ui.common.extension.nonNull
import pl.marekvogt.cryptocurrency.ui.common.extension.observeEvent
import pl.marekvogt.cryptocurrency.ui.common.extension.showMessage
import pl.marekvogt.cryptocurrency.ui.common.list.MarginItemDecoration
import pl.marekvogt.cryptocurrency.ui.common.list.Orientation

@AndroidEntryPoint
class CryptoCurrencyListFragment @Inject constructor(): Fragment() {

    private val viewModel: CryptoCurrencyListViewModel by viewModels()

    private var binding by autoCleared<FragmentCurrencyListBinding>()
    private var currencyRatesAdapter by autoCleared<CryptoCurrencyListAdapter>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        currencyRatesAdapter = CryptoCurrencyListAdapter()
        currencyRatesAdapter.onItemClicked = { viewEntity, imgCurrencySymbol ->
            findNavController().navigate(
                CryptoCurrencyListFragmentDirections.actionNavigateToDetails(viewEntity, imgCurrencySymbol.transitionName, viewEntity.currency.name),
                FragmentNavigatorExtras(imgCurrencySymbol to imgCurrencySymbol.transitionName)
            )
        }
        binding.rwCurrencyRates.adapter = currencyRatesAdapter
        binding.rwCurrencyRates.addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.card_margin).toInt(), Orientation.VERTICAL))

        postponeEnterTransition()
        binding.rwCurrencyRates.viewTreeObserver
            .addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
    }

    private fun setupViewModel() {
        viewModel.loadCryptoCurrencyRates()

        viewModel.viewState.nonNull().observe(viewLifecycleOwner) { viewState ->
            currencyRatesAdapter.submitList(viewState.cryptoRates)
        }

        viewModel.startLoadingAnimationEvent.observeEvent(viewLifecycleOwner) {
            binding.viewShimmerListPlaceholder.startShimmer()
        }

        viewModel.stopLoadingAnimationEvent.observeEvent(viewLifecycleOwner) {
            binding.viewShimmerListPlaceholder.stopShimmer()
        }

        viewModel.errorMessageEvent.observeEvent(viewLifecycleOwner) { errorMessage ->
            binding.layoutRoot showMessage errorMessage
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.startLoadingAnimationIfNeeded()
    }

    override fun onPause() {
        super.onPause()
        viewModel.stopLoadingAnimationIfNeeded()
    }
}