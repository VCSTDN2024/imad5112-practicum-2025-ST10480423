package vcmsa.ci.musicmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList

class Input : AppCompatActivity() {

    private lateinit var songET: EditText
    private lateinit var artistsET: EditText
    private lateinit var ratingET: EditText
    private lateinit var commentET: EditText
    private lateinit var addButton: Button
    private lateinit var clearButton: Button

    private lateinit var btnView: Button


    private val songtitle = mutableListOf<String>()
    private val artists = mutableListOf<String>()
    private val rating = mutableListOf<Int>()
    private val comment = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)




        songET = findViewById(R.id.songET)
        artistsET = findViewById(R.id.artistET)
        commentET = findViewById(R.id.commentET)
        ratingET = findViewById(R.id.ratingET)
        addButton = findViewById(R.id.addButton)
        clearButton = findViewById(R.id.clearButton)
        btnView = findViewById(R.id.btnView)

        addButton.setOnClickListener(){
            Addtoplaylist()
        }

        btnView.setOnClickListener(){
            if (songtitle.isNotEmpty()){
                val intent = Intent(this, DetailedView::class.java)
                intent.putStringArrayListExtra("songtitle", ArrayList(songtitle))
                intent.putStringArrayListExtra("artists", ArrayList(artists))
                intent.putIntegerArrayListExtra("rating", ArrayList(rating))
                intent.putStringArrayListExtra("comment", ArrayList(comment))
                startActivity(intent)
            } else {
                Snackbar.make(btnView, "The artist list is empty.", Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    private fun Addtoplaylist(){
        val thesongtitle = songET.text.toString().trim()
        val theartistsname = artistsET.text.toString().trim()
        val therating = ratingET.text.toString().trim()
        val thecomment = commentET.text.toString().trim()

        if (thesongtitle.isEmpty()){
            Snackbar.make(findViewById(android.R.id.content), "song title is empty.", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (theartistsname.isEmpty()){
            Snackbar.make(findViewById(android.R.id.content), "the artists name is empty", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (thecomment.isEmpty()){
            Snackbar.make(findViewById(android.R.id.content), "There is no comment ", Snackbar.LENGTH_SHORT).show()
            return
        }
        val rating = therating.toIntOrNull()
        if(rating == null || rating <= 0){
            Snackbar.make(findViewById(android.R.id.content), "There is no rate entered.", Snackbar.LENGTH_SHORT).show()
            return
        }

        songtitle.add(thesongtitle)
        this.artists.add(theartistsname)
        this.rating.add(rating)
        this.comment.add(thecomment)

        Snackbar.make(findViewById(android.R.id.content), "$songtitle added to the packing list.", Snackbar.LENGTH_SHORT).show()
    }



}