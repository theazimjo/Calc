package com.example.calc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.calc.databinding.NumberLayoutBinding

class CustumAdapter(context: Context, val imagelist: ArrayList<Int>) :
    ArrayAdapter<Int>(context, R.layout.number_layout, imagelist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: NumberLayoutBinding = if (convertView == null) {
            NumberLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            NumberLayoutBinding.bind(convertView)
        }

        binding.imageView.setImageResource(imagelist[position])

        return binding.root
    }
}