package com.example.etfood.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.etfood.ui.activity.ListAdminActivity
import com.example.etfood.databinding.RowCategoryBinding
import com.example.etfood.ui.model.ModelCategory

class AdapterCategory :RecyclerView.Adapter<AdapterCategory.HolderCategory>{

    private var context: Context
    public var categoryArrayList: ArrayList<ModelCategory>
    private var filterList: ArrayList<ModelCategory>

    private lateinit var binding : RowCategoryBinding

    constructor(context: Context, categoryArrayList: ArrayList<ModelCategory>) {
        this.context = context
        this.categoryArrayList = categoryArrayList
        this.filterList = categoryArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCategory {
      binding = RowCategoryBinding.inflate(LayoutInflater.from(context), parent,false)
        return HolderCategory(binding.root)
    }

    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
       val model = categoryArrayList[position]
        val id = model.id
        val category = model.category
        val uid = model.uid
        val timestamp = model.timestamp

        //set data
        holder.categoryTv.text = category


        holder.itemView.setOnClickListener{
            val intent = Intent(context, ListAdminActivity::class.java)
            intent.putExtra("categoryId",id)
            intent.putExtra("category",category)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return categoryArrayList.size
    }

    inner class HolderCategory(itemView:View): RecyclerView.ViewHolder(itemView){

        var categoryTv:TextView = binding.categoryTv

    }

}