package test.platzi.com.raian.com.org.simpleplatzi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import test.platzi.com.raian.com.org.simpleplatzi.R
import test.platzi.com.raian.com.org.simpleplatzi.model.Item

class RVCustomAdapter(var lstRes: List<Item>?, val context: Context) : RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(lstRes?.size!! > 0) lstRes!!.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.mTextViewProductName?.text = lstRes?.get(position).toString()
        Picasso.with(context)
                .load(lstRes?.get(position)?.mediumImage)
                .into(holder?.mImageViewProduct)
    }

    //ViewHolder
    //TODO: Move this to holder package
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        lateinit var mImageViewProduct : ImageView
        lateinit var mTextViewProductName : TextView

        init{
            itemView?.let {
                mImageViewProduct = it.findViewById(R.id.mImageViewProduct)
                mTextViewProductName = it.findViewById(R.id.mTextViewProductName)
            }

        }
    }

    fun filterList(filteredProductByName: ArrayList<Item>) {
        lstRes = filteredProductByName
        notifyDataSetChanged()
    }

}