package com.dicoding.mindspace.view.question

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mindspace.R
import com.dicoding.mindspace.data.questionList
import com.dicoding.mindspace.databinding.ActivityQuestionBinding
import com.dicoding.mindspace.view.emoticon.EmoticonDetectionActivity
import com.dicoding.mindspace.view.emoticon.ResultFragment
import com.dicoding.mindspace.view.emoticon.stories.StoriesActivity
import com.dicoding.mindspace.view.home.MainActivity
import com.dicoding.mindspace.view.sharingsession.SharingSessionAdapter

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAction()
    }

    private fun setAction() {

        val adapter = QuestionAdapter()
        binding.rvQuestion.layoutManager = LinearLayoutManager(this)
        binding.rvQuestion.setHasFixedSize(true)
        binding.rvQuestion.adapter = adapter
        adapter.submitList(questionList)

        binding.btnSaveAnswer.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}