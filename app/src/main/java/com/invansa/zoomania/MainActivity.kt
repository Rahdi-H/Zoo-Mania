package com.invansa.zoomania

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    private var listOfAnimal = ArrayList<Animal>()
    private var adapter: AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfAnimal.add(Animal("Deer", "Deer lives in jungle", R.drawable.deer, false))
        listOfAnimal.add(Animal("Dog", "Dog lives in jungle", R.drawable.dog, false))
        listOfAnimal.add(Animal("Elephant", "Elephant lives in jungle", R.drawable.elephant, true))
        listOfAnimal.add(Animal("Flamingo", "Flamingo lives in jungle", R.drawable.flamingo, false))
        listOfAnimal.add(Animal("Fox", "Fox lives in jungle", R.drawable.fox, false))
        listOfAnimal.add(Animal("Giraffe", "Giraffe lives in jungle", R.drawable.giraffe, false))
        listOfAnimal.add(Animal("Deer", "Deer lives in jungle", R.drawable.deer, false))
        listOfAnimal.add(Animal("Dog", "Dog lives in jungle", R.drawable.dog, false))
        listOfAnimal.add(Animal("Elephant", "Elephant lives in jungle", R.drawable.elephant, true))
        listOfAnimal.add(Animal("Flamingo", "Flamingo lives in jungle", R.drawable.flamingo, false))
        listOfAnimal.add(Animal("Fox", "Fox lives in jungle", R.drawable.fox, false))
        listOfAnimal.add(Animal("Giraffe", "Giraffe lives in jungle", R.drawable.giraffe, false))
        adapter = AnimalsAdapter(this, listOfAnimal)
        idlistView.adapter = adapter
    }
    class AnimalsAdapter(context: Context, listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
        private var listOfAnimals: ArrayList<Animal>? = listOfAnimals
        private var context: Context? = context
        override fun getCount(): Int {
            return listOfAnimals!!.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals!![p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals!![p0]
            if (animal.iskiller) {
                val layout = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myView = layout.inflate(R.layout.animal_killer_ticket, null)
                myView.idtitle.text = animal.name
                myView.iddes.text = animal.des
                myView.imageView.setImageResource(animal.img)
                myView.imageView.setOnClickListener{
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("img", animal.img)
                    context!!.startActivity(intent)
                }
                return myView

            } else {
                val layout = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val myView = layout.inflate(R.layout.animal_ticket, null)
                myView.idtitle.text = animal.name
                myView.iddes.text = animal.des
                myView.imageView.setImageResource(animal.img)
                myView.imageView.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("des", animal.des)
                    intent.putExtra("img", animal.img)
                    context!!.startActivity(intent)
                }
                return myView

            }
        }
    }
}