package app.iida.jessy.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //クイズ画面を用意する
        val quizIntent: Intent = Intent( this,QuizActlivity::class.java)

        //STARTボタンがタップされたら
        startButton.setOnClickListener{
            //クイズ場面に移動する
            startActivity(quizIntent)
        }
    }


    }
