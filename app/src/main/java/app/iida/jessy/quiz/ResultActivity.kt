package app.iida.jessy.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //クイズ画面からクイズ数を受け取る
        val quizCount: Int = intent.getIntExtra("QuizCount",0)
        //クイズ数をTextViewに反映する
        quizCountText.text = "$quizCount 門中・・・"

        //正解数を受け取る
        val correctCount: Int = intent.getIntExtra("CorrectCount",0)
        //正解数をTextViewに反映する
        correctCountText.text = correctCount.toString()

        //もう一回ボタンがタップされたら
        againButton.setOnClickListener {
            //画面遷移の手順
            //クイズ画面へ移動する準備をする
            val quizIntent:Intent = Intent(this,QuizActlivity:: class.java)
            //クイズ画面に移動する
            startActivity(quizIntent)
        }

    }
}