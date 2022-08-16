package com.invansa.zoomania

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animal_info.*

class AnimalInfo: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal_info)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val des = bundle.getString("des")
        val img = bundle.getInt("img")
        idanimalinfoimg.setImageResource(img)
        idanimalinfotitle.text = name
        idanimalinfodes.text = des
    }
}