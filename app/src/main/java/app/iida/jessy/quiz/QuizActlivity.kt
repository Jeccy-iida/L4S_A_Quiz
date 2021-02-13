package app.iida.jessy.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_quiz_actlivity.*
import kotlinx.android.synthetic.main.activity_quiz_actlivity.view.*


class QuizActlivity : AppCompatActivity() {

    val quizLists: List<List<String>> = listOf(
        listOf("Androidコースのキャラクターの名前は？","ランディ","フィル","ドロイド","ランディ"),
        listOf("Androidアプリを開発する言語はどれ？","JavaScript","Kotlin","Swift","Kotlin"),
        listOf("ImageViewは、何を扱える要素？","文字","音声","画像","画像")
    )
    //クイズをシャッフルして変数に入れる
    val shuffledLists: List<List<String>> = quizLists.shuffled()

    //クイズ数をカウントする変数を作る
    var quizCount: Int = 0

    //正解の答えを入れる変数を作る
    var correctAnswer: String = ""

    //正解の回数を入れる変数を作る
    var correctCount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_actlivity)

        //クイズを表示する
        showQuestion()

        answerButton1.setOnClickListener {
            checkAnswer(answerButton1.text.toString())
        }

        answerButton2.setOnClickListener {
            checkAnswer(answerButton2.text.toString())
        }

        answerButton3.setOnClickListener {
            checkAnswer(answerButton3.text.toString())
        }


        nextButton.setOnClickListener {
            //現在のクイズ数と、全問クイズ数が一致するか比較
            if (quizCount == quizLists.size) {
                //一緒だったら、結果画面へ移動する
                //クイズ数をセットする
                //正解数をセットする
                //結果画面に切り替
            } else {
                //一緒じゃなければ画像を非表示にする
                judgeImage.isVisible = false
                nextButton.isVisible = false
                //回答ボタンを有効にする
                answerButton1.isEnabled = true
                answerButton2.isEnabled = true
                answerButton3.isEnabled = true
                //正解表示をリセットする
                correctAnswerText.text = ""
                //クイズを表示する
                showQuestion()
            }

        }
    }

    //画面に表示するクイズを作る
    fun showQuestion(){
        val question: List<String> = shuffledLists[quizCount]
        //クイズの中身を確認する
        Log.d("debug",question.toString())
        //クイズを、TextViewに反映する
        quizText.text = question[0]
        //クイズの選択肢を表示する
        answerButton1.text = question[1]
        answerButton2.text = question[2]
        answerButton3.text = question[3]
        //正しい答えをセットする
        correctAnswer = question[4]
    }

    fun checkAnswer(answerText: String){

        if(answerText == correctAnswer){
            //あってたら丸の画像を反映
            judgeImage.setImageResource(R.drawable.maru_image)
            //正解した数をカウント
            correctCount++
        }else{
            judgeImage.setImageResource(R.drawable.batu_image)
        }
        //判定画像を表示
        showAnswer()
        //クイズ数をカウント
        quizCount++
    }

    //画像表示の際のボタン設定
    fun showAnswer(){
        //正解：正解の言葉を呼び出してる
        correctAnswerText.text = "正解:$correctAnswer"

        judgeImage.isVisible = true
        //次へのボタンを表示すする（表示する→true 無効（表示を消す）→false)
        nextButton.isVisible = true

        answerButton1.isEnabled = false
        answerButton2.isEnabled = false
        answerButton3.isEnabled = false
    }
}