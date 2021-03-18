package com.example.focusstart.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.focusstart.R
import com.example.focusstart.adapter.CurrencyListAdapter
import com.example.focusstart.model.Currency
import com.example.focusstart.ui.base.BaseFragment
import com.example.focusstart.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment: BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by activityViewModels()
    override val layout: Int = R.layout.fragment_list

    lateinit var currencyList: LiveData<List<Currency>>
    private val adaptert = CurrencyListAdapter() {
        val action = ListFragmentDirections.actionListFragmentToSingleFragment(
                it.id,
                it.name,
                it.value
        )
        main.navController.navigate(action.actionId, action.arguments)
    }

    override fun setupViews() {
        initViewModel()
        viewModel.getCurrencyLIst()
        val divider = DividerItemDecoration(main, DividerItemDecoration.VERTICAL)

        with(rv_currency_list){
            adapter = adaptert
            layoutManager = LinearLayoutManager(main)
            addItemDecoration(divider)
        }
    }

    private fun initViewModel(){
        currencyList = viewModel.currencyItems
        currencyList.observe(main, Observer{
            adaptert.updateList(it)
        })
    }
}