package com.vm.virginmoney.ui.people

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vm.virginmoney.data.model.People
import com.vm.virginmoney.databinding.LayoutPeopleListItemBinding
import kotlinx.android.synthetic.main.layout_people_list_item.view.*
import java.util.*

class PeopleListAdapter(private val dataSet: ArrayList<People>) :
    RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutPeopleListItemBinding) : RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: People) {
            view.name.text = """${item.firstName}  ${item.lastName}"""
            view.email.text = """${item.email}"""
            view.phone.text = """${item.phone}"""
            view.job.text = """${item.jobTitle}"""
            Picasso.get().load(item.avatar).into(view.profile);
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutPeopleListItemBinding =
            LayoutPeopleListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val dataModel: People = dataSet[position]
        viewHolder.bind(dataModel)
    }
    override fun getItemCount() = dataSet.size
}