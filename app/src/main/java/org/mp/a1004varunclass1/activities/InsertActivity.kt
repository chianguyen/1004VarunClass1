package org.mp.a1004varunclass1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insert.*
import org.mp.a1004varunclass1.R
import org.mp.a1004varunclass1.modules.Employee

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        btn_insert.setOnClickListener(object: View.OnClickListener{

            override fun onClick(v: View?) {

                var name = edit_text_name.text.toString()
                var email = edit_text_email.text.toString()
                var phone = edit_text_phone.text.toString()

                //Need module, so create a module class
                //-> create packages to organize

                //put read data in the employee object
                var employee: Employee = Employee(name, email, phone)

                //initialise database object
                var firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

                //We can have multiple databases in one project
                //Points to the "employees" database in this project
                //If database "employees" exists, points to it
                //If database "employees" doesn't exist, create one
                var databaseReference = firebaseDatabase.getReference("employees")

                //pushes empId into the database with 'push()'
                // and gives it a key with 'key'
                //'key' here is 'getKey'
                var empId = databaseReference.push().key

                //Now that empID is now an object with an ID,
                //we give it the value for that ID
                //the "value" here is the 'employee' object
                databaseReference.child(empId!!).setValue(employee)

                Toast.makeText(applicationContext, "Record Inserted", Toast.LENGTH_SHORT).show()

            }

        })
    }
}
