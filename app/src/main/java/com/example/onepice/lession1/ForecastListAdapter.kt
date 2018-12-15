//package com.example.onepice.lession1
//
//import android.support.v7.widget.RecyclerView
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.example.onepice.lession1.domain.ForecastList
//import java.text.FieldPosition
//
///**
// * 描    述：
// * 作    者：fantianwen
// * 时    间：2018/12/9  10:55 AM
// */
//class ForecastListAdapter(val weekForecast: EosDataQr) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
//        return ViewHolder(TextView(parent.context))
//    }
//
////
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        with(weekForecast.dailyForecast[position]) {
//            holder.textView.text = "$date - $description - $high/$low"
//        }
//
//
//    }
//
//    override fun getItemCount(): Int = weekForecast.dailyForecast.size
//
//
//    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {
//
//    }
//}
