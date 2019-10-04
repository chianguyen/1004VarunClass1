package org.mp.a1004varunclass1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_recycler_data.*
import org.mp.a1004varunclass1.R
import org.mp.a1004varunclass1.modules.Employee

class RecyclerData : AppCompatActivity() {

    var userAdapter: UserAdapter? = null
    val employeeList: ArrayList<Employee> = ArrayList<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_data)

        readData()

        recycler_list.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(employeeList, this)
        recycler_list.adapter = userAdapter


        rec_btn_back.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var myIntent = Intent(this@RecyclerData, MainActivity::class.java)
                startActivity(myIntent)
            }
        })
    }

    private fun readData(){

        var firebasedatabase = FirebaseDatabase.getInstance()
        var databaseReference = firebasedatabase.getReference("employees")

        var employeeList = ArrayList<Employee>()

        databaseReference.addValueEventListener(object: ValueEventListener {

            var keys: ArrayList<String> = ArrayList<String>()

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(databaseSnapshot: DataSnapshot) {

                var text = ""

                //read data one by one
                for(data in databaseSnapshot.children){
                    //store the first extracted data in the key
                    keys.add(data.key!!)

                    //from the key get to the employee object
                    var employee: Employee? = data.getValue(Employee::class.java)
                    employeeList.add(employee!!)

                }

                userAdapter?.setData(employeeList)

            }

        })

    }
}
