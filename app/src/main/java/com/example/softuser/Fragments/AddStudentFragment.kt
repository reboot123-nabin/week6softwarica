package com.example.softuser.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.softuser.R
import com.example.softuser.StudentDetailsActivity
import com.example.softuser.Studentdata
import com.example.softuser.model.Student
import java.lang.reflect.Array.get
import java.nio.file.Paths.get


class AddStudentFragment : Fragment() {
    private lateinit var etfullname: EditText
    private lateinit var etAge: EditText
    private lateinit var rdGroup: RadioGroup
    private lateinit var rdMale:RadioButton
    private lateinit var rdFemale:RadioButton
    private lateinit var rdOthers:RadioButton

    private lateinit var etAddress:EditText
    private lateinit var etimage:EditText
    private lateinit var btnSave: Button

    var newStudent=ArrayList<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_student, container, false)

        etfullname=view.findViewById(R.id.etfullname)
        etAge=view.findViewById(R.id.etage)
        etimage=view.findViewById(R.id.etimage)
        etAddress=view.findViewById(R.id.etaddress)
        rdMale=view.findViewById(R.id.rdMale)
        rdFemale=view.findViewById(R.id.rdFemale)
        rdGroup=view.findViewById(R.id.rdGroup)
        rdOthers=view.findViewById(R.id.rdOthers)
        btnSave=view.findViewById(R.id.btnsave)
        btnSave.setOnClickListener {
            var name = etfullname.text.toString();
            var age = 0;
            try{
                age = etAge.text.toString().toInt();
            }catch (e:Exception){
                e.printStackTrace();
                age = 0;
            }
            var gender=rdGroup.checkedRadioButtonId.toString()
            if(rdGroup.checkedRadioButtonId!=1){
                if(rdMale.isChecked){
                    gender="Male"
                }else if (rdFemale.isChecked){
                    gender="Female"
                }else if (rdOthers.isChecked){
                    gender="other"
                }
            }

            var address = etAddress.text.toString();
            var image = etimage.text.toString();
            var studentdata = Student(id, name, age, gender, address, image)

            newStudent.add(studentdata);
            var bundle = Bundle()
            bundle.putString("data","yourdata");
            var homeFragment = HomeFragment();
            homeFragment.arguments = bundle
            Studentdata.get().List().add(studentdata);
            etfullname.setText("")
            etAge.setText("")
            rdMale.isChecked=false
            rdFemale.isChecked=false
            rdOthers.isChecked=false
            etAddress.setText("")
            etimage.setText("")

        }
        return view

    }



}