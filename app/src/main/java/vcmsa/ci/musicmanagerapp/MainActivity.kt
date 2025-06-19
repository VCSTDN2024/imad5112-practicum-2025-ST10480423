package vcmsa.ci.musicmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonView).setOnClickListener(){
            startActivity(Intent(this,DetailedView::class.java))
        }
        findViewById<Button>(R.id.btnadd).setOnClickListener(){
            startActivity(Intent(this,Input::class.java))

        }
        findViewById<Button>(R.id.btnExit).setOnClickListener(){
            finishAffinity()
            exitProcess(0)
        }



    }
}