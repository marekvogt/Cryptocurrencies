package pl.marekvogt.cryptocurrency.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_currency_list.*
import pl.marekvogt.cryptocurrency.R
import javax.inject.Inject
import pl.marekvogt.cryptocurrency.databinding.FragmentCurrencyListBinding
import pl.marekvogt.cryptocurrency.ui.common.extension.showMessage


class CryptoCurrencyListFragment : DaggerFragment() {

    @Inject lateinit var viewModel: CryptoCurrencyListViewModel
    @Inject lateinit var currencyRatesAdapter: CryptoCurrencyListAdapter
    private lateinit var binding: FragmentCurrencyListBinding

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
        rwCurrencyRates.adapter = currencyRatesAdapter
        rwCurrencyRates.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun setupViewModel() {
        viewModel.loadCryptoCurrencyRates()
        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            binding.viewState = viewState
            currencyRatesAdapter.submitList(viewState.cryptoRates)
            viewState.errorMessageEvent?.getContentIfNotHandled()?.let { errorMessage ->
                layoutRoot showMessage errorMessage
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        rwCurrencyRates.adapter = null
    }
}