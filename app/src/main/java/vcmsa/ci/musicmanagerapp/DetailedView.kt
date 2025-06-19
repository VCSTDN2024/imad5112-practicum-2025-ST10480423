package vcmsa.ci.musicmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedView : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var displayTexted: TextView
    private lateinit var checkButton: Button
    private lateinit var avgButton: Button
    private lateinit var songtitle: ArrayList<String>
    private lateinit var artists: ArrayList<String>
    private lateinit var rating: ArrayList<Int>
    private lateinit var comment: ArrayList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        backButton = findViewById(R.id.backButton)
        displayTexted = findViewById(R.id.displayTexted)
        checkButton = findViewById(R.id.checkButton)
        avgButton = findViewById(R.id.avgButton)

        songtitle = intent.getStringArrayListExtra("songtitle") ?: arrayListOf()
        artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        rating = intent.getIntegerArrayListExtra("rating") ?: arrayListOf()
        comment = intent.getStringArrayListExtra("comment") ?: arrayListOf()

        checkButton.setOnClickListener() {
            checkthelist()
        }

        backButton.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }

        avgButton.setOnClickListener() {
          //  Calculation()
        }
    }

    private fun checkthelist() {
        val stringBuilder = StringBuilder()
        if (songtitle.isNotEmpty()) {
            for (i in songtitle.indices) {
                stringBuilder.append("songtitle: ${songtitle[i]}\n")
                stringBuilder.append("artists: ${artists[i]}\n")
                stringBuilder.append("rating: ${rating[i]}\n")
                stringBuilder.append("comment: ${comment[i]}\n\n")
            }
            this.displayTexted.text = stringBuilder.toString()
        }
    }


}
