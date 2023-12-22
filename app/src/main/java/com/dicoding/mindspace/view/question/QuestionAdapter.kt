package com.dicoding.mindspace.view.question

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mindspace.data.Question
import com.dicoding.mindspace.data.api.ApiConfig
import com.dicoding.mindspace.databinding.ItemQuestionBinding
import com.dicoding.mindspace.view.question.QuestionAdapter.MyViewHolder.Companion.DIFF_CALLBACK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class QuestionAdapter : ListAdapter<Question, QuestionAdapter.MyViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = getItem(position)
        if (story != null) {
            holder.bind(story)
        }
    }

    class MyViewHolder(private val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(q : Question){
            binding.tvQuestion.text = q.questionText
            binding.radioGroup.setOnCheckedChangeListener{ _, checkedId ->
                val idQuestion = q.questionId.toString()
                when (checkedId){
                    binding.radioButton1.id -> {
                        submit(idQuestion, "1")
                    }
                    binding.radioButton2.id -> {
                        submit(idQuestion, "2")
                    }
                    binding.radioButton3.id -> {
                        submit(idQuestion, "3")}
                    binding.radioButton4.id -> {
                        submit(idQuestion, "4")}
                }
            }
        }

        private fun submit(questionId: String, optionId: String) {
            itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                withContext(Dispatchers.IO) {
                    val jsonBody = """
                    {
                        "question_id": "$questionId",
                        "option_id": "$optionId"
                    }
                """.trimIndent()

                    val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
                    val requestBody = jsonBody.toRequestBody(mediaType)
                    //ApiConfig.getApiSurvey().submitAnswer(requestBody)
            }
        }
    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Question>(){
            override fun areItemsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean {
                return oldItem.questionId == newItem.questionId
            }

            override fun areContentsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
}