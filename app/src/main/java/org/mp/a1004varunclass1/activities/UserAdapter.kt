package org.mp.a1004varunclass1.activities

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_unit.view.*
import org.mp.a1004varunclass1.R
import org.mp.a1004varunclass1.modules.Employee

class UserAdapter (var employeeList: ArrayList<Employee>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var employee = employeeList.get(position)
        holder?.txtInfo.text = employee.email
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_unit, parent, false))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun setData(data: ArrayList<Employee>){
        employeeList = data

        //reload because data changed
        notifyDataSetChanged()
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    var txtInfo = view.txt_show
}