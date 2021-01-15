package com.example.softuser.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuser.Adapter.StudentAdapter
import com.example.softuser.R
import com.example.softuser.Studentdata
import com.example.softuser.model.Student


class HomeFragment : Fragment() {
private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        if(Studentdata.get().List().size==0){
            loadStudents();
        }
        recyclerView=view.findViewById(R.id.recylerview)
        val adapter= StudentAdapter(Studentdata.get().List(),context!!)
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter

        return view;



    }

    private fun loadStudents(){
        Studentdata.get().List().add(
            Student(1,"Nabin thapa magar",20,"Male","Sanepa",
            "https://scontent.fktm8-1.fna.fbcdn.net/v/t31.0-8/r180/19402053_424668114598897_3828723119105692134_o.jpg?_nc_cat=101&cb=846ca55b-311e05c7&ccb=2&_nc_sid=8bfeb9&_nc_ohc=7w6WznRDY_AAX_VCYSE&_nc_ht=scontent.fktm8-1.fna&oh=69fbab4a7adcad03ceb87178cb8dbfa2&oe=60274F4A")
        )

        Studentdata.get().List().add(
            Student(2,"Sujan",22,"Male","Dillibazar",
                "https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/89356851_251174115912865_7891050963769753600_o.jpg?_nc_cat=107&ccb=2&_nc_sid=8bfeb9&_nc_ohc=3dAKweCjDDgAX8acdBZ&_nc_oc=AQmIEbbb9gd8EIoH-Mv6Sn10iAsiC4ROYPTR-TTJ9l1G8bAjXOluSnFq25WpVkLhgy0&_nc_ht=scontent.fktm8-1.fna&oh=c0281157fb44a631ecd19663c7c250ba&oe=602629ED")
        )

        Studentdata.get().List().add(
            Student(3,"Angelina",20,"Female","Balaju",
                "https://i.pinimg.com/564x/b7/d7/1c/b7d71cec933bdee0553f552481f25d02.jpg")
        )

    }


}