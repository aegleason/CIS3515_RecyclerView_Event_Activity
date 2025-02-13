package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TODO(Step 1: Implement click behavior)
val button: Button = findViewById(R.id.my_button)
button.setOnClickListener {

}


// TODO (Step 1a: Accept lambda in constructor)
class NumberDisplayAdapter (
    private val numbers: Array<Int>,
    private val onItemClick: (Int) -> Unit // lambda
) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    // TODO (Step 1b: Invoke lambda via onClickListener)
    inner class NumberViewHolder (layout: View) : RecyclerView.ViewHolder (layout) {
        // enumerate views inside layout
        val textView = layout.findViewById<TextView>(R.id.textView)

        fun bind(number: Int) {
            textView.text = number.toString()
            itemView.setOnClickListener { onItemClick(number) } // invoke lambda, could be
            // more precise

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }

}