package pl.marekvogt.cryptocurrency.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_currency_list.*
import pl.marekvogt.cryptocurrency.R
import javax.inject.Inject
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyListBinding
import pl.marekvogt.cryptocurrency.ui.common.extension.nonNull
import pl.marekvogt.cryptocurrency.ui.common.extension.observeEvent
import pl.marekvogt.cryptocurrency.ui.common.extension.showMessage
import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsFragment

class CryptoCurrencyListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var currencyRatesAdapter: CryptoCurrencyListAdapter
    private lateinit var binding: FragmentCurrencyListBinding

    private val viewModel: CryptoCurrencyListViewModel by viewModels { viewModelFactory }

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
        currencyRatesAdapter.onItemClicked = { viewEntity, imgCurrencySymbol ->
            findNavController().navigate(
                R.id.actionNavigateToDetails,
                CryptoCurrencyDetailsFragment.createExtras(viewEntity, imgCurrencySymbol.transitionName),
                null,
                FragmentNavigatorExtras(imgCurrencySymbol to imgCurrencySymbol.transitionName)
            )
        }
        rwCurrencyRates.adapter = currencyRatesAdapter
        rwCurrencyRates.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun setupViewModel() {
        viewModel.getViewState().nonNull().observe(viewLifecycleOwner) { viewState ->
            binding.viewState = viewState
            currencyRatesAdapter.submitList(viewState.cryptoRates)
        }

        viewModel.startLoadingAnimationEvent.observeEvent(viewLifecycleOwner) {
            viewShimmerListPlaceholder.startShimmer()
        }

        viewModel.stopLoadingAnimationEvent.observeEvent(viewLifecycleOwner) {
            viewShimmerListPlaceholder.stopShimmer()
        }

        viewModel.errorMessageEvent.observeEvent(viewLifecycleOwner) { errorMessage ->
            layoutRoot showMessage errorMessage
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

    override fun onDestroyView() {
        super.onDestroyView()
        rwCurrencyRates.adapter = null
    }
}