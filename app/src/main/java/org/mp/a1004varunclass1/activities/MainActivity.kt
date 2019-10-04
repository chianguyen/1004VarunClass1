package org.mp.a1004varunclass1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.mp.a1004varunclass1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_insert.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, InsertActivity::class.java)
                startActivity(intent)
            }
        })

        btn_read.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                //To see it in Recycler view
                val intent = Intent(this@MainActivity, RecyclerData::class.java)

//              val intent = Intent(this@MainActivity, ReadActivity::class.java)
                // This if you just want to show the result as text on the Read Activity

                startActivity(intent)

            }

        })

    }
}
