package pl.marekvogt.cryptocurrency.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.os.bundleOf
import androidx.transition.TransitionInflater
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_currency_details.*
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.ui.common.extension.getIntOrNull


private const val ARG_CURRENCY_ICON_RES = "arg-currency-icon-res"
private const val ARG_TRANSITION_NAME = "arg-transition-name"

class CryptoCurrencyDetailsFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_currency_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currencyIconDrawable = arguments?.getIntOrNull(ARG_CURRENCY_ICON_RES)?.let { context?.getDrawable(it) }
        imgCurrencyIcon.setImageDrawable(currencyIconDrawable)
        imgCurrencyIcon.transitionName = arguments?.getString(ARG_TRANSITION_NAME)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    companion object {
        fun createExtras(
            @DrawableRes currencyIconRes: Int,
            transitionName: String
        ) = bundleOf(
            ARG_CURRENCY_ICON_RES to currencyIconRes,
            ARG_TRANSITION_NAME to transitionName
        )
    }
}