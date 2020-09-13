package com.example.focusstart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.focusstart.R
import com.example.focusstart.model.Currency
import kotlinx.android.synthetic.main.currency_list_item.view.*

class CurrencyListAdapter(private val currencyList: List<Currency>, val listener: (Currency) -> Unit): RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder>() {

    class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(currencyList: Currency, listener: (Currency) -> Unit) = with(itemView) {
            currency_title.text = currencyList.name
            currency_value.text = currencyList.value
            calculate_button.setOnClickListener {
                listener.invoke(currencyList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val currencyView = LayoutInflater.from(parent.context).inflate(R.layout.currency_list_item, parent, false)
        return CurrencyViewHolder(currencyView)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencyList[position], listener)
    }

    override fun getItemCount(): Int = currencyList.size
}