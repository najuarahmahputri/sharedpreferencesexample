package najuarahmahputri.polbeng.ac.id.sharedpreferencesexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import najuarahmahputri.polbeng.ac.id.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = getPreferences(Context.MODE_PRIVATE)
        binding.btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("firstName",
                binding.etFirstName.text.toString())
            editor.putString("lastName",
                binding.etLastName.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved Data!", Toast.LENGTH_LONG).show()
        }
        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            val output = "$firstName $lastName"
            binding.etFirstName.setText(firstName)
            binding.etLastName.setText(lastName)
            binding.tvOutput.text = output
        }
    }

    override fun onResume() {
        super.onResume()
        binding.etFirstName.setText("")
        binding.etLastName.setText("")
        binding.tvOutput.text = ""
    }
}