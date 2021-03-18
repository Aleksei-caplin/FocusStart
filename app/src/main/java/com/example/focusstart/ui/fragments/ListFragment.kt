package com.example.focusstart.ui.fragments

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import com.example.focusstart.R
import com.example.focusstart.adapter.CurrencyListAdapter
import com.example.focusstart.model.Currency
import com.example.focusstart.model.CurrencyWrapper
import com.example.focusstart.net.Common
import com.example.focusstart.net.CurrencyListInterface
import com.example.focusstart.ui.base.BaseFragment
import com.example.focusstart.viewmodels.MainViewModel
//import com.example.focusstart.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Response


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
    //private lateinit var currencyList: CurrencyListInterface
    //private lateinit var currencyProvider: CurrencyListAdapter

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
            Log.d("M_ggg", currencyList.value.toString())
            adaptert.updateList(it)
        })
    }

    /*override fun onResume() {
        super.onResume()
        currencyList = Common.retrofitService
        initViews()
    }

    private fun initViews() {


        currencyList.getCurrencyList().enqueue(object: Callback<CurrencyWrapper>{
            override fun onResponse(
                call: Call<CurrencyWrapper>,
                response: Response<CurrencyWrapper>
            ) {

                val currensyResponce = response.body()!!.valute
                val currensyResponceList = currensyResponce.map { it.value }

                currencyProvider = CurrencyListAdapter(currensyResponceList) {
                    //replaceFragment(SingleFragment(it))
                }

                with(rv_currency_list){
                    adapter = currencyProvider
                    layoutManager = LinearLayoutManager(activity)
                }

            }

            override fun onFailure(call: Call<CurrencyWrapper>, t: Throwable) {
                Log.d("M_ListFragment_error", t.toString())
            }

        })


    }*/





}